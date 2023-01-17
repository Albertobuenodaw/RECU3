package Alberto.COLLECTIONS;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class db {
    private Connection con = DriverManager.getConnection("jdbc:mariadb//localhost::3306/nombreBase deDatos");
    private String User;

    private String password;

    private Statement st = con.createStatement();

    private ResultSet rs = st.executeQuery("");

    

    public db() throws SQLException {
    }
}
