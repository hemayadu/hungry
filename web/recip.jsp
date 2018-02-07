<%-- 
    Document   : recip
    Created on : Feb 5, 2018, 7:43:41 PM
    Author     : yaduvanshi hema
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body background="kitchen.jpg">
     <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
        <h1>HUNGRI</h1>
    </div>
      <ul  class="nav navbar-nav navbar-right">
      <li class="active"><a href="recip.jsp">Search by recipe</a></li>
      <li><a href="index.html">Search by ingrediants</a></li>
      <li><a href="order.html">Order</a></li>
      </ul>
  </div>
</nav>
        <div class="container">
            <form action="GetByRecipe" method="post">
                Recipe Name<input type="text" name="recipe" class="form-control" required/>
               
                    <select name="cusine" class="form-control">
                        <option value="indian" >Indian</option>
                        <option value="chinese">Chinese</option>
                        <option value="french">French</option>
                    </select>
           
                <p align="center"><button type="submit" class="btn btn-primary">Click</button></p>
                

            </form>
        </div>
    </body>
</html>
