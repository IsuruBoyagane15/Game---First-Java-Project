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
 * The class of Binocular which super warrior carries
 */
public class Binocular {

    private final SuperWarrior carrier;
    
    /**
     * 
     * constructor
     * 
     * @param carrier the owner of the binocular
     */
    public Binocular(SuperWarrior carrier){
        this.carrier = carrier;
    }
    
    /**
     * This method check nearby locations of a super warrior who carries the binocular and return the first grid
     * position of a lotus
     * @return grid position of nearby lotus 
     */
    public GridPosition scanPositions(){
        ArrayList<GridPosition> ScannedPositions = new ArrayList<>();
        ScannedPositions.add(new GridPosition(this.carrier.getPosition().getX()+1,this.carrier.getPosition().getY()));
        ScannedPositions.add(new GridPosition(this.carrier.getPosition().getX()-1,this.carrier.getPosition().getY()));
        ScannedPositions.add(new GridPosition(this.carrier.getPosition().getX(),this.carrier.getPosition().getY()+1));
        ScannedPositions.add(new GridPosition(this.carrier.getPosition().getX(),this.carrier.getPosition().getY()-1));
        
        return this.carrier.getMyGame().getALotusPosition(ScannedPositions);
    }
}
