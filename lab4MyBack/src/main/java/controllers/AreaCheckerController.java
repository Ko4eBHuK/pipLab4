package controllers;

import domain.DotData;

import javax.servlet.http.HttpSession;

public class AreaCheckerController {
    public DotData isPointInArea(DotData dotData, int id)
    {
        long currentTime = System.nanoTime();
        double x = dotData.getX();
        double y = dotData.getY();
        int userId = id;
        double radius = dotData.getR();
        boolean inArea = true;

        if ( radius >= 0 ) {
            if ( x >= 0 ) {
                if ( y > 0 ) {
                    inArea = y <= -2 * x + radius;
                } else {
                    inArea = y >= - radius / 2 && x <= radius;
                }
            } else {
                if ( y >= 0 ) {
                    inArea = x * x + y * y <= radius * radius / 4;
                } else {
                    inArea = false;
                }
            }
        } else {
            if ( x <= 0 ) {
                if ( y < 0 ) {
                    inArea = y <= -2 * x - radius;
                } else {
                    inArea = y <= -radius / 2 && x >= radius;
                }
            } else {
                if ( y <= 0 ) {
                    inArea = x * x + y * y <= radius * radius / 4;
                } else {
                    inArea = false;
                }
            }
        }

        return new DotData(x, y, radius, (System.nanoTime() - currentTime) / 1000000000d, System.currentTimeMillis(), userId, inArea);
    }
}
