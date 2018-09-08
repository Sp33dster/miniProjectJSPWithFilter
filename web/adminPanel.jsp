
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your admin panel</title>
</head>
<body>
<h1>This is your admin panel. You can upload files here</h1>
<br>
<%
    if (request.getAttribute("upload_message") != null && !request.getAttribute("upload_message").equals("")) {

%>
<h1><%=request.getAttribute("upload_message")%></h1><br>

<%
    
%>

<form action="/uploadFile" method="post" enctype="multipart/form-data">
    <input type="file" name="file" >
    <input type="submit" value="upload" >

</form>
</body>
</html>
