/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thegame;

/**
 *
 * @author 160071X
 * The class of super warriors which inherit from warrior class
 */
public class SuperWarrior extends Warrior {

    private Binocular binocular;

    /**
     * constructor
     *
     * @param position initial grid location of the super warrior
     * @param name  of a super warrior
     * @param myGame the game which super warrior plays
     */
    public SuperWarrior(GridPosition position, String name, Game myGame){
        super(position,name, myGame);
        binocular = new Binocular(this);
    }

    /**
     *Overridden swim method
     */
    @Override
    public void eat(){
        System.out.println("SUPERWARRIOR EATS...!");
    }

    /**
     *Overridden sleep method
     */
    @Override
    public void sleep(){
        System.out.println("SUPERWARRIOR SLEEPS...!");
    }

    /**
     * Overridden swim method
     * Super warrior scan for lotus using his binocular and if there are no lotus in the vicinity he swims like a normal warrior
     */
    @Override
    public void swim() throws InterruptedException{
        if (this.binocular.scanPositions() != null && this.isMortal){
            synchronized (this.binocular.scanPositions()) {
                if (this.myGame.canMoveWarrior(this.binocular.scanPositions())) {
                    this.setPosition(this.binocular.scanPositions());
                    System.out.println(this.getName() + " moved to " +this.getPosition());
                    this.myGame.getInvolved(this);
                }
                else {
                    swim();
                }
            }
        }
        else{
            super.swim();
        }
    }

}
