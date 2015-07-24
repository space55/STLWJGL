import org.lwjgl.opengl.Display;

import Logger.Logger;

public class Background implements Runnable
{
	public void run()
	{
		while (true)
		{
			if (Display.isCloseRequested())
			{
				Logger.println("Calling Main.quit()");
				Main.quit();
			}
		}
	}
}
