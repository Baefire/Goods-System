import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Vector;

public class SystemFrame extends JFrame {
    private final JTable table;

    private final JButton button1 = new JButton("添加");
    private final JButton button2 = new JButton("删除");
    private final JButton button3 = new JButton("查找");
    private final JButton button4 = new JButton("修改");
    private final JButton button5 = new JButton("价格查找");
    private final JButton button6 = new JButton("显示所有");
    private final JButton button7 = new JButton("保存");
    private final JButton button8 = new JButton("载入");
    private final JLabel lowprice = new JLabel("最低价");
    private final JLabel highprice = new JLabel("最高价");
    private final JTextField low = new JTextField("");
    private final JTextField high = new JTextField("");

    public SystemFrame(){
        super("商品管理系统");
        this.setBounds(100, 100, 980, 518);
        Container c = this.getContentPane();
        c.setLayout(new BorderLayout());// 布局管理器
         //设置按下右上角X号后关闭
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);// 窗
        ImageIcon img = new ImageIcon("System.jpg");
        JLabel imgLabel = new JLabel(img);
        this.getLayeredPane().add(imgLabel,new Integer(Integer.MIN_VALUE));
        imgLabel.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
        this.setVisible(true);
        ((JPanel)c).setOpaque(false);

        /*上方按键模块*/
        JPanel options = new JPanel();
        options.setLayout(new FlowLayout());
        options.add(button1);
        options.add(button2);
        options.add(button3);
        options.add(button4);
        c.add(options,"North");
        options.setOpaque(false);

        /*下方按键及文本框模块*/
        JPanel options1 = new JPanel();
        JPanel text = new JPanel();
        text.setLayout(new GridLayout(2,2));
        options1.setLayout(new FlowLayout());
        text.add(lowprice);
        text.add(low);
        text.add(highprice);
        text.add(high);
        options1.add(text);
        options1.add(button5);
        options1.add(button6);
        options1.add(button7);
        options1.add(button8);
        c.add(options1,"South");
        options1.setOpaque(false);
        text.setOpaque(false);

        /*表格模块*/
        JPanel excel = new JPanel();
        excel.setLayout(new FlowLayout());
        String[] titles = {"ID","名称","价格","数量"};
        JScrollPane scrollPane = new JScrollPane();
        excel.add(scrollPane);
        table = new JTable();
        scrollPane.setViewportView(table);
        c.add(excel,"Center");
        excel.setOpaque(false);

        button1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FunctionFrame frame = new FunctionFrame();
                frame.AddFrame();
            }
        });

        button2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FunctionFrame frame = new FunctionFrame();
                frame.DeleteFrame();
            }
        });

        button3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FunctionFrame frame = new FunctionFrame();
                frame.SearchFrame();
            }
        });
        button4.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FunctionFrame frame = new FunctionFrame();
                frame.ChangeFrame();
            }
        });


        button5.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float price1 = Float.parseFloat(low.getText());
                float price2 = Float.parseFloat(high.getText());
                SeverAchive get = new SeverAchive();
                Vector<Goods> receive = get.searchBypricerange(price2, price1);
                if (receive == null) {
                    JOptionPane.showMessageDialog(null, "未找到商品信息！");
                } else {
                    String[][] data = new String[receive.size()][4];
                    for (int i = 0; i < data.length; i++) {
                        for (int j = 0; j < data[i].length; j++) {
                            data[i][0] = receive.get(i).getnum();
                            data[i][1] = receive.get(i).getname();
                            data[i][2] = Float.toString(receive.get(i).getprice());
                            data[i][3] = Float.toString(receive.get(i).getstocks());
                        }
                    }
                    table.setModel(new DefaultTableModel(data, titles));
                }
            }
        });

        button6.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SeverAchive get = new SeverAchive();
                Vector<Goods> receive = get.getGoodsLists();
                String[][] data = new String[receive.size()][4];
                for (int i = 0; i < data.length; i++) {
                    for (int j = 0; j < data[i].length; j++) {
                        data[i][0] = receive.get(i).getnum();
                        data[i][1] = receive.get(i).getname();
                        data[i][2] = Float.toString(receive.get(i).getprice());
                        data[i][3] = Float.toString(receive.get(i).getstocks());
                    }
                }
                table.setModel(new DefaultTableModel(data,titles));
            }
        });
        button7.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileOutputStream fos = null;
                ObjectOutputStream oos = null;
                try {
                    String fileName="System Data";
                    fos = new FileOutputStream(fileName);
                    oos = new ObjectOutputStream(fos);
                    oos.writeObject(GoodsData.goods);
                }
                catch (Exception ignored){}
                finally {
                    try{
                    oos.flush();
                    oos.close();
                    }
                    catch (Exception ignored){}
                    JOptionPane.showMessageDialog(null, "保存成功");
                }
            }
        });

        button8.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileInputStream fis = null;
                ObjectInputStream ois = null;
                try {
                    String fileName="System Data";
                    HashMap<String,Goods> oldData = null;
                    fis = new FileInputStream(fileName);
                    ois = new ObjectInputStream(fis);
                    oldData = (HashMap<String, Goods>)ois.readObject();
                    GoodsData.goods.putAll(oldData);
                }
                catch (Exception e1){e1.printStackTrace();}
                finally {
                    try{
                    ois.close();}
                    catch (Exception ignored){}
                    JOptionPane.showMessageDialog(null, "加载成功");
                }
            }
        });
    }
}
