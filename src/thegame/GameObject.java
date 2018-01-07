/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thegame;

/**
 *
 * @author 160071X
 * Abstract class which all game objects inherit from
 *
 */
public abstract class GameObject {
    
    private GridPosition position;
    
    /**
    *Constructor
    *
    *@param position grid location of a game object
    *
    */
    public GameObject(GridPosition position){
        this.position = position;
    }
    
    /**
     * this method set the value of a position of a game object
     * @param position grid position of a game object
     */
    public void setPosition(GridPosition position){
        this.position = position;
    }
    
    /**
     * this method is used to get the value of a game object's position
     * @return the position of a game object
     */
    public GridPosition getPosition(){
        return position;
    }
}


