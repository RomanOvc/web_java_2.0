package Servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/lol")
public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        String image_naem = request.getQueryString();
    }


    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        // Формируем путь к картинкам
        // для проверки поменять на сво путь -> "c:\\You\\path\\for\\image\\"
        String image_name = request.getParameter("image_name");
        System.out.println("image_name: " + image_name);
        String image_full_path = "c:\\Users\\Roman\\Pictures\\" + image_name;
        System.out.println(image_full_path);

        response.setContentType("image/jpeg");
        //считать картинку с диска в память, после чего выдать html-страницу с ней и её именем в качестве ответа на запрос
        ServletOutputStream out;
        out = response.getOutputStream();
        FileInputStream fin = new FileInputStream(image_full_path);

        BufferedInputStream bin = new BufferedInputStream(fin);
        BufferedOutputStream bout = new BufferedOutputStream(out);
        int ch = 0;

        while ((ch = bin.read()) != -1) {
            bout.write(ch);
        }

        bin.close();
        fin.close();
        bout.close();
        out.close();
        request.setAttribute("image_name", image_name);
    }
}