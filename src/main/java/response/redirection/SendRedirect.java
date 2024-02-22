package response.redirection;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SendRedirect extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        res.sendRedirect("https://www.youtube.com");

    }
}
