
package modelo;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccesoProducto extends Conexion {
    
    private ResultSet resultado;

    public AccesoProducto() {
        super.conectar();
    }
    
    //metodo CRUD - Read
    public ResultSet listarProducto(){
        try {
            super.getStmt();
            resultado = stmt.executeQuery("Select * from producto");
        } catch (SQLException ex) {
            Logger.getLogger(AccesoProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    //metodo CRUD - Create
    public void ingresarProducto(String descripcion, int stock, int precio){
        try {
            super.getStmt();
            stmt.executeUpdate("Insert into producto(descripcion,stock,precio) "
                    + "values ('"+descripcion+"',"+stock+","+precio+")");
            System.out.println("Ingresado con exito!");
        } catch (SQLException ex) {
            System.out.println("error al ingresar producto!");
            Logger.getLogger(AccesoProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //metodo CRUD - Update
    public void actualizarProducto(String descripcion, int stock, int precio, int codigo){
        try {
            super.getStmt();
            stmt.executeUpdate("Update producto set "
                    + "descripcion='"+descripcion+"', "
                    + "stock="+stock+", "
                    + "precio="+precio+" where cod_pro="+codigo);
            System.out.println("Actualizado con exito!");
        } catch (SQLException ex) {
            System.out.println("error al actualizar producto!");
            Logger.getLogger(AccesoProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //metodo CRUD - Delete
    public void eliminarProducto(int codigo){
        try {
            super.getStmt();
            stmt.executeUpdate("Delete from producto where cod_pro="+codigo);
            System.out.println("Eliminado con exito!");
        } catch (SQLException ex) {
            System.out.println("error al eliminar producto!");
            Logger.getLogger(AccesoProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //metodo busqueda por existencia
    public ResultSet existenciaProducto(int codigo){
        try {
            super.getStmt();
            resultado = stmt.executeQuery("Select * from producto where cod_pro="+codigo);
        } catch (SQLException ex) {
            Logger.getLogger(AccesoProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
        
    }
    
    
}
