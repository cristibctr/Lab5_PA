/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5_pa;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author crist
 */
public class PlayCommand extends Commands{

    public PlayCommand() {
        System.out.println("Play()");
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
