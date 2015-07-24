
public class Threads implements Runnable
{
	public void run()
	{
		while (true)
		{
			Thread t = new Thread(this);
			t.start();
			this.run();
		}
	}
}
