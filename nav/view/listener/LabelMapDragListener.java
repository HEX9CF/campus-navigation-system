package nav.view.listener;

import nav.view.HomeView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 地图拖拽监听器
 *
 * @date 2024/09/05
 */
public class LabelMapDragListener extends MouseAdapter {
    private final HomeView view;
    private Point prevLocation = new Point(-1, -1);

    public LabelMapDragListener(HomeView view) {
        this.view = view;
    }

    /**
     * 鼠标按下
     *
     * @param e e
     */
    @Override
    public void mousePressed(MouseEvent e) {
        prevLocation = e.getPoint();
        view.getLabelMap().setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
    }

    /**
     * 鼠标释放
     *
     * @param e e
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        view.getLabelMap().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        JViewport viewport = (JViewport) view.getLabelMap().getParent();
        Point viewPos = viewport.getViewPosition();
        int dx = prevLocation.x - e.getX();
        int dy = prevLocation.y - e.getY();
        viewPos.translate(dx, dy);
        view.getLabelMap().scrollRectToVisible(new Rectangle(viewPos, viewport.getSize()));
    }
}
