/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5_pa;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author crist
 */
public class CatalogUtil {
    public static void save(Catalog catalog) throws IOException{
        try(var oos = new ObjectOutputStream(new FileOutputStream(catalog.getPath()))){
            oos.writeObject(catalog);
        }
    }
    
    public static Catalog load(String path) throws InvalidCatalogException {
        try(var oos = new ObjectInputStream(new FileInputStream(path))){
            return (Catalog)oos.readObject();
        }
        catch (IOException ex)
        {
            throw new InvalidCatalogException(ex);
        }
        catch(ClassNotFoundException ex)
        {
            throw new InvalidCatalogException(ex);
        }
    }
    
    static public void play(Item item) throws IOException{
        Desktop desktop = Desktop.getDesktop();
        try{
            desktop.open(new File(item.getLocation()));
        }
        catch(IOException ex){
            System.out.println();
        }
    }
    
    
}
