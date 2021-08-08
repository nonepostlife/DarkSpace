package ru.postlife.gdx.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.postlife.gdx.base.Sprite;
import ru.postlife.gdx.math.Rect;

public class StarShip extends Sprite {

    private static final float PADDING = 0.03f;
    private static final float V_LEN = 0.005f;

    private int currentTexture;

    private TextureRegion[] textures;
    private Rect worldBounds;

    private final Vector2 v;
    private Vector2 touch;

    private boolean touched;

    public StarShip(TextureRegion[] regions) {
        super(regions[0]);
        currentTexture = 0;
        textures = regions;
        v = new Vector2(1, 0);
        v.setLength(V_LEN);
        touch = new Vector2();
        touched = false;
    }

    @Override
    public void update(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.A) && getLeft() > worldBounds.getLeft() + PADDING) {
            pos.add(-v.x, v.y);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D) && getRight() < worldBounds.getRight() - PADDING) {
            pos.add(v.x, v.y);
        }
        if (touched) {
            if (touch.x > getHalfWidth() && getRight() < worldBounds.getRight() - PADDING) {
                pos.add(v.x, v.y);
            }
            if (touch.x < getHalfWidth() && getLeft() > worldBounds.getLeft() + PADDING) {
                pos.add(-v.x, v.y);
            }
        }
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        this.touch = touch;
        touched = true;
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        touched = false;
        return false;
    }

    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
        setHeightProportion(0.12f);
        float x = 0.0f;
        float y = worldBounds.getBottom() + getHalfHeight() + PADDING;
        pos.set(x, y);
    }
}