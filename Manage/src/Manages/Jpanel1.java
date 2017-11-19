package Manages;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Jpanel1 extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 业主信息界面的面板
	private JPanel panel1, pl2, pl3, pl4;
	// 业主信息界面按钮
	private JButton bt1, bt2, bt4;
	// 业主信息界面面板pl2标签
	private JLabel label1, label2, label3, label4, label5, label6, label7,
			label8, label9, label10, label11, label12, label13;
	// 业主信息界面标签箭头图片
	private JLabel Jlabel1, Jlabel2;
	// 业主信息界面面板pl2的JTextField
	private JTextField text1, text2, text3, text4, text5, text6, text7;
	// 业主信息界面面板pl2的JTextArea
	private JTextArea area1;
	// 业主信息界面面板pl2的JCheckBox和ButtonGroup
	private JCheckBox box1, box2;
	private ButtonGroup group;
	// 业主信息界面面板pl2的JComboBox
	private JComboBox<String> com1, com2, com3;
	// 业主信息界面面板pl2的JScrollBar
	private JScrollBar bar1, bar2, bar3;
	// 业主信息界面面板pl3标签
	private JLabel bel1;
	// 业主信息界面面板pl3JTextField
	private JTextField JText1;
	// 业主信息界面面板JButton
	private JButton button, button1, button2, button3, button4, button5;
	// pl4的标签
	private JLabel label_1, label_3, label_5, label_7, label_9, label_11,
			label_13, label_15, label_17, label_19, label_21;
	// pl4的JTextField和JTextArea
	private JTextField te1, te2, te3, te4, te5, te6, te7, te8, te9, te10;
	private JTextArea area2;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Jpanel1() {
		// TODO Auto-generated constructor stub

		String s1[][] = new String[100][11];
		int numbers = 0;
		// 读取panel1文件
		try {

			int i = 0, j = 0;

			File s = new File("data/panel1.txt");
			FileReader fr = new FileReader(s);
			BufferedReader t = new BufferedReader(fr);
			String str = t.readLine();
			while (str != null) {
				StringTokenizer st = new StringTokenizer(str, " ");
				// 将文件进行分割
				while (st.hasMoreTokens()) {
					// 将文件写入到数组中
					s1[j][i] = st.nextToken();
					i++;
				}

				str = t.readLine();
				j++;
				i = 0;
			}

			t.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		// 读取业主姓名
		String ss[] = new String[100];
		for (int a = 0, b = 1; a < 100; a++) {

			ss[a] = s1[a][b];
			if (ss[a] == null) {

				numbers = a;
				break;
			}
		}
		String[] s2 = new String[numbers];
		for (int a = 0; a < numbers; a++) {

			s2[a] = ss[a];
		}

		// 业主信息面板
		panel1 = new JPanel() {

			/**
					 * 
					 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {

				ImageIcon images1 = new ImageIcon(
						"image/9056962_162738403151_2.jpg");
				java.awt.Image im1 = images1.getImage();
				g.drawImage(im1, 0, 0, 650, 500, images1.getImageObserver());

				g.setColor(Color.darkGray);
				g.drawLine(130, 0, 130, 500);

				g.setColor(Color.gray);
				g.drawLine(0, 170, 130, 170);

				g.setColor(Color.gray);
				g.drawLine(0, 400, 130, 400);

			}
		};
		panel1.setLayout(null);
		panel1.setBounds(0, 0, 650, 500);

		Jlabel1 = new JLabel(new ImageIcon(
				"image/arrow_right_27.399141630901px_1188313_easyicon.net.png"));
		Jlabel1.setBounds(101, 15, 30, 20);

		Jlabel2 = new JLabel(new ImageIcon(
				"image/arrow_right_27.399141630901px_1188313_easyicon.net.png"));
		Jlabel2.setBounds(101, 65, 30, 20);
		Jlabel2.setVisible(false);

		bt1 = new JButton("录入信息");
		bt1.setBounds(10, 10, 90, 30);
		bt1.setFont(new Font("华文彩云", Font.PLAIN, 15));
		bt1.setForeground(Color.lightGray);
		bt1.setFocusPainted(false);
		bt1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bt1.addActionListener(this);

		bt2 = new JButton("查看信息");
		bt2.setBounds(10, 60, 90, 30);
		bt2.setFont(new Font("华文彩云", Font.PLAIN, 15));
		bt2.setForeground(Color.lightGray);
		bt2.setFocusPainted(false);
		bt2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bt2.addActionListener(this);

		bt4 = new JButton("返回");
		bt4.setBounds(10, 420, 100, 30);
		bt4.setFont(new Font("华文彩云", Font.PLAIN, 15));
		bt4.setForeground(Color.black);
		bt4.setFocusPainted(false);
		bt4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bt4.addActionListener(this);

		label13 = new JLabel("<html>提示:除意见<br>是非必须填<br>以外,其余都必须填!</html>");
		label13.setBounds(8, 180, 110, 180);
		label13.setFont(new Font("楷体", Font.PLAIN, 20));
		label13.setForeground(Color.blue);

		// 业主信息面板pl2
		pl2 = new JPanel();
		pl2.setLayout(null);
		pl2.setBounds(130, 0, 520, 500);
		pl2.setOpaque(false);

		label1 = new JLabel("业主编号:");
		label1.setBounds(50, 20, 88, 40);
		label1.setFont(new Font("楷体", Font.PLAIN, 18));

		text1 = new JTextField();
		text1.setBounds(133, 27, 110, 28);

		label2 = new JLabel("业主姓名:");
		label2.setBounds(285, 20, 88, 40);
		label2.setFont(new Font("楷体", Font.PLAIN, 18));

		text2 = new JTextField();
		text2.setBounds(370, 27, 100, 28);

		label3 = new JLabel("性别:");
		label3.setBounds(50, 66, 88, 40);
		label3.setFont(new Font("楷体", Font.PLAIN, 18));

		box1 = new JCheckBox("男");
		box1.setBounds(120, 70, 60, 30);
		box1.setFocusable(false);
		box1.setFont(new Font("楷体", Font.PLAIN, 16));

		box2 = new JCheckBox("女");
		box2.setBounds(190, 70, 60, 30);
		box2.setFocusable(false);
		box2.setFont(new Font("楷体", Font.PLAIN, 16));

		group = new ButtonGroup();

		label4 = new JLabel("工作单位:");
		label4.setBounds(50, 113, 88, 40);
		label4.setFont(new Font("楷体", Font.PLAIN, 17));

		text3 = new JTextField();
		text3.setBounds(130, 120, 220, 28);

		label5 = new JLabel("电话号码:");
		label5.setBounds(48, 160, 88, 40);
		label5.setFont(new Font("楷体", Font.PLAIN, 17));

		text4 = new JTextField();
		text4.setBounds(130, 165, 150, 28);

		label6 = new JLabel("QQ:");
		label6.setBounds(300, 160, 60, 40);
		label6.setFont(new Font("楷体", Font.PLAIN, 17));

		text5 = new JTextField();
		text5.setBounds(330, 165, 150, 28);

		label7 = new JLabel("住房信息:");
		label7.setBounds(50, 207, 100, 40);
		label7.setFont(new Font("楷体", Font.PLAIN, 19));

		label8 = new JLabel("楼栋号:");
		label8.setBounds(150, 207, 70, 40);
		label8.setFont(new Font("楷体", Font.PLAIN, 16));

		bar1 = new JScrollBar();
		bar1.setVisibleAmount(2);

		com1 = new JComboBox(new Object[] { "1", "2", "3", "4", "5", "6", "7",
				"8", "9" });
		com1.setBounds(210, 213, 55, 27);
		com1.setMaximumRowCount(3);
		com1.setFont(new Font("楷体", Font.PLAIN, 15));
		com1.setFocusable(false);

		label9 = new JLabel("单元号:");
		label9.setBounds(295, 207, 70, 40);
		label9.setFont(new Font("楷体", Font.PLAIN, 16));

		bar2 = new JScrollBar();
		bar2.setVisibleAmount(2);

		com2 = new JComboBox(new Object[] { "1", "2", "3", "4", "5", "6", "7" });
		com2.setBounds(360, 213, 55, 27);
		com2.setMaximumRowCount(3);
		com2.setFont(new Font("楷体", Font.PLAIN, 15));
		com2.setFocusable(false);

		label10 = new JLabel("房号:");
		label10.setBounds(50, 250, 90, 40);
		label10.setFont(new Font("楷体", Font.PLAIN, 18));

		text6 = new JTextField();
		text6.setBounds(105, 256, 110, 30);

		label11 = new JLabel("住房面积:");
		label11.setBounds(240, 250, 120, 40);
		label11.setFont(new Font("楷体", Font.PLAIN, 18));

		text7 = new JTextField();
		text7.setBounds(330, 256, 110, 30);

		label12 = new JLabel("业主对住房的意见和看法:");
		label12.setBounds(30, 300, 240, 40);
		label12.setFont(new Font("楷体", Font.PLAIN, 18));

		area1 = new JTextArea();
		area1.setBounds(245, 310, 260, 55);
		area1.setLineWrap(true);
		area1.setBackground(Color.gray);
		area1.setFont(new Font("楷体", Font.PLAIN, 14));

		button = new JButton("清空");
		button.setBounds(255, 410, 100, 32);
		button.setFont(new Font("华文彩云", Font.PLAIN, 20));
		button.setForeground(Color.darkGray);
		button.setToolTipText("清空所有文本框内容");
		button.setFocusPainted(false);
		button.setFocusable(false);
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.addActionListener(this);

		button2 = new JButton("保存");
		button2.setBounds(135, 410, 100, 32);
		button2.setFont(new Font("华文彩云", Font.PLAIN, 20));
		button2.setForeground(Color.darkGray);
		button2.setFocusPainted(false);
		button2.setFocusable(false);
		button2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button2.addActionListener(this);

		// 业主信息面板pl3
		pl3 = new JPanel();
		pl3.setLayout(null);
		pl3.setBounds(130, 0, 520, 500);
		pl3.setOpaque(false);

		bel1 = new JLabel("你要查询业主的名字:");
		bel1.setBounds(30, 30, 240, 40);
		bel1.setFont(new Font("楷体", Font.PLAIN, 18));

		button1 = new JButton("确定");
		button1.setBounds(380, 34, 90, 32);
		button1.setFont(new Font("华文彩云", Font.PLAIN, 20));
		button1.setForeground(Color.darkGray);
		button1.setFocusPainted(false);
		button1.setFocusable(false);
		button1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button1.addActionListener(this);

		JText1 = new JTextField();
		JText1.setBounds(220, 35, 120, 30);

		bar3 = new JScrollBar();

		com3 = new JComboBox<String>(s2);
		com3.setBounds(220, 35, 142, 30);
		com3.setFont(new Font("楷体", Font.PLAIN, 15));
		com3.setMaximumRowCount(3);
		com3.setFocusable(false);
		com3.addActionListener(this);

		// 业主信息面板pl4
		pl4 = new JPanel() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {

				g.drawLine(50, 15, 460, 15);
				g.drawLine(50, 15, 50, 340);
				g.drawLine(460, 15, 460, 340);
				g.drawLine(50, 340, 460, 340);

				g.drawLine(250, 15, 250, 55);
				g.drawLine(250, 95, 250, 215);
				g.drawLine(50, 55, 460, 55);
				g.drawLine(50, 95, 460, 95);
				g.drawLine(50, 135, 460, 135);
				g.drawLine(50, 175, 460, 175);
				g.drawLine(50, 215, 460, 215);
				g.drawLine(50, 255, 460, 255);
			}
		};
		pl4.setLayout(null);
		pl4.setBounds(0, 70, 520, 430);
		pl4.setOpaque(false);

		button3 = new JButton("删除");
		button3.setBounds(140, 350, 90, 32);
		button3.setFont(new Font("华文彩云", Font.PLAIN, 20));
		button3.setForeground(Color.darkGray);
		button3.setToolTipText("永久删除此人信息");
		button3.setFocusPainted(false);
		button3.setFocusable(false);
		button3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button3.addActionListener(this);

		button4 = new JButton("修改");
		button4.setBounds(248, 350, 90, 32);
		button4.setFont(new Font("华文彩云", Font.PLAIN, 20));
		button4.setForeground(Color.darkGray);
		button4.setToolTipText("修改此人信息");
		button4.setFocusPainted(false);
		button4.setFocusable(false);
		button4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button4.addActionListener(this);

		button5 = new JButton("保存");
		button5.setBounds(248, 350, 90, 32);
		button5.setFont(new Font("华文彩云", Font.PLAIN, 20));
		button5.setForeground(Color.darkGray);
		button5.setToolTipText("保存此人信息");
		button5.setFocusPainted(false);
		button5.setFocusable(false);
		button5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button5.addActionListener(this);
		button5.setVisible(false);

		label_1 = new JLabel("业主编号:");
		label_1.setBounds(60, 20, 100, 30);
		label_1.setFont(new Font("楷体", Font.PLAIN, 18));

		te1 = new JTextField();
		te1.setBounds(140, 17, 110, 39);
		te1.setFont(new Font("楷体", Font.PLAIN, 18));
		te1.setBorder(new EmptyBorder(0, 0, 0, 0));
		te1.setOpaque(false);
		te1.setEditable(false);

		label_3 = new JLabel("业主姓名:");
		label_3.setBounds(260, 20, 100, 30);
		label_3.setFont(new Font("楷体", Font.PLAIN, 18));

		te2 = new JTextField();
		te2.setBounds(340, 17, 110, 39);
		te2.setFont(new Font("楷体", Font.PLAIN, 18));
		te2.setBorder(new EmptyBorder(0, 0, 0, 0));
		te2.setOpaque(false);
		te2.setEditable(false);

		label_5 = new JLabel("性别:");
		label_5.setBounds(60, 60, 100, 30);
		label_5.setFont(new Font("楷体", Font.PLAIN, 18));

		te3 = new JTextField();
		te3.setBounds(140, 57, 110, 39);
		te3.setFont(new Font("楷体", Font.PLAIN, 18));
		te3.setBorder(new EmptyBorder(0, 0, 0, 0));
		te3.setOpaque(false);
		te3.setEditable(false);

		label_9 = new JLabel("电话号码:");
		label_9.setBounds(60, 100, 100, 30);
		label_9.setFont(new Font("楷体", Font.PLAIN, 18));

		te5 = new JTextField();
		te5.setBounds(140, 97, 110, 39);
		te5.setFont(new Font("楷体", Font.PLAIN, 18));
		te5.setBorder(new EmptyBorder(0, 0, 0, 0));
		te5.setOpaque(false);
		te5.setEditable(false);

		label_11 = new JLabel("QQ:");
		label_11.setBounds(260, 100, 100, 30);
		label_11.setFont(new Font("楷体", Font.PLAIN, 18));

		te6 = new JTextField();
		te6.setBounds(340, 97, 110, 39);
		te6.setFont(new Font("楷体", Font.PLAIN, 18));
		te6.setBorder(new EmptyBorder(0, 0, 0, 0));
		te6.setOpaque(false);
		te6.setEditable(false);

		label_13 = new JLabel("楼栋号:");
		label_13.setBounds(60, 140, 100, 30);
		label_13.setFont(new Font("楷体", Font.PLAIN, 18));

		te7 = new JTextField();
		te7.setBounds(140, 137, 110, 39);
		te7.setFont(new Font("楷体", Font.PLAIN, 18));
		te7.setBorder(new EmptyBorder(0, 0, 0, 0));
		te7.setOpaque(false);
		te7.setEditable(false);

		label_15 = new JLabel("单元号:");
		label_15.setBounds(260, 140, 100, 30);
		label_15.setFont(new Font("楷体", Font.PLAIN, 18));

		te8 = new JTextField();
		te8.setBounds(340, 137, 110, 39);
		te8.setFont(new Font("楷体", Font.PLAIN, 18));
		te8.setBorder(new EmptyBorder(0, 0, 0, 0));
		te8.setOpaque(false);
		te8.setEditable(false);

		label_17 = new JLabel("房号:");
		label_17.setBounds(60, 180, 100, 30);
		label_17.setFont(new Font("楷体", Font.PLAIN, 18));

		te9 = new JTextField();
		te9.setBounds(140, 177, 110, 39);
		te9.setFont(new Font("楷体", Font.PLAIN, 18));
		te9.setBorder(new EmptyBorder(0, 0, 0, 0));
		te9.setOpaque(false);
		te9.setEditable(false);

		label_19 = new JLabel("住房面积:");
		label_19.setBounds(260, 180, 100, 30);
		label_19.setFont(new Font("楷体", Font.PLAIN, 18));

		te10 = new JTextField();
		te10.setBounds(340, 177, 110, 39);
		te10.setFont(new Font("楷体", Font.PLAIN, 18));
		te10.setBorder(new EmptyBorder(0, 0, 0, 0));
		te10.setOpaque(false);
		te10.setEditable(false);

		label_7 = new JLabel("工作单位:");
		label_7.setBounds(60, 220, 100, 30);
		label_7.setFont(new Font("楷体", Font.PLAIN, 18));

		te4 = new JTextField();
		te4.setBounds(140, 217, 200, 39);
		te4.setFont(new Font("楷体", Font.PLAIN, 18));
		te4.setBorder(new EmptyBorder(0, 0, 0, 0));
		te4.setOpaque(false);
		te4.setEditable(false);

		label_21 = new JLabel("业主对住房的看法:");
		label_21.setBounds(60, 260, 160, 30);
		label_21.setFont(new Font("楷体", Font.PLAIN, 18));

		area2 = new JTextArea();
		area2.setBounds(220, 260, 240, 80);
		area2.setFont(new Font("楷体", Font.PLAIN, 18));
		area2.setBorder(new EmptyBorder(0, 0, 0, 0));
		area2.setOpaque(false);
		area2.setEditable(false);
		area2.setLineWrap(true);

		pl3.add(JText1);
		pl3.add(com3);
		com3.add(bar3);

		pl4.add(label_1);
		pl4.add(te1);
		pl4.add(label_3);
		pl4.add(te2);
		pl4.add(label_5);
		pl4.add(te3);
		pl4.add(label_7);
		pl4.add(te4);
		pl4.add(label_9);
		pl4.add(te5);
		pl4.add(label_11);
		pl4.add(te6);
		pl4.add(label_13);
		pl4.add(te7);
		pl4.add(label_15);
		pl4.add(te8);
		pl4.add(label_17);
		pl4.add(te9);
		pl4.add(label_19);
		pl4.add(te10);
		pl4.add(label_21);
		pl4.add(area2);
		panel1.add(bt1);
		panel1.add(bt2);
		panel1.add(bt4);
		panel1.add(Jlabel1);
		panel1.add(Jlabel2);
		panel1.add(label13);
		panel1.add(pl2);
		pl2.add(label1);
		pl2.add(label2);
		pl2.add(label3);
		pl2.add(label4);
		pl2.add(label5);
		pl2.add(label6);
		pl2.add(label7);
		pl2.add(label8);
		pl2.add(label9);
		pl2.add(label10);
		pl2.add(label11);
		pl2.add(label12);
		pl2.add(button);
		pl2.add(button2);
		pl2.add(area1);
		pl2.add(text1);
		pl2.add(text2);
		pl2.add(text3);
		pl2.add(text4);
		pl2.add(text5);
		pl2.add(text6);
		pl2.add(text7);
		group.add(box1);
		group.add(box2);
		pl2.add(box1);
		pl2.add(box2);
		com1.add(bar1);
		com2.add(bar2);
		pl2.add(com1);
		pl2.add(com2);
		pl3.add(bel1);
		pl3.add(button1);
		pl3.add(pl4);
		pl4.add(button3);
		pl4.add(button4);
		pl4.add(button5);
		this.add(panel1);

		this.setSize(650, 500);
		this.setTitle("物主信息管理--业主信息");
		this.setIconImage((new ImageIcon(
				"image/Company_house_48px_520461_easyicon.net.png")).getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}

	@SuppressWarnings({})
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String arr[][] = new String[100][11];
		int num = 0;
		// 读取panel1文件
		try {

			int i = 0, j = 0;

			File s = new File("data/panel1.txt");
			FileReader fr = new FileReader(s);
			BufferedReader t = new BufferedReader(fr);
			String str = t.readLine();
			while (str != null) {
				StringTokenizer st = new StringTokenizer(str, " ");
				// 将文件进行分割
				while (st.hasMoreTokens()) {
					// 将文件写入到数组中
					arr[j][i] = st.nextToken();
					i++;
				}

				str = t.readLine();
				j++;
				i = 0;
			}

			t.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		// 读取业主姓名
		String ss[] = new String[100];
		for (int a = 0, b = 1; a < 100; a++) {

			ss[a] = arr[a][b];
			if (ss[a] == null) {

				break;
			}
		}

		// 业主信息界面面板--录入按钮
		if (e.getSource().equals(bt1)) {

			Jlabel1.setVisible(true);
			Jlabel2.setVisible(false);

			label13.setVisible(true);

			JText1.setText("");
			// 清空pl4面板内容
			te1.setText("");
			te2.setText("");
			te3.setText("");
			te4.setText("");
			te5.setText("");
			te6.setText("");
			te7.setText("");
			te8.setText("");
			te9.setText("");
			te10.setText("");
			area2.setText("");

			// 移除pl3面板，添加pl2面板
			panel1.remove(pl3);
			panel1.add(pl2);
			panel1.validate();
			panel1.repaint();
		}

		// 业主信息界面面板--查看按钮
		else if (e.getSource().equals(bt2)) {

			Jlabel1.setVisible(false);
			Jlabel2.setVisible(true);

			label13.setVisible(false);

			JText1.setText("");

			button3.setEnabled(false);
			button4.setEnabled(false);

			// 移除pl2面板，添加pl3面板
			panel1.remove(pl2);
			panel1.add(pl3);
			panel1.validate();
			panel1.repaint();
		}

		// 业主信息界面面板--返回按钮
		else if (e.getSource().equals(bt4)) {

			new MyManages();
			this.dispose();
		}

		// 保存按钮
		else if (e.getSource().equals(button2)) {

			boolean b1, b2;
			b1 = box1.isSelected();
			b2 = box2.isSelected();

			if (text1.getText().isEmpty() | text2.getText().isEmpty()
					| text3.getText().isEmpty() | text4.getText().isEmpty()
					| text5.getText().isEmpty() | text6.getText().isEmpty()
					| text7.getText().isEmpty() | (!(b1) && !(b2))) {

				JOptionPane.showMessageDialog(null, "请输入完整的信息!", "警告",
						JOptionPane.CANCEL_OPTION);

			}

			else {

				// 把账号和密码写入panel1文件
				try {

					File s = new File("data/panel1.txt");
					BufferedWriter writer = new BufferedWriter(new FileWriter(
							s, true));
					writer.append(text1.getText());
					writer.append(" ");
					writer.append(text2.getText());
					writer.append(" ");
					if (box1.isSelected()) {

						writer.append(box1.getText());
						writer.append(" ");
					} else if (box2.isSelected()) {

						writer.append(box2.getText());
						writer.append(" ");
					}
					writer.append(text3.getText());
					writer.append(" ");
					writer.append(text4.getText());
					writer.append(" ");
					writer.append(text5.getText());
					writer.append(" ");
					writer.append(com1.getSelectedItem().toString());
					writer.append(" ");
					writer.append(com2.getSelectedItem().toString());
					writer.append(" ");
					writer.append(text6.getText());
					writer.append(" ");
					writer.append(text7.getText());
					writer.append(" ");
					writer.append(area1.getText());
					writer.newLine();
					writer.flush();
					writer.close();

					JOptionPane.showMessageDialog(null, "保存成功!", "保存",
							JOptionPane.INFORMATION_MESSAGE);

					// 向JComboBox添加子项
					com3.addItem(text2.getText());

				} catch (Exception e1) {

					JOptionPane.showMessageDialog(null, "保存失败!", "保存",
							JOptionPane.CANCEL_OPTION);
				}
			}
		}

		// 业主信息界面面板--搜索组合框
		else if (e.getSource().equals(com3)) {

			String s = com3.getSelectedItem().toString();
			JText1.setText(s);
		}

		// 清空按钮
		else if (e.getSource().equals(button)) {

			int a = 1;
			a = JOptionPane.showConfirmDialog(null, "是否清空所有内容?", "提示",
					JOptionPane.YES_NO_OPTION);

			// 选择yes
			if (a == 0) {

				text1.setText("");
				text2.setText("");
				text3.setText("");
				text4.setText("");
				text5.setText("");
				text6.setText("");
				text7.setText("");
				area1.setText("");
			}
		}

		else if (e.getSource().equals(button1)) {

			// 清空pl4面板内容
			te1.setText("");
			te2.setText("");
			te3.setText("");
			te4.setText("");
			te5.setText("");
			te6.setText("");
			te7.setText("");
			te8.setText("");
			te9.setText("");
			te10.setText("");
			area2.setText("");

			boolean b = false;

			for (int a = 0; a < 100; a++) {

				if (JText1.getText().equals(ss[a])) {

					b = true;
					num = a;
					break;
				}

			}

			if (b == false) {

				JOptionPane.showMessageDialog(null, "查无此人!", "提示",
						JOptionPane.CANCEL_OPTION);

				JText1.setText("");

			}

			else {

				te1.setText(arr[num][0]);
				te2.setText(arr[num][1]);
				te3.setText(arr[num][2]);
				te4.setText(arr[num][3]);
				te5.setText(arr[num][4]);
				te6.setText(arr[num][5]);
				te7.setText(arr[num][6]);
				te8.setText(arr[num][7]);
				te9.setText(arr[num][8]);
				te10.setText(arr[num][9]);
				area2.setText(arr[num][10]);
				pl4.repaint();
				button3.setEnabled(true);
				button4.setEnabled(true);
			}
		}

		// 删除按钮
		else if (e.getSource().equals(button3)) {

			if (JText1.getText().isEmpty()) {

				JOptionPane.showMessageDialog(null, "请确定要删除车主的姓名!", "提示",
						JOptionPane.CANCEL_OPTION);
			}

			else {

				int a = 1;
				a = JOptionPane.showConfirmDialog(null, "是否删除此人信息?", "提示",
						JOptionPane.YES_NO_OPTION);

				// 选择yes
				if (a == 0) {

					com3.removeActionListener(this);
					String str = JText1.getText();
					com3.removeItem(str);
					
					button3.setEnabled(false);
					button4.setEnabled(false);
					// 清空pl4面板内容
					te1.setText("");
					te2.setText("");
					te3.setText("");
					te4.setText("");
					te5.setText("");
					te6.setText("");
					te7.setText("");
					te8.setText("");
					te9.setText("");
					te10.setText("");
					area2.setText("");
					pl4.repaint();

					File s = new File("data/panel1.txt");
					try {
						BufferedWriter writer = new BufferedWriter(
								new FileWriter(s));

						for (int i = 0; arr[i][1] != null; i++) {

							if (arr[i][1].equals(JText1.getText())) {

								continue;
							}

							else {

								writer.append(arr[i][0]);
								writer.append(" ");
								writer.append(arr[i][1]);
								writer.append(" ");
								writer.append(arr[i][2]);
								writer.append(" ");
								writer.append(arr[i][3]);
								writer.append(" ");
								writer.append(arr[i][4]);
								writer.append(" ");
								writer.append(arr[i][5]);
								writer.append(" ");
								writer.append(arr[i][6]);
								writer.append(" ");
								writer.append(arr[i][7]);
								writer.append(" ");
								writer.append(arr[i][8]);
								writer.append(" ");
								writer.append(arr[i][9]);
								if (arr[i][10] == null) {

								} else {

									writer.append(" ");
									writer.append(arr[i][10]);
								}
								writer.newLine();
							}
						}
						writer.flush();
						writer.close();

						JOptionPane.showMessageDialog(null, "删除成功!", "删除",
								JOptionPane.INFORMATION_MESSAGE);

						com3.addActionListener(this);
						JText1.setText("");

					} catch (IOException e1) {
						// TODO Auto-generated catch block

						JOptionPane.showMessageDialog(null, "删除失败!", "删除",
								JOptionPane.CANCEL_OPTION);
					}
				}

			}
		}

		// 修改按钮
		else if (e.getSource().equals(button4)) {

			te1.setEditable(true);
			te2.setEditable(true);
			te3.setEditable(true);
			te4.setEditable(true);
			te5.setEditable(true);
			te6.setEditable(true);
			te7.setEditable(true);
			te8.setEditable(true);
			te9.setEditable(true);
			te10.setEditable(true);
			area2.setEditable(true);

			button4.setVisible(false);
			button5.setVisible(true);
		}

		// 保存按钮
		else if (e.getSource().equals(button5)) {

			File s = new File("data/panel1.txt");
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(s));

				for (int i = 0; arr[i][1] != null; i++) {

					if (arr[i][1].equals(JText1.getText())) {

						writer.append(te1.getText());
						writer.append(" ");
						writer.append(te2.getText());
						writer.append(" ");
						writer.append(te3.getText());
						writer.append(" ");
						writer.append(te4.getText());
						writer.append(" ");
						writer.append(te5.getText());
						writer.append(" ");
						writer.append(te6.getText());
						writer.append(" ");
						writer.append(te7.getText());
						writer.append(" ");
						writer.append(te8.getText());
						writer.append(" ");
						writer.append(te9.getText());
						writer.append(" ");
						writer.append(te10.getText());
						if (area2.getText().isEmpty()) {

						} else {

							writer.append(" ");
							writer.append(area2.getText());
						}
						writer.newLine();
					}

					else {

						writer.append(arr[i][0]);
						writer.append(" ");
						writer.append(arr[i][1]);
						writer.append(" ");
						writer.append(arr[i][2]);
						writer.append(" ");
						writer.append(arr[i][3]);
						writer.append(" ");
						writer.append(arr[i][4]);
						writer.append(" ");
						writer.append(arr[i][5]);
						writer.append(" ");
						writer.append(arr[i][6]);
						writer.append(" ");
						writer.append(arr[i][7]);
						writer.append(" ");
						writer.append(arr[i][8]);
						writer.append(" ");
						writer.append(arr[i][9]);
						if (arr[i][10] == null) {

						} else {

							writer.append(" ");
							writer.append(arr[i][10]);
						}
						writer.newLine();
					}
				}
				writer.flush();
				writer.close();

				JOptionPane.showMessageDialog(null, "修改成功!", "修改",
						JOptionPane.INFORMATION_MESSAGE);

				com3.addActionListener(this);
				button4.setVisible(true);
				button5.setVisible(false);

				te1.setEditable(false);
				te2.setEditable(false);
				te3.setEditable(false);
				te4.setEditable(false);
				te5.setEditable(false);
				te6.setEditable(false);
				te7.setEditable(false);
				te8.setEditable(false);
				te9.setEditable(false);
				te10.setEditable(false);
				area2.setEditable(false);

			} catch (IOException e1) {
				// TODO Auto-generated catch block

				JOptionPane.showMessageDialog(null, "修改失败!", "修改",
						JOptionPane.CANCEL_OPTION);
			}

		}
	}

}
