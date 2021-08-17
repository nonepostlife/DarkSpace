package ru.postlife.gdx.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.postlife.gdx.base.Sprite;
import ru.postlife.gdx.math.Rect;

public class GameOverLabel extends Sprite {

    public GameOverLabel(TextureAtlas atlas) {
        super(atlas.findRegion("message_game_over"));
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.08f);
        pos.set(new Vector2(pos.x, pos.y + 0.2f));
    }
}
