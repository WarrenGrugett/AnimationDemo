
import java.awt.*;
import java.util.*;

import processing.core.PImage;

public class Mario extends Sprite
{

    public static final int MARIO_WIDTH = 40;
    public static final int MARIO_HEIGHT = 60;

    public Mario(PImage img, int x, int y)
    {
        super(img, x, y, MARIO_WIDTH, MARIO_HEIGHT);
    }

    // METHODS
    public void walk(int dir)
    {
        // WALK!
    }

    public void jump()
    {
        walk(2);
    }

    <<<<<<<HEAD

    public void act(ArrayList<Shape> obstacles)
    {
        // FALL (and stop when a platform is hit)
        int finalY = 9999999;
        for (Shape obstacle : obstacles)
        {
            if (obstacle.getBounds2D().getWidth() > 0)
            {
                if (obstacle.getBounds2D().getX() < x
                        && obstacle.getBounds2D().getX() + obstacle.getBounds2D().getWidth() > x
                        && obstacle.getBounds2D().getY() < finalY)
                {
                    finalY = (int) (obstacle.getBounds2D().getY() - MARIO_HEIGHT);
                }
            }
            else if (obstacle.getBounds2D().getWidth() < 0)
            {

            }
        }
        moveToLocation(x, finalY);
    }=======

    public void act(ArrayList<Shape> obstacles) {
		// FALL (and stop when a platform is hit)
		int finalY = 9999999;
		for (Shape obstacle : obstacles) {
			if (obstacle.getBounds2D().getWidth() > 0) {
				if (obstacle.getBounds2D().getX() < x
						&& obstacle.getBounds2D().getX() + obstacle.getBounds2D().getWidth() > x
						&& obstacle.getBounds2D().getY() < finalY) {
					finalY = (int) (obstacle.getBounds2D().getY() - MARIO_HEIGHT);
				}
			} else if (obstacle.getBounds2D().getWidth() < 0) {

			}
		}
		moveToLocation(x, finalY);
	}>>>>>>>branch'master'

    of https:// github.com/WarrenGrugett/AnimationDemo
}