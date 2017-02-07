package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        System.out.println(session.getId());
        Enumeration attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            Object o = attributeNames.nextElement();
            System.out.println(session.getAttribute(o.toString()));
        }
        if (session.getAttribute("test") == null) {
            session.setAttribute("test", "hello world");
        }

        PrintWriter writer = resp.getWriter();
        writer.print("<a href=\"?name=max\">link</a>");

        if (req.getParameter("name") != null) {
            System.out.println(req.getParameter("name"));
        }

        int maxInactiveInterval = session.getMaxInactiveInterval();
        System.out.println(maxInactiveInterval);
    }
}
