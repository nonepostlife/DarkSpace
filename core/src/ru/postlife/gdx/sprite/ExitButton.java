package ru.postlife.gdx.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.postlife.gdx.base.BaseButton;
import ru.postlife.gdx.math.Rect;

public class ExitButton extends BaseButton {

    private static final float PADDING = 0.03f;

    public ExitButton(TextureAtlas atlas) {
        super(atlas.findRegion("btExit"));
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.18f);
        setBottom(worldBounds.getBottom() + PADDING);
        setRight(worldBounds.getRight() - PADDING);
    }

    @Override
    public void action() {
        Gdx.app.exit();
    }
}
