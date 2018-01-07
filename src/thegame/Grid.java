/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thegame;
import java.util.*;
/**
 *
 * @author 160071X
 * The class of 2D grid which is used to keep track on positions of game objects 
 */
public class Grid {
    
    private HashMap<GridPosition,GameObject > grid;
    
    /**
     * 
     * constructor
     */
    public Grid(){
        grid = new HashMap<>();
    }
    
    /**
     * this method is used to get the grid
     * @return the grid
     */
    public HashMap<GridPosition, GameObject> getGrid() {
        return grid;
    }  
}
   
   

