/*
    Document   : eBooksStoreAdmineBooksServlet.java
    Author     : gheorgheaurelpacurar   
    Copyright  : gheorgheaurelpacurar
 */
package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gheor
 */
public class eBooksStoreAdminEBooks extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

// ============================= DB SETUP ========================================================================================================
        // declare specific DB info
        String user = "CIPRIAN";
        String password = "sargeras01";
        String url = "jdbc:derby://localhost:1527/EBOOKS;create=true;";
        String driver = "org.apache.derby.jdbc.ClientDriver";

// ============================= INSERT ========================================================================================================
        // check push on Insert button
        if (request.getParameter("admin_ebooks_insert") != null) { // insert values from fields
            // set connection paramters to the DB
            // read values from page fields
            Map<BookParameters, String> parameterMap = getInsertParameters(request);

            // declare specific DBMS operationsvariables
            Connection connection = null;
            PreparedStatement pstmnt = null;

            try {

                //check driver and create connection
                Class driverClass = Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
                String DML = "INSERT INTO EBOOKS.EBOOKS VALUES (?, ?, ?, ?, ?, ?, ?)";
                pstmnt = connection.prepareStatement(DML);

//                setFirst7Strings(pstmnt, parameterMap);
                // ============================= PREPARE STATEMENT=====================
                pstmnt.setString(1, parameterMap.get(BookParameters.ISBN));
                pstmnt.setString(2, parameterMap.get(BookParameters.DENUMIRE));
                pstmnt.setInt(3, filterID(parameterMap.get(BookParameters.ID_TYPE)));
                pstmnt.setInt(4, filterID(parameterMap.get(BookParameters.ID_QUALITY)));
                pstmnt.setInt(5, Integer.parseInt(parameterMap.get(BookParameters.PAGES)));
                pstmnt.setInt(6, filterID(parameterMap.get(BookParameters.ID_GENRE)));
                pstmnt.setDouble(7, Double.parseDouble(parameterMap.get(BookParameters.PRET)));

                pstmnt.execute();
            } catch (ClassNotFoundException | SQLException ex) {
                // display a message for NOT OK
                Logger.getLogger(eBooksStoreAdminUsersServlet.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                close(null, pstmnt, connection);
                request.getRequestDispatcher("./eBooksStoreAdminEBooks.jsp").forward(request, response);
            }
        } // ============================= UPDATE ========================================================================================================
        // check push on Update button
        else if (request.getParameter("admin_ebooks_update") != null) {

            // declare specific variables
            PreparedStatement pstmnt = null;
            Connection connection = null;

            try {

                //check driver and create connection
                Class driverClass = Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);

                // identify selected checkbox
                String[] selectedCheckboxes = request.getParameterValues("admin_ebooks_checkbox");

                // ============================= UPDATE ONE CHECKBOX =====================
                if (selectedCheckboxes.length == 1) {
                    // update all fields
                    String checkedIsbn = selectedCheckboxes[0];

                    updateOneCheckbox(request, connection, pstmnt, checkedIsbn);

                    // ============================= UPDATE MORE CHECKBOXES =====================
                } else if (selectedCheckboxes.length > 1) {
                    // update all except isbn

                    updateAllCheckboxes(request, connection, pstmnt, selectedCheckboxes);
                }

            } catch (ClassNotFoundException | SQLException ex) {
                // display a message for NOT OK
                Logger.getLogger(eBooksStoreAdminUsersServlet.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                close(null, pstmnt, connection);
                request.getRequestDispatcher("./eBooksStoreAdminEBooks.jsp").forward(request, response);
            }
        } // ============================= DELETE ========================================================================================================
        // check push on Delete button
        else if (request.getParameter("admin_ebooks_delete") != null) { // delete 
            // declare specific variables
            PreparedStatement pstmnt = null;
            Connection connection = null;

            try {
                //check driver and create connection
                Class driverClass = Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);

                // identify selected checkbox and for each execute the delete operation
                String[] selectedCheckboxes = request.getParameterValues("admin_ebooks_checkbox");

                // more critical DB operations should be made into a transaction
                connection.setAutoCommit(false);

                delete(connection, pstmnt, selectedCheckboxes);

                connection.commit();
                connection.setAutoCommit(true);

            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(eBooksStoreAdminUsersServlet.class.getName()).log(Level.SEVERE, null, ex);
                if (connection != null) {
                    try {
                        connection.rollback();
                    } catch (SQLException ex1) {
                        Logger.getLogger(eBooksStoreAdminUsersServlet.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            } finally {
                close(null, pstmnt, connection);
                request.getRequestDispatcher("./eBooksStoreAdminEBooks.jsp").forward(request, response);
            }
        } // check push on Cancel button
        else if (request.getParameter("admin_ebooks_cancel") != null) { // cancel
            request.getRequestDispatcher("./eBooksStoreMainPage.jsp").forward(request, response);
        }
    }
    // ===========================================================================================================================
    // ===========================================================================================================================
    // ===========================================================================================================================
    // ===========================================================================================================================
    // ===========================================================================================================================

    // ============================= DELETE CHECKS ========================================================================================================
    private void delete(Connection connection, PreparedStatement pstmnt, String[] selectedCheckboxes) throws SQLException {
        for (String isbn : selectedCheckboxes) {

            // realize delete of all selected rows
            String DML = "DELETE FROM EBOOKS.EBOOKS WHERE isbn=?";
            pstmnt = connection.prepareStatement(DML);
            pstmnt.setString(1, isbn);

            pstmnt.execute();

            // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            // ALSO DELETE THE DEPENDENCIES (AUTHORS, RATINGS etc)
            // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        }
    }

    // ============================= UPDATE ALL CHECKS ========================================================================================================
    private void updateAllCheckboxes(HttpServletRequest request, Connection connection, PreparedStatement pstmnt, String[] selectedCheckboxes)
            throws SQLException {

        ResultSet results = null;
        Statement statement = null;

        for (String checkedIsbn : selectedCheckboxes) {

            // ============================= GET CURRENT EBOOK ==============
            String sql = "SELECT * FROM EBOOKS.EBOOKS WHERE isbn='" + checkedIsbn + "'";

            statement = connection.createStatement();
            results = statement.executeQuery(sql);

            String denumire = null;
            int id_type = 0;
            int id_quality = 0;
            int pages = 0;
            int id_genre = 0;
            double pret = 0;

            if (results.next()) {

                denumire = results.getString("denumire");
                id_type = results.getInt("id_type");
                id_quality = results.getInt("id_quality");
                pages = results.getInt("pages");
                id_genre = results.getInt("id_genre");
                pret = results.getDouble("pret");

            }

            Ebook ebook = new Ebook(checkedIsbn, denumire, id_type, id_quality, pages, id_genre, pret);
            // ============================= PASS THE CURRENT EBOOK ==============
            Map<BookParameters, String> parameterMap = getUpdateParameters(request, ebook, true);

            String DML = "UPDATE EBOOKS.EBOOKS "
                    + "SET isbn=?, denumire=?, id_type=?, id_quality=?, pages=?, id_genre=?, pret=? "
                    + "WHERE isbn=?";

            pstmnt = connection.prepareStatement(DML);

//                        setFirst7Strings(pstmnt, parameterMap);
            // ============================= PREPARE STATEMENT=====================
            pstmnt.setString(1, parameterMap.get(BookParameters.ISBN));
            pstmnt.setString(2, parameterMap.get(BookParameters.DENUMIRE));
            pstmnt.setInt(3, filterID(parameterMap.get(BookParameters.ID_TYPE)));
            pstmnt.setInt(4, filterID(parameterMap.get(BookParameters.ID_QUALITY)));
            pstmnt.setInt(5, Integer.parseInt(parameterMap.get(BookParameters.PAGES)));
            pstmnt.setInt(6, filterID(parameterMap.get(BookParameters.ID_GENRE)));
            pstmnt.setDouble(7, Double.parseDouble(parameterMap.get(BookParameters.PRET)));
            // ========== WHERE =============
            pstmnt.setString(8, checkedIsbn);

            pstmnt.execute();

        }

        close(results, null, null);
        closeStatement(statement);

    }
    // ============================= UPDATE ONE CHECK ========================================================================================================

    private void updateOneCheckbox(HttpServletRequest request, Connection connection, PreparedStatement pstmnt, String checkedIsbn)
            throws SQLException {

        String denumire = null;
        int id_type = 0;
        int id_quality = 0;
        int pages = 0;
        int id_genre = 0;
        double pret = 0;

        // ============================= GET THE EBOOK ==============
        String sql = "SELECT * FROM EBOOKS.EBOOKS WHERE isbn='" + checkedIsbn + "'";

        Statement statement = connection.createStatement();
        ResultSet results = statement.executeQuery(sql);

        if (results.next()) {

            denumire = results.getString("denumire");
            id_type = results.getInt("id_type");
            id_quality = results.getInt("id_quality");
            pages = results.getInt("pages");
            id_genre = results.getInt("id_genre");
            pret = results.getDouble("pret");

        }

        Ebook ebook = new Ebook(checkedIsbn, denumire, id_type, id_quality, pages, id_genre, pret);
        // ============================= PASS THE EBOOK ==============
        Map<BookParameters, String> parameterMap = getUpdateParameters(request, ebook, false);

        String DML = "UPDATE EBOOKS.EBOOKS "
                + "SET isbn=?, denumire=?, id_type=?, id_quality=?, pages=?, id_genre=?, pret=? "
                + "WHERE isbn=?";

        pstmnt = connection.prepareStatement(DML);

//                    setFirst7Strings(pstmnt, parameterMap);
// ============================= PREPARE STATEMENT=====================
        pstmnt.setString(1, parameterMap.get(BookParameters.ISBN));
        pstmnt.setString(2, parameterMap.get(BookParameters.DENUMIRE));
        pstmnt.setInt(3, filterID(parameterMap.get(BookParameters.ID_TYPE)));
        pstmnt.setInt(4, filterID(parameterMap.get(BookParameters.ID_QUALITY)));
        pstmnt.setInt(5, Integer.parseInt(parameterMap.get(BookParameters.PAGES)));
        pstmnt.setInt(6, filterID(parameterMap.get(BookParameters.ID_GENRE)));
        pstmnt.setDouble(7, Double.parseDouble(parameterMap.get(BookParameters.PRET)));
        // ========== WHERE =============
        pstmnt.setString(8, checkedIsbn);

        pstmnt.execute();

        close(results, null, null);
        closeStatement(statement);

    }

// ============================= FILTER THE IDs ========================================================================================================
    private int filterID(String string) {

        String[] separated = string.split("|");
        return Integer.parseInt(separated[0]);
//        for (int i = 0; i < string.length(); i++) {
//            if (string.charAt(i) == '|') {
//                substring = string.substring(0, i);
//            }
//        }
    }

    // ============================= GET INSERT PARAMETERS ===================================================================================================
    private Map<BookParameters, String> getInsertParameters(HttpServletRequest request) {

        Map<BookParameters, String> parameterMap = new HashMap<>();

        String isbn = request.getParameter("admin_ebooks_isbn");
        String denumire = request.getParameter("admin_ebooks_denumire");
        String pret = request.getParameter("admin_ebooks_price");
        String pages = request.getParameter("admin_ebooks_pages");
        String id_type = request.getParameter("admin_ebooks_id_type");
        String id_genre = request.getParameter("admin_ebooks_id_genres");
        String id_quality = request.getParameter("admin_ebooks_id_paper_qualities");

        parameterMap.put(BookParameters.ISBN,
                ((isbn == null || isbn.trim().equals("")) ? "" : isbn));

        parameterMap.put(BookParameters.DENUMIRE,
                ((denumire == null || denumire.trim().equals("")) ? "" : denumire));

        parameterMap.put(BookParameters.PRET,
                (pret == null || pret.trim().equals("")) ? "0" : pret);

        parameterMap.put(BookParameters.PAGES,
                (pages == null || pages.trim().equals("")) ? "0" : pages);

        parameterMap.put(BookParameters.ID_TYPE,
                id_type);

        parameterMap.put(BookParameters.ID_GENRE,
                id_genre);

        parameterMap.put(BookParameters.ID_QUALITY,
                id_quality);

        return parameterMap;
    }

    // ============================= GET UPDATE PARAMETERS ==============================================================================================
    private Map<BookParameters, String> getUpdateParameters(HttpServletRequest request, Ebook ebook, boolean multipleChecks) {

        Map<BookParameters, String> parameterMap = new HashMap<>();

        String isbnParam = request.getParameter("admin_ebooks_isbn");
        String denumireParam = request.getParameter("admin_ebooks_denumire");
        String pretParam = request.getParameter("admin_ebooks_price");
        String pagesParam = request.getParameter("admin_ebooks_pages");
        String id_typeParam = request.getParameter("admin_ebooks_id_type");
        String id_genreParam = request.getParameter("admin_ebooks_id_genres");
        String id_qualityParam = request.getParameter("admin_ebooks_id_paper_qualities");

        // if parameter is null or "", don't change it
        if (multipleChecks) {
            parameterMap.put(BookParameters.ISBN,
                    ebook.getIsbn());
        } else {
            parameterMap.put(BookParameters.ISBN,
                    ((isbnParam == null || isbnParam.trim().equals("")) ? ebook.getIsbn() : isbnParam));
        }

        parameterMap.put(BookParameters.DENUMIRE,
                ((denumireParam == null || denumireParam.trim().equals("")) ? ebook.getDenumire() : denumireParam));

        parameterMap.put(BookParameters.PRET,
                (pretParam == null || pretParam.trim().equals("")) ? Double.toString(ebook.getPret()) : pretParam);

        parameterMap.put(BookParameters.PAGES,
                (pagesParam == null || pagesParam.trim().equals("")) ? Integer.toString(ebook.getPages()) : pagesParam);

        parameterMap.put(BookParameters.ID_TYPE,
                id_typeParam);

        parameterMap.put(BookParameters.ID_GENRE,
                id_genreParam);

        parameterMap.put(BookParameters.ID_QUALITY,
                id_qualityParam);

        return parameterMap;
    }

// ============================= CONFIGURE THE PREPARED STATEMENT =====================================================================
    private void setFirst7Strings(PreparedStatement pstmnt, Map<BookParameters, String> parameterMap) throws SQLException {

        pstmnt.setString(1, parameterMap.get(BookParameters.ISBN));
        pstmnt.setString(2, parameterMap.get(BookParameters.DENUMIRE));
        pstmnt.setInt(3, filterID(parameterMap.get(BookParameters.ID_TYPE)));
        pstmnt.setInt(4, filterID(parameterMap.get(BookParameters.ID_QUALITY)));
        pstmnt.setInt(5, Integer.parseInt(parameterMap.get(BookParameters.PAGES)));
        pstmnt.setInt(6, filterID(parameterMap.get(BookParameters.ID_GENRE)));
        pstmnt.setDouble(7, Double.parseDouble(parameterMap.get(BookParameters.PRET)));
    }

    // ============================= CLOSE RESOURCES ========================================================================================================
    private void close(ResultSet resultSet, Statement stmt, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();

            } catch (SQLException ex) {
                Logger.getLogger(eBooksStoreAdminUsersServlet.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (stmt != null) {
            try {
                stmt.close();

            } catch (SQLException ex) {
                Logger.getLogger(eBooksStoreAdminUsersServlet.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (connection != null) {
            try {
                connection.setAutoCommit(true);

            } catch (SQLException ex) {
                Logger.getLogger(eBooksStoreAdminUsersServlet.class
                        .getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    connection.close();

                } catch (SQLException ex) {
                    Logger.getLogger(eBooksStoreAdminUsersServlet.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void closeStatement(Statement statement) throws SQLException {
        if(statement != null) {
            statement.close();
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet serves eBooksSoreAdminEBooks.JSP page";
    }// </editor-fold>

}
