package src.view.listener;

import src.controller.PathAlgorithm;
import src.view.PathView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * 查询路径按钮监听器
 *
 * @date 2024/09/05
 */
public class BtnQueryPathListener implements ActionListener {
    private final PathView view;

    public BtnQueryPathListener(PathView view) {
        this.view = view;
    }
    private PathAlgorithm pathAlgorithm = new PathAlgorithm();
    ArrayList<String> passingPoints;

    @Override
    public void actionPerformed(ActionEvent e) {
        String startPoint = view.getTextFieldStart().getText();
        String destPoint = view.getTextFieldDest().getText();
        passingPoints = view.getPassingPoints();

        // 判断起点和终点是否为空
        if(startPoint.isEmpty() || destPoint.isEmpty()) {
            JOptionPane.showMessageDialog(null, "起点或终点不能为空！", "警告", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 判断起点和终点是否相同
        if(startPoint.equals(destPoint)) {
            JOptionPane.showMessageDialog(null, "起点和终点不能相同！", "警告", JOptionPane.WARNING_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(null, pathAlgorithm.FindMinestDistance(startPoint, destPoint,passingPoints), "提示", JOptionPane.INFORMATION_MESSAGE);
    }
}

