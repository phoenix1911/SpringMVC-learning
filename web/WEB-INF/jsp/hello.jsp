<%@ page import="java.util.Enumeration" %><%--
  User: TJL Date: 2018/9/12  Time: 10:23
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Test1.hellojsp</title>
    <link rel="stylesheet" href="css/common.css" type="text/css">
</head>
<body>
    <h1>hello.jsp</h1>
    day1:
    <ul>
        <li>http://localhost:8080/springmvc/test1hello.action
            day1[TestHelloControlloer]<br>
            model.msg:${msg}<br>
            request.paramter,name:<%=request.getParameter("name")%>
        </li>
        <li>
            <img src="images/1.jpg">
        </li>
        <li>
            model[msg]:${msg}****${requestScope.msg}***<%=request.getAttribute("msg")%><br>
            user:${user}<br>
            <%=request.getMethod()%>
            <%--<%--%>
                <%--Enumeration<String> attributeNames = request.getAttributeNames();--%>
                <%--while (attributeNames.hasMoreElements()) {--%>
                    <%--String key = attributeNames.nextElement();--%>
                    <%--out.write(key+": "+request.getAttribute(key)+"<br>");--%>
                <%--}--%>

            <%--%>--%>

        </li>
        <li>
            model[msg]:${msg }****${requestScope.msg }***<%=request.getAttribute("msg") %><br/>
            session.msg:${sessionScope.msg }<br/>
            name:${name }<br/>
            user:${requestScope.user }
        </li>
    </ul>
</body>
</html>
