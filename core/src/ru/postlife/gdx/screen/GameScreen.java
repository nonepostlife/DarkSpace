package ru.postlife.gdx.screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.postlife.gdx.base.BaseScreen;
import ru.postlife.gdx.math.Rect;
import ru.postlife.gdx.sprite.Background;
import ru.postlife.gdx.sprite.Star;
import ru.postlife.gdx.sprite.StarShip;

public class GameScreen extends BaseScreen {

    private static final int STAR_COUNT = 64;
    private static final int COUNT_SHIP_STATUS = 2;

    private Texture bg;
    private Background background;

    private TextureAtlas atlas;

    private Star[] stars;

    private StarShip ship;

    @Override
    public void show() {
        super.show();
        bg = new Texture("textures/bg.png");
        background = new Background(bg);

        atlas = new TextureAtlas("textures/mainAtlas.tpack");
        stars = new Star[STAR_COUNT];
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star(atlas);
        }
        TextureRegion texture = atlas.findRegion("main_ship");
        TextureRegion[][] tmp = texture.split(
                texture.getRegionWidth() / COUNT_SHIP_STATUS,
                texture.getRegionHeight());

        TextureRegion[] texturesShip = tmp[0];
        ship = new StarShip(texturesShip);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        draw();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        for (Star star : stars) {
            star.resize(worldBounds);
        }
        ship.resize(worldBounds);
    }

    @Override
    public void dispose() {
        super.dispose();
        bg.dispose();
        atlas.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        ship.touchDown(touch, pointer, button);
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        ship.touchUp(touch, pointer, button);
        return false;
    }

    private void update(float delta) {
        for (Star star : stars) {
            star.update(delta);
        }
        ship.update(delta);
    }

    private void draw() {
        batch.begin();
        background.draw(batch);
        for (Star star : stars) {
            star.draw(batch);
        }
        ship.draw(batch);
        batch.end();
    }
}
