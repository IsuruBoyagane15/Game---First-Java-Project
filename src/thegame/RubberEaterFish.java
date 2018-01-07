/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thegame;

import java.util.ArrayList;
/**
 *
 * @author 160071X 
 * The class of Rubber Eating Fish in the game
 */
public class RubberEaterFish extends Fish implements Involvable{

    /*
    *
    *constructor
    *
    *@param position initial grid location of the rubber eater fish
    */
    public RubberEaterFish(GridPosition position){
        super(position);
        }
    
    /**
     * this method set warrior's fins to a empty ArrayList and display that a warrior cannot swim anymore
     * @param warrior warrior who moved to position of a rubber eater fish
     */

    /**
     * implementation of the involve method
     * fish eats warrior's fins
     *
     * @param warrior who made a move to a certain grid position
     */
    @Override
    public void involve(Warrior warrior){
        warrior.setFins(new ArrayList<>());
        System.out.println("\nFish on " + this.getPosition() + " ate " + warrior.getName() + "'s fins...!");
        System.out.println(warrior.getName() + " cannot swim anymore ...!\n");
    }
    
   
}
