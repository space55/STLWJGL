import Logger.Logger;

public class T
{
	// Translate
	public static float X(float x)
	{
		Logger.println("Translate X has been called");
		return x - 0.5f;
	}
	
	public static float Y(float y)
	{
		Logger.println("Translate Y has been called");
		return y + 1f;
	}
}
