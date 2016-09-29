package com.andersonescott;

/**
 * Created by JackassNoonNerd on 9/29/16.
 */
public class Player extends Entity {

    protected int score;

    public Player(double[] tempCoords, double[] tempVelocity, int tempScore){
        super(tempCoords, tempVelocity);
        score = tempScore;
    }

    public int getScore(){
        return score;
    }

    public void setScore(int newValue){
        score = newValue;
    }

    public void incrementScore(int value){
        score += value;
    }
}
