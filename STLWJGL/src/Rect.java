import org.lwjgl.opengl.GL11;

public class Rect
{
	float x;
	float y;
	float width;
	float height;
	
	public Rect(float x, float y, float width, float height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		// get();
	}
	
	public void set(float x, float y)
	{
		set(x, y, width, height);
	}
	
	public void set(float x, float y, float width, float height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public float[] get()
	{
		return new float[]
		{
				x, y, width, height
		};
	}
	
	public void draw()
	{
		GL11.glColor3f(1f, 1f, 1f);
		
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glVertex2f(x, y);
		GL11.glVertex2f(x, y + height);
		GL11.glVertex2f(x + width, y + height);
		GL11.glVertex2f(x + width, y);
		GL11.glEnd();
	}
}
