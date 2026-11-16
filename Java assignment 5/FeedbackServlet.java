package com.feedbackapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FeedbackServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // Read the values submitted by feedback.html.
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String feedbackType = request.getParameter("feedbackType");
        String comments = request.getParameter("comments");

        // Format the current date and time.
        String currentDateTime = LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss a"));

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html lang='en'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<title>Feedback Submitted</title>");
            out.println("<style>");
            out.println("body{font-family:Arial,sans-serif;background:#f3f6fb;margin:0;padding:30px;color:#263238}");
            out.println(".card{max-width:650px;margin:40px auto;background:white;padding:30px;border-radius:14px;box-shadow:0 5px 22px #00000012}");
            out.println("h1{color:#1769aa} .label{font-weight:bold;color:#37474f}");
            out.println(".value{background:#f5f8fc;padding:12px;border-radius:7px;overflow-wrap:anywhere}");
            out.println("a{display:inline-block;margin-top:18px;background:#1769aa;color:white;text-decoration:none;padding:11px 18px;border-radius:7px}");
            out.println("</style></head><body><main class='card'>");
            out.println("<h1>Feedback Submitted Successfully!</h1>");
            out.println("<h2>Thank you, " + escapeHtml(name) + " for your feedback!</h2>");

            out.println("<p class='label'>Email</p>");
            out.println("<div class='value'>" + escapeHtml(email) + "</div>");

            out.println("<p class='label'>Feedback Type</p>");
            out.println("<div class='value'>" + escapeHtml(feedbackType) + "</div>");

            out.println("<p class='label'>Comments</p>");
            out.println("<div class='value'>" + escapeHtml(comments).replace("\n", "<br>") + "</div>");

            out.println("<p class='label'>Current Date and Time</p>");
            out.println("<div class='value'>" + escapeHtml(currentDateTime) + "</div>");

            out.println("<a href='feedback.html'>Submit another response</a>");
            out.println("</main></body></html>");
        }
    }

    // Escape user-entered text before placing it in the HTML response.
    private String escapeHtml(String value) {
        if (value == null) {
            return "";
        }
        return value.replace("&", "&amp;")
                    .replace("<", "&lt;")
                    .replace(">", "&gt;")
                    .replace("\"", "&quot;")
                    .replace("'", "&#x27;");
    }
}
