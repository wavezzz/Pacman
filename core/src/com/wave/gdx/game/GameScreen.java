package com.wave.gdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;


public class GameScreen extends ScreenAdapter {
	private PacmanGame pacmanGame;
	private Texture pacmanImg;
	private Pacman pacman;
	 
    public GameScreen(PacmanGame pacmanGame) {
        this.pacmanGame = pacmanGame;
        pacmanImg = new Texture("pacman.png");
      
        pacman = new Pacman(100,100);
    }
    @Override
    public void render(float delta) {
    	update(delta);
    	Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    	SpriteBatch batch = pacmanGame.batch;
    	batch.begin();
    	Vector2 pos = pacman.getPosition();
        batch.draw(pacmanImg, pos.x, pos.y);
        batch.end();
    }
    private void update(float delta) {
    	if(Gdx.input.isKeyPressed(Keys.UP)) {
            pacman.move(3);
    	}
        if(Gdx.input.isKeyPressed(Keys.DOWN)) {
            pacman.move(1);
        }
        if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
            pacman.move(2);
        }
        if(Gdx.input.isKeyPressed(Keys.LEFT)) {
            pacman.move(4);
        }        
    }
}
