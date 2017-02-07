package servlet;

import servlet.listener.httpsession.MyHttpSessionBindingListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/attribute/listener")
public class ListenerTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("name", "max1");
        servletContext.setAttribute("name", "max2");
        servletContext.removeAttribute("name");

        MyHttpSessionBindingListener my = new MyHttpSessionBindingListener();
        my.setName("max2222");
        HttpSession session = req.getSession();
        session.setAttribute("my", my);
        session.removeAttribute("my");
    }
}
