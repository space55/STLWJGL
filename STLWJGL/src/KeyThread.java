
public class KeyThread extends Thread
{
	public KeyThread()
	{
		Logger.write("KeyThread Started");
	}
	
	public void run()
	{
		Logger.write("KeyThread Run");
		while (true)
		{
			if (KeyboardMain.get(0))
			{
				Movement.moveLeft();
			}
			
			if (KeyboardMain.get(22))
			{
				Movement.moveUp();
			}
			
			if (KeyboardMain.get(18))
			{
				Movement.moveDown();
			}
			
			if (KeyboardMain.get(3))
			{
				Movement.moveRight();
			}
		}
	}
}
