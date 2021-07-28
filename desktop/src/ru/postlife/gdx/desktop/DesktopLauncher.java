package ru.postlife.gdx.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import ru.postlife.gdx.DarkSpace;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = DarkSpace.WIDTH;
		config.height = DarkSpace.HEIGHT;
		config.resizable = false;
		new LwjglApplication(new DarkSpace(), config);
	}
}
