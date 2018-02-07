package hungri;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Get", urlPatterns = {"/Get"})
public class Get extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String num = request.getParameter("no");
        int n = Integer.parseInt(num);
        String[] ing = new String[n];
        out.print(" <head>\n"
                + "        <title>TODO supply a title</title>\n"
                + "        <meta charset=\"UTF-8\">\n"
                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                + "  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n"
                + "  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n"
                + "  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n"
                + "    </head>\n"
                + "    <body background=\"kitchen.jpg\">");
        out.print(" <nav class=\"navbar navbar-inverse\">\n"
                + "  <div class=\"container-fluid\">\n"
                + "    <div class=\"navbar-header\">\n"
                + "        <h1>HUNGRI</h1>\n"
                + "    </div>\n"
                + "      <ul  class=\"nav navbar-nav navbar-right\">\n"
                + "      <li><a href=\"recip.jsp\">Search by recipe</a></li>\n"
                + "      <li class=\"active\"><a href=\"index.html\">Search by ingrediants</a></li>\n"
                + "      <li><a href=\"order.html\">Order</a></li>\n"
                + "      </ul>\n"
                + "  </div>\n"
                + "</nav>\n"
                + "        <div class=\"container\">");
        out.print("<form action=\"GetVal\" method=\"post\" >");
        out.print("<input type=\"number\" name=\"no\" value=" + n + " class=\"form-control\" readonly / >");
        out.print("<br/>");
        out.print("<select name=\"cusine\" class=\"form-control\">\n" +
"                        <option value=\"indian\" >Indian</option>\n" +
"                        <option value=\"chinese\">Chinese</option>\n" +
"                        <option value=\"french\">French</option>\n" +
"                    </select>");
        out.print("<br/>");
        for (int z = 0; z < n; z++) {
            out.print("Ingredient " + (z + 1));
            out.print("<input type=\"text\" name=\"ing" + z + "\" class=\"form-control\" required / >");
            out.print("<br/>");
        }
        out.print(" <p align=\"center\"><button type=\"submit\" value=\"click\" class=\"btn btn-primary\">Click</button></p>");
        out.print("</form>");
        out.print("</div>\n"
                + "    </body>");
    }

}
