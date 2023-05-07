package com.example.jakartasecurity.example1;

import jakarta.inject.Inject;
import jakarta.security.enterprise.SecurityContext;
import jakarta.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@BasicAuthenticationMechanismDefinition(realmName = "userRealm")
@WebServlet(value = "/basic")
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"ADMIN"}))
public class BasicSecurityServlet extends HttpServlet {

    @Inject
    private SecurityContext securityContext;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("" +
                "Authentication type: " + req.getAuthType() + "\n" +
                "Principal: " + req.getAuthType() + "\n" +
                "User in role MANAGER: " + securityContext.isCallerInRole("MANAGER") + "\n" +
                "User in role ADMIN: " + securityContext.isCallerInRole("ADMIN") + "\n" +
                "name: " + req.getUserPrincipal() != null ? req.getUserPrincipal().getName() : "unauthenticated"

                );
    }
}
