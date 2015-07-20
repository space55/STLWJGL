import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class Paddle
{
	int paddleX;
	int paddleY;
	int paddleSpeed;
	int paddleLength;
	int paddleWidth;
	int width;
	int height;
	boolean side;
	
	public Paddle(int sW, int sH, boolean si)
	{
		width = sW;
		height = sH;
		paddleWidth = 10;
		paddleLength = 80;
		paddleSpeed = 10;
		side = si; // false = left
		if (side)
		{
			paddleX += width - paddleWidth;
		}
		else
		{
			paddleX = 0;
		}
		paddleY = 0;
	}
	
	public void draw()
	{
		GL11.glColor3f(1f, 1f, 1f);
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glVertex2f(paddleX, paddleY);
		GL11.glVertex2f(paddleX, paddleY + paddleLength);
		GL11.glVertex2f(paddleX + paddleWidth, paddleY + paddleLength);
		GL11.glVertex2f(paddleX + paddleWidth, paddleY);
		GL11.glEnd();
	}
	
	public boolean bounds(float ballX, float ballY, float ballRadius)
	{
		if (!side)
		{
			if (paddleY <= ballY + ballRadius && paddleY + paddleLength >= ballY - ballRadius)
			{
				if (paddleX + paddleWidth >= ballX - ballRadius)
				{
					return true;
				}
			}
		}
		else
		{
			if (paddleY <= ballY + ballRadius && paddleY + paddleLength >= ballY - ballRadius)
			{
				if (paddleX <= ballX + ballRadius)
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public void move()
	{
		if (!side)
		{
			if (Keyboard.isKeyDown(Keyboard.KEY_W))
			{
				paddleY -= paddleSpeed;
			}
			if (Keyboard.isKeyDown(Keyboard.KEY_S))
			{
				paddleY += paddleSpeed;
			}
		}
		else
		{
			if (Keyboard.isKeyDown(Keyboard.KEY_UP))
			{
				paddleY -= paddleSpeed;
			}
			if (Keyboard.isKeyDown(Keyboard.KEY_DOWN))
			{
				paddleY += paddleSpeed;
			}
		}
	}
	
	public void moveTowards(float ballY, float ballVelX, float ballVelY)
	{
		if (paddleY + (paddleLength / 2) < ballY)
		{
			paddleY += Math.abs(ballVelX) + Math.abs(ballVelY);
		}
		if (paddleY + (paddleLength / 2) > ballY)
		{
			paddleY -= Math.abs(ballVelX + Math.abs(ballVelY));
		}
	}
}
