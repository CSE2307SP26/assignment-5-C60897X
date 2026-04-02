import java.awt.event.KeyEvent;
import edu.princeton.cs.introcs.StdDraw;

public class Player {

    private double playerSpeed = 0.01;
    // private double radius = 0.025;
    private double positionX = 0.5;
    private double positionY = 0.5;

    public void movePlayerBall() {
        if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
            positionY = positionY + playerSpeed;
        }
        if(StdDraw.isKeyPressed(KeyEvent.VK_S)) {
            positionY = positionY - playerSpeed;
        }
        if(StdDraw.isKeyPressed(KeyEvent.VK_A)) {
            positionX = positionX - playerSpeed;
        }
        if(StdDraw.isKeyPressed(KeyEvent.VK_D)) {
            positionX = positionX + playerSpeed;
        }

        if(positionX > 1) {
            positionX = 1;
        }
        if(positionX < 0) {
            positionX = 0;
        }
        if(positionY > 1) {
            positionY = 1;
        }
        if(positionY < 0) {
            positionY = 0;
        }
    }
}
