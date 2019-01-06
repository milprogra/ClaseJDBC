
package clase1;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class claseUno {

    
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/faladeuda?autoReconnect=true&useSSL=false","admin","admin");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * From cliente");
            while (rs.next()) {
                int codigo = rs.getInt("cod_cli");
                String nombre = rs.getString("nom_cli");
                String apellido = rs.getString("ape_cli");
                String rut = rs.getString("rut_cli");
                System.out.println(rut+" "+nombre+" "+apellido+" "+codigo);
            }
        } catch (SQLException ex) {
            System.out.println("fracaso :( ");
            Logger.getLogger(claseUno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
