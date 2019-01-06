
package clase1;
import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ejercicioUno {

    
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int seleccion = 0;
        do {
            System.out.println(".: Menu :.\n"
                    + "1) listar productos\n"
                    + "2) ingresar productos\n"
                    + "3) actualizar producto\n"
                    + "4) eliminar producto\n"
                    + "0) salir.");
            seleccion = entrada.nextInt();
            entrada.skip("\n");
            switch (seleccion) {
                case 1:
                    listarProducto();
                break;
                case 2:
                    ingresarProducto();
                break;
                case 3:
                    actualizarProducto();
                break;
                case 4:
                    eliminarProducto();
                break;
                case 0:
                    System.out.println("chao!");
                break;
                default:
                    System.out.println("mal ingresado");
            }
            
        } while (seleccion!=0);
        
    }
    
    public static Statement conectar(){
        Statement stmt = null;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/faladeuda?autoReconnect=true&useSSL=false", "admin", "admin");
            stmt = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ejercicioUno.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stmt;
    }
    
    public static void listarProducto(){ 
        System.out.println(".: Listado productos :.");
        try {
            Statement stmt = conectar();
            ResultSet rs = stmt.executeQuery("Select * From producto");
            while (rs.next()) {
                System.out.println(rs.getInt("cod_pro")+" "
                        +rs.getString("descripcion")+" "
                        +rs.getInt("precio")+" "
                        +rs.getInt("stock"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ejercicioUno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void ingresarProducto(){
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("ingresar descripcion producto:");
        String descripcion = entrada.nextLine();
        System.out.println("ingrese precio producto:");
        int precio = entrada.nextInt();
        entrada.skip("\n");
        System.out.println("ingrese stock producto:");
        int stock = entrada.nextInt();
        entrada.skip("\n");
        
        try {
            Statement stmt = conectar();
            stmt.executeUpdate("Insert into producto(descripcion,precio,stock) values ('"+
                    descripcion+"',"+precio+","+stock+")");
            System.out.println("exito! :) ");
        } catch (SQLException ex) {
            Logger.getLogger(claseDos.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("fracaso :( ");
        }
    }
    
    public static void actualizarProducto(){
        Scanner entrada = new Scanner(System.in);
        String descripcion;
        int precio,stock,codigo;
        System.out.println("ingresar codigo producto:");
        codigo = entrada.nextInt();
        entrada.skip("\n");
        try {
            Statement stmt = conectar();
            ResultSet rs = stmt.executeQuery("select * from producto where cod_pro="+codigo);
            while (rs.next()) {
                descripcion = rs.getString("descripcion");
                precio = rs.getInt("precio");
                stock = rs.getInt("stock");
                System.out.println(descripcion+" "+precio+" "+stock);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ejercicioUno.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("modificar descripcion:");
        descripcion = entrada.nextLine();
        System.out.println("modificar precio:");
        precio = entrada.nextInt();
        entrada.skip("\n");
        System.out.println("modificar stock:");
        stock = entrada.nextInt();
        entrada.skip("\n");
        
        try {
            Statement stmt = conectar();
            stmt.executeUpdate("Update producto set descripcion='"+descripcion+"',"
                    + "precio="+precio+","
                    + "stock="+stock+" where cod_pro="+codigo);
            System.out.println("exito! :) ");
        } catch (SQLException ex) {
            Logger.getLogger(claseDos.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("fracaso :( ");
        }
    }
    
    public static void eliminarProducto(){
        Scanner entrada = new Scanner(System.in);
        int codigo;
        System.out.println("ingresar codigo producto:");
        codigo = entrada.nextInt();
        entrada.skip("\n");
        
        try {
            Statement stmt = conectar();
            ResultSet rs = stmt.executeQuery("select * from producto where cod_pro="+codigo);
            while (rs.next()) {
                System.out.println(rs.getString("descripcion")+" "
                +rs.getInt("precio")+" "
                +rs.getInt("stock"));  
            }
        } catch (SQLException ex) {
            Logger.getLogger(ejercicioUno.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("seguro de eliminar registro si/no:");
        String seleccion= entrada.nextLine();
        if (seleccion.equals("si")) {
            
            try {
            Statement stmt = conectar();
            stmt.executeUpdate("Delete from producto where cod_pro="+codigo);
            System.out.println("registro eliminado! ");
            } catch (SQLException ex) {
                Logger.getLogger(claseDos.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("fracaso :( ");
            }
            
        }else{
            System.out.println("no eliminado!");
        }
    }
    
}
