package org.example;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (Connection conn = DBUtil.getConnection()) {
            String query = "SELECT name, votes FROM candidates";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            response.getWriter().println("<h1>Voting Results</h1>");
            while (rs.next()) {
                response.getWriter().println("<p>" + rs.getString("name") + ": " + rs.getInt("votes") + " votes</p>");
            }
        } catch (Exception e) {
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}

