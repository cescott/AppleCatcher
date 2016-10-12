package com.andersonescott.gameworld;


import com.andersonescott.objects.Apple;
import com.andersonescott.objects.Player;
import com.andersonescott.objects.Scoreboard;

import java.util.ArrayList;

public class GameWorld {

    protected ArrayList<Apple> apples= new ArrayList<Apple>();
    protected Player player;
    protected Scoreboard scoreboard;

    protected int counter;

    protected GameState gameState;

    public enum GameState {
        RUNNING, GAMEOVER
    }

    public GameWorld(){
        player = new Player(new double[] {350, 10}, 0);
        scoreboard = new Scoreboard();
        gameState = GameState.RUNNING;
    }

    public void update(float delta){
        //update player
        player.update(delta);
        //update all the apples
        if (appleCount()) {
            apples.add(new Apple(new double[]{(Math.random() * 700) + 10, 520}));
        }
        for (int i=0; i<apples.size();i++){
            apples.get(i).update(delta);
        }
        //update scoreboard
        scoreboard.update(player.getScore());
        //update collisions
        collisionUpdate();
    }

    public Player getPlayer(){
        return player;
    }

    public ArrayList<Apple> getApples(){
        return apples;
    }

    public Scoreboard getScoreboard(){
        return scoreboard;
    }

    public boolean appleCount() {
        counter++;
        if (counter/30 >= (20/(player.getScore()+ 5)) + 0.25) {
            counter = 0;
            return true;
        }
        return false;
    }

    public void collisionUpdate() {
        for (int i = 0; i < apples.size(); i++) {
            if ((apples.get(i).x() <= 0 && apples.get(i).getVelocity()[0] < 0)
                    || (apples.get(i).x() >= 720 && apples.get(i).getVelocity()[0] > 0)) {
                apples.get(i).setVelocity(new double[]{apples.get(i).getVelocity()[0] * -1, apples.get(i).getVelocity()[1]});
            }
            if (apples.get(i).y() <= 10) {
                apples.remove(i);
            }
            else if (Math.abs(apples.get(i).y() - player.y()) <= 200 && Math.abs(apples.get(i).x() - player.x()) <= 100) {
                player.incrementScore(1);
                apples.remove(i);
            }
        }
        if ((player.x() <= 0 && player.getVelocity()[0] < 0) || (player.x() >= 700 && player.getVelocity()[0] > 0)) {
            player.setVelocity(new double[]{player.getVelocity()[0] * -1, player.getVelocity()[1]});
        }
    }

}
