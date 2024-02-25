package controller;

import dao.UserDao;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(
        urlPatterns = {"/checkLogin"},
        initParams = {@WebInitParam(name = "adminName", value = "nvdungyb"),
                @WebInitParam(name = "adminPassword", value = "admin"),
                @WebInitParam(name = "adminEmail", value = "nguyenvandungk49a1@gmail.com")}
)
public class Login extends HttpServlet {
    private Connection connection = null;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        doPost(req, res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String userName = req.getParameter("UserName").trim();
        String pass = req.getParameter("UserPassword").trim();
        User user = null;
        try {
            user = UserDao.login(userName, pass);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String submitButton = req.getParameter("submit");

        if (submitButton != null && submitButton.equals("Submit")) {
            HttpSession httpSession = req.getSession(true);
            httpSession.setAttribute("user", user);         // Lưu thông tin user vào session, nếu Session không tồn tại thì tạo mới.

            if (httpSession.getAttribute("isLogined") == null) {
                httpSession.setAttribute("isLogined", true);
                httpSession.setAttribute("admin", true);
            }

//            req.getRequestDispatcher("wellcome.jsp").forward(req, res);
            req.getRequestDispatcher("cookie").forward(req, res);

        } else if (submitButton != null && submitButton.equals("Register")) {
            // Để đk thì user không tồn tại trong db.
            if (user == null) {
                if (!userName.isEmpty() && !pass.isEmpty()) {
                    boolean isInserted = UserDao.saveUser(new User(userName, pass));        // New user.
                    if (isInserted) {
                        System.out.println("User đã được đăng kí");
                    } else {
                        System.out.println("User đăng kí không thành công");
                    }
                }
            }

            req.getRequestDispatcher("index.jsp").forward(req, res);
        }
    }
}
