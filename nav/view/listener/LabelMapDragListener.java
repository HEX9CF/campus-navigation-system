package nav.view.listener;

import nav.view.HomeView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LabelMapDragListener extends MouseAdapter {
    private final HomeView view;
    private int prevX = -1;
    private int prevY = -1;

    public LabelMapDragListener(HomeView view) {
        this.view = view;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        prevX = e.getX();
        prevY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int x = e.getX() - prevX;
        int y = e.getY() - prevY;
        if(x != 0 || y != 0) {
            Point location = view.getLabelMap().getLocation();
            location.x += x;
            location.y += y;
            view.getLabelMap().setLocation(location);
        }
    }
}
