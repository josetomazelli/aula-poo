
package DAL;
import java.sql.*;
import javax.swing.JOptionPane;


public class ConectaBd {
    
    public static Connection conectabd() throws ClassNotFoundException, SQLException{
       
        try{
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/inspecao","josetomazelli","Jose1245");
            return con;
        }
        catch(SQLException error){
    
    JOptionPane.showMessageDialog(null, error);
    
    return null;
}
    }
    
}
