package nav.view.listener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnQueryPathListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO: 判断起点和终点是否为空
        // TODO: 判断起点和终点是否相同
        JOptionPane.showMessageDialog(null, "查询路径", "提示", JOptionPane.INFORMATION_MESSAGE);
    }
}

