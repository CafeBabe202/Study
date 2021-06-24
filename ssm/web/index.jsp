<%@ page import="cn.happyOnion801.study.ssm.controller.Hello" %>
<%--
  Created by IntelliJ IDEA.
  User: zhanghao
  Date: 2021/5/10
  Time: 下午4:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
</head>

<body>
<%
    Hello hello = new Hello();
    out.print(hello.say());
%>
<a href="${pageContext.request.contextPath}/arrayList?arr=1,2,3">集合类型</a>
<hr/>
<a href="${pageContext.request.contextPath}/map?a=12&b=21">Map</a>
<hr/>
<a href="${pageContext.request.contextPath}/date?publicationDate=2020-01-02">日期转换</a>
<hr/>
<a href="${pageContext.request.contextPath}/download">下载</a>
<hr/>
<a href="${pageContext.request.contextPath}/upload">上传</a>
<hr/>
<a href="${pageContext.request.contextPath}/error">Error</a>
<hr/>
<a href="${pageContext.request.contextPath}/inter">拦截器</a>
<hr/>
<form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="tx" multiple="multiple"/>
    <input type="submit" value="submit"/>
</form>
</body>
</html>
