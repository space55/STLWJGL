import org.lwjgl.input.Keyboard;

public class KeyboardInputThread extends Thread
{
	
	public KeyboardInputThread()
	{
		Logger.write("KeyboardInputThread Started");
	}
	
	public void run()
	{
		Logger.write("KeyboardInputThread Run");
		while (true)
		{
			if (Keyboard.getEventKeyState())
			{
				// Key A
				if (Keyboard.getEventKey() == Keyboard.KEY_A)
				{
					KeyboardMain.set(0, true);
				}
				else
				{
					KeyboardMain.set(0, false);
				}
				
				// Key W
				if (Keyboard.getEventKey() == Keyboard.KEY_W)
				{
					KeyboardMain.set(22, true);
				}
				else
				{
					KeyboardMain.set(22, false);
				}
				
				// Key S
				if (Keyboard.getEventKey() == Keyboard.KEY_S)
				{
					KeyboardMain.set(18, true);
				}
				else
				{
					KeyboardMain.set(18, false);
				}
				
				// Key D
				if (Keyboard.getEventKey() == Keyboard.KEY_D)
				{
					KeyboardMain.set(3, true);
				}
				else
				{
					KeyboardMain.set(3, false);
				}
				
				// Key SHIFT
				if (Keyboard.getEventKey() == Keyboard.KEY_LSHIFT || Keyboard.getEventKey() == Keyboard.KEY_LSHIFT)
				{
					KeyboardMain.set(128, true);
				}
				else
				{
					KeyboardMain.set(128, false);
				}
			}
		}
	}
}
