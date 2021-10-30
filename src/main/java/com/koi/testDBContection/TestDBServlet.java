package com.koi.testDBContection;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

    @WebServlet(name = "TestDBServlet", value = "/TestDBServlet")
public class TestDBServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jdbcUrl = "jdbc:sqlserver://localhost:1433;databaseName=SpringMVC;user=sa;password=ankoi03102001;";
        try {
            PrintWriter out = response.getWriter();
            System.out.println("Connecting to Database: " + jdbcUrl);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(jdbcUrl);
            out.println("Success!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
