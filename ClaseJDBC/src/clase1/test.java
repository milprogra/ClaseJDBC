/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase1;

/**
 *
 * @author mjara
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String descripcion = "producto tanto";
        int precio = 12000;
        int stock = 30;
        
        System.out.println("Insert into producto(descripcion,precio,stock) values ('"+
                    descripcion+"',"+precio+","+stock+")");
    }
    
}
