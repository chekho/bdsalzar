/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javamongo502;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mongodb.BasicDBObject;
import com.mongodb.Mongo;

/**
 *
 * @author chekho
 */
public class connection {
    DB BaseDatos;
    DBCollection coleccion;
    BasicDBObject document = new BasicDBObject();
    
    public connection(){
        try {
            Mongo mongo = new Mongo("127.0.0.1", 27017);
            BaseDatos = mongo.getDB(  "actividad502");
            coleccion = BaseDatos.getCollection("actividad502");
            System.out.println("Conexion Exitosa");
        } catch(Exception ex) {            
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE,null,ex);
        }        
 
    }
    
    public boolean insertar(String accion){
        
        document.put("accion", accion);
        coleccion.insert(document);              
        return true;        
    }
    
    public void mostrar(){
       DBCursor cursor = coleccion.find();       
       while(cursor.hasNext()){
           System.out.println(cursor.next());           
       }
    }
    
    public boolean actualizar(String accionVieja, String accionNueva){
        
        document.put("accion", accionVieja);
        BasicDBObject documentNuevo = new BasicDBObject();
        documentNuevo.put("accion", accionNueva);
        coleccion.findAndModify(document, documentNuevo);               
        return true;
    }   
    
    public boolean eliminar(String accion){
        document.put("accion", accion);  
        coleccion.remove(document);
        return true;
    }
}
