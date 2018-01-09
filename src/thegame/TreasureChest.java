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
 * The class of treasurechest
 */
public class TreasureChest extends GameObject implements Involvable{
    
    private boolean isFound;
    private ArrayList<Warrior> warriors = new ArrayList<>();
    private Game myGame;

    /**
     * 
     * constructor
     * 
     * @param position initial grid location of the treasure chest
     */
    public TreasureChest(GridPosition position, Game myGame) {
        super(position);
        this.isFound = false;
        this.myGame = myGame;
    }

    /**
     * This method is used to get whether the chest is found by a warrior
     * @return
     */
    public boolean isFound() {
        return isFound;
    }

    /**
     * implementation of the involve method
     * finishing time is taken
     * all other warriors are notified that there is a winner
     *results are send to the game to display
     *
     * @param warrior who made a move to a certain grid position
     */
    @Override
    public void involve(Warrior warrior){
        long timeFound = System.currentTimeMillis();
        isFound = true;
        notifyWarriors();
        myGame.displayResult(new Result(warrior, timeFound));
    }

    /**
     * This method is used to add warriors into the list of warriors who should be notified about a discovery or the chest
     *
     * @param warrior who started moving
     */
    public void addListener( Warrior warrior) {
        warriors.add(warrior);
    }

    /**
     * This method is used to notify all swimming warriors to stop once a warrior reached to the chest
     */
    public void notifyWarriors(){
        for (Warrior warrior : warriors){
            warrior.update();
        }
    }

}