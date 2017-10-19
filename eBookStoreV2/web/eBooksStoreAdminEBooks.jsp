<%-- 
    Document   : eBooksStoreAdminEBooks
    Created on : Nov 19, 2016, 7:36:42 PM
    Author     : gheor
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>eBooksStore Management </title>
        <link rel="stylesheet" type="text/css" href=".\\css\\ebookstore.css">
    </head>

    <body>
        <h1>Manage the books from Electronic Books Store</h1>
        <form action="${pageContext.request.contextPath}/eBooksStoreAdminEBooks">
            <%-- test if actual user is authenticated and authorized --%>
            <c:choose>
                <c:when test="${(actualUserRole == 'admin')}">   
                    <!-- include menu -->
                    <%@ include file="./utils/eBooksStoreMenu.jsp" %>
                    <%-- Master view --%>

                    <sql:setDataSource 
                        var="snapshot" 
                        driver="org.apache.derby.jdbc.ClientDriver40"
                        url="jdbc:derby://localhost:1527/EBOOKS;create=true;"
                        user="CIPRIAN"  
                        password="sargeras01"/>
                    <sql:query dataSource="${snapshot}" var="result">
                        SELECT ISBN, DENUMIRE, TYPE, QUALITY, PAGES, GENRE, PRET
                        FROM EBOOKS.EBOOKS, EBOOKS.BOOK_TYPES, EBOOKS.BOOK_PAPER_QUALITIES, EBOOKS.BOOK_GENRES
                        WHERE ID_TYPE = EBOOKS.BOOK_TYPES.ID
                        AND ID_QUALITY = EBOOKS.BOOK_PAPER_QUALITIES.ID
                        AND ID_GENRE = EBOOKS.BOOK_GENRES.ID
                    </sql:query>

                    <table style = "margin-top: -30px" border="2" width="100%">
                        <tr>
                            <td width="2.31%" class="thc"> select </td>   
                            <td width="11.79%" class="thc"> ISBN </td>  
                            <td width="11.79%" class="thc">TITLE</td>
                            <td width="5.92%" class="thc">PAGES</td>
                            <td width="7.87%" class="thc">TYPE</td>
                            <td width="7.83%" class="thc">QUALITY</td>
                            <td width="11.8%" class="thc">GENRE</td>
                            <td width="6.62%" class="thc">PRICE</td>
                        </tr>
                    </table>    

                    <div style="overflow-y: scroll; height:330px;">
                        <table border="1" width="100%">    
                            <c:forEach var="row" varStatus="loop" items="${result.rows}">
                                <tr>
                                    <td width="3%" class="tdc"><input type="checkbox" name="admin_ebooks_checkbox" value="${row.isbn}"></td>
                                    <td width="12%" class="tdc"><c:out value="${row.isbn}"/></td>
                                    <td width="12%" class="tdc"><c:out value="${row.denumire}"/></td>
                                    <td width="6%" class="tdc"><c:out value="${row.pages}"/></td>
                                    <td width="8%" class="tdc"><c:out value="${row.type}"/></td>
                                    <td width="8%" class="tdc"><c:out value="${row.quality}"/></td>
                                    <td width="12%" class="tdc"><c:out value="${row.genre}"/></td>
                                    <td width="6%" class="tdc"><c:out value="${row.pret}"/></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                    <hr>
                    <%-- Details --%>
                    <sql:setDataSource 
                        var="snapshotgenres" 
                        driver="org.apache.derby.jdbc.ClientDriver40"
                        url="jdbc:derby://localhost:1527/EBOOKS;create=true;"
                        user="CIPRIAN"  
                        password="sargeras01"/>
                    <sql:query dataSource="${snapshotgenres}" var="resultgenres">
                        SELECT ID, GENRE FROM EBOOKS.BOOK_GENRES 
                    </sql:query>
                    <sql:setDataSource 
                        var="snapshotpaperqualities" 
                        driver="org.apache.derby.jdbc.ClientDriver40"
                        url="jdbc:derby://localhost:1527/EBOOKS;create=true;"
                        user="CIPRIAN"  
                        password="sargeras01"/>
                    <sql:query dataSource="${snapshotpaperqualities}" var="resultpaperqualities">
                        SELECT ID, QUALITY FROM EBOOKS.BOOK_PAPER_QUALITIES 
                    </sql:query>    
                    <sql:setDataSource 
                        var="snapshottypes" 
                        driver="org.apache.derby.jdbc.ClientDriver40"
                        url="jdbc:derby://localhost:1527/EBOOKS;create=true;"
                        user="CIPRIAN"  
                        password="sargeras01"/>
                    <sql:query dataSource="${snapshottypes}" var="resulttypes">
                        SELECT ID, TYPE FROM EBOOKS.BOOK_TYPES 
                    </sql:query>    
                    <table class="tablecenterdwithborder">
                        <tr>
                            <td>   

                                <table>
                                    <tr>
                                        <td> ISBN: </td>
                                        <td> <input style = "min-width: 145px;" type="text" name="admin_ebooks_isbn"></input></td>
                                    </tr>                                        
                                    <tr>
                                        <td> TITLE: </td>
                                        <td> <input style = "min-width: 145px;" type="text" name="admin_ebooks_denumire"></input></td>
                                    </tr>
                                    <tr>
                                        <td> PAGES NO: </td>
                                        <td> <input style = "min-width: 145px;" type="text" name="admin_ebooks_pages"></input></td>
                                    </tr>
                                    <tr>
                                        <td> PRICE: </td>
                                        <td> <input style = "min-width: 145px;" type="text" name="admin_ebooks_price"></input></td>
                                    </tr>
                                    <tr>
                                        <td> TYPE: </td>
                                        <td>
                                            <select style = "min-width: 150px;" name="admin_ebooks_id_type" required="true">
                                                <c:forEach var="rowtype" items="${resulttypes.rows}">    
                                                    <option name="admin_ebooks_types" value="${rowtype.ID}|${rowtype.TYPE}">${rowtype.TYPE}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td> PAPER_QUALITY: </td>
                                        <td>
                                            <select style = "min-width: 150px;" name="admin_ebooks_id_paper_qualities" required="true">
                                                <c:forEach var="rowquality" items="${resultpaperqualities.rows}">    
                                                    <option name="admin_ebooks_paper_qualities" value="${rowquality.ID}|${rowquality.quality}">${rowquality.quality}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td> GENRE: </td>
                                        <td>
                                            <select style = "min-width: 150px;" name="admin_ebooks_id_genres" required="true">
                                                <c:forEach var="rowgenre" items="${resultgenres.rows}">    
                                                    <option name="admin_ebooks_genres" value="${rowgenre.ID}|${rowgenre.genre}">${rowgenre.genre}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                    </tr>
                                </table>

                            </td>
                        </tr>
                        <tr>
                            <td>
                                <%-- buttons --%>
                                <table>

                                    <tr>
                                        <td class="tdc"><input style = "min-width: 65px;" type="submit" class="ebooksstorebutton" name="admin_ebooks_insert" value="Insert"></td> 
                                        <td class="tdc"><input style = "min-width: 65px;" type="submit" class="ebooksstorebutton" name="admin_ebooks_update" value="Update"></td>
                                        <td class="tdc"><input style = "min-width: 65px;" type="submit" class="ebooksstorebutton" name="admin_ebooks_delete" value="Delete"></td> 
                                        <td class="tdc"><input style = "min-width: 65px;" type="submit" class="ebooksstorebutton" name="admin_ebooks_cancel" value="Cancel"></td>
                                    </tr>  
                                </table>
                            </td>
                        </tr>
                    </table>    
                </form>
            </c:when>
            <c:otherwise>
                <c:redirect url="./Index.jsp"></c:redirect>
            </c:otherwise>
        </c:choose>
    </form>
</body>
</html>

