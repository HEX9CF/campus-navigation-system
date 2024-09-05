package nav.view;

import nav.view.listener.BtnPathViewListener;
import nav.view.listener.SliderZoomListener;

import javax.swing.*;
import java.awt.*;

public class HomeView extends JFrame {
    private JButton btnPathForm;
    private ImageIcon imgIcoMap;
    private Image imgMap;
    private JLabel labelMap;
    private JSlider sliderZoom;

    public HomeView() {
        setLayout(new BorderLayout());
        init();
        setTitle("校园行走最优路径查询系统");
        setExtendedState(JFrame.MAXIMIZED_BOTH); // 窗口最大化
//        setBounds(100, 100, 960, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void init() {
        btnPathForm = new JButton("路径查询");
        btnPathForm.addActionListener(new BtnPathViewListener());
        add(btnPathForm, BorderLayout.SOUTH);

        imgIcoMap = new ImageIcon("image/map.jpg");
        imgMap = imgIcoMap.getImage();
        labelMap = new JLabel(imgIcoMap);
        add(labelMap, BorderLayout.CENTER);

        sliderZoom = new JSlider(JSlider.VERTICAL, 0, 100, 50);
        sliderZoom.setMajorTickSpacing(10);
        sliderZoom.setMinorTickSpacing(1);
        sliderZoom.setPaintTicks(true);
        sliderZoom.setPaintLabels(true);
        sliderZoom.setSnapToTicks(true);
        sliderZoom.addChangeListener(new SliderZoomListener(this));
        add(sliderZoom, BorderLayout.EAST);

        validate();
    }

    public ImageIcon getImgIcoMap() {
        return imgIcoMap;
    }

    public Image getImgMap() {
        return imgMap;
    }

    public JLabel getLabelMap() {
        return labelMap;
    }
}