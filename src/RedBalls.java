import java.awt.Color;
import edu.princeton.cs.introcs.StdDraw;

public class RedBalls {
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

	public void createRedBall() {
		for(int i = 0; i < redBallCount; i++) {
			redBallXPosition[i] = Math.random();
			redBallYPosition[i] = Math.random();
			ballXVelocity[i] = Math.random() * (velocityUpperBound - velocityLowerBound) + velocityLowerBound;
			ballYVelocity[i] = Math.random() * (velocityUpperBound - velocityLowerBound) + velocityLowerBound;
		}
	}

	public void bounceBall() {
		for(int i = 0; i < redBallCount; i++) {
			redBallXPosition[i] = redBallXPosition[i] + ballXVelocity[i];
			redBallYPosition[i] = redBallYPosition[i] + ballYVelocity[i];
			if(redBallXPosition[i] + radius > 1 || redBallXPosition[i] - radius < 0) { 
				ballXVelocity[i] = -ballXVelocity[i];
			}
			if(redBallYPosition[i] + radius > 1 || redBallYPosition[i] - radius < 0) { 
				ballYVelocity[i] = -ballYVelocity[i];
			}
			for(int j = 0; j < redBallCount; j++) {
				if(i != j) {
					double distance = Math.sqrt(Math.pow(redBallXPosition[i] - redBallXPosition[j], 2) + Math.pow(redBallYPosition[i] - redBallYPosition[j], 2));
					if(distance < 2 * radius) {
						ballXVelocity[i] = -ballXVelocity[i];
						ballYVelocity[i] = -ballYVelocity[i];
					}
				}
			}
		}
	}

	public boolean determineCollision() {
		for(int i = 0; i < redBallCount; i++) {
			redBallXPosition[i] = redBallXPosition[i] + ballXVelocity[i];
			redBallYPosition[i] = redBallYPosition[i] + ballYVelocity[i];
			if(redBallXPosition[i] + radius > 1 || redBallXPosition[i] - radius < 0) { 
				ballXVelocity[i] = -ballXVelocity[i];
			}
			if(redBallYPosition[i] + radius > 1 || redBallYPosition[i] - radius < 0) { 
				ballYVelocity[i] = -ballYVelocity[i];
			}
			for(int j = 0; j < redBallCount; j++) {
				if(i != j) {
					double distance = Math.sqrt(Math.pow(redBallXPosition[i] - redBallXPosition[j], 2) + Math.pow(redBallYPosition[i] - redBallYPosition[j], 2));
					if(distance < 2 * radius) {
						ballXVelocity[i] = -ballXVelocity[i];
						ballYVelocity[i] = -ballYVelocity[i];
					}
				}
			}
			double d = Math.sqrt(Math.pow(redBallXPosition[i] - playerX, 2) + Math.pow(redBallYPosition[i] - playerY, 2));
			if(d < 2 * radius) {
				collision = true;
			}
		}
		return collision;
	}

	public void restartGameAfterCollision() {
		if(collision) {
			redBallCount = 3;
			for(int i = 0; i < redBallCount; i++) {
				redBallXPosition[i] = Math.random();
				redBallYPosition[i] = Math.random();
				ballXVelocity[i] = Math.random() * (velocityUpperBound - velocityLowerBound) + velocityLowerBound;
				ballYVelocity[i] = Math.random() * (velocityUpperBound - velocityLowerBound) + velocityLowerBound;
				score = 0;
				st = System.currentTimeMillis();
				dt = System.currentTimeMillis();
				playerX = 0.5;
				playerY = 0.5;
			}
		}
	}
			// StdDraw.setPenColor(Color.red);
			// for(int i = 0; i < redBallCount; i++) {
			// 	StdDraw.filledCircle(redBallXPosition[i], redBallYPosition[i], radius);
			// }
			
			// StdDraw.setPenColor(Color.black);
			// StdDraw.filledCircle(playerX, playerY, radius);
			// StdDraw.text(0.5, 0.1, "Score: " + score + " High Score: " + highScore);
			
			// StdDraw.show();
			// StdDraw.pause(10);
			
}
