/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5_pa;

import java.io.IOException;

/**
 *
 * @author crist
 */
public class Main {
    public static void main(String args[]) {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }
    
    private void testCreateSave() {
        Catalog catalog = new Catalog("My Books", "d:/media/catalog.ser");
        var movie = new Movie("bestMovie", 2012, 10);
        var book  = new Book("bestBook", 2018, "John" );
        catalog.add(movie);
        catalog.add(book);
        try {
            CatalogUtil.save(catalog);
        } catch (IOException ex) {
           System.out.println("Can't save: " + ex);
        }
    }
    
    private void testLoadView() {
        Catalog catalog;
        try {
            catalog = CatalogUtil.load("d:/java/catalog.ser");
            CatalogUtil.play(catalog.findByName("bestSong"));
        } 
        catch (InvalidCatalogException ex) {
            System.out.println("Can't load: " + ex);
        }
        catch(IOException ex)
        {
            System.out.println("Can't play: " + ex);
        }
        
    }
}
