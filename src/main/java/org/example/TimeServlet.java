package org.example;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/time")
public class TimeServlet extends HttpServlet {
    String timezone;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=utf-8");
        timezone = req.getParameter("timezone");
        resp.getWriter().write(getCurrentUtcTime(timezone));
        resp.getWriter().close();
    }

    public static String getCurrentUtcTime(String timezone) {
        if (timezone == null) {
            timezone = "UTC";
        } else if (timezone.contains(" ")) {
            timezone = timezone.replace(" ", "+");
        }
        ZoneId zone = ZoneId.of(timezone);
        ZonedDateTime zonedDateTime = ZonedDateTime.now(zone);
        return zonedDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss '" + timezone + "'"));
    }
}
