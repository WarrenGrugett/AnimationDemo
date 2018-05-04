
import java.awt.geom.*;
import processing.core.*;

/*
 * Represents a moving image.
 *
 * by: Shelby
 */

public class Sprite extends Rectangle2D.Double {

	private static final long serialVersionUID = 1L;
	private PImage image;

	public Sprite(PImage img, int x, int y, int w, int h) {
		super(x, y, w, h);
		image = img;
	}

	public void moveToLocation(double x, double y) {
		super.x = x;
		super.y = y;
	}

	public void moveByAmount(double x, double y) {
		super.x += x;
		super.y += y;
	}

	public void applyWindowLimits(int windowWidth, int windowHeight) {
		x = Math.min(x, windowWidth - width);
		y = Math.min(y, windowHeight - height);
		x = Math.max(0, x);
		y = Math.max(0, y);
	}

	public void draw(PApplet g) {
		g.image(image, (int) x, (int) y, (int) width, (int) height);
	}
}