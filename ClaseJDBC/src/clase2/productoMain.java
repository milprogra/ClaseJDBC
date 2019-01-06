
package clase2;
import modelo.AccesoProducto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author mjara
 */
public class productoMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AccesoProducto ap = new AccesoProducto();
        ResultSet resultado = null;
        
        //Read
        try {
            resultado = ap.listarProducto();
            while (resultado.next()) {
                System.out.println(resultado.getInt("cod_pro")
                        +" "+resultado.getString("descripcion")+" "
                        +resultado.getInt("stock")+" "
                        +resultado.getInt("precio"));
            }
        } catch (SQLException ex) {
            System.out.println("error al listar!");
            Logger.getLogger(productoMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Create
        ap.ingresarProducto("producto de interes", 35, 12000);
        
        //Update
        ap.actualizarProducto("producto nuevo", 120, 70000, 23);
        
        //Delete
        ap.eliminarProducto(31);
        
        //existencia
        try {
            resultado = ap.existenciaProducto(18);
            while (resultado.next()) {
                System.out.println(resultado.getInt("cod_pro")
                        +" "+resultado.getString("descripcion")+" "
                        +resultado.getInt("stock")+" "
                        +resultado.getInt("precio"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(productoMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
