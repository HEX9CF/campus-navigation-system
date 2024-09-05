package nav.view.listener;

import nav.view.HomeView;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SliderZoomListener implements ChangeListener {
    private HomeView view;
    private JSlider slider;

    public SliderZoomListener(HomeView view) {
        this.view = view;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        slider = (JSlider) e.getSource();
        int value = slider.getValue();
        int width = view.getImgMap().getWidth(view) * value / 100;
        int height = view.getImgMap().getHeight(view) * value / 100;
        Image imgMap = view.getImgMap().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon imgIcoMap = new ImageIcon(imgMap);
        view.getLabelMap().setIcon(imgIcoMap);
    }
}
