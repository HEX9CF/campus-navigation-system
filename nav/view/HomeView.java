package nav.view;

import nav.view.listener.BtnPathViewListener;

import javax.swing.*;
import java.awt.*;

public class HomeView extends JFrame {
    private JButton btnPathForm;
    private ImageIcon imgIcoMap;
    private JLabel labelMap;

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
        add(btnPathForm, BorderLayout.NORTH);

        imgIcoMap = new ImageIcon("image/map.jpg");
        labelMap = new JLabel(imgIcoMap);
        add(labelMap, BorderLayout.CENTER);

        validate();
    }
}