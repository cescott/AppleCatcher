package com.andersonescott;

import com.badlogic.gdx.graphics.Texture;

public class Player extends Entity {

    protected int score;

    public Player(double[] tempCoords, double[] tempVelocity, int tempScore){
        super(tempCoords, tempVelocity);
        image = new Texture("player.jpg");
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
