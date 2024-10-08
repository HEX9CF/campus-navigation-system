package src.view.listener;

import src.view.PathView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 清空表单按钮监听器
 *
 * @date 2024/09/05
 */
public class BtnClearFormListener implements ActionListener {
    private final PathView view;

    public BtnClearFormListener(PathView view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int opt = JOptionPane.showConfirmDialog(null, "确定要清空表单吗？", "提示", JOptionPane.YES_NO_OPTION);
        if(opt == JOptionPane.YES_OPTION) {
            // 清空表单
            view.getTextFieldStart().setText("");
            view.getTextFieldDest().setText("");
            view.getTextFieldPass().setText("");
            view.getTextAreaPass().setText("");

            // 清空途经点
            view.getPassingPoints().clear();
        }
    }
}

