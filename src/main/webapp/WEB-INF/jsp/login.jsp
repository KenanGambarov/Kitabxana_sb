<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
    <head>
        <spring:url value="/resources/css/home.css" var="home" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kitabxana</title>
        <link href="${home}" rel="stylesheet" />
    </head>
    <body>

        <c:url value="/j_spring_security_check" var="loginUrl" />
        <form  action="/main" method='POST' class="box login">
            <fieldset class="boxBody">

                <label>
                    Email
                </label>
                <input name="username" type="text">
                <label>
                    Password
                </label>
                <input name="password" type="password"/>

                <input name="submit" type="submit" value="Login" class="btnLogin"/>
                <br/>
                
                <a href="registration" class="a">Sign Up</a>

                <input type="hidden" name="${_csrf.parameterName}"
                                       value="${_csrf.token}" />
                
            </fieldset>&nbsp;

            <c:if test="${not empty error}">         
                <div class="error" style="text-align: center">
                    ${error}  
                </div>
            </c:if>
        </form>
    </body>
</html>
