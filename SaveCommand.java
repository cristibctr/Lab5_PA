/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5_pa;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import static lab5_pa.Main.catalog;
/**
 *
 * @author crist
 */
public class SaveCommand extends Commands{

    public SaveCommand() {
        System.out.println("Save()");
    }
    public static void save() throws IOException{
        try(var oos = new ObjectOutputStream(new FileOutputStream(catalog.getPath()))){
            oos.writeObject(catalog);
        }
    }
}
