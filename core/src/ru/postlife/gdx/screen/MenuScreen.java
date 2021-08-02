package ru.postlife.gdx.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.postlife.gdx.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private Texture background;
    private Texture img;
    private Vector2 objectPosition;
    private Vector2 objectDestination;
    private Vector2 n;
    private Vector2 v;

    private float velocity;
    private int step;

    @Override
    public void show() {
        super.show();
        img = new Texture("figure.png");
        objectPosition = new Vector2(0, 0);
        objectDestination = new Vector2();
        n = new Vector2();
        v = new Vector2();
        velocity = 15;
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        if (step > 0) {
            objectPosition.add(v);
            step--;
        } else {
            objectPosition = objectDestination;
        }
        batch.draw(img, objectPosition.x, objectPosition.y);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        int y = Gdx.graphics.getHeight() - screenY;
        objectDestination = new Vector2(screenX, y);
        n = objectDestination.cpy().sub(objectPosition);
        float length = n.len();
        n.nor();
        v = n.scl(velocity);
        step = (int) (length / v.len());

        System.out.println("touch: screenX = " + screenX + " screenY = " + y);
        return super.touchDown(screenX, screenY, pointer, button);
    }
}
