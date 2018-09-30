<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <spring:url value="/css/home.css" var="home" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kitabxana</title>
        <link href="${home}" rel="stylesheet" />
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <style>
            .box.login {
                height: 350px;
                width: 332px;
                position: absolute;
                left: 50%;
                top: 50%;
                margin: -130px 0 0 -166px;
            }
        </style>

    </head>
    <body>
        <form:form method="POST" modelAttribute="user" class="box login">
            <fieldset class="boxBody" style="height: 480px;">
                <form:label path="full_name">
                    Full Name
                </form:label>
                <form:input path="full_name" />
                <form:errors path="full_name" cssClass="error" element="span"/>

                <form:label path="email">
                    Email
                </form:label>
                <form:input  path="email" />
                <form:errors path="email" cssClass="error" element="span"/>

                <form:label path="password">
                    Password
                </form:label>
                <form:input path="password" />
                <form:errors path="password" cssClass="error" element="span"/>

                <button  type="submit" class="btnLogin">Save</button>
            </fieldset>
        </form:form>
    </body>
</html>
