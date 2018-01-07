/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thegame;

import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 160071X
 * The class of game
 */
public class Game {
    
    private  final Grid grid;
    private  ArrayList <GameObject> listOfObjects;
    private  ArrayList <Warrior> listOfWarriors;
    private  ArrayList <Lotus> listOfLotus;
    private  ArrayList <KillerFish> listOfKillerFish;
    private  ArrayList <RubberEaterFish> listOfREFish;
    private  ArrayList <Fish> listOfInocentFish;
    private  TreasureChest treasureChest;
    private long startTime;
    
    /**
    * 
    *Constructor
    *
    */    
    public Game(){
        this.grid = new Grid();
        this.listOfObjects = new ArrayList<>();
        this.listOfWarriors = new ArrayList<>();
        this.listOfLotus = new ArrayList<>();
        this.listOfInocentFish = new ArrayList<>();
        this.listOfREFish = new ArrayList<>();
        this.listOfKillerFish = new ArrayList<>();

    }

    /**
     * this method create all game objects, put them to suitable grid positions and display the details of created objects
     */
    public void initiateObjects(){
        Scanner sc = new Scanner(System.in);
        
        Lake lake = new Lake();
        TreasureChest treasureChest = new TreasureChest(new GridPosition(5,5));
        this.treasureChest = treasureChest;
        System.out.println("TREASURE CHEST IS LOCATED AT (5,5) LOCATION\n");
        listOfObjects.add(treasureChest);
        grid.getGrid().put(treasureChest.getPosition(),treasureChest);
        
        System.out.println("    ---ENTER NAMES OF FOUR WARRIORS---");
        Random rand = new Random();
        for (int i = 1; i<5; i++){
            int superOrNot = rand.nextInt(2);
            if (superOrNot == 1){
                //create super warriors
                listOfObjects.add(new SuperWarrior(initiateWarriorPositions(),sc.next(),this));
                listOfWarriors.add((Warrior)listOfObjects.get(i));
                grid.getGrid().put(listOfObjects.get(i).getPosition(),listOfObjects.get(i));
            }
            else{
                //create normal warriors
                listOfObjects.add(new Warrior(initiateWarriorPositions(),sc.next(),this));
                listOfWarriors.add((Warrior)listOfObjects.get(i));
                grid.getGrid().put(listOfObjects.get(i).getPosition(),listOfObjects.get(i));
            }
        }
        
        for (int i=5; i<11; i++){
            if (i<7){
                //create two inocent fish
                listOfObjects.add(new Fish(initiateOtherPositions()));
                listOfInocentFish.add((Fish)listOfObjects.get(i));
                grid.getGrid().put(listOfObjects.get(i).getPosition(),listOfObjects.get(i));
            }
            else if (i<9){
                //create two rubber eating fish
                listOfObjects.add(new RubberEaterFish(initiateOtherPositions()));
                listOfREFish.add((RubberEaterFish)listOfObjects.get(i));
                grid.getGrid().put(listOfObjects.get(i).getPosition(),listOfObjects.get(i));
            }
            else{
                //create two killer fish
                listOfObjects.add(new KillerFish(initiateOtherPositions()));
                listOfKillerFish.add((KillerFish)listOfObjects.get(i));
                grid.getGrid().put(listOfObjects.get(i).getPosition(),listOfObjects.get(i));
            }
        }
       
        for (int i = 11; i<16; i++){
            listOfObjects.add(new Lotus(initiateOtherPositions()));
            listOfLotus.add((Lotus)listOfObjects.get(i));
            grid.getGrid().put(listOfObjects.get(i).getPosition(),listOfObjects.get(i));
        }
        System.out.println();
        
        for (Warrior warrior : listOfWarriors){
            System.out.println(warrior.getClass().getSimpleName() + " : " + warrior.getName()+ " is on " + warrior.getPosition());
        }
        System.out.println();
        
        for (Fish innocentFish : listOfInocentFish){
            System.out.println("Fish " + innocentFish.getIdentity()+" : Innocent fish on " + innocentFish.getPosition());
        }
        System.out.println();
        
        for (RubberEaterFish rubberEatertFish : listOfREFish){
            System.out.println("Fish " + rubberEatertFish.getIdentity()+" : Rubber Eater fish on " + rubberEatertFish.getPosition());
        }
        System.out.println();
        
        for (KillerFish killerFish : listOfKillerFish){
            System.out.println("Fish " + killerFish.getIdentity()+" : Killer fish on " + killerFish.getPosition());
        }
        System.out.println();
        
        for (Lotus lotus : listOfLotus){
            System.out.println("Lotus "+ lotus.getIdentity() + " on " + lotus.getPosition());
        }
        System.out.println();
    }
     
    /**
     * this method create and return a suitable grid position for warrior
     * @return suitable grid position to a warrior
     */
    public GridPosition initiateWarriorPositions(){
        Random rand = new Random();
        int x;
        int y;
        x = rand.nextInt(11);
        y = rand.nextInt(11);
        GridPosition temp = new GridPosition(x,y);
        if (x == 0 || x == 10 || y == 0 || y == 10){
            if (this.grid.getGrid().containsKey(temp)){
                return initiateWarriorPositions();
            }
            else{
                return temp;   
            }
        }
        else{
            return initiateWarriorPositions();
        }
    }
     
    /**
     * this method create and return a suitable grid position for objects that are not warriors
     * @return suitable grid position to a objects that are not warriors
     * 
     */
    public GridPosition initiateOtherPositions(){
        Random rand = new Random();
        int x;
        int y;
        x = rand.nextInt(11);
        y = rand.nextInt(11);
        GridPosition temp = new GridPosition(x,y);
        if (grid.getGrid().containsKey(temp)){   
            return initiateWarriorPositions();
        }
        else{
            return temp;   
        }
    }
    
    /**
     * this method check whether given position is in the grid
     * @param position grid position to be checked
     * @return whether given position is in the bounds of the grid
     */
    public boolean checkPosition(GridPosition position){
        return position.getX()>-1 && position.getY()>-1 && position.getX()<11 && position.getY()<11;
    }
    
    /**
     * this method set the consequences to warrior after warrior took a move
     * warrior may win the game
     * warrior may loss his fins
     * warrior may be killed
     * warrior may become immortal
     *
     * @param warrior who moved
     */
    public void getInvolved(Warrior warrior){
        for (int i = 0; i<listOfObjects.size(); i++){
            if (listOfObjects.get(i).getPosition().equals(warrior.getPosition())){
                if (listOfObjects.get(i) instanceof TreasureChest){
                    TreasureChest treasureChest = (TreasureChest) listOfObjects.get(i);
                    treasureChest.involve(warrior);
                    break;
                }
                if (listOfObjects.get(i) instanceof RubberEaterFish){
                    RubberEaterFish rubberEaterFish = (RubberEaterFish) listOfObjects.get(i);
                    rubberEaterFish.involve(warrior);
                    break;
                }
                if (listOfObjects.get(i) instanceof KillerFish && warrior.getMortal()){
                    KillerFish killerFish = (KillerFish) listOfObjects.get(i);
                    killerFish.involve(warrior);
                    break;
                }
                if (listOfObjects.get(i) instanceof Lotus && warrior.getMortal()) {
                    Lotus lotus = (Lotus) listOfObjects.get(i);
                    warrior.pluck(lotus);
                    break;
                }
            }
        }        
    }
    
    /**
     * 
     * this method gives a grid position of a lotus which is in scannedPositions sent by binocular of a super warrior
     * @param scannedPositions set of positions that binocular scanned
     * @return grid position of lotus
     */
    public GridPosition getALotusPosition(ArrayList<GridPosition> scannedPositions){
        for (GridPosition scannedPosition : scannedPositions){
            for (Lotus lotus : listOfLotus){
                if (scannedPosition.equals(lotus.getPosition())){
                    return lotus.getPosition();
                }
            }
        }
        return null;
    }
    
    /**
     * this method check whether a warrior is occupied on the target position
     * @param targetPosition position that warrior suppose to move
     * @return whether there is a warrior in the target position
     */
    public boolean canMoveWarrior(GridPosition targetPosition){
        for (Warrior warrior : listOfWarriors){
            if (warrior.getPosition().equals(targetPosition)){
                return false;
            }
            else if (warrior == listOfWarriors.get(listOfWarriors.size()-1)){
                return true;
            }  
        }
        return false;
    }

    /**
     *This method decides whether any warrior can move anymore or not
     *
     * @return whether any warrior can move anymore or not
     */
    public boolean AreWarriorsMobile(){
        boolean areWarriorsMobile =  false;
        for (Warrior warrior : listOfWarriors){
            areWarriorsMobile = areWarriorsMobile || (warrior.getAlive() && warrior.getFins().size() == 2);
            if (areWarriorsMobile){return true;}
        }
        return false;
    }
    
    /**
     * This method let warriors to play the game by starting different threads & keep game on until a proper result comes
     */
    public void play(){
        System.out.println("          --- GAME IS ON ---");
        this.initiateObjects();
        //clock of the game starts here
        long startTime = System.currentTimeMillis();
        this.treasureChest.setStartTime(startTime);
        for (Warrior warrior : listOfWarriors){
            //starting warrior threads one by one
            Thread thread = new Thread(warrior);
            thread.start();
            //notify the treasure chest that a warrior started moving
            treasureChest.addListener(warrior);
        }

        //this block keep the game on in the main thread until a warrior find the chest or all warriors are immobile
        while (AreWarriorsMobile() && treasureChest.isFound() == false){
            continue;
        }
        //if all warriors are immobile terminate the game
        if (AreWarriorsMobile() == false) {
            System.out.println("       ---NO WARRIOR REACHED THE CHEST---\n           GAME OVER...!");
        }


    }

}
