import org.lwjgl.opengl.Display;

import Logger.Logger;

public class Collision
{
	public static boolean checkWall(float x, float y, float xVel, float yVel, float size, int direction)
	{
		if (direction == 0)
		{
			if (y - yVel <= size - 1f)
			{
				return false;
			}
		}
		else if (direction == 1)
		{
			if (y + yVel >= FloatMath.getFloatHeight(Display.getHeight()) - size)
			{
				return false;
			}
		}
		else if (direction == 2)
		{
			if (x - xVel <= size - 1f)
			{
				return false;
			}
		}
		else if (direction == 3)
		{
			if (x + xVel >= FloatMath.getFloatWidth(Display.getWidth()) - size)
			{
				return false;
			}
		}
		else
		{
			Logger.println("THE PROGRAM IS CORRUPTED!!! :D");
		}
		return true;
	}
}
