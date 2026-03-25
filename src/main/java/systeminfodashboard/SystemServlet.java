import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/system")
public class SystemServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String userAgent = request.getHeader("User-Agent");
        String language = request.getHeader("Accept-Language");

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String currentTime = now.format(formatter);

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>System Info</title>");
        out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css' rel='stylesheet'>");
        out.println("</head>");
        out.println("<body class='bg-light'>");

        out.println("<div class='container mt-5'>");
        out.println("<h2 class='mb-4 text-center'>Thông tin hệ thống</h2>");

        out.println("<table class='table table-bordered table-striped'>");
        out.println("<thead class='table-dark'>");
        out.println("<tr><th>Thông tin</th><th>Giá trị</th></tr>");
        out.println("</thead>");
        out.println("<tbody>");

        out.println("<tr><td>User-Agent</td><td>" + userAgent + "</td></tr>");
        out.println("<tr><td>Language</td><td>" + language + "</td></tr>");
        out.println("<tr><td>Server Time</td><td>" + currentTime + "</td></tr>");

        out.println("</tbody>");
        out.println("</table>");

        out.println("<div class='text-center'>");
        out.println("<a href='index.jsp' class='btn btn-secondary'>Quay lại</a>");
        out.println("</div>");

        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}