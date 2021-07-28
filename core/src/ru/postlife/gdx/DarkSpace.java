package ru.postlife.gdx;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class DarkSpace extends ApplicationAdapter {
	SpriteBatch batch;
	Texture background;
	Texture img;

	public static final int WIDTH = 480;
	public static final int HEIGHT = 854;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("figure.png");
		background = new Texture("background_space_small.jpg");
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(background, 0, 0);
		batch.draw(img, WIDTH/2 - img.getWidth()/2, HEIGHT/2 - img.getHeight()/2);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
