/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5_pa;
import static lab5_pa.Main.catalog;
/**
 *
 * @author crist
 */
public class ListCommand extends Commands{

    public ListCommand() {
        System.out.println("List()");
    }
    public void list(){
        catalog.list();
    }
}
