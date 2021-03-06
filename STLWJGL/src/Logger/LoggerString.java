package Logger;

public class LoggerString extends Logger
{
	public static void print(String msg)
	{
		if (verbose)
		{
			if (timestamp)
			{
				if (logfile)
				{
					out.print("[" + date() + " " + time() + "] " + msg);
				}
				System.out.print("[" + date() + " " + time() + "] " + msg);
			}
			else
			{
				if (logfile)
				{
					out.print(msg);
				}
				System.out.print(msg);
			}
		}
	}
	
	public static void println(String msg)
	{
		if (verbose)
		{
			if (timestamp)
			{
				if (logfile)
				{
					out.println("[" + date() + " " + time() + "] " + msg);
				}
				System.out.println("[" + date() + " " + time() + "] " + msg);
			}
			else
			{
				if (logfile)
				{
					out.println(msg);
				}
				System.out.println(msg);
			}
		}
	}
}
