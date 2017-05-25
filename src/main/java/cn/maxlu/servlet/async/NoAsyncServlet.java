package cn.maxlu.servlet.async;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;

@WebServlet(urlPatterns = {"/noAsync"})
public class NoAsyncServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long start = System.nanoTime();
        System.out.println("servlet thread start " + Thread.currentThread().getName() + " " + LocalTime.now());

        longProcess();

        long end = System.nanoTime();
        System.out.println("servlet thread end" + Thread.currentThread().getName() + " " + LocalTime.now());
        System.out.println("cost " + (end - start) / 1000000 + " ms");
    }

    private void longProcess() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
