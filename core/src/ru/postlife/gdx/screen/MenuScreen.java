package ru.postlife.gdx.screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.postlife.gdx.base.BaseScreen;
import ru.postlife.gdx.math.Rect;
import ru.postlife.gdx.sprite.Background;
import ru.postlife.gdx.sprite.Logo;

public class MenuScreen extends BaseScreen {

    private Texture bg;
    private Texture textureLogo;
    private Background background;
    private Logo logo;

    @Override
    public void show() {
        super.show();
        bg = new Texture("textures/bg.png");
        textureLogo = new Texture("figure.png");
        background = new Background(bg);
        logo = new Logo(textureLogo);
    }

    @Override
    public void resize(Rect worldBounds) {
        background.resize(worldBounds);
        logo.resize(worldBounds);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        background.draw(batch);
        logo.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        bg.dispose();
        textureLogo.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        logo.touchDown(touch, pointer, button);
        return false;
    }
}
