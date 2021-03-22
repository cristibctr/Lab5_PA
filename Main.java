/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5_pa;

import freemarker.template.TemplateException;
import java.io.IOException;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author crist
 */
public class Main {
    static Catalog catalog = new Catalog("My catalog", "d:/media/catalog.ser");
    public static void main(String args[]) {
        Commands command;
        Scanner s = new Scanner(System.in);
        Main app = new Main();
        //app.testCreateSave();
        //app.testLoadView();
        System.out.println("Please write a command: (add/list/save/load/play/report)");
        String commKbd = s.next();
        String loadPath, itemName;
        var movie = new Movie("bestMovie", 2012, 10, "D:/myPath/bestMovie");
        var book  = new Book("bestBook", 2018, "John", "D:/myPath/bestBook");
        catalog.add(movie);
        catalog.add(book);
        switch(commKbd){
            case "add":
                command = new AddCommand();
                ((AddCommand)command).add();
                break;
            case "list":
                command = new ListCommand();
                ((ListCommand)command).list();
                break;
            case "save":
                command = new SaveCommand();
                try {
                    ((SaveCommand)command).save();
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "load":
                command = new LoadCommand();
                System.out.println("Please specify a path: ");
                loadPath = s.next();
                try {
                    ((LoadCommand)command).load(loadPath);
                } catch (InvalidCatalogException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "play":
                command = new PlayCommand();
                System.out.println("Please specify an Item name: ");
                itemName = s.next();
                try {
                    ((PlayCommand)command).play(catalog.getItems().stream().filter(item -> item.getName().equals(itemName)).collect(Collectors.toList()).get(0));
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "report":
                try {
                command = new ReportCommand();
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (TemplateException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            default:
                throw new InvalidCommand(commKbd);
        }
            
    }
    
    private void testCreateSave() {
        Catalog catalog = new Catalog("My Books", "d:/media/catalog.ser");
        var movie = new Movie("bestMovie", 2012, 10, "D:/myPath/bestMovie");
        var book  = new Book("bestBook", 2018, "John", "D:/myPath/bestBook");
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
