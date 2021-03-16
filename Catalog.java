/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5_pa;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author crist
 */
public class Catalog implements Serializable {
    private String name, path;
    private List<Item> items = new ArrayList<>();

    Catalog(String name, String path) {
        this.name = name;
        this.path = path;
    }
    public void add(Item item){
        items.add(item);
    }
    
    public Item findByName(String name){
        return items.stream().filter(n -> n.getName().equals(name)).findFirst().orElse(null);
    }

    public String getPath() {
        return path;
    }
    
    public void list(){
        items.stream().forEach(i -> {System.out.println("Name: " + i.getName() + "Location: " + i.getLocation());});
    }
    
    public Item getItemsIndex(int index) {
        return items.get(index);
    }
    
    
}
