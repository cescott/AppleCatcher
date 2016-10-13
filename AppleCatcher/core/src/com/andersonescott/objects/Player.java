package com.andersonescott.objects;

import com.badlogic.gdx.graphics.Texture;

public class Player extends Entity {

    protected int score;
    protected int lives;

    public Player(double[] tempCoords, int tempScore){
        super(tempCoords);
        image = new Texture("applecatcher_bill.png");
        score = tempScore;
        lives = 3;
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

    public int getLives() {
        return lives;
    }
    public void damage(){
        lives--;
    }

    public void input(String state, int keycode){

        if (keycode == 21){ //left arrow
            if (state.equals("pressed")) {
                velocity[0] = velocity[0] - 800;
            }
            else if (state.equals("released")){
                velocity[0] = velocity[0] + 800;
            }
        }

        else if (keycode == 22){ //right arrow
            if (state.equals("pressed")) {
                velocity[0] = velocity[0] + 800;
            }
            else if (state.equals("released")){
                velocity[0] = velocity[0] - 800;
            }
        }

        else if (keycode == 19) {
            if (state.equals("pressed") && coords[1] == 10) {
                velocity[1] = 1200;
                acceleration[1] = -3600;
            }
        }
    }
}
