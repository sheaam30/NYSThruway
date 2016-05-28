package shealabs.nysthruway.util;

import android.view.View;

public class ViewUtil {

    private ViewUtil() { }

    public static boolean isPointInsideView(float x, float y, View view){
        int location[] = new int[2];
        view.getLocationOnScreen(location);
        int viewX = (int) view.getX();
        int viewY = (int) view.getY();

        //point is inside view bounds
        if(( x > viewX && x < (viewX + view.getWidth())) &&
                ( y > viewY && y < (viewY + view.getHeight()))){
            return true;
        } else {
            return false;
        }
    }
}
