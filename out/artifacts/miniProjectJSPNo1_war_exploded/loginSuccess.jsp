
<%@ page contentType="text/html;charset=UTF-8" language="java"
            pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Success Page</title>
</head>
<body>
<%
    //allow access only if session exist
    String user = (String) session.getAttribute("user");
    String userName = null;
    String sessionID = null;
    Cookie[] cookies = request.getCookies();
    if (cookies != null){
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("user")) userName = cookie.getValue();
            if (cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();

        }
    }

%>

<p><font color="blue"> This info is from cookies</font> </p><br>
<h3> Hi <%= userName%>, your session ID is: <%=sessionID%></h3><br>
<p><font colour="blue">This info is from session</font></p><br>
<h3>The session user is: <%=user%></h3><br>

<a href="/adminPanel.jsp"> Go to your admin panel</a>

<form action="/logout" method="get">
    <input type="submit" value="Log Out">
</form>


</body>
</html>
