package org.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;

@WebServlet("/time")
public class TimeServlet extends HttpServlet {

    private String initTime;

    @Override
    public void init() throws ServletException {
        initTime = Instant.now().toString();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().write(initTime);
        resp.getWriter().close();
    }

    @Override
    public void destroy() {
        initTime = null;
    }
}
