import org.lwjgl.opengl.Display;

public class FloatMath
{
	public static float getFloatHeight(int number)
	{
		return number / (float) Display.getHeight();
	}
	
	public static float getFloatWidth(int number)
	{
		return number / (float) Display.getWidth();
	}
}
