package com.andersonescott.gameworld;


import com.andersonescott.objects.Apple;
import com.andersonescott.objects.Player;

import java.util.ArrayList;

public class GameWorld {

    //objects
    protected ArrayList<Apple> apples= new ArrayList<Apple>();
    protected Player player;

    //apple count variables
    protected double num = 0;
    protected double currentScore = 0;
    protected int counter;

    protected GameState gameState;

    public enum GameState {
        READY, RUNNING, GAMEOVER
    }

    public GameWorld(){
        player = new Player(new double[] {350, 10}, 0);
        gameState = GameState.READY;
    }

    public void start(){
        player.restart();
        gameState = GameState.RUNNING;
    }

    public void update(float delta){
        switch (gameState){
            case RUNNING:
                updateRunning(delta);

            case GAMEOVER:
                //TODO
            case READY:
                //TODO
        }
    }

    public void updateRunning(float delta){
        //update player
        player.update(delta);
        //update all the apples
        if (appleCount()) {
            apples.add(new Apple(new double[]{(Math.random() * 700) + 10, 520}));
        }
        for (int i=0; i<apples.size();i++){
            apples.get(i).update(delta);
        }
        //update collisions
        collisionUpdate();
        if (player.getLives() == 0){
            gameState = GameState.GAMEOVER;
        }
    }

    public Player getPlayer(){
        return player;
    }

    public ArrayList<Apple> getApples(){
        return apples;
    }

    public boolean isReady(){
        return gameState == GameState.READY;
    }

    public boolean isRunning(){
        return gameState == GameState.RUNNING;
    }

    public boolean isGameover(){
        return gameState == GameState.GAMEOVER;
    }

    public boolean appleCount() {
        counter++;
        num = counter;
        currentScore = player.getScore() + 20;
        if (num/30 >= (75/currentScore) + 0.35) {
            counter = 0;
            return true;
        }
        return false;
    }

    public void collisionUpdate() {
        for (int i = 0; i < apples.size(); i++) {
            //handle bouncing off walls
            if ((apples.get(i).x() <= 0 && apples.get(i).getVelocity()[0] < 0)
                    || (apples.get(i).x() >= 720 && apples.get(i).getVelocity()[0] > 0)) {
                apples.get(i).setVelocity(new double[]{apples.get(i).getVelocity()[0] * -1, apples.get(i).getVelocity()[1]});
            }
            //hit ground
            if (apples.get(i).y() <= 10) {
                apples.remove(i);
                player.damage();
            }
            //player catches it
            else if (Math.abs(apples.get(i).y() - player.y()) <= 200 && Math.abs(apples.get(i).x() - player.x()) <= 100) {
                player.incrementScore(1);
                apples.remove(i);
            }
        }
        if (player.x() <= 0 && player.getVelocity()[0] < 0) {
            player.setCoords(new double[]{0, player.y()});
        }
        else if (player.x() >= 700 && player.getVelocity()[0] > 0) {
            player.setCoords(new double[]{700, player.y()});
        }
        if (player.y() <= 10 && player.getAcceleration()[1] < 0) {
            player.setAcceleration(new double[]{0, 0});
            player.setVelocity(new double[]{player.getVelocity()[0], 0});
            player.setCoords(new double[] {player.x(), 10});
        }
    }

    public void restart(){
        player.restart();
        apples.clear();
        gameState = GameState.READY;
        num = 0;
        counter = 0;
    }

}
