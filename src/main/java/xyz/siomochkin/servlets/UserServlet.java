package xyz.siomochkin.servlets;

import org.apache.commons.io.FileUtils;
import xyz.siomochkin.dao.LikedDAO;
import xyz.siomochkin.dao.UserDAO;
import xyz.siomochkin.model.Liked;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class UserServlet extends HttpServlet {


    private Integer id;
    UserDAO userDAO;
    LikedDAO likedDAO;

    public UserServlet(Integer id, UserDAO userDAO, LikedDAO likedDAO) {
        this.id = id;
        this.userDAO = userDAO;
        this.likedDAO = likedDAO;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();
        File file = new File("lib/static/html/LikePage.html");
        String outText = new FileUtils().readFileToString(file);

        if (id == userDAO.id + 1) {
            resp.sendRedirect("/liked");
            id = 1;

        }

        outText = String.format(outText, userDAO.get(id).getImage(), userDAO.get(id).getName());
        writer.print(outText);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String like = req.getParameter("like");


        if (like.equals("yes")) {
            Liked setter = new Liked();
            setter.setLikedId(likedDAO.id);
            setter.setUserId(userDAO.get(id).getId());
            setter.setChatId(1);
            likedDAO.save(setter);
            id++;
            doGet(req, resp);
        } else {
            id++;
            doGet(req, resp);
        }


    }
}
