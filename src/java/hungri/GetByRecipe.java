/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hungri;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "GetByRecipe", urlPatterns = {"/GetByRecipe"})
public class GetByRecipe extends HttpServlet {
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int p=-1;
          PrintWriter out=response.getWriter();
        String recipe=request.getParameter("recipe");
        String c=request.getParameter("cusine");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hungri", "root", "root");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from "+c+" where RecipeName='" + recipe + "'");
                
            out.print(" <head>\n"
                + "        <title>TODO supply a title</title>\n"
                + "        <meta charset=\"UTF-8\">\n"
                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                + "  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n"
                + "  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n"
                + "  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n"
                + "    </head>\n"
                + "    <body>");
        out.print(" <nav class=\"navbar navbar-inverse\">\n"
                + "  <div class=\"container-fluid\">\n"
                + "    <div class=\"navbar-header\">\n"
                + "        <h1>HUNGRI</h1>\n"
                + "    </div>\n"
                + "      <ul  class=\"nav navbar-nav navbar-right\">\n"
                + "      <li class=\"active\"><a href=\"recip.jsp\">Search by recipe</a></li>\n"
                + "      <li><a href=\"index.html\">Search by ingrediants</a></li>\n"
                + "      <li><a href=\"order.html\">Order</a></li>\n"
                + "      </ul>\n"
                + "  </div>\n"
                + "</nav>\n"
                + "        <div class=\"container\">");
                  while (rs.next()) {
                      p++;
               out.print("<div><h1 align=\"center\">");
               out.print(rs.getString(4));
               out.print("</h1></div>");
               out.print("<a href=\""+rs.getString(6)+"\"><img src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ0IS6djw7ie6z2mujo0OFW9zrx5oE4Xhi9C41yjJDP2QLt1U0P\"/></a><br/>");
               out.print("<img src=\""+rs.getString(7)+"\"/>");
               out.print("<div><h2>Ingrediants</h2><p>");
               out.write(rs.getString(3));
               out.print("</p></div>");
               out.print("<div><h2>Steps</h2><p>");
               out.print(rs.getString(5));
               out.print("</p></div>");
                  }
                  if(p<0){
                      out.print("Match not found");
                  }
                 
        out.print("</div>\n"
                + "    </body>");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    
}
