package com.example.jakartasecurity.example2;

import jakarta.security.enterprise.authentication.mechanism.http.FormAuthenticationMechanismDefinition;
import jakarta.security.enterprise.authentication.mechanism.http.LoginToContinue;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@FormAuthenticationMechanismDefinition(loginToContinue = @LoginToContinue(
        loginPage = "/login",
        errorPage = "/error"
))
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"ADMIN", "MANAGER"}))
@WebServlet(urlPatterns = "/form")
public class FormSecurityServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getUserPrincipal() != null ? req.getUserPrincipal().getName() : "unauthenticated";
        resp.getWriter().write("username: " + userName);
    }
}
