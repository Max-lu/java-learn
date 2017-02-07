package servlet.async;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/async2"}, asyncSupported = true)
public class AsyncServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.print("<html><head><title>Async Servlet</title></head><body><div id='process'></div>");

        AsyncContext asyncContext = req.startAsync();
        asyncContext.setTimeout(60000);
        asyncContext.addListener(new MyAsyncListener());
        asyncContext.start(() -> {
            for (int i = 0; i < 10; i++) {
                writer.print("<script>");
                    String script = "document.getElementById('process').innerHTML='" + (i * 10) + "% complete...'";
                writer.print(script);
                writer.print("</script>");
                writer.flush();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            writer.print("<script>");
            writer.print("document.getElementById('process').innerHTML='100% complete'");
            writer.print("</script>");
            writer.print("</body></html>");
            asyncContext.complete();
        });

    }
}
