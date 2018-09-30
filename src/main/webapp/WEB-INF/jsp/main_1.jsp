<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
    <head>
        <spring:url value="/resources/css/my-theme.css" var="theme" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hospitals project</title>
        <link href="${theme}" rel="stylesheet" />
        <script>
            function change1() {
                var x = document.getElementById("author").selectedIndex;
                var y = document.getElementById("author").options;
                document.getElementById("auth").value = y[x].value;
            }
            function change2() {
                var x = document.getElementById("title").selectedIndex;
                var y = document.getElementById("title").options;
                document.getElementById("titl").value = y[x].value;
            }
        </script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    </head>

    <body>
        <c:url value="/j_spring_security_logout" var="logoutUrl" />
        <form action="${logoutUrl}" method="post" id="logoutForm">
            <input type="hidden" name="${_csrf.parameterName}"
                   value="${_csrf.token}" />
        </form>

        <script>
            function formSubmit() {
                document.getElementById("logoutForm").submit();
            }
        </script>          
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <a href="javascript:formSubmit()"  type="submit"><i></i> Sistemdən çıxış</a>
        </c:if>          
            <br/><br/>
        <form:form  commandName="main">
            <form:select onchange="change1();" id="author" path="author" cssClass="inputfield inputtext widget state corner-all">
                <form:option label="List of Author" value="${null}"/>
                <form:options items="${author_list}" itemLabel="author" itemValue="author"/>
            </form:select>
            <form:select onchange="change2();" id="title" path="title" cssClass="inputfield inputtext widget state corner-all">
                <form:option label="List of Title" value="${null}"/>
                <form:options items="${title_list}" itemLabel="title" itemValue="title"/>
            </form:select>&nbsp;&nbsp;    
            <button type="submit" class="button widget state corner-all" style="width: 80px;height: 25px;">Select</button>
            <br/><br/>
            <input id="auth" type="text" name="author" class="inputfield inputtext widget-content widget state corner-all" />&nbsp;&nbsp;&nbsp;&nbsp;
            <input id="titl" type="text" name="title" class="inputfield inputtext widget-content widget state corner-all" />
            <br/><br/>
            <table border="1">
                <thead>
                    <tr>
                        <th>Author</th>
                        <th>Title</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${book_list}" var="book">
                        <tr>
                            <td>${book.author}</td>
                            <td>${book.title}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <input type="hidden" name="${_csrf.parameterName}"
                   value="${_csrf.token}" />
            <a href="downloadPDF">PDF</a>
        </form:form>
            
    </body>
</html>
