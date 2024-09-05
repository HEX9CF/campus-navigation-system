package nav.view.listener;

import nav.view.HomeView;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 缩放滑块监听器
 *
 * @author HEX9CF
 * @date 2024/09/05
 */
public class SliderZoomListener extends MouseAdapter implements ChangeListener {
    private HomeView view;
    private int prevValue = -1;

    public SliderZoomListener(HomeView view) {
        this.view = view;
    }

    /**
     * 状态已更改
     *
     * @param e e
     */
    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider slider = (JSlider) e.getSource();
        prevValue = slider.getValue();
    }

    /**
     * 鼠标释放
     *
     * @param e e
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        JSlider slider = (JSlider) e.getSource();
        int value = slider.getValue();
        if(value == prevValue) {
            if(value == 0) {
                value = 1;
            }
            int width = view.getImgMap().getWidth(view) * value / 100;
            int height = view.getImgMap().getHeight(view) * value / 100;
            Image imgMap = view.getImgMap().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            ImageIcon imgIcoMap = new ImageIcon(imgMap);
            view.getLabelMap().setIcon(imgIcoMap);
        }
    }
}
