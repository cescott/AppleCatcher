package com.andersonescott.gameworld;


import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class GameRenderer {

    protected GameWorld world;

    protected OrthographicCamera cam;

    protected SpriteBatch batch;

    protected Texture background, hearts;

<<<<<<< HEAD
    protected BitmapFont font, title;
=======
    protected BitmapFont font, title, gameTitle, gameTitleShadow;
>>>>>>> origin/master
    protected GlyphLayout layout;

    public GameRenderer(GameWorld tempWorld){

        world = tempWorld;
        //load textures
        background = new Texture("applecatcher_bg.jpg");
        hearts = new Texture("applecatcher_heart.png");
        //initialize graphics
        batch = new SpriteBatch();
        cam = new OrthographicCamera();
        cam.setToOrtho(true, 800, 600);
        //load fonts
        font = new BitmapFont();
<<<<<<< HEAD
        title = new BitmapFont();
        layout = new GlyphLayout();

=======
>>>>>>> origin/master
        font.setColor(1.0f, 1.0f, 1.0f, 1.0f);

        title = new BitmapFont();
        title.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        title.getData().setScale(1.25f);

        gameTitle = new BitmapFont(Gdx.files.internal("PenPineappleApplePen.fnt"));
        gameTitle.setColor(1.0f, 0.843f, 0.0f, 1.0f);
        gameTitle.getData().setScale(3f);

        gameTitleShadow = new BitmapFont(Gdx.files.internal("PenPineappleApplePen.fnt"));
        gameTitleShadow.setColor(0f, 0f, 0f, 0.9f);
        gameTitleShadow.getData().setScale(3f);
        //initialize glyphlayout for text centering
        layout = new GlyphLayout();
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
        //don't draw lives or score if game is on the ready screen
        if (!world.isReady()) {
            //draw scoreboard
            font.draw(batch, "Score: " + world.getPlayer().getScore(), 700f, 570f);
            //draw lives
            for (int j = 0; j < world.getPlayer().getLives(); j++) {
                batch.draw(hearts, 10, 55 * j + 125);
            }
        }
        //draw paused screen
        if (world.isPaused()){
            layout.setText(title, "Game Paused");
            title.draw(batch, layout, (800-layout.width)/2, 300f);

            layout.setText(title, "Press Space to Resume");
            title.draw(batch, layout, (800-layout.width)/2, 250f);
        }
        //draw gameover screen
        if (world.isGameover()){
            layout.setText(title, "Game Over");
            title.draw(batch, layout, (800-layout.width)/2, 300f);

            layout.setText(title, "Score: "+world.getPlayer().getScore());
            title.draw(batch, layout, (800-layout.width)/2, 250f);
        }
        //draw title screen
        if (world.isReady()){
<<<<<<< HEAD
=======
            //shadow of title, slightly offset
            layout.setText(gameTitleShadow, "Apple Catcher BETA");
            gameTitleShadow.draw(batch, layout, ((800-layout.width)/2)+2, 400-2);
            //title
            layout.setText(gameTitle, "Apple Catcher BETA");
            gameTitle.draw(batch, layout, (800-layout.width)/2, 400f);
            //subtitle
>>>>>>> origin/master
            layout.setText(title, "Press space to Start");
            title.draw(batch, layout, (800-layout.width)/2, 300f);
        }
        batch.end();
    }
}
