import java.awt.Color;
import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Game {
	double velocityLowerBound = 0.005;
	double velocityUpperBound = 0.01;
	int redBallCount = 3;
	double radius = 0.025;
	int score = 0;
	int highScore = 0;
	double playerX = 0.5;
	double playerY = 0.5;
	double[] redBallXPosition = new double[redBallCount];
	double[] redBallYPosition = new double[redBallCount];
	double[] ballXVelocity = new double[redBallCount];
	double[] ballYVelocity = new double[redBallCount];
	boolean collision = false;
	long st = System.currentTimeMillis();
	long dt = System.currentTimeMillis();

//red ball related code moved to RedBalls.java
//player related code moved to Player.java

	public void determineScore() {
		StdDraw.enableDoubleBuffering();
		long currentTimeStamp = System.currentTimeMillis();
			if(currentTimeStamp > st + 1000) {
				score++;
				if(score > highScore) {
					highScore = score;
				}
				st = currentTimeStamp;
			}
			if(currentTimeStamp > dt + 10000) {
				redBallCount++;
				double[] ballXnew = new double[redBallCount];
				double[] ballYnew = new double[redBallCount];
				double[] ballXVnew = new double[redBallCount];
				double[] ballYVnew = new double[redBallCount];
				for(int i = 0; i < redBallCount - 1; i++) {
					ballXnew[i] = redBallXPosition[i];
					ballYnew[i] = redBallYPosition[i];
					ballXVnew[i] = ballXVelocity[i];
					ballYVnew[i] = ballYVelocity[i];
				}
				ballXnew[redBallCount-1] = Math.random();
				ballYnew[redBallCount-1] = Math.random();
				ballXVnew[redBallCount-1] = Math.random() * (velocityUpperBound - velocityLowerBound) + velocityLowerBound;
				ballYVnew[redBallCount-1] = Math.random() * (velocityUpperBound - velocityLowerBound) + velocityLowerBound;
				redBallXPosition = ballXnew;
				redBallYPosition = ballYnew;
				ballXVelocity = ballXVnew;
				ballYVelocity = ballYVnew;
				dt = currentTimeStamp;
			}
			StdDraw.setPenColor(Color.red);
			for(int i = 0; i < redBallCount; i++) {
				StdDraw.filledCircle(redBallXPosition[i], redBallYPosition[i], radius);
			}
			StdDraw.show();
			StdDraw.pause(10);
	}
}
