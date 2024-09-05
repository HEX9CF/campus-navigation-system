package nav.view;

import nav.view.listener.BtnAddPassListener;
import nav.view.listener.BtnClearFormListener;
import nav.view.listener.BtnPathViewListener;
import nav.view.listener.BtnQueryPathListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * 路径视图
 *
 * @date 2024/09/05
 */
public class PathView extends JFrame{
    private Box boxForm;
    private Box boxStartDest;
    private Box boxV1;
    private Box boxV2;
    private Box boxPass;
    private Box boxBtn;
    private JTextArea textAreaPass;
    private JTextField textFieldStart;
    private JTextField textFieldDest;
    private JTextField textFieldPass;
    private JButton btnAddPass;
    private JButton btnQueryPath;
    private JButton btnClearForm;
    private ArrayList<String> passingPoints;

    public PathView(){
        setLayout(new FlowLayout());
        init();
        setTitle("路径查询");
        setBounds(100, 100, 400, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void init() {
        passingPoints = new ArrayList<>();

        boxForm = Box.createVerticalBox();

        boxForm.add(Box.createVerticalStrut(8));
        boxV1 = Box.createVerticalBox();
        boxV2 = Box.createVerticalBox();

        boxV1.add(new JLabel("起点"));
        boxV1.add(Box.createVerticalStrut(8));
        boxV1.add(new JLabel("终点"));
        boxV1.add(Box.createVerticalStrut(8));

        textFieldStart = new JTextField(20);
        boxV2.add(textFieldStart);
        boxV2.add(Box.createVerticalStrut(8));
        textFieldDest = new JTextField(20);
        boxV2.add(textFieldDest);
        boxV2.add(Box.createVerticalStrut(8));

        boxStartDest = Box.createHorizontalBox();
        boxStartDest.add(boxV1);
        boxStartDest.add(Box.createHorizontalStrut(8));
        boxStartDest.add(boxV2);
        boxForm.add(boxStartDest);

        // 途经点
        boxForm.add(Box.createVerticalStrut(8));
        boxPass = Box.createHorizontalBox();
        boxPass.add(new JLabel("途经点"));
        boxPass.add(Box.createHorizontalStrut(8));
        textFieldPass = new JTextField(20);
        boxPass.add(textFieldPass);
        boxPass.add(Box.createHorizontalStrut(8));
        btnAddPass = new JButton("添加");
        btnAddPass.addActionListener(new BtnAddPassListener(this));
        boxPass.add(btnAddPass);
        boxForm.add(boxPass);

        boxForm.add(Box.createVerticalStrut(8));
        textAreaPass = new JTextArea(5, 20);
        boxForm.add(new JScrollPane(textAreaPass));

        // 按钮
        boxForm.add(Box.createVerticalStrut(8));
        boxBtn = Box.createHorizontalBox();
        btnClearForm = new JButton("清空表单");
        btnClearForm.addActionListener(new BtnClearFormListener(this));
        boxBtn.add(btnClearForm);
        boxForm.add(boxBtn);
        boxBtn.add(Box.createHorizontalStrut(8));
        btnQueryPath = new JButton("查询路径");
        btnQueryPath.addActionListener(new BtnQueryPathListener(this));
        boxBtn.add(btnQueryPath);

        add(boxForm);
        validate();
    }

    public JTextField getTextFieldPass() {
        return textFieldPass;
    }

    public JTextField getTextFieldDest() {
        return textFieldDest;
    }

    public JTextField getTextFieldStart() {
        return textFieldStart;
    }

    public JTextArea getTextAreaPass() {
        return textAreaPass;
    }

    public ArrayList<String> getPassingPoints() {
        return passingPoints;
    }
}

