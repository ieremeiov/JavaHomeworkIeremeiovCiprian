<%-- 
    Document   : eBooksStoreAdminUsersPage
    Created on : Oct 6, 2017, 8:35:27 AM
    Author     : gheor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>


<%@ taglib prefix="cip" uri="WEB-INF/tlds/usersutil.tld"%>




<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Electronic Books Store Manage Users</title>
        <link rel="stylesheet" type="text/css" href=".\\css\\ebookstore.css">
    </head>



    <body>
       
                <!-- include menu -->
                <%@ include file="./utils/eBooksStoreMenu.jsp" %>
                <%-- Master view --%>

                <form action="${pageContext.request.contextPath}/eBooksStoreAdminUsersPage.jsp" method="POST">
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    <cip:MyConnection
                        myConnection="snapshot" 
                        driver="org.apache.derby.jdbc.ClientDriver40"
                        url="jdbc:derby://localhost:1527/EBOOKS;create=true;"
                        username="CIPRIAN"  
                        password="sargeras01"/>
                    
                    
                    <cip:MySelect dataSource="${snapshot}" resultSet="result">
                        SELECT EBOOKS.USERS.SSN, EBOOKS.USERS."NAME", EBOOKS.USERS.PASSWORD, EBOOKS.USERS."ROLE" 
                        FROM EBOOKS.USERS, EBOOKS.ROLES 
                        WHERE EBOOKS.USERS."ROLE" = EBOOKS.ROLES."ROLE" ORDER BY NAME, ROLE ASC 
                    </cip:MySelect>>
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                    <table border="1" width="100%">
                        <tr>
                            <td width="3.95%" class="thc"> select </td>   
                            <td width="13.8%" class="thc"> CNP </td>  
                            <td width="13.8%" class="thc">NAME</td>
                            <td width="13.8%" class="thc">PASSWORD</td>
                            <td width="14.5%" class="thc">ROLE</td>
                    </table>   
                    <div style="overflow-y: scroll; height:330px;">
                        <table border="1" width="100%">    
                            </tr>
                            <c:forEach var="row" varStatus="loop" items="${result.rows}">
                                <tr>
                                    <td width="4%" class="tdc"><input type="checkbox" name="admin_users_checkbox" value="${row.ssn}"></td>
                                    <td width="14%" class="tdc"><c:out value="${row.ssn}"/></td>
                                    <td width="14%" class="tdc"><c:out value="${row.name}"/></td>
                                    <td width="14%" class="tdc"><c:out value="${row.password}"/></td>
                                    <td width="14%" class="tdc"><c:out value="${row.role}"/></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                    <hr>

                    </td>
                    </tr>
                    </table>    
                </form>
       
    </body>    




</html>

