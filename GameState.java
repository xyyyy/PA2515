package com.fifi.States;

import java.awt.Graphics2D;

public abstract class GameState {
	
	public GameStateManager gsm;
	
	public GameState(GameStateManager gsm){
		this.gsm = gsm;
	}
	
	public void init(){}
	public void update(){}
	public void draw(Graphics2D g){}
	public void handleListener(){}
}
