package servlet.filedownload;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

public class DownLoadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        download(resp);
    }

    private void download(HttpServletResponse response) throws IOException {
        int length = 0;
        String file = "test.txt";

        ServletOutputStream out = response.getOutputStream();
        ServletContext servletContext = getServletConfig().getServletContext();
        ServletContext servletContext1 = getServletContext();
        System.out.println(servletContext == servletContext1);
        System.out.println(servletContext.equals(servletContext1));
        String mimeType = servletContext.getMimeType(file);
        response.setContentType(mimeType == null ? "text/plain" : mimeType);
        response.setHeader("Content-Disposition", "attachment;filename=\"test.txt\"");

        InputStream in = servletContext.getClassLoader().getResourceAsStream(file);
//        int temp;
//        while (in != null && ((temp = in.read()) != -1)) {
//            out.write(temp);
//        }

        byte[] buffer = new byte[1024];
        while (in != null && ((length = in.read(buffer)) != -1)) {
            out.write(buffer, 0, length);
        }
        out.flush();
        out.close();
    }
}
