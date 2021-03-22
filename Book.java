/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5_pa;

/**
 *
 * @author crist
 */
public class Book extends Item{
    String author;
    int releaseYear;

    public Book(String name, int releaseYear, String author, String location) {
        this.releaseYear = releaseYear;
        this.author = author;
        this.name = name;
        this.location = location;
    }
    
    
}
