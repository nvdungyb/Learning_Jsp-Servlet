package servlet.security;

import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.HttpMethodConstraint;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet(
        name = "ServletSecurity",
        urlPatterns = {"/security"}
)
@jakarta.servlet.annotation.ServletSecurity(
        value = @HttpConstraint(rolesAllowed = {"Member"}),
        httpMethodConstraints = {@HttpMethodConstraint(value = "GET", rolesAllowed = {"admin"})}
)
public class ServletSecurity extends HttpServlet {

}

//https://www.baeldung.com/javaee-web-annotations

// Tôi chưa biết làm thế nào để cấp quyền cho user.

