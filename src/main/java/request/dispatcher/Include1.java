package request.dispatcher;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/include1")
public class Include1 extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        PrintWriter pr = res.getWriter();

        pr.write("<h1> Hello from Include1 </h1>");

        // Request scope.
        req.setAttribute("attr1", "value1");

        RequestDispatcher rd = req.getRequestDispatcher("include2");
        rd.include(req, res);
    }
}

/* Include method of RequestDispatcher interface:
_ Được sử dụng để bao gồm response của một servlet trong response của servlet khác.
_ Cụ thể yêu cầu vẫn tiếp tục được xử lý bởi servlet được include và nội dung của response được bao gồm tất cả các response
của servlet gốc và servlet được include.
_ Thường được sử dụng khi muốn kết hợp nội dung từ nhiều nguồn khác nhau để tạo ra một phản hồi hoàn chỉnh.
 */