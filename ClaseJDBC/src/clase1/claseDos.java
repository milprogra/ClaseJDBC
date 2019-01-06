
package clase1;
import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class claseDos {

    public static void main(String[] args) {
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
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/faladeuda?autoReconnect=true&useSSL=false", "admin", "admin");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("Insert into producto(descripcion,precio,stock) values ('"+
                    descripcion+"',"+precio+","+stock+")");
            System.out.println("exito! :) ");
        } catch (SQLException ex) {
            Logger.getLogger(claseDos.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("fracaso :( ");
        }
       
    }
    
}
