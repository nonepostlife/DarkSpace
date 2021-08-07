package ru.postlife.gdx.sprite;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.postlife.gdx.base.BaseButton;
import ru.postlife.gdx.math.Rect;
import ru.postlife.gdx.screen.GameScreen;

public class PlayButton extends BaseButton {

    private static final float PADDING = 0.03f;

    private final Game game;

    public PlayButton(TextureAtlas atlas, Game game) {
        super(atlas.findRegion("btPlay"));
        this.game = game;
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.23f);
        setBottom(worldBounds.getBottom() + PADDING);
        setLeft(worldBounds.getLeft() + PADDING);
    }

    @Override
    public void action() {
        game.setScreen(new GameScreen());
    }
}
