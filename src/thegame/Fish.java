/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thegame;

/**
 *
 * @author 160071X 
 * The class of Fish in the lake
 */
public class Fish extends GameObject{
    
    private static int FISH_COUNT;
    private int identity;
    
    /**
    *Constructor
    *
    *@param position initial grid location of the fish
    */
    public Fish(GridPosition position){
        super(position);
        this.identity = getFISH_COUNT()+1;
        FISH_COUNT ++;
    }

    /**
     * This method is used to get the FISH_COUNT
     *
     * @return number of fish created
     */
    public static int getFISH_COUNT() {
        return FISH_COUNT;
    }

    /**
     * This method is used to get the identity of a fish
     *
     * @return in t identity of a fish
     */
    public int getIdentity(){
        return identity;
    }
}
