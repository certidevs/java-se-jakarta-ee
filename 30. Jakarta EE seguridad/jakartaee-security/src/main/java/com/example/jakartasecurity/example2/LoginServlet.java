package com.example.jakartasecurity.example2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("""
                                
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <title>Title</title>
                </head>
                <body>

                <h2>Login to continue</h2>
                <form method="post" action="j_security_check">
                    <label>
                        Username:
                        <input type="text" name="j_username">
                    </label>

                    <label>
                        Password:
                        <input type="password" name="j_password">
                    </label>

                    <input type="submit" value="Iniciar sesión">
                </form>
                </body>
                </html>
                                
                                
                """);
    }
}
