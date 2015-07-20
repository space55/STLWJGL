
public class KeyboardMain extends Thread
{
	static MasterInput mi;
	static KeyboardInputThread kit;
	static KeyThread kt;
	
	public void init()
	{
		Logger.write("KeyboardMain Initializing");
		mi = new MasterInput();
		kit = new KeyboardInputThread();
		kt = new KeyThread();
		runThreads();
		Logger.write("KeyboardMain Initialized");
	}
	
	private void runThreads()
	{
		Logger.write("KeyboardMain Running Threads");
		kit.run();
		kt.run();
	}
	
	public static boolean get(int key)
	{
		return mi.get(key);
	}
	
	public static void set(int key, boolean pressed)
	{
		mi.set(key, pressed);
	}
}
