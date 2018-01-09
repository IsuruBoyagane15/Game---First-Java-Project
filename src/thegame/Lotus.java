/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thegame;

/**
 *
 * @author 160071X
 * The class of Lotus in the game
 */
public class Lotus extends GameObject implements Involvable {

    private int numberOfPetals;
    private static int LOTUS_COUNT;
    private int identity;

    /**
     * constructor
     *
     * @param position initial grid location of the lotus
     */
    public Lotus(GridPosition position) {
        super(position);
        this.numberOfPetals = 100;
        this.identity = LOTUS_COUNT + 1;
        LOTUS_COUNT++;
    }

    /**
     * this method check whether warrior can pluck a petal and set w immortal if he can pluck a petal
     *
     * @param warrior warrior who moved to a lotus position
     */
    public void involve(Warrior warrior) {
        if (numberOfPetals > 0) {
            numberOfPetals -= 1;
            warrior.setMortal(false);
            System.out.println("\n" + warrior.getName() + " plucked a petal of a lotus located on " + getPosition() + "...!");
            System.out.println(warrior.getName() + " is now immortal...!\n");
        } else {
            System.out.println("\nThere are no petals to pluck...!\n");
        }
    }

    /**
     * This method is used to get the identity of a lotus
     *
     * @return int identity od a warrior
     */
    public int getIdentity() {
        return identity;
    }

}
