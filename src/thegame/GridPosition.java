/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thegame;

/**
 *
 * @author 160071X 
 * the class of Grid Positions
 */
public class GridPosition {
    private int x;
    private int y;

    /**
     * 
     * constructor
     * 
     * @param x x coordinate of the grid position
     * @param y y coordinate of the grid position
     */
    public GridPosition(int x, int y) {
        this.x = x;
        this.y = y;

    }
    
    /**
     * this method is used to get the x coordinate of a grid position
     * @return x coordinate of a grid position
     */
    public int getX() {
        return x;
    }

    /**
     * this method is used to get the y coordinate of a grid position
     * @return y coordinate of a grid position
     */
    public int getY() {
        return y;
    }
    
    /**
     * this method is used to set the x coordinate of a grid position
     * @param x the value to be set to the x coordinate of grid position
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * this method is used to set the y coordinate of a grid position
     * @param y the value to be set to the y coordinate of grid position
     */
    public void setY(int y) {
        this.y = y;
    }
    
    @Override
    public String toString(){
        return "("+x+","+y+")";
    }
    
    
    @Override
    public boolean equals(Object position){
        if (position instanceof GridPosition){
            GridPosition thisPosition = (GridPosition)position;
            return (this.x == thisPosition.x && this.y == thisPosition.y);
            }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.x;
        hash = 29 * hash + this.y;
        return hash;
    }
}
