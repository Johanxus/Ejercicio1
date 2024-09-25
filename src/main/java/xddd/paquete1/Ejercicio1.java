/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package xddd.paquete1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Johanxus
 */
public class Ejercicio1 {
    public static void main(String[] args) {
        String Usuario = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/java1";
        Connection Conexion;
        Statement statement;
        ResultSet rs;
       
        
        System.out.println("bienvenido, que opcion quiere escoger: 1. consultar, 2.insertar. 3.actualizar. 4. eliminar ");
        Scanner q = new Scanner(System.in);
        int opcion = q.nextInt();
        try {
            Conexion = DriverManager.getConnection(url, Usuario, password);
            statement = Conexion.createStatement();
            rs = statement.executeQuery("SELECT * FROM `datos` ");
            
         switch(opcion){
         
             case 1 ->{
             while(rs.next()){
             System.out.println(rs.getString("id") + "." + " " +
                     rs.getString("nombres"));
             
                }
             }
             case 2 ->{
             System.out.println("Ingrese el nombre que quiera ingresar a la base de datos");
             Scanner input2 = new Scanner(System.in);
             String nombre2 = input2.nextLine();
             String sql = "INSERT INTO datos (nombres) VALUES ('" + nombre2 + "')";
             statement.execute(sql);
             
             }
             case 3 ->{
             System.out.println("Ingrese la id que quiera actualizar a la base de datos");
             Scanner input2 = new Scanner(System.in);
             String id = input2.nextLine();
             System.out.println("Ingrese el mombre que quiera actualizar a la base de datos");
             Scanner input3 = new Scanner(System.in);
             String nombre = input3.nextLine();
             String sql = "UPDATE `datos` SET `nombres` = '"+ nombre +"' WHERE `datos`.`ID` = "+ id + "; ";
             statement.execute(sql);
             
             
             }
             case 4 ->{
             System.out.println("Ingrese la id que quiera eliminar de la base de datos");
             Scanner input2 = new Scanner(System.in);
             String id = input2.nextLine();
             String sql = "DELETE FROM datos WHERE `datos`.`ID` = "+id+"";
             statement.execute(sql);
             
             
             }
         
         
         }   
        } catch (SQLException ex) {
            Logger.getLogger(Ejercicio1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        }
        
        
        
        
    }

