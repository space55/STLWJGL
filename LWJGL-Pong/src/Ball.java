import java.util.Random;

import org.lwjgl.opengl.GL11;

public class Ball {
	int ballRadius;
	float ballX;
	float ballY;
	float ballVelX;
	float ballVelY;
	int width;
	int height;
	boolean upBounce = false;
	boolean sideBounce = false;
	public float getBallX() {
		return ballX;
	}
	public void setBallX(float ballX) {
		this.ballX = ballX;
	}
	public float getBallY() {
		return ballY;
	}
	public void setBallY(float ballY) {
		this.ballY = ballY;
	}
	public float getBallVelX() {
		return ballVelX;
	}
	public void setBallVelX(float ballVelX) {
		this.ballVelX = ballVelX;
	}
	public float getBallVelY() {
		return ballVelY;
	}
	public void setBallVelY(float ballVelY) {
		this.ballVelY = ballVelY;
	}
	public Ball(int sW, int sH) {
		ballRadius = 20;
		ballX = sW/2;
		ballY = sH/2;
		Random ran = new Random();
		float x = 0;
		float y = 0;
		while(x==0 || y==0){
			x = ran.nextFloat()*4 - 2;
			y = ran.nextFloat()*4 - 2;
		}
		if(x/x == -1){x=x-2;}else{x+=2;}
		ballVelX = x;
		ballVelY = y;
		width = sW;
		height = sH;
	}
	public void draw(){
		GL11.glColor3f(1f,1f,1f);
		GL11.glBegin(GL11.GL_TRIANGLE_FAN);
		GL11.glBegin(GL11.GL_TRIANGLE_FAN);
		//+GL11.glVertex2f(0, 0);
		for(int i = 0; i <= 16; i++){ //NUM_PIZZA_SLICES decides how round the circle looks.
		    double angle = Math.PI * 2 * i /16;
		    GL11.glVertex2f((float)Math.cos(angle)*ballRadius+ballX, (float)Math.sin(angle)*ballRadius+ballY);
		}
		GL11.glEnd();
	}
	public void move(){
		ballX+=ballVelX;
		ballY+=ballVelY;
	}
}
