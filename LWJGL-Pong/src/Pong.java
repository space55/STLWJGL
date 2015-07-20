import java.awt.Font;
import java.util.Random;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;

public class Pong
{
	static int height = 600;
	static int width = 800;
	static Paddle playerPaddle;
	static Paddle compPaddle;
	static Ball ball;
	static int speed = 5;
	private TrueTypeFont font;
	int gameTime;
	int score = 0;
	int playerNum = 2;
	boolean gameOver = false;
	
	public static void main(String[] as)
	{
		Pong t = new Pong();
		t.start();
	}
	
	public void start()
	{
		try
		{
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.create();
			GL11.glMatrixMode(GL11.GL_PROJECTION);
			GL11.glLoadIdentity();
			GL11.glOrtho(0.0, Display.getDisplayMode().getWidth(), 0.0, Display.getDisplayMode().getHeight(), -1.0, 1.0);
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
			Display.setTitle("PONG");
			setup();
		}
		catch (LWJGLException e)
		{
			e.printStackTrace();
			System.exit(0);
		}
		while (!Display.isCloseRequested())
		{
			Display.update();
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			font.drawString(100, 50, "SCORE: " + score + "  TIME: " + gameTime / 100, Color.blue);
			GL11.glDisable(GL11.GL_BLEND);
			playerPaddle.draw();
			compPaddle.draw();
			ball.draw();
			checkTime();
			if (gameOver)
			{
				gameOver = false;
				setup();
			}
		}
		Display.destroy();
	}
	
	public void setup()
	{
		playerPaddle = new Paddle(width, height, false);
		compPaddle = new Paddle(width, height, true);
		ball = new Ball(width, height);
		
		Font awtFont = new Font("Times New Roman", Font.BOLD, 24);
		font = new TrueTypeFont(awtFont, false);
	}
	
	public void checkTime()
	{
		if ((System.nanoTime() / 1000000) % 10 == 0)
		{
			gameTime += 1;
			try
			{
				ball.move();
				if (playerNum == 1)
				{
					compPaddle.moveTowards(ball.ballY, ball.ballVelX, ball.ballVelY);
					playerPaddle.move();
				}
				else if (playerNum == 2)
				{
					compPaddle.move();
					playerPaddle.move();
				}
				else
				{
					compPaddle.moveTowards(ball.ballY, ball.ballVelX, ball.ballVelY);
					playerPaddle.moveTowards(ball.ballY, ball.ballVelX, ball.ballVelY);
				}
				
				// check hitting paddle
				boundsBall();
				if (playerPaddle.bounds(ball.ballX, ball.ballY, ball.ballRadius))
				{
					bounceBallPaddle(false);
				}
				if (compPaddle.bounds(ball.ballX, ball.ballY, ball.ballRadius))
				{
					bounceBallPaddle(true);
				}
			}
			catch (Exception e)
			{
			}
		}
	}
	
	public void boundsBall()
	{
		if (ball.ballX - ball.ballRadius <= 0)
		{
			gameOver = true;
			score -= 1;
		}
		if (ball.ballX + ball.ballRadius >= width)
		{
			gameOver = true;
			score += 1;
		}
		if (ball.ballY - ball.ballRadius <= 0)
		{
			bounceBall(true);
		}
		if (ball.ballY + ball.ballRadius >= height)
		{
			bounceBall(false);
		}
	}
	
	public void bounceBall(boolean side/* direction */)
	{
		// up = true
		if (side/* direction */)
		{
			ball.setBallVelY(-ball.ballVelY);
			while (ball.ballY - ball.ballRadius <= 0)
			{
				ball.move();
			}
		}
		else
		{
			ball.setBallVelY(-ball.ballVelY);
			while (ball.ballY + ball.ballRadius >= height)
			{
				ball.move();
			}
		}
		/*
		 * else{ ball.setBallVelX(-ball.ballVelX); }
		 */
	}
	
	public void bounceBallPaddle(boolean side)
	{
		Random ran = new Random();
		// false = left side
		if (!side)
		{
			ball.setBallVelX(-ball.ballVelX);
			if (ball.ballVelX / ball.ballVelX == -1)
			{
				float ad = ran.nextFloat() * 2;
				ball.setBallVelX(ball.ballVelX - ad);
			}
			else
			{
				float ad = ran.nextFloat() * 2;
				ball.setBallVelX(ball.ballVelX + ad);
			}
			if (ball.ballVelY / ball.ballVelY == -1)
			{
				ball.setBallVelY(ball.ballVelY - ran.nextFloat() * 2);
			}
			else
			{
				ball.setBallVelY(ball.ballVelY + ran.nextFloat() * 2);
			}
			while (playerPaddle.bounds(ball.ballX, ball.ballY, ball.ballRadius))
			{
				ball.move();
			}
		}
		else
		{
			ball.setBallVelX(-ball.ballVelX);
			if (ball.ballVelX / ball.ballVelX == -1)
			{
				float ad = ran.nextFloat() * 2;
				ball.setBallVelX(ball.ballVelX - ad);
			}
			else
			{
				float ad = ran.nextFloat() * 2;
				ball.setBallVelX(ball.ballVelX - ad);
			}
			if (ball.ballVelY / ball.ballVelY == -1)
			{
				ball.setBallVelY(ball.ballVelY - ran.nextFloat() * 2);
			}
			else
			{
				ball.setBallVelY(ball.ballVelY + ran.nextFloat() * 2);
			}
			while (compPaddle.bounds(ball.ballX, ball.ballY, ball.ballRadius))
			{
				ball.move();
			}
		}
		System.out.println(ball.ballVelX);
		
	}
}
