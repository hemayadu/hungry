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
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yaduvanshi hema
 */
@WebServlet(name = "GetVal", urlPatterns = {"/GetVal"})
public class GetVal extends HttpServlet {

    static String c;
    static int p = -1;
    static String st[] = new String[100];
    static String recip[] = new String[100];
    static int z = -1;
    static String temp;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        c = request.getParameter("cusine");
        int n = Integer.parseInt(request.getParameter("no"));
        String[] ing = new String[n];
        for(int z=0;z<n;z++){
           ing[z]=request.getParameter("ing"+z);
        }
        Arrays.sort(ing);
        
        printCombination(ing, n, n);
        connection();
        
       
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
         if(p<0){
            out.print("Match not found");
        
        }else{
        String[] b = new String[p + 1];
        for (int i = 0; i <=p; i++) {
            b[i]=recip[i];           
        }
            out.print("<form action=\"GetRecipe\" method=\"post\" >");
            out.print("<div class=\"form-group\">");
              out.print("<input type=\"text\" name=\"cusine\" value=\""+c+"\" class=\"form-control\" readonly/ >");
           out.print("<br/>");
              for (int j=0;j<=p;j++) {
                  
            out.print("Select a recipe<input type=\"radio\" name=\"recipe\" value=\""+b[j]+"\"/>"+b[j]+"<br/>");          
        }
            
            out.print(" <p align=\"center\"><button type=\"submit\" value=\"click\" class=\"btn btn-primary\"/>Click</button></p>");  
             
         out.print("</div>");
          out.print("</form>");
        out.print("</div>\n"
                + "    </body>");
        z=-1;p=-1;
        
        }
         
       
    }

    static void combinationUtil(String arr[], String data[], int start, int end, int index, int r) {
        if (index == r) {
            ++z;
            for (int j = 0; j < r; j++) {
                if (j != 0) {

                    temp = st[z] + "," + data[j];
                } else {

                    temp = data[j];
                }
                st[z] = temp;
                // System.out.print(st[z]+",\n");
            }
            //  System.out.print("\n");

            return;
        }

        for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
            data[index] = arr[i];
            combinationUtil(arr, data, i + 1, end, index + 1, r);
        }
    }

    public void printCombination(String arr[], int n, int r) {
          
        String data[] = new String[r];
        while (r >= 0) {

            combinationUtil(arr, data, 0, n - 1, 0, r);
            r--;

        }
    }

    public String[] connection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hungri", "root", "root");
            for (int a = 0; a < z; a++) {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select RecipeName from " + c + " where Ing='" + st[a] + "'");
                while (rs.next()) {
                    ++p;
                    recip[p] = rs.getString(1);
                }
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
       return recip;
    }
}
