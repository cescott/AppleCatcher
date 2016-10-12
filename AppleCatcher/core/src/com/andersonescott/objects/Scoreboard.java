package com.andersonescott.objects;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

@SuppressWarnings("WeakerAccess")
public class Scoreboard {
    protected float[] coords = {700,570};
    protected int score;
    protected String scoreboard;
    protected BitmapFont font;

    public Scoreboard(){
        score = 0;
        scoreboard = "Score: 0";
        font = new BitmapFont();
    }

    public void update(int currentScore){
        score = currentScore;
        scoreboard = "Score: "+ score;
    }

    public void draw(SpriteBatch batch){
        font.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        font.draw(batch, scoreboard, coords[0], coords[1]);
    }
}
