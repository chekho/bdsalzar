/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javamongo502;

/**
 *
 * @author chekho
 */
public class Javamongo502 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        connection conn = new connection();                                    
        conn.mostrar();
        
        conn.mostrar();
        conn.insertar("nadar");
        System.out.println("otro mas");
        conn.mostrar();
        System.out.println("otro mas");
        conn.actualizar("nadar", "brincar");
        conn.mostrar();
    }
    
}
