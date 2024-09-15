package src.view;

import src.view.listener.BtnPathViewListener;
import src.view.listener.LabelMapDragListener;
import src.view.listener.SliderZoomListener;

import javax.swing.*;
import java.awt.*;

/**
 * 主页视图
 *
 * @date 2024/09/05
 */
public class HomeView extends JFrame {
    private JButton btnPathForm;
    private ImageIcon imgIcoMap;
    private Image imgMap;
    private JLabel labelMap;
    private JSlider sliderZoom;

    public HomeView() {
        setLayout(new BorderLayout());
        init();
        setTitle("汕头大学校园导航系统");
        setExtendedState(JFrame.MAXIMIZED_BOTH); // 窗口最大化
//        setBounds(100, 100, 960, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void init() {
        btnPathForm = new JButton("路径查询");
        btnPathForm.addActionListener(new BtnPathViewListener());
        add(btnPathForm, BorderLayout.SOUTH);

        // 地图
        imgIcoMap = new ImageIcon("image/map.jpg");
        imgMap = imgIcoMap.getImage();
        labelMap = new JLabel(imgIcoMap);
        labelMap.addMouseListener(new LabelMapDragListener(this));
        add(new JScrollPane(labelMap), BorderLayout.CENTER);

        // 缩放滑块
        sliderZoom = new JSlider(JSlider.VERTICAL, 0, 50, 30);
        sliderZoom.setMajorTickSpacing(10);
        sliderZoom.setMinorTickSpacing(1);
        sliderZoom.setPaintTicks(true);
        sliderZoom.setPaintLabels(true);
        sliderZoom.setSnapToTicks(true);
        SliderZoomListener sliderZoomListener = new SliderZoomListener(this);
        sliderZoom.addChangeListener(sliderZoomListener);
        sliderZoom.addMouseListener(sliderZoomListener);
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