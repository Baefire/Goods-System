import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FunctionFrame extends Frame {
    private static final long serialVersionUID = 1L;

    public void AddFrame() {

        JFrame jFrame = new JFrame("增加一个商品");
        Container c = jFrame.getContentPane();

        JLabel a1 = new JLabel("ID");
        JTextField bh = new JTextField();

        JLabel a2 = new JLabel("商品名称");
        JTextField mc = new JTextField();

        JLabel a3 = new JLabel("商品单价");
        JTextField dj = new JTextField();

        JLabel a4 = new JLabel("商品数量");
        JTextField sl = new JTextField();

        JButton ok = new JButton("新增");
        JButton cancel = new JButton("重置");
        // 设置窗体的位置及大小
        jFrame.setBounds(600, 200, 300, 250);
        c.setLayout(new BorderLayout());// 布局管理器
        // 设置按下右上角X号后关闭
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // 初始化--往窗体里放其他控件
        jFrame.setLocationRelativeTo(null);// 窗
        /*标题部分*/
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());
        titlePanel.add(new JLabel("新增商品"));
        c.add(titlePanel, "North");
        /*输入部分*/
        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(null);
        a1.setBounds(50,25,100,20);
        a2.setBounds(50, 50, 100, 20);
        a3.setBounds(50, 75, 100, 20);
        a4.setBounds(50, 100, 100, 20);
        fieldPanel.add(a1);
        fieldPanel.add(a2);
        fieldPanel.add(a3);
        fieldPanel.add(a4);
        bh.setBounds(110,25,120,20);
        mc.setBounds(110, 50, 120, 20);
        dj.setBounds(110, 75, 120, 20);
        sl.setBounds(110, 100, 120, 20);
        fieldPanel.add(bh);
        fieldPanel.add(mc);
        fieldPanel.add(dj);
        fieldPanel.add(sl);
        c.add(fieldPanel, "Center");
        /*按钮部分*/
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(ok);
        buttonPanel.add(cancel);
        c.add(buttonPanel, "South");
        // 设置窗体可见
        jFrame.setVisible(true);

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SeverAchive severachive = new SeverAchive();
                try {
                    String bh1 = bh.getText();
                    String mc1 = mc.getText();
                    String dj1 = dj.getText();
                    String sl1 = sl.getText();
                    if ("".equals(bh1)||"".equals(mc1) || "".equals(dj1) || "".equals(sl1)) {
                        JOptionPane.showMessageDialog(null, "请求参数不能为空");
                        return;
                    }
                    float dj2 = Float.parseFloat(dj1);
                    Float sl2 = Float.parseFloat(sl1);
                    Goods g = new Goods(bh1, mc1, dj2, sl2);
                    boolean flag = severachive.addGoods(g);
                    if (flag) {
                        JOptionPane.showMessageDialog(null, "添加成功");
                        jFrame.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "已存在该商品，请重新输入！");
                    }
                } catch (HeadlessException e1) {

                }

            }
        });
        // 取消按下去清空
        cancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                bh.setText("");
                mc.setText("");
                dj.setText("");
                sl.setText("");
            }
        });
    }
    public void DeleteFrame(){
        JFrame jFrame = new JFrame("删除一个商品");
        Container c = jFrame.getContentPane();

        JLabel a1 = new JLabel("ID");
        JTextField bh = new JTextField();
        JButton ok = new JButton("删除");
        JButton cancel = new JButton("重置");
        // 设置窗体的位置及大小
        jFrame.setBounds(600, 200, 300, 250);
        c.setLayout(new BorderLayout());// 布局管理器
        // 设置按下右上角X号后关闭
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // 初始化--往窗体里放其他控件
        jFrame.setLocationRelativeTo(null);// 窗
        /*标题部分*/
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());
        titlePanel.add(new JLabel("删除商品"));
        c.add(titlePanel, "North");
        /*输入部分*/
        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(null);
        a1.setBounds(50,50,100,20);
        fieldPanel.add(a1);
        bh.setBounds(110,50,120,20);
        fieldPanel.add(bh);
        c.add(fieldPanel, "Center");
        /*按钮部分*/
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(ok);
        buttonPanel.add(cancel);
        c.add(buttonPanel, "South");
        // 设置窗体可见
        jFrame.setVisible(true);

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SeverAchive severachive = new SeverAchive();
                try {
                    String bh1 = bh.getText();
                    if (" ".equals(bh1)) {
                        JOptionPane.showMessageDialog(null, "请求参数不能为空");
                        return;
                    }
                    boolean flag = severachive.deleteGoods(bh1);
                    if (flag) {
                        JOptionPane.showMessageDialog(null, "删除成功");
                        jFrame.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "未找到商品信息！");
                    }
                } catch (HeadlessException e1) {

                }

            }
        });
        // 取消按下去清空
        cancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                bh.setText("");
            }
        });
    }
    public void SearchFrame(){
        JFrame jFrame = new JFrame("查找一个商品");
        Container c = jFrame.getContentPane();

        JLabel a1 = new JLabel("输入编号");
        JTextField bh = new JTextField();
        JLabel a2 = new JLabel("输入名称");
        JTextField mc = new JTextField();

        JButton ok = new JButton("查找");
        JButton cancel = new JButton("重置");

        // 设置窗体的位置及大小
        jFrame.setBounds(600, 200, 300, 250);
        c.setLayout(new BorderLayout());// 布局管理器
        // 设置按下右上角X号后关闭
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // 初始化--往窗体里放其他控件
        jFrame.setLocationRelativeTo(null);// 窗
        /*标题部分--North*/
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());
        titlePanel.add(new JLabel("查找商品"));
        c.add(titlePanel, "North");
        /*输入部分*/
        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(null);
        a1.setBounds(50,50,100,20);
        a2.setBounds(50, 100, 100, 20);
        fieldPanel.add(a1);
        fieldPanel.add(a2);
        bh.setBounds(110,50,120,20);
        mc.setBounds(110, 100, 120, 20);
        fieldPanel.add(bh);
        fieldPanel.add(mc);
        c.add(fieldPanel, "Center");
        /*按钮部分*/
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(ok);
        buttonPanel.add(cancel);
        c.add(buttonPanel, "South");
        // 设置窗体可见
        jFrame.setVisible(true);

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean flag1 = false;
                Goods good;
                SeverAchive severachive = new SeverAchive();
                try {
                    String bh1 = bh.getText();
                    String mc1 = mc.getText();

                    if("".equals(bh1)){
                        if("".equals(mc1)) {JOptionPane.showMessageDialog(null, "请求参数不能为空");return;}
                        else good = severachive.searchByname(mc1);
                    }
                    else{
                        if("".equals(mc1)) good = severachive.searchBynum(bh1);
                        else {good = severachive.searchBynum(bh1);flag1 = true;}
                    }

                    if(flag1&&(!good.getname().equals(mc1))){
                        JOptionPane.showMessageDialog(null,"输入编号名称不匹配，请重新输入！");return;}
                    if (!(good==null)) {
                        JOptionPane.showMessageDialog(null, "查找成功!\n所查商品信息："+good.getnum()+" "
                        +good.getname()+" "+good.getprice()+" "+good.getstocks());
                        jFrame.setVisible(false);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "没有所查商品信息！");
                    }
                }
                catch (HeadlessException e1) {

                }

            }
        });
        // 取消按下去清空
        cancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                bh.setText("");
                mc.setText("");
            }
        });
    }
    public void ChangeFrame(){
        JFrame jFrame = new JFrame("修改一个商品信息");
        Container c = jFrame.getContentPane();

        JLabel a1 = new JLabel("请输入ID");
        JTextField bh = new JTextField();

        JLabel a2 = new JLabel("新名称");
        JTextField mc = new JTextField();

        JLabel a3 = new JLabel("新价格");
        JTextField dj = new JTextField();

        JLabel a4 = new JLabel("新库存");
        JTextField sl = new JTextField();

        JButton ok = new JButton("修改");
        JButton cancel = new JButton("重置");
        jFrame.setBounds(600, 200, 300, 250);
        c.setLayout(new BorderLayout());
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());
        titlePanel.add(new JLabel("修改一个商品"));
        c.add(titlePanel, "North");

        /*输入部分--Center*/
        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(null);
        a1.setBounds(50,25,100,20);
        a2.setBounds(50, 50, 100, 20);
        a3.setBounds(50, 75, 100, 20);
        a4.setBounds(50, 100, 100, 20);
        fieldPanel.add(a1);
        fieldPanel.add(a2);
        fieldPanel.add(a3);
        fieldPanel.add(a4);
        bh.setBounds(110,25,120,20);
        mc.setBounds(110, 50, 120, 20);
        dj.setBounds(110, 75, 120, 20);
        sl.setBounds(110, 100, 120, 20);
        fieldPanel.add(bh);
        fieldPanel.add(mc);
        fieldPanel.add(dj);
        fieldPanel.add(sl);
        c.add(fieldPanel, "Center");
        /*按钮部分--South*/
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(ok);
        buttonPanel.add(cancel);
        c.add(buttonPanel, "South");
        // 设置窗体可见
        jFrame.setVisible(true);

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean flag = false;
                SeverAchive severachive = new SeverAchive();
                try {
                    String bh1 = bh.getText();
                    String mc1 = mc.getText();
                    String dj1 = dj.getText();
                    String sl1 = sl.getText();
                    if("".equals(bh1)) {JOptionPane.showMessageDialog(null,"请输入ID");return;}
                    else{
                        if(!"".equals(mc1)){
                            if("".equals(dj1)) {
                                if ("".equals(sl1)) flag = severachive.changename(bh1, mc1);
                                else {
                                    flag = severachive.changename(bh1, mc1);
                                    flag = severachive.changestocks(bh1, Float.parseFloat(sl1));
                                }
                            }
                            else{
                                if("".equals(sl1)){
                                    flag = severachive.changename(bh1,mc1);
                                    flag = severachive.changeprice(bh1,Float.parseFloat(dj1));
                                }
                                else {
                                    flag = severachive.changename(bh1,mc1);
                                    flag = severachive.changeprice(bh1,Float.parseFloat(dj1));
                                    flag = severachive.changestocks(bh1,Float.parseFloat(sl1));
                                }
                            }
                        }
                        else{
                            if("".equals(dj1)){
                                if("".equals(sl1)) {JOptionPane.showMessageDialog(null,"没有输入任何内容！");return;}
                                else {flag = severachive.changestocks(bh1,Float.parseFloat(sl1));}
                            }
                            else{
                                if("".equals(sl1)){flag = severachive.changeprice(bh1,Float.parseFloat(dj1));}
                                else{
                                    flag = severachive.changeprice(bh1,Float.parseFloat(dj1));
                                    flag = severachive.changestocks(bh1,Float.parseFloat(sl1));
                                }
                            }
                        }
                    }
                    if (flag) {
                        JOptionPane.showMessageDialog(null, "修改成功");
                        jFrame.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "未找到商品信息！");
                    }
                } catch (HeadlessException e1) {

                }

            }
        });
        // 取消按下去清空
        cancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                bh.setText("");
                mc.setText("");
                dj.setText("");
                sl.setText("");
            }
        });
    }
}
