package xyz.siomochkin.servlets;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import xyz.siomochkin.dao.LikedDAO;
import xyz.siomochkin.dao.UserDAO;
import xyz.siomochkin.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import static com.google.common.base.Charsets.UTF_8;

public class LikedServlet extends HttpServlet{

    UserDAO userDAO;
    LikedDAO likedDAO;


    public LikedServlet(UserDAO userDAO, LikedDAO likedDAO) {
        this.userDAO = userDAO;
        this.likedDAO = likedDAO;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding(String.valueOf(UTF_8));
        PrintWriter wr = resp.getWriter();
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
        cfg.setDirectoryForTemplateLoading(new File("lib/static/html"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);

        HashMap<Integer, User> userHashMap = new HashMap<>();

        for (int i = 1; i <= likedDAO.id; i++){
            userHashMap.put(i, userDAO.get(likedDAO.get(i).getUserId()));
        }

        Map<String, Object> model = new HashMap<>();


        model.put("likedUsers", userHashMap);

        Template template = cfg.getTemplate("liked.html");
        Writer out = resp.getWriter();

        try {
            template.process(model, out);

        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
