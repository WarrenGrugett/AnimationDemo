
import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import processing.core.*;

public class Mario extends Sprite {
	private static final long serialVersionUID = 1L;
	public static final int MARIO_WIDTH = 40, MARIO_HEIGHT = 60;
	private final double grav = 2;
	private boolean jumping = false;
	private double yVel = 0, xVel = 0;

	public Mario(PImage img, int x, int y) {
		super(img, x, y, MARIO_WIDTH, MARIO_HEIGHT);
	}

	public void walk(int dir) {
		if (Math.abs(xVel) < 6)
			xVel += dir;
	}

	public void jump() {
		if (!jumping) {
			yVel += 30;
			jumping = true;
		}
	}

	public void act(ArrayList<Shape> obstacles) {
		yVel -= grav;
		moveByAmount(0, -yVel);
		double newY = -1;
		for (int i = 0; i < obstacles.size(); i++) {
			if (obstacles.get(i).contains(new Point2D.Double(x, y - yVel + MARIO_HEIGHT))
					|| obstacles.get(i).contains(new Point2D.Double(x + MARIO_WIDTH, y - yVel + MARIO_HEIGHT))
					|| obstacles.get(i).contains(new Point2D.Double(x, y - yVel))
					|| obstacles.get(i).contains(new Point2D.Double(x + MARIO_WIDTH, y - yVel))) {
				if (yVel < 0) {
					newY = obstacles.get(i).getBounds2D().getY() - MARIO_HEIGHT;
					yVel = 0;
					jumping = false;
				} else if (yVel > 0) {
					newY = obstacles.get(i).getBounds2D().getY() + obstacles.get(i).getBounds2D().getHeight() + 10;
					yVel = 0;
				}
			}
		}
		if (newY != -1)
			moveToLocation(x, newY);
		if (xVel > 0)
			xVel -= 0.5;
		else if (xVel < 0)
			xVel += 0.5;
		double newX = -1;
		for (int i = 0; i < obstacles.size(); i++) {
			if (obstacles.get(i).contains(new Point2D.Double(x + xVel + MARIO_WIDTH, y))) {
				System.out.println(x + xVel + MARIO_WIDTH + ", " + y);
				newX = obstacles.get(i).getBounds2D().getX() - MARIO_WIDTH;
				xVel = 0;
			} else if (obstacles.get(i).contains(new Point2D.Double(x + xVel, y))) {
				newX = obstacles.get(i).getBounds2D().getX() + obstacles.get(i).getBounds2D().getWidth();
				xVel = 0;
			}
		}
		moveByAmount(xVel, 0);
		if (newX != -1)
			moveToLocation(newX, y);
	}
}