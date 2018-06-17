package xyz.siomochkin;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import xyz.siomochkin.servlets.LikedServlet;
import xyz.siomochkin.servlets.StaticServlet;
import xyz.siomochkin.servlets.UserServlet;
import xyz.siomochkin.dao.LikedDAO;
import xyz.siomochkin.dao.UserDAO;

public class ServerApp {
    public static void main(String[] args) throws Exception {

        LikedDAO likedDAO = new LikedDAO();
        UserDAO userDAO = new UserDAO();

        Server server = new Server(8080);

        ServletContextHandler handler = new ServletContextHandler();
        ServletHolder holderUser = new ServletHolder(new UserServlet(1, userDAO, likedDAO));
        ServletHolder holderLiked = new ServletHolder(new LikedServlet(userDAO, likedDAO));
        ServletHolder holderStatic = new ServletHolder(new StaticServlet());


        handler.addServlet(holderUser, "/user");
        handler.addServlet(holderLiked, "/liked");
        handler.addServlet(holderStatic, "/css/*");

        server.setHandler(handler);
        server.start();
        server.join();
    }
}
