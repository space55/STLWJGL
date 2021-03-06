import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Logger.Logger;

public class BuildWall
{
	public static int lines = 0;
	public static int width = 0;
	
	public static void build()
	{
		Logger.println("Building wall");
		BufferedReader br = null;
		try
		{
			Logger.println("Creating board reader");
			br = new BufferedReader(new FileReader("board.bd"));
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		String input = null;
		try
		{
			Logger.println("Reading board");
			input = br.readLine();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		for (int counter = 0; input != null; counter++)
		{
			width = 0;
			for (int counter2 = 0; counter2 < input.length(); counter2++)
			{
				if (input.charAt(counter2) == '#')
				{
					Wall.wall[counter2][counter] = true;
				}
				else
				{
					Wall.wall[counter2][counter] = false;
				}
				width++;
			}
			lines++;
			try
			{
				input = br.readLine();
			}
			catch (IOException e)
			{
				input = null;
			}
		}
		Logger.println("Lines: " + lines);
		Logger.println("Width: " + width);
	}
}
