package nav.view.listener;

import nav.view.PathView;

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
    private String startPoint;
    private String destPoint;
    private ArrayList<String> passingPoints;

    public BtnQueryPathListener(PathView view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        startPoint = view.getTextFieldStart().getText();
        destPoint = view.getTextFieldDest().getText();

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

        JOptionPane.showMessageDialog(null, "查询路径", "提示", JOptionPane.INFORMATION_MESSAGE);

        // debug
        System.out.println("起点：" + startPoint);
        System.out.println("终点：" + destPoint);
        System.out.println("途经点：");
        for(String pass : view.getPassingPoints()) {
            System.out.println(pass);
        }
    }
}

