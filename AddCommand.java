/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5_pa;

import java.util.Scanner;
import static lab5_pa.Main.catalog;

/**
 *
 * @author crist
 */
public class AddCommand extends Commands{

    public AddCommand() {
        System.out.println("Add()");
    }
    public void add(){
        Scanner s = new Scanner(System.in);
        System.out.println("Movie/Book:");
        String movieOrBook = s.next();
        String name, author, location;
        int rating, releaseYear;
        if(movieOrBook.equals("Movie")){
            System.out.println("Name:");
            name = s.next();
            System.out.println("Release Year:");
            releaseYear = s.nextInt();
            System.out.println("Rating");
            rating = s.nextInt();
            System.out.println("Location");
            location = s.next();
            var movie = new Movie(name, releaseYear, rating, location);
            catalog.add(movie);
        }
        else if(movieOrBook.equals("Book")){
            System.out.println("Name:");
            name = s.next();
            System.out.println("Release Year:");
            releaseYear = s.nextInt();
            System.out.println("Author");
            author = s.next();
            System.out.println("Location");
            location = s.next();
            var book = new Book(name, releaseYear, author, location);
            catalog.add(book);
        }
        else{
            System.out.println("Incorrect command");
        }
    }
}
