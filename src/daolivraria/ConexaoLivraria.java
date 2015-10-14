package daolivraria;

import java.sql.*;

public class ConexaoLivraria {
        public static Connection getNewConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            String url = "jdbc:mysql://localhost/Livraria";
            String user = "root";
            String pswd = "NOBELnobel1493*";
            Connection con = DriverManager.getConnection(url, user, pswd);

            return con;
            
        } catch (Exception e1) {
            return null;
        }
        
    }
}
