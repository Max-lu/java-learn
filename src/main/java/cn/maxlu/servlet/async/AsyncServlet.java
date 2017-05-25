package cn.maxlu.servlet.async;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;

@WebServlet(urlPatterns = {"/async"}, asyncSupported = true)
public class AsyncServlet extends HttpServlet {

    //释放servlet线程，启动新的线程处理耗时任务，自动管理线程池
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long start = System.nanoTime();
        System.out.println("servlet thread start " + Thread.currentThread().getName() + " " + LocalTime.now());

        AsyncContext asyncContext = req.startAsync();
        req.setAttribute("mainThread", Thread.currentThread().getName());
        asyncContext.setTimeout(5000);
        asyncContext.start(() -> {
            longProcess();
            req.setAttribute("workThread", Thread.currentThread().getName());
            asyncContext.dispatch("/threadName.jsp");
        });


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
