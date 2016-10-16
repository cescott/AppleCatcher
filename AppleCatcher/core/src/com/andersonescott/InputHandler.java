package com.andersonescott;

import com.andersonescott.gameworld.GameWorld;
import com.andersonescott.objects.Player;
import com.badlogic.gdx.InputProcessor;

public class InputHandler implements InputProcessor{

    protected GameWorld world;
    protected Player player;

    public InputHandler(GameWorld tempWorld){
        world = tempWorld;
        player = world.getPlayer();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        /*if (world.isRunning()){
            player.input("pressed", keycode);
        }*/
        world.updateKeys(true, keycode);
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        /*if (player.getVelocity()[0]!= 0){
            player.input("released", keycode);
        }*/
        world.updateKeys(false, keycode);
        if (keycode == 62) {
            if (world.isGameover()) {
                world.restart();
            }
            else if (world.isReady()) {
                world.start();
            }
        }
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
