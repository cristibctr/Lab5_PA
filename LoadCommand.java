/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5_pa;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import static lab5_pa.Main.catalog;
/**
 *
 * @author crist
 */
public class LoadCommand extends Commands{

    public LoadCommand() {
        System.out.println("Load()");
    }
    public static void load(String path) throws InvalidCatalogException {
        try(var oos = new ObjectInputStream(new FileInputStream(path))){
            catalog = (Catalog)oos.readObject();
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
}
