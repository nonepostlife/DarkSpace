package ru.postlife.gdx.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.postlife.gdx.base.BaseButton;
import ru.postlife.gdx.math.Rect;
import ru.postlife.gdx.screen.GameScreen;

public class NewGameButton extends BaseButton {

    private GameScreen gameScreen;

    public NewGameButton(TextureAtlas atlas, GameScreen gameScreen) {
        super(atlas.findRegion("button_new_game"));
        this.gameScreen = gameScreen;
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.05f);
        pos.set(worldBounds.pos);
    }

    @Override
    public void action() {
        gameScreen.startNewGame();
    }
}
