package filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/*
 Chỉ định rằng Filter sẽ được áp dụng cho mọi yêu cầu đến đường dẫn /checkLogin.
 */

@WebFilter("/checkLogin")
public class LoginFilter implements Filter {
    private String adminName = "nvdungyb";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
        String userName = req.getParameter("UserName");
        if (userName.equals(adminName)) {
            req.getRequestDispatcher("admin.jsp").forward(req, res);
        } else {
            filterChain.doFilter(req, res);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
