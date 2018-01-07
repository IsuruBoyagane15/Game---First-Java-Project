/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thegame;

/**
 *
 * @author 160071X 
 * The class of Killer Fish in the game
 */
public class KillerFish extends Fish implements Involvable{
        
    /**
     * 
     * constructor
     * 
     * @param position initial grid location of the killer fish
     */
    public KillerFish(GridPosition position){
        super(position);
    }
    
    /**
     * this method set warrior's isAlive to false and display that warrior is killed
     * @param warrior warrior who moved to the position of the killer fish
     */
    public void involve(Warrior warrior){
        warrior.setAlive(false);
        System.out.println("\n" + warrior.getName() + " was killed by killer fish on "+ getPosition() + "...!\n");
    }
    
}
