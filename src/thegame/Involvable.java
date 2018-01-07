/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thegame;

/**
 *
 * @author 160071X
 * this is a interface which treasure chest, killer fish, rubber eating fish and lotus extends
 */


public interface Involvable {

    /**
     *This abstract method is used to let game objects to involve to the game
     *
     * @param warrior who made a move to a certain grid position
     */
    public abstract void involve(Warrior warrior);
}
