package servlet.fileupload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet(urlPatterns = {"/multipleUploads"})
@MultipartConfig
public class UploadFileServlet2 extends HttpServlet {

    private AtomicInteger num = new AtomicInteger(0);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("upload_input++.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String realPath = getServletContext().getRealPath("/WEB-INF");
        Collection<Part> parts = req.getParts();
        for (Part part : parts) {
            if (part.getContentType() != null) {
                String fileName = getFileName(part);
                part.write(realPath + "/" + fileName);
            }
        }
    }

    private String getFileName(Part part) {
        String disposition = part.getHeader("content-disposition");
        String[] elements = disposition.split(";");
        for (String element : elements) {
            if (element.trim().startsWith("filename")) {
                return element.substring(element.indexOf("=") + 1).trim().replace("\"", "");
            }
        }
        return "default" + num.getAndIncrement();
    }
}
