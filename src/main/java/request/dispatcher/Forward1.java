package request.dispatcher;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class Forward1 extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        PrintWriter pr = res.getWriter();

        pr.write("<h1> Hello from Forward1 </h1>");

        // Request scope.
        req.setAttribute("attr1", "value1");

        RequestDispatcher rd = req.getRequestDispatcher("forward2");
        rd.forward(req, res);
    }
}


/* Phương thức forward của interface RequestDispatcher:
_ Được sử dụng để chuyển hướng request từ một servlet đến một servlet khác, và không quay lại servlet gốc.
_ Được sử dụng khi muốn chuyển tiếp quyền kiểm soát hoàn toàn từ servlet này sang servlet khác để xử lý request.
 */