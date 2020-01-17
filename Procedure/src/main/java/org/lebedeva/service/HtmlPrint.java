package org.lebedeva.service;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface HtmlPrint {
    static void printTable(PrintWriter writer, String[] createTable, ResultSet resultSet) throws SQLException {
        writer.println("<!DOCTYPE html>\n" + "<html lang=\"en\">\n" + "<head>\n"
                + "    <meta charset=\"UTF-8\">\n" + "<title>Table</title>\n"
                + "<link rel=\"stylesheet\" type=\"text/css\" href=\"/static/css/2.css\">" +
                "</head><body>");

        writer.println("<table><thead><tr>\n");

        for (String s : createTable) {
            writer.println("<th>" + s + "</th>\n");
        }
        writer.println("</tr>" + "</thead><tbody>\n" + "<tr>\n");

        while (resultSet.next()) {
            for (String s : createTable) {
                writer.println("<td>" + resultSet.getString(s) + "</td>\n");
            }
            writer.println("</tr>");
        }
        writer.println("</tbody></table>");
        writer.println("</body></html>");
    }
}
