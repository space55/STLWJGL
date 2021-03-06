import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import Logger.Logger;

public class Main
{
	public static void start()
	{
		createWindow();
		init();
		Draw.firstDraw();
		run();
	}
	
	public static void createWindow()
	{
		try
		{
			Logger.println("Window created");
			Display.setDisplayMode(new DisplayMode(800, 600));
			Display.create();
			// GL11.glViewport(-400, 400, Display.getWidth(),
			// Display.getHeight());
			GL11.glMatrixMode(GL11.GL_PROJECTION_MATRIX);
			GL11.glOrtho(0, 1, -1, 0, -1, 1);
			GL11.glLoadIdentity();
			
		}
		catch (LWJGLException e)
		{
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public static void init()
	{
		Logger.println("Initializing");
		
		KeyboardInput ki = new KeyboardInput();
		(new Thread(ki)).start();
		Background b = new Background();
		(new Thread(b)).start();
		BuildWall.build();
		
		// init OpenGL here
		Logger.println("Setting title");
		Display.setTitle("Spaceman");
	}
	
	public static void run()
	{
		while (!Display.isCloseRequested())
		{
			try
			{
				Thread.sleep(10);
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Display.update();
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			GL11.glDisable(GL11.GL_BLEND);
			// render OpenGL here
			Draw.draw();
		}
	}
	
	public static void quit()
	{
		Logger.println("Program quitting");
		System.exit(0);
	}
	
	public static void main(String[] argv)
	{
		Logger.println("Program running");
		start();
	}
}