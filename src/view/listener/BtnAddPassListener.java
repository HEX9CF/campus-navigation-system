package src.view.listener;

import src.controller.PathAlgorithm;
import src.view.PathView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 途经点添加按钮监听器
 *
 * @date 2024/09/05
 */
public class BtnAddPassListener implements ActionListener {
    private final PathView view;
    private PathAlgorithm path_algorithm = new PathAlgorithm();
    public BtnAddPassListener(PathView view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String passingPoint = view.getTextFieldPass().getText();
        String[] splitInput = passingPoint.split(" ");
        // 判断是否重复添加
        if(view.getPassingPoints().contains(passingPoint)) {
            JOptionPane.showMessageDialog(null, "途经点已存在，不能重复添加！", "警告", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 判断途经点是否为空
        if(passingPoint.isEmpty()) {
            JOptionPane.showMessageDialog(null, "途经点不能为空！", "警告", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 判断途经点是否为起点或终点
        String startPoint = view.getTextFieldStart().getText();
        String destPoint = view.getTextFieldDest().getText();
        if(passingPoint.equals(startPoint) || passingPoint.equals(destPoint)) {
            JOptionPane.showMessageDialog(null, "途经点不能为起点或终点！", "警告", JOptionPane.WARNING_MESSAGE);
            return;
        }

        for(String point : splitInput){
            view.getPassingPoints().add(point);
        }
        // 添加途经点
        view.getTextAreaPass().append(passingPoint + "\n");
    }
}
