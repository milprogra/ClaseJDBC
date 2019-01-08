
package clase4;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author mjara
 */
public class AccesoPerros extends Conexion{
    
    private ResultSet resultado;

    public AccesoPerros() {
        super.conectar();
    }
    
    //metodo CRUD - Read
    public ResultSet listarPerros(){
        try {
            super.getStmt();
            resultado = stmt.executeQuery("Select * from perros");
        } catch (SQLException ex) {
            Logger.getLogger(AccesoPerros.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    public void ingresarPerros(int id, String nombre,int edad, String raza, String sexo,boolean operado, boolean chip){
        try {
            super.getStmt();
            stmt.executeUpdate("Insert into perros values ("+id+",'"+nombre+"',"+edad+",'"+raza+"','"+sexo+"',"+operado+","+chip+")");
            System.out.println("Ingresado con exito!");
        } catch (SQLException ex) {
            System.out.println("error al ingresar producto!");
            Logger.getLogger(AccesoPerros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
