package cn.maxlu.servlet.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

//@WebFilter(filterName = "loggingFilter", urlPatterns = {"/*"},
//        initParams = {@WebInitParam(name = "logFileName", value = "log"), @WebInitParam(name = "prefix", value = "URI:")})
public class LoggingFilter implements Filter {

    private String prefix;
    private PrintWriter loggger;
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String logFileName = filterConfig.getInitParameter("logFileName");
        this.prefix = filterConfig.getInitParameter("prefix");
        String realPath = filterConfig.getServletContext().getRealPath("/");
        File file = new File(realPath, logFileName + atomicInteger + ".txt");
        while (file.exists()) {
            file = new File(realPath, logFileName + atomicInteger.incrementAndGet() + ".txt");
        }
        try {
            this.loggger = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String requestURI = httpServletRequest.getRequestURI();
        loggger.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()) + " " + prefix + requestURI);
        loggger.flush();
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        if (this.loggger != null) {
            this.loggger.close();
        }
    }
}
