import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Login extends Frame {
    private final String zhanghao ="Baelfire";
    private final String mima = "928156";
    private final JFrame jFrame = new JFrame("登录");
    private final JTextField username = new JTextField("");
    private final JPasswordField password = new JPasswordField("");

    public Login() {
        ImageIcon img = new ImageIcon("Login.gif");
        JLabel imgLabel = new JLabel(img);
        jFrame.getLayeredPane().add(imgLabel,new Integer(Integer.MIN_VALUE));
        imgLabel.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
        // 设置窗体的位置及大小
        jFrame.setBounds(600, 200, 481, 300);
        Container c = jFrame.getContentPane();
        c.setLayout(new BorderLayout());// 布局管理器
        // 设置按下右上角X号后关闭
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 初始化--往窗体里放其他控件
        jFrame.setLocationRelativeTo(null);// 窗
        // 标题部分
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());
        titlePanel.add(new JLabel("商品管理系统 "));
        c.add(titlePanel, "North");
        titlePanel.setOpaque(false);
        // 输入部分
        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(null);
        JLabel a1 = new JLabel("用户名");
        a1.setBounds(150, 70, 50, 20);
        JLabel a2 = new JLabel("密   码");
        a2.setBounds(150, 110, 50, 20);
        fieldPanel.add(a1);
        fieldPanel.add(a2);
        username.setBounds(210, 70, 120, 20);
        password.setBounds(210, 110, 120, 20);
        fieldPanel.add(username);
        fieldPanel.add(password);
        c.add(fieldPanel, "Center");
        fieldPanel.setOpaque(false);

        // 按钮部分
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        JButton okbtn = new JButton("登录");
        buttonPanel.add(okbtn);
        c.add(buttonPanel, "South");
        buttonPanel.setOpaque(false);
        // 设置窗体可见
        jFrame.setVisible(true);
        ((JPanel)c).setOpaque(false);

        // 确认按下去获取

        okbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String uname = username.getText();
                    String pwd = String.valueOf(password.getPassword());
                    if (uname.equals(zhanghao)&&pwd.equals(mima)) {
                        jFrame.setVisible(false);
                        JOptionPane.showMessageDialog(null, "恭喜您,登录成功!");
                        SystemFrame m = new SystemFrame();
                        m.setVisible(true);
                        // 窗口居中
                        m.setLocationRelativeTo(null);
                    } else {
                        JOptionPane.showMessageDialog(null, "登录失败，账号或密码错误");
                    }
                } catch (HeadlessException e1) {
                    username.setText("");
                    password.setText("");
                    JOptionPane.showMessageDialog(null, "登录失败");
                }

            }
        });
    }

}


