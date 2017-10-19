/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taghandlers;

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
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import servlets.User;
import servlets.UserParameters;
import servlets.eBooksStoreAdminUsersServlet;

/**
 *
 * @author Cip
 */
public class UpdateUser extends SimpleTagSupport {

    private String CNP;
    private String username;
    private String password;
    private String role;
    private String[] selectedCheckboxes;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     * @throws javax.servlet.jsp.JspException
     * @throws java.io.IOException
     */
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();

        String dbUser = "CIPRIAN";
        String dbPassword = "sargeras01";
        String url = "jdbc:derby://localhost:1527/EBOOKS;create=true;";
        String driver = "org.apache.derby.jdbc.ClientDriver";

        PreparedStatement pstmnt = null;
        Connection connection = null;

        try {
            
            Class driverClass = Class.forName(driver);
            connection = DriverManager.getConnection(url, dbUser, dbPassword);
            
            // ============================= UPDATE ONE CHECKBOX =====================
            if (selectedCheckboxes.length == 1) {
                // update all fields
                String checkedSsn = selectedCheckboxes[0];

                updateOneCheckbox(connection, pstmnt, checkedSsn);

                // ============================= UPDATE MORE CHECKBOXES =====================
            } else if (selectedCheckboxes.length > 1) {
                // update all except isbn

                updateAllCheckboxes(connection, pstmnt, selectedCheckboxes);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            // display a message for NOT OK
            Logger.getLogger(eBooksStoreAdminUsersServlet.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            close(null, pstmnt, connection);
        }

        JspFragment f = getJspBody();

        if (f != null) {
            try {
                f.invoke(out);
            } catch (IOException ex) {
                throw new JspException("Error in UpdateUser tag", ex);
            }
        }

    }

    // ============================= UPDATE ALL CHECKS ========================================================================================================
    private void updateAllCheckboxes(Connection connection, PreparedStatement pstmnt, String[] selectedCheckboxes)
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
            Map<UserParameters, String> parameterMap = getUpdateParameters(user, true);

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

    private void updateOneCheckbox(Connection connection, PreparedStatement pstmnt, String checkedSsn)
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
        Map<UserParameters, String> parameterMap = getUpdateParameters(user, false);

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

    // ============================= GET UPDATE PARAMETERS ==============================================================================================
    private Map<UserParameters, String> getUpdateParameters(User user, boolean multipleChecks) {

        Map<UserParameters, String> parameterMap = new HashMap<>();

        if (multipleChecks) {
            parameterMap.put(UserParameters.SSN,
                    user.getSsn());
        } else {
            parameterMap.put(UserParameters.SSN,
                    ((CNP == null || CNP.trim().equals("")) ? user.getSsn() : CNP));
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
// ============================= SETTERS ========================================================================================================

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setSelectedCheckboxes(String[] selectedCheckboxes) {
        this.selectedCheckboxes = selectedCheckboxes;
    }

    
}
