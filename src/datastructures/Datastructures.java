/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import java.util.LinkedList;

/**
 *
 * @author Annika
 */
public class Datastructures {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Heap h = new Heap(4);
        h.insertValues();
        LinkedList l = h.getValues();
        System.out.println(l.size());
        System.out.println(h.getSize());
        
        for(Object i: l) {
            System.out.println(i);
        }
        
        h.add();
        
        h.print(h.getRoot());
        
    }
    
}
