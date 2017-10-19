/*
    Document   : eBooksStoreAdminUsersServlet.java
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
 * Servlet is serving eBooksStoreAdminUsersPage.jsp
 *
 * @author Gheorghe Aurel Pacurar
 */
public class eBooksStoreAdminUsersServlet extends HttpServlet {

    // =================== INIT ===================================================
    @Override
    public void init() throws ServletException {

    }

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

        String user;
        String password;
        String url;
        String driver;

        Connection connection = null;
        PreparedStatement pstmnt = null;

        try {

            user = "CIPRIAN";
            password = "sargeras01";
            url = "jdbc:derby://localhost:1527/EBOOKS;create=true;";
            driver = "org.apache.derby.jdbc.ClientDriver";

            Class driverClass = Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(eBooksStoreAdminEBooks.class.getName()).log(Level.SEVERE, null, ex);
        }

        String ssnParam = request.getParameter("admin_users_ssn");
        String usernameParam = request.getParameter("admin_users_username");
        String passwordParam = request.getParameter("admin_users_password");
        String roleParam = request.getParameter("admin_user_role");

// ============================= INSERT ========================================================================================================
        // check push on Insert button
        if (request.getParameter("admin_users_insert") != null) { // insert values from fields

            // declare specific DBMS operationsvariables
            // ============================= TODO: IF USERNAME IS NULL DO NOT INSERT! ===================
            try {
                //check driver and create connection

                String DML = "INSERT INTO EBOOKS.USERS VALUES (?, ?, ?, ?)";

                pstmnt = connection.prepareStatement(DML);

                pstmnt.setString(1, ssnParam);
                pstmnt.setString(2, usernameParam);
                pstmnt.setString(3, passwordParam);
                pstmnt.setString(4, roleParam);

                pstmnt.execute();

            } catch (SQLException ex) {
                // display a message for NOT OK
                Logger.getLogger(eBooksStoreAdminUsersServlet.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                close(null, pstmnt, connection);
                // redirect page to its JSP as view
                request.getRequestDispatcher("./eBooksStoreAdminUsersPage.jsp").forward(request, response);
            }
        } // ============================= UPDATE ========================================================================================================
        // check push on Update button
        else if (request.getParameter("admin_users_update") != null) { // update
            // declare specific variables

            try {

                // identify selected checkbox and for each execute the update operation
                String[] selectedCheckboxes = request.getParameterValues("admin_users_checkbox");

                // ============================= UPDATE ONE CHECKBOX =====================
                if (selectedCheckboxes.length == 1) {
                    // update all fields
                    String checkedSsn = selectedCheckboxes[0];

                    updateOneCheckbox(request, connection, pstmnt, checkedSsn);

                    // ============================= UPDATE MORE CHECKBOXES =====================
                } else if (selectedCheckboxes.length > 1) {
                    // update all except isbn

                    updateAllCheckboxes(request, connection, pstmnt, selectedCheckboxes);
                }

            } catch (SQLException ex) {
                // display a message for NOT OK
                Logger.getLogger(eBooksStoreAdminUsersServlet.class.getName()).log(Level.SEVERE, null, ex);

            } finally {
                close(null, pstmnt, connection);
                // redirect page to its JSP as view
                request.getRequestDispatcher("./eBooksStoreAdminUsersPage.jsp").forward(request, response);
            }
        } // ============================= DELETE ========================================================================================================
        // check push on Delete button
        else if (request.getParameter("admin_users_delete") != null) { // delete 
            // declare specific variables

            try {

                String[] selectedCheckboxes = request.getParameterValues("admin_users_checkbox");

                // more critical DB operations should be made into a transaction
                connection.setAutoCommit(false);

                for (String ssn : selectedCheckboxes) {
                    // realize delete of all selected rows
                    String DML = "DELETE FROM EBOOKS.USERS WHERE SSN=?";
                    pstmnt = connection.prepareStatement(DML);
                    pstmnt.setString(1, ssn);
                    pstmnt.execute();
                }

                connection.commit();
                connection.setAutoCommit(true);

            } catch (SQLException ex) {
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
                // redirect page to its JSP as view
                request.getRequestDispatcher("./eBooksStoreAdminUsersPage.jsp").forward(request, response);
            }
        } // ============================= CANCEL ========================================================================================================// check push on Cancel button
        else if (request.getParameter("admin_users_cancel") != null) { // cancel
            request.getRequestDispatcher("./eBooksStoreMainPage.jsp").forward(request, response);
        } // check push on admin user roles button
        else if (request.getParameter("admin_userroles_open") != null) { // insert values from fields
            request.getRequestDispatcher("./eBooksStoreAdminUserRolesPage.jsp").forward(request, response);
        } // check push on admin customers button
    }

    // ============================= UPDATE ALL CHECKS ========================================================================================================
    private void updateAllCheckboxes(HttpServletRequest request, Connection connection, PreparedStatement pstmnt, String[] selectedCheckboxes)
            throws SQLException {

        ResultSet results = null;
        Statement statement = null;

        for (String checkedSsn : selectedCheckboxes) {

            String name = null;
            String password = null;
            String role = null;

            // ============================= GET CURRENT USER ==============
            String sql = "SELECT * FROM EBOOKS.USERS WHERE ssn='" + checkedSsn + "'";

            statement = connection.createStatement();
            results = statement.executeQuery(sql);

            if (results.next()) {

                name = results.getString("name");
                password = results.getString("password");
                role = results.getString("role");

            }

            User user = new User(checkedSsn, name, password, role);
            // ============================= PASS THE CURRENT USER ==============
            Map<UserParameters, String> parameterMap = getUpdateParameters(request, user, true);

            String DML = "UPDATE EBOOKS.USERS "
                    + "SET ssn=?, name=?, password=?, role=? "
                    + "WHERE ssn=?";

            pstmnt = connection.prepareStatement(DML);

            // ============================= PREPARE STATEMENT =====================
            pstmnt.setString(1, parameterMap.get(UserParameters.SSN));
            pstmnt.setString(2, parameterMap.get(UserParameters.NAME));
            pstmnt.setString(3, (parameterMap.get(UserParameters.PASSWORD)));
            pstmnt.setString(4, (parameterMap.get(UserParameters.ROLE)));
            // ========== WHERE =============
            pstmnt.setString(5, checkedSsn);

            pstmnt.execute();

        }

        close(results, null, null);
        closeStatement(statement);

    }
    // ============================= UPDATE ONE CHECK ========================================================================================================

    private void updateOneCheckbox(HttpServletRequest request, Connection connection, PreparedStatement pstmnt, String checkedSsn)
            throws SQLException {

        String name = null;
        String password = null;
        String role = null;

        // ============================= GET THE USER ==============
        String sql = "SELECT * FROM EBOOKS.USERS WHERE ssn='" + checkedSsn + "'";

        Statement statement = connection.createStatement();
        ResultSet results = statement.executeQuery(sql);

        if (results.next()) {

            name = results.getString("name");
            password = results.getString("password");
            role = results.getString("role");

        }

        User user = new User(checkedSsn, name, password, role);
        // ============================= PASS THE USER ==============
        Map<UserParameters, String> parameterMap = getUpdateParameters(request, user, false);

        String DML = "UPDATE EBOOKS.USERS "
                + "SET ssn=?, name=?, password=?, role=? "
                + "WHERE ssn=?";

        pstmnt = connection.prepareStatement(DML);

// ============================= PREPARE STATEMENT=====================
        pstmnt.setString(1, parameterMap.get(UserParameters.SSN));
        pstmnt.setString(2, parameterMap.get(UserParameters.NAME));
        pstmnt.setString(3, (parameterMap.get(UserParameters.PASSWORD)));
        pstmnt.setString(4, (parameterMap.get(UserParameters.ROLE)));
        // ========== WHERE =============
        pstmnt.setString(5, checkedSsn);

        pstmnt.execute();

        close(results, null, null);
        closeStatement(statement);

    }

    // ============================= GET INSERT PARAMETERS ===================================================================================================
    private Map<UserParameters, String> getInsertParameters(HttpServletRequest request) {

        Map<UserParameters, String> parameterMap = new HashMap<>();

        String ssn = request.getParameter("admin_users_ssn");
        String username = request.getParameter("admin_users_username");
        String password = request.getParameter("admin_users_password");
        String role = request.getParameter("admin_user_role");

        parameterMap.put(UserParameters.SSN,
                ((ssn == null || ssn.trim().equals("")) ? "" : ssn));

        parameterMap.put(UserParameters.NAME,
                ((username == null || username.trim().equals("")) ? "" : username));

        parameterMap.put(UserParameters.PASSWORD,
                (password == null || password.trim().equals("")) ? "0" : password);

        parameterMap.put(UserParameters.ROLE,
                role);

        return parameterMap;
    }

    // ============================= GET UPDATE PARAMETERS ==============================================================================================
    private Map<UserParameters, String> getUpdateParameters(HttpServletRequest request, User user, boolean multipleChecks) {

        Map<UserParameters, String> parameterMap = new HashMap<>();

        String ssn = request.getParameter("admin_users_ssn");
        String username = request.getParameter("admin_users_username");
        String password = request.getParameter("admin_users_password");
        String role = request.getParameter("admin_user_role");

        if (multipleChecks) {
            parameterMap.put(UserParameters.SSN,
                    user.getSsn());
        } else {
            parameterMap.put(UserParameters.SSN,
                    ((ssn == null || ssn.trim().equals("")) ? user.getSsn() : ssn));
        }
        parameterMap.put(UserParameters.NAME,
                ((username == null || username.trim().equals("")) ? user.getName() : username));

        parameterMap.put(UserParameters.PASSWORD,
                (password == null || password.trim().equals("")) ? user.getPassword() : password);

        parameterMap.put(UserParameters.ROLE,
                role);

        return parameterMap;
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
    // ============================= CLOSE STATEMENT ========================================================================================================

    private void closeStatement(Statement statement) throws SQLException {
        if (statement != null) {
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
        return "Servlet is serving eBooksStoreAdminUsersPage.jsp";
    }// </editor-fold>

}
