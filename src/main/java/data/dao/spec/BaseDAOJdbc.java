package data.dao.spec;

import presentation.backingBeans.SessionBean;

import javax.annotation.Resource;
import javax.faces.bean.SessionScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class BaseDAOJdbc {

    protected Connection connection;

    public BaseDAOJdbc() {
        try {
            Context context = new InitialContext();
            DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/mdvsp");
            connection = ds.getConnection();
            setSchema(SessionBean.userName);
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
    }

    protected void setSchema(String name){
        if(name == null || name.isEmpty()){
            name = "default_schema";
        }

        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate("USE " + name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}