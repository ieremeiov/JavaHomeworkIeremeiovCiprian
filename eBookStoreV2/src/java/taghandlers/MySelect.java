/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taghandlers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.sql.DataSource;

/**
 *
 * @author Cip
 */
public class MySelect extends SimpleTagSupport {

    private String dataSource;
    private String resultSet;

    private DataSource dataSourceDb;
    private ResultSet resultSetDb;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     * @throws javax.servlet.jsp.JspException
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();

        try {
            // TODO: insert code to write html before writing the body content.
            // e.g.:
            //
            // out.println("<strong>" + attribute_1 + "</strong>");
            // out.println("    <blockquote>");

            
            String query = getJspBody().toString();

            Statement statement;
            Connection connection;

            try {

                connection = dataSourceDb.getConnection();
                statement = connection.createStatement();

                resultSetDb = statement.executeQuery(query);

            } catch (SQLException ex) {
                
            }

            getJspContext().setAttribute(dataSource, dataSourceDb, PageContext.SESSION_SCOPE);
            getJspContext().setAttribute(resultSet, resultSetDb, PageContext.SESSION_SCOPE);
            
            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }

            // TODO: insert code to write html after writing the body content.
            // e.g.:
            //
            // out.println("    </blockquote>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in MySelect tag", ex);
        }
    }
    
    

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public void setResultSet(String resultSet) {
        this.resultSet = resultSet;
    }
    
    
    
    
    
    
    

}
