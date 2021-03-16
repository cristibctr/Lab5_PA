/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5_pa;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author crist
 */
public abstract class Item implements Serializable{
    private String name, location;
    private Map<String, Object> tags = new HashMap<>();
    
    public void addTag(String key, Object obj) {
        tags.put(key, obj);
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    
}
