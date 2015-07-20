import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class Main
{
	public void start()
	{
		try
		{
			// Display.sync(30);
			Display.setDisplayMode(new DisplayMode(800, 600));
			Display.create();
			GL11.glMatrixMode(GL11.GL_PROJECTION);
			GL11.glOrtho(0.0, Display.getDisplayMode().getWidth(), 0.0, Display.getDisplayMode().getHeight(), -1.0, 1.0);
			GL11.glLoadIdentity();
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
		}
		catch (LWJGLException e)
		{
			e.printStackTrace();
			System.exit(0);
		}
		Logger.write("Creating and running KeyboardInput object");
		
		KeyboardInput ki = new KeyboardInput();
		(new Thread(ki)).start();
		
		// init OpenGL here
		Logger.write("Setting title");
		Display.setTitle("How about dem packers?");
		
		Logger.write("Starting !Display.isCloseRequested() while loop");
		
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
		
		Display.destroy();
		System.exit(0);
	}
	
	public static void main(String[] argv)
	{
		Main displayExample = new Main();
		displayExample.start();
	}
}