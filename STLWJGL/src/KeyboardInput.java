import org.lwjgl.input.Keyboard;

public class KeyboardInput implements Runnable
{
	public static boolean moveUp = false;
	public static boolean moveDown = false;
	public static boolean moveLeft = false;
	public static boolean moveRight = false;
	
	private static int sleep = 1;
	private static int moveSpeed = 1;
	
	public void run()
	{
		Logger.write("KeyboardInput run called");
		while (true)
		{
			try
			{
				while (Keyboard.next())
				{
					if (Keyboard.getEventKeyState())
					{
						// Key A
						if (Keyboard.getEventKey() == Keyboard.KEY_A)
						{
							moveLeft = true;
						}
						else
						{
							moveLeft = false;
						}
						
						// Key W
						if (Keyboard.getEventKey() == Keyboard.KEY_W)
						{
							moveUp = true;
						}
						else
						{
							moveUp = false;
						}
						
						// Key S
						if (Keyboard.getEventKey() == Keyboard.KEY_S)
						{
							moveDown = true;
						}
						else
						{
							moveDown = false;
						}
						
						// Key D
						if (Keyboard.getEventKey() == Keyboard.KEY_D)
						{
							moveRight = true;
						}
						else
						{
							moveRight = false;
						}
						
						// Key SHIFT
						/*
						 * if (Keyboard.getEventKey() == Keyboard.KEY_LSHIFT ||
						 * Keyboard.getEventKey() == Keyboard.KEY_LSHIFT) {
						 * KeyboardMain.set(128, true); }
						 */
					}
					else
					{
						moveUp = false;
						moveDown = false;
						moveLeft = false;
						moveRight = false;
					}
				}
			}
			catch (Exception e)
			{
				Logger.write("Seems that the client is shutting down!");
			}
			if (moveUp)
			{
				moveUp();
			}
			if (moveDown)
			{
				moveDown();
			}
			if (moveLeft)
			{
				moveLeft();
			}
			if (moveRight)
			{
				moveRight();
			}
		}
	}
	
	public static void moveUp()
	{
		try
		{
			Thread.sleep(sleep);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Draw.rect.set(Draw.rect.get()[0], Draw.rect.get()[1] + FloatMath.getFloatHeight(moveSpeed), Draw.rect.get()[2], Draw.rect.get()[3]);
	}
	
	public static void moveDown()
	{
		try
		{
			Thread.sleep(sleep);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Draw.rect.set(Draw.rect.get()[0], Draw.rect.get()[1] - FloatMath.getFloatHeight(moveSpeed), Draw.rect.get()[2], Draw.rect.get()[3]);
	}
	
	public static void moveLeft()
	{
		try
		{
			Thread.sleep(sleep);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Draw.rect.set(Draw.rect.get()[0] - FloatMath.getFloatWidth(moveSpeed), Draw.rect.get()[1], Draw.rect.get()[2], Draw.rect.get()[3]);
	}
	
	public static void moveRight()
	{
		try
		{
			Thread.sleep(sleep);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Draw.rect.set(Draw.rect.get()[0] + FloatMath.getFloatWidth(moveSpeed), Draw.rect.get()[1], Draw.rect.get()[2], Draw.rect.get()[3]);
	}
}
