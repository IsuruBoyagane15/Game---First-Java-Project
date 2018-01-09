/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thegame;

import java.util.Random;
import java.util.ArrayList;

/**
 *
 * @author 160071X
 * The class of warriors which inherit from game objects class
 */
public class Warrior extends GameObject implements Runnable{
    private final String name;
    protected boolean isMortal;
    private boolean isAlive;
    protected final Game myGame;
    private ArrayList<SwimFin> fins;
    private static int WARRIOR_COUNT;
    private boolean canWin;
    
    /**
    *
    * constructor
    * 
    *@param position initial grid location of a warrior
    *@param name name of a warrior
    *@param myGame the game which warrior plays
    *
    */
    public Warrior(GridPosition position,String name,Game myGame){
        super(position);
	    this.name = name;
	    this.isAlive = true;
        this.isMortal = true;
        this.myGame = myGame;
        this.fins = new ArrayList<>();
        fins.add(new SwimFin());
        fins.add(new SwimFin());
        this.canWin = true;
        WARRIOR_COUNT ++;
    }

    /**
     * Overridden run() method
     *
     * warrior takes moves in his thread until he is alive, has two fins and treasure chest is not found
     */
    @Override
    public void run(){

        while (getFins().size() == 2  && isAlive && canWin){
            try {
                 this.swim();
             } catch (InterruptedException ex) {
                 return;
             }
        }
    }


    /**
     * This method is used to move a warrior from onr position to another
     */
    public void swim() throws InterruptedException {
        Random rand = new Random();
        int direction = rand.nextInt(4);
        GridPosition targetPosition = null;
        // This block selects a random direction to warrior to move
        switch (direction) {
            case 0:
                targetPosition = new GridPosition(this.getPosition().getX() + 1, this.getPosition().getY());
                break;
            case 1:
                targetPosition = new GridPosition(this.getPosition().getX() - 1, this.getPosition().getY());
                break;
            case 2:
                targetPosition = new GridPosition(this.getPosition().getX(), this.getPosition().getY() + 1);
                break;
            case 3:
                targetPosition = new GridPosition(this.getPosition().getX(), this.getPosition().getY() - 1);
                break;
        }
        //when a warrior selected a direction that grid position is locked to achieve sychronization
        synchronized (targetPosition) {
            if (this.myGame.canMoveWarrior(targetPosition) && this.myGame.checkPosition(targetPosition)) {
                this.setPosition(targetPosition);
                System.out.println(this.getName() + " moved to " + this.getPosition());
                this.myGame.getInvolved(this);
                Thread.sleep(100);
            } else {
                this.swim();
            }
        }
    }

    /**
     * This method is used to keep updated the warriors about the chest
     * if treasure chest is found warrior cannot win
     */
    public void update(){
        this.canWin = false;
    }

    /**
     * this method is used to pluck a petal of a lotus
     *
     * @param lotus the lotus which the warrior is going to pluck
     */
    public void pluck(Lotus lotus) {
        lotus.involve(this);
    }


    /**
     * warrior eats
     */
    public void eat() {
        System.out.println("WARRIOR EATS...!");
    }

    /**
     * warrior sleeps
     */
    public void sleep() {
        System.out.println("WARRIOR SLEEPS...!");
    }

    /**
     * this method is used to get the name of the warrior
     * @return name of the warrior
     */
    public String getName(){
        return this.name;
    }

    /**
     * this method is used to get hasFins of the warrior
     * @return whether warrior has fins
     */
    public ArrayList<SwimFin> getFins(){
        return fins;
    }

    /**
     * this method is used to get isMortal of the warrior
     * @return whether warrior can be killed
     */
    public boolean getMortal(){
        return this.isMortal;
    }

    /**
     * this method is used to set fins of the warrior
     * @param fins the value to be set to hasFins
     */
    public void setFins(ArrayList<SwimFin> fins){
        this.fins = fins;
    }

    /**
     * this method is used to get the game warrior is playing
     *
     * @return game the warrior plays
     */
    public Game getMyGame() {
        return this.myGame;
    }

    /**
     * this method is used to get isAlive of the warrior
     *
     * @return whether warrior is alive
     */
    public boolean getAlive() {
        return this.isAlive;
    }

    /**
     * this method is used to set isMortal of the warrior
     * @param isMortal value to be set to isMortal
     */
    public void setMortal(boolean isMortal){
        this.isMortal = isMortal;
    }

    /**
     * this method is used to set isAlive of the warrior
     * @param isAlive value to be set to isAlive
     */
    public void setAlive(boolean isAlive){
        this.isAlive = isAlive;
    }


}
