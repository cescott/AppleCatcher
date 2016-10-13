package com.andersonescott.gameworld;


import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class GameRenderer {

    protected GameWorld world;

    protected OrthographicCamera cam;

    protected SpriteBatch batch;

    protected Texture background, hearts;

    protected BitmapFont font = new BitmapFont();

    public GameRenderer(GameWorld tempWorld){
        world = tempWorld;
        batch = new SpriteBatch();
        background = new Texture("applecatcher_bg.jpg");
        hearts = new Texture("applecatcher_heart.png");
        cam = new OrthographicCamera();
        cam.setToOrtho(true, 800, 600);
        font.setColor(1.0f, 1.0f, 1.0f, 1.0f);
    }

    public void render(){
        //draw a black background
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //start drawing textures
        batch.begin();
        //draw background
        batch.draw(background, 0, 0);
        //draw apples
        for (int i=0; i<world.getApples().size();i++){
            batch.draw(world.getApples().get(i).getImage(), (int)world.getApples().get(i).x(), (int)world.getApples().get(i).y());
        }
        //draw player
        batch.draw(world.getPlayer().getImage(), (int)world.getPlayer().x(), (int)world.getPlayer().y());
        //draw scoreboard
        font.draw(batch, "Score: "+world.getPlayer().getScore(), 700f, 570f);
        //draw lives
        for (int j=0; j<world.getPlayer().getLives(); j++){
            batch.draw(hearts, 10, 55*j+125);
        }
        batch.end();
    }
}
