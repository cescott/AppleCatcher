package com.andersonescott;

import com.andersonescott.gameworld.GameScreen;

import com.badlogic.gdx.Game;


import java.util.ArrayList;

public class AppleCatcher extends Game{
	Player player;
	ArrayList<Apple> apples;
	
	@Override
	public void create () {
		setScreen(new GameScreen());
	}
}
