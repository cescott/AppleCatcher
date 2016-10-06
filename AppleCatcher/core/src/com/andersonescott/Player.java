package com.andersonescott;

import com.badlogic.gdx.graphics.Texture;

public class Player extends Entity {

    protected int score;

    public Player(double[] tempCoords, int tempScore){
        super(tempCoords);
        image = new Texture("applecatcher_bill.png");
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
