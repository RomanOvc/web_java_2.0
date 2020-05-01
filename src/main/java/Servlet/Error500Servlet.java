package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet(urlPatterns = "/error500")
public class Error500Servlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        try (PrintWriter writer = response.getWriter()) {
            writer.write("<html><head><title>Error description</title></head><body>");
            writer.write("<h2>неправильная ссылка на картинку или не правильно введено имя картинки</h2>");
            writer.write("<a href='http://localhost:9090'>Повторите попытку</a>");
            writer.write("</html></body>");
        }
    }
}