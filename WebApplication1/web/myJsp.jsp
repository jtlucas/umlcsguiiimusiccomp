<%-- 
    Document   : myJsp
    Created on : Dec 4, 2008, 11:08:03 AM
    Author     : Jesse
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Hello World!</h2>
        <p>
            <%
            out.print("This is from real Java<br/>");
            for(int k =0 ;k < 5 ; k++){
                out.println(k + " -- text <br/>");
            }
                
            %>
        </p>
    </body>
</html>
