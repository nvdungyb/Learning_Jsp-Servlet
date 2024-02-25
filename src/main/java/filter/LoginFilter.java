package filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;
import java.io.PrintWriter;

/*
 Chỉ định rằng Filter sẽ được áp dụng cho mọi yêu cầu đến đường dẫn /checkLogin.
 */

@WebFilter("/checkLogin")
public class LoginFilter implements Filter {
    private String adminName = "nvdungyb";
    private static int countVisistor = 0;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
        countVisistor++;
        System.out.println("Number of visitors: " + countVisistor);

        String userName = req.getParameter("UserName");
        if (userName.equals(adminName)) {
            req.getRequestDispatcher("admin.jsp").forward(req, res);

//      Sending response by filter only.
//            PrintWriter pr = res.getWriter();
//            pr.write("<h1>This site is under construction</h1>");
//            pr.close();
//      We can checking total response time in filter and more...
        } else {
            filterChain.doFilter(req, res);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
