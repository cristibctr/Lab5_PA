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
public class Movie extends Item{
    int releaseYear, rating;

    public Movie(String name, int releaseYear, int rating) {
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.setName(name);
    }
    
    
}
