package src.view.listener;

import src.view.PathView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 路径视图按钮监听器
 *
 * @date 2024/09/05
 */
public class BtnPathViewListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        PathView pathView = new PathView();
    }
}
