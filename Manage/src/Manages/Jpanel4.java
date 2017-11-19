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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Jpanel4 extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 公司员工管理界面面板
	private JPanel panel4, panel4_1, panel4_2, pl4;
	// 公司员工管理面板标签
	private JLabel jla1, jla2, jla3, jla4, jla5, jla6, jla7, jla8, jla9, jla10,
			jla11;
	// 公司员工管理界面按钮
	private JButton jbu1, jbu2, jbu3, jbu4, jbu5;
	// 公司员工管理界面JTextField
	private JTextField tex1, tex2, tex3, tex4, tex5, tex6;
	// 公司员工管理界面面板的JCheckBox和ButtonGroup
	private JCheckBox check1, check2;
	private ButtonGroup bg;
	// 业主车辆管理界面面板的JComboBox和JScrollBar
	private JComboBox<?> bo_1;
	private JScrollBar ba_1;
	// panel4_2面板的JTextField
	private JTextField te1, te2, te3, te4, te5, te6, te7, te8, te9;
	// panel4_2面板的JComboBox
	private JComboBox<String> box1;
	// panel4_2面板的JScrollBar
	private JScrollBar ba1;
	// panel4_2面板的按钮
	private JButton button1, button2, button3, button4;
	// panel4_2标签
	private JLabel label1, label2, label3, label4, label5, label6, label7,
			label8, label9;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Jpanel4() {
		// TODO Auto-generated constructor stub

		String s1[][] = new String[100][8];
		// 判断有多少人
		int numbers = 0;
		// 读取panel4文件
		try {

			int i = 0, j = 0;

			File s = new File("data/panel4.txt");
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
		for (int a = 0, b = 2; a < 100; a++) {

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

		// 公司员工管理界面面板
		panel4 = new JPanel() {

			/**
					 * 
					 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {

				ImageIcon images1 = new ImageIcon("image/1-1312251103424M.jpg");
				java.awt.Image im1 = images1.getImage();
				g.drawImage(im1, 0, 0, 650, 500, images1.getImageObserver());

				g.setColor(Color.darkGray);
				g.drawLine(0, 70, 650, 70);

				g.setColor(Color.darkGray);
				g.drawLine(130, 70, 130, 500);

				g.setColor(Color.gray);
				g.drawLine(0, 330, 130, 330);
			}

		};
		panel4.setLayout(null);
		panel4.setBounds(0, 0, 650, 500);

		panel4_1 = new JPanel();
		panel4_1.setLayout(null);
		panel4_1.setBounds(130, 70, 520, 430);
		panel4_1.setOpaque(false);

		jla1 = new JLabel("公司员工管理");
		jla1.setFont(new Font("楷体", Font.PLAIN, 30));
		jla1.setBounds(205, 20, 200, 30);

		jla2 = new JLabel(new ImageIcon(
				"image/arrow_right_27.399141630901px_1188313_easyicon.net.png"));
		jla2.setBounds(101, 105, 30, 20);

		jla3 = new JLabel(new ImageIcon(
				"image/arrow_right_27.399141630901px_1188313_easyicon.net.png"));
		jla3.setBounds(101, 165, 30, 20);
		jla3.setVisible(false);

		jla4 = new JLabel("员工类型:");
		jla4.setFont(new Font("楷体", Font.PLAIN, 22));
		jla4.setBounds(30, 20, 120, 30);

		ba_1 = new JScrollBar();

		bo_1 = new JComboBox(new Object[] { "办公室人员", "清洁工", "门卫", "其他" });
		bo_1.setBounds(130, 23, 120, 27);
		bo_1.setMaximumRowCount(3);
		bo_1.setFont(new Font("楷体", Font.PLAIN, 15));
		bo_1.setFocusable(false);

		jla5 = new JLabel("编号:");
		jla5.setFont(new Font("楷体", Font.PLAIN, 22));
		jla5.setBounds(270, 20, 100, 30);

		tex1 = new JTextField();
		tex1.setBounds(330, 23, 110, 30);

		jla6 = new JLabel("姓名:");
		jla6.setFont(new Font("楷体", Font.PLAIN, 22));
		jla6.setBounds(30, 80, 100, 30);

		tex2 = new JTextField();
		tex2.setBounds(90, 83, 110, 30);

		jla7 = new JLabel("性别:");
		jla7.setFont(new Font("楷体", Font.PLAIN, 22));
		jla7.setBounds(270, 80, 100, 30);

		check1 = new JCheckBox("男");
		check1.setBounds(330, 83, 60, 30);
		check1.setFocusable(false);
		check1.setFont(new Font("楷体", Font.PLAIN, 16));

		check2 = new JCheckBox("女");
		check2.setBounds(390, 83, 60, 30);
		check2.setFocusable(false);
		check2.setFont(new Font("楷体", Font.PLAIN, 16));

		bg = new ButtonGroup();

		jla8 = new JLabel("电话:");
		jla8.setFont(new Font("楷体", Font.PLAIN, 22));
		jla8.setBounds(30, 140, 100, 30);

		tex3 = new JTextField();
		tex3.setBounds(90, 143, 110, 30);

		jla9 = new JLabel("工资:");
		jla9.setFont(new Font("楷体", Font.PLAIN, 22));
		jla9.setBounds(270, 140, 100, 30);

		tex4 = new JTextField();
		tex4.setBounds(330, 143, 110, 30);

		jla10 = new JLabel("身份证号码:");
		jla10.setFont(new Font("楷体", Font.PLAIN, 22));
		jla10.setBounds(30, 200, 200, 30);

		tex5 = new JTextField();
		tex5.setBounds(150, 203, 200, 30);

		jla11 = new JLabel("住址:");
		jla11.setFont(new Font("楷体", Font.PLAIN, 22));
		jla11.setBounds(30, 260, 100, 30);

		tex6 = new JTextField();
		tex6.setBounds(90, 263, 300, 30);

		jbu1 = new JButton("录入");
		jbu1.setBounds(10, 100, 90, 30);
		jbu1.setFont(new Font("华文彩云", Font.PLAIN, 15));
		jbu1.setForeground(Color.lightGray);
		jbu1.setFocusPainted(false);
		jbu1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jbu1.addActionListener(this);

		jbu2 = new JButton("查看");
		jbu2.setBounds(10, 160, 90, 30);
		jbu2.setFont(new Font("华文彩云", Font.PLAIN, 15));
		jbu2.setForeground(Color.lightGray);
		jbu2.setFocusPainted(false);
		jbu2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jbu2.addActionListener(this);

		jbu3 = new JButton("返回");
		jbu3.setBounds(10, 420, 100, 30);
		jbu3.setFont(new Font("华文彩云", Font.PLAIN, 15));
		jbu3.setForeground(Color.black);
		jbu3.setFocusPainted(false);
		jbu3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jbu3.addActionListener(this);

		jbu4 = new JButton("保存");
		jbu4.setBounds(135, 335, 100, 30);
		jbu4.setFont(new Font("华文彩云", Font.PLAIN, 15));
		jbu4.setForeground(Color.black);
		jbu4.setFocusPainted(false);
		jbu4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jbu4.addActionListener(this);

		jbu5 = new JButton("清空");
		jbu5.setBounds(255, 335, 100, 30);
		jbu5.setFont(new Font("华文彩云", Font.PLAIN, 15));
		jbu5.setForeground(Color.black);
		jbu5.setFocusPainted(false);
		jbu5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jbu5.addActionListener(this);

		panel4_2 = new JPanel();
		panel4_2.setLayout(null);
		panel4_2.setBounds(130, 70, 520, 430);
		panel4_2.setOpaque(false);

		label1 = new JLabel("请输入员工的姓名:");
		label1.setBounds(10, 20, 200, 30);
		label1.setFont(new Font("楷体", Font.PLAIN, 23));

		ba1 = new JScrollBar();

		box1 = new JComboBox<String>(s2);
		box1.setBounds(215, 20, 140, 30);
		box1.setMaximumRowCount(3);
		box1.setFont(new Font("楷体", Font.PLAIN, 15));
		box1.setFocusable(false);
		box1.addActionListener(this);

		te1 = new JTextField();
		te1.setBounds(215, 20, 120, 30);

		button1 = new JButton("确定");
		button1.setBounds(370, 20, 90, 30);
		button1.setFont(new Font("华文彩云", Font.PLAIN, 15));
		button1.setForeground(Color.black);
		button1.setFocusPainted(false);
		button1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button1.addActionListener(this);

		pl4 = new JPanel() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {

				g.drawLine(20, 30, 460, 30);
				g.drawLine(20, 285, 460, 285);
				g.drawLine(20, 30, 20, 285);
				g.drawLine(460, 30, 460, 285);

				g.drawLine(20, 80, 460, 80);
				g.drawLine(20, 130, 460, 130);
				g.drawLine(20, 180, 460, 180);
				g.drawLine(20, 230, 460, 230);
				g.drawLine(230, 30, 230, 180);
			}
		};
		pl4.setLayout(null);
		pl4.setBounds(0, 56, 520, 430);
		pl4.setOpaque(false);

		button2 = new JButton("删除");
		button2.setBounds(140, 300, 90, 30);
		button2.setFont(new Font("华文彩云", Font.PLAIN, 15));
		button2.setForeground(Color.black);
		button2.setFocusPainted(false);
		button2.setEnabled(false);
		button2.setToolTipText("删除此人信息");
		button2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button2.addActionListener(this);

		button3 = new JButton("修改");
		button3.setBounds(250, 300, 90, 30);
		button3.setFont(new Font("华文彩云", Font.PLAIN, 15));
		button3.setForeground(Color.black);
		button3.setFocusPainted(false);
		button3.setEnabled(false);
		button3.setToolTipText("修改此人信息");
		button3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button3.addActionListener(this);

		button4 = new JButton("保存");
		button4.setBounds(250, 300, 90, 30);
		button4.setFont(new Font("华文彩云", Font.PLAIN, 15));
		button4.setForeground(Color.black);
		button4.setFocusPainted(false);
		button4.setVisible(false);
		button4.setToolTipText("保存此人信息");
		button4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button4.addActionListener(this);

		label2 = new JLabel("员工类型:");
		label2.setFont(new Font("楷体", Font.PLAIN, 20));
		label2.setBounds(30, 40, 100, 30);

		label3 = new JLabel("编号:");
		label3.setFont(new Font("楷体", Font.PLAIN, 20));
		label3.setBounds(240, 40, 100, 30);

		label4 = new JLabel("姓名:");
		label4.setFont(new Font("楷体", Font.PLAIN, 20));
		label4.setBounds(30, 90, 100, 30);

		label5 = new JLabel("性别:");
		label5.setFont(new Font("楷体", Font.PLAIN, 20));
		label5.setBounds(240, 90, 100, 30);

		label6 = new JLabel("电话:");
		label6.setFont(new Font("楷体", Font.PLAIN, 20));
		label6.setBounds(30, 140, 100, 30);

		label7 = new JLabel("工资:");
		label7.setFont(new Font("楷体", Font.PLAIN, 20));
		label7.setBounds(240, 140, 100, 30);

		label8 = new JLabel("身份证号码:");
		label8.setFont(new Font("楷体", Font.PLAIN, 20));
		label8.setBounds(30, 190, 150, 30);

		label9 = new JLabel("住址:");
		label9.setFont(new Font("楷体", Font.PLAIN, 20));
		label9.setBounds(30, 240, 100, 30);

		te2 = new JTextField();
		te2.setBounds(120, 35, 110, 40);
		te2.setFont(new Font("楷体", Font.PLAIN, 20));
		te2.setBorder(new EmptyBorder(0, 0, 0, 0));
		te2.setOpaque(false);
		te2.setEditable(false);

		te3 = new JTextField();
		te3.setBounds(310, 35, 110, 40);
		te3.setFont(new Font("楷体", Font.PLAIN, 20));
		te3.setBorder(new EmptyBorder(0, 0, 0, 0));
		te3.setOpaque(false);
		te3.setEditable(false);

		te4 = new JTextField();
		te4.setBounds(100, 85, 110, 40);
		te4.setFont(new Font("楷体", Font.PLAIN, 20));
		te4.setBorder(new EmptyBorder(0, 0, 0, 0));
		te4.setOpaque(false);
		te4.setEditable(false);

		te5 = new JTextField();
		te5.setBounds(310, 85, 110, 40);
		te5.setFont(new Font("楷体", Font.PLAIN, 20));
		te5.setBorder(new EmptyBorder(0, 0, 0, 0));
		te5.setOpaque(false);
		te5.setEditable(false);

		te6 = new JTextField();
		te6.setBounds(100, 135, 110, 40);
		te6.setFont(new Font("楷体", Font.PLAIN, 20));
		te6.setBorder(new EmptyBorder(0, 0, 0, 0));
		te6.setOpaque(false);
		te6.setEditable(false);

		te7 = new JTextField();
		te7.setBounds(310, 135, 110, 40);
		te7.setFont(new Font("楷体", Font.PLAIN, 20));
		te7.setBorder(new EmptyBorder(0, 0, 0, 0));
		te7.setOpaque(false);
		te7.setEditable(false);

		te8 = new JTextField();
		te8.setBounds(155, 185, 250, 40);
		te8.setFont(new Font("楷体", Font.PLAIN, 20));
		te8.setBorder(new EmptyBorder(0, 0, 0, 0));
		te8.setOpaque(false);
		te8.setEditable(false);

		te9 = new JTextField();
		te9.setBounds(100, 235, 250, 40);
		te9.setFont(new Font("楷体", Font.PLAIN, 20));
		te9.setBorder(new EmptyBorder(0, 0, 0, 0));
		te9.setOpaque(false);
		te9.setEditable(false);

		panel4.add(jbu1);
		panel4.add(jbu2);
		panel4.add(jbu3);
		panel4.add(jla1);
		panel4.add(panel4_1);
		panel4.add(jla2);
		panel4.add(jla3);
		panel4_1.add(jla4);
		panel4_1.add(jla5);
		panel4_1.add(jla6);
		panel4_1.add(jla7);
		panel4_1.add(jla8);
		panel4_1.add(jla9);
		panel4_1.add(jla10);
		panel4_1.add(jla11);
		bo_1.add(ba_1);
		panel4_1.add(bo_1);
		panel4_1.add(tex1);
		panel4_1.add(tex2);
		panel4_1.add(tex3);
		panel4_1.add(tex4);
		panel4_1.add(tex5);
		panel4_1.add(tex6);
		bg.add(check1);
		bg.add(check2);
		panel4_1.add(check1);
		panel4_1.add(check2);
		panel4_1.add(jbu4);
		panel4_1.add(jbu5);
		panel4_2.add(label1);
		panel4_2.add(te1);
		panel4_2.add(button1);
		box1.add(ba1);
		panel4_2.add(box1);
		panel4_2.add(pl4);
		pl4.add(label2);
		pl4.add(label3);
		pl4.add(label4);
		pl4.add(label5);
		pl4.add(label6);
		pl4.add(label7);
		pl4.add(label8);
		pl4.add(label9);
		pl4.add(te2);
		pl4.add(te3);
		pl4.add(te4);
		pl4.add(te5);
		pl4.add(te6);
		pl4.add(te7);
		pl4.add(te8);
		pl4.add(te9);
		pl4.add(button2);
		pl4.add(button3);
		pl4.add(button4);

		this.add(panel4);

		this.setSize(650, 500);
		this.setTitle("物主信息管理--员工信息");
		this.setIconImage((new ImageIcon(
				"image/Company_house_48px_520461_easyicon.net.png")).getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String arr[][] = new String[100][8];
		int num = 0;
		boolean b = false;

		// 读取panel4文件
		try {

			int i = 0, j = 0;

			File s = new File("data/panel4.txt");
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
		for (int a = 0, c = 2; a < 100; a++) {

			ss[a] = arr[a][c];
			if (ss[a] == null) {

				break;
			}
		}

		// 公司员工管理面板——返回按钮
		if (e.getSource().equals(jbu3)) {

			new MyManages();
			this.dispose();
		}

		// 公司员工管理界面面板--录入按钮
		else if (e.getSource().equals(jbu1)) {

			jla2.setVisible(true);
			jla3.setVisible(false);

			panel4.remove(panel4_2);
			panel4.add(panel4_1);
			panel4.validate();
			panel4.repaint();
		}

		// 公司员工管理界面面板--查看按钮
		else if (e.getSource().equals(jbu2)) {

			jla2.setVisible(false);
			jla3.setVisible(true);

			panel4.remove(panel4_1);
			panel4.add(panel4_2);
			panel4.validate();
			panel4.repaint();
		}

		// 保存按钮
		else if (e.getSource().equals(jbu4)) {

			if (tex1.getText().isEmpty() | tex2.getText().isEmpty()
					| tex3.getText().isEmpty() | tex4.getText().isEmpty()
					| tex5.getText().isEmpty() | tex6.getText().isEmpty()
					| check1.getText().isEmpty() | check2.getText().isEmpty()) {

				JOptionPane.showMessageDialog(null, "请输入完整的信息!", "警告",
						JOptionPane.CANCEL_OPTION);
			}

			else {

				File s = new File("data/panel4.txt");
				try {
					BufferedWriter writer = new BufferedWriter(new FileWriter(
							s, true));

					writer.append(bo_1.getSelectedItem().toString());
					writer.append(" ");
					writer.append(tex1.getText());
					writer.append(" ");
					writer.append(tex2.getText());
					if (check1.isSelected()) {

						writer.append(" ");
						writer.append(check1.getText());
					} else {

						writer.append(" ");
						writer.append(check2.getText());
					}
					writer.append(" ");
					writer.append(tex3.getText());
					writer.append(" ");
					writer.append(tex4.getText());
					writer.append(" ");
					writer.append(tex5.getText());
					writer.append(" ");
					writer.append(tex6.getText());
					writer.newLine();
					writer.flush();
					writer.close();

					JOptionPane.showMessageDialog(null, "保存成功!", "保存",
							JOptionPane.INFORMATION_MESSAGE);

					// box1添加子项
					box1.addItem(tex2.getText());

				} catch (IOException e1) {
					// TODO Auto-generated catch block

					JOptionPane.showMessageDialog(null, "保存失败!", "保存",
							JOptionPane.CANCEL_OPTION);
				}
			}
		}

		// 清空按钮
		else if (e.getSource().equals(jbu5)) {

			int a = 1;
			a = JOptionPane.showConfirmDialog(null, "是否清空所有内容?", "提示",
					JOptionPane.YES_NO_OPTION);

			// 选择yes
			if (a == 0) {

				tex1.setText("");
				tex2.setText("");
				tex3.setText("");
				tex4.setText("");
				tex5.setText("");
				tex6.setText("");
			}
		}

		//从下拉框box1中获取信息
		else if (e.getSource().equals(box1)) {

			String s = box1.getSelectedItem().toString();
			te1.setText(s);
		}

		//确定查询按钮
		else if (e.getSource().equals(button1)) {

			// 清空pl4上的内容
			te2.setText("");
			te3.setText("");
			te4.setText("");
			te5.setText("");
			te6.setText("");
			te7.setText("");
			te8.setText("");
			te9.setText("");

			for (int a = 0; a < 100; a++) {

				if (te1.getText().equals(ss[a])) {

					b = true;
					num = a;
					break;
				}

			}

			if (b == false) {

				JOptionPane.showMessageDialog(null, "查无此人!", "提示",
						JOptionPane.CANCEL_OPTION);

				te1.setText("");

			}

			else {

				te2.setText(arr[num][0]);
				te3.setText(arr[num][1]);
				te4.setText(arr[num][2]);
				te5.setText(arr[num][3]);
				te6.setText(arr[num][4]);
				te7.setText(arr[num][5]);
				te8.setText(arr[num][6]);
				te9.setText(arr[num][7]);

				pl4.repaint();

				button2.setEnabled(true);
				button3.setEnabled(true);
			}

		}

		//删除按钮
		else if (e.getSource().equals(button2)) {

			if (te1.getText().isEmpty()) {

				JOptionPane.showMessageDialog(null, "请确定要删除员工的姓名!", "提示",
						JOptionPane.CANCEL_OPTION);
			}

			else {

				int a = 1;
				a = JOptionPane.showConfirmDialog(null, "是否删除此人信息?", "提示",
						JOptionPane.YES_NO_OPTION);

				// 选择yes
				if (a == 0) {

					box1.removeActionListener(this);
					String str = te1.getText();
					box1.removeItem(str);

					button2.setEnabled(false);
					// 清空pl4上的内容
					te2.setText("");
					te3.setText("");
					te4.setText("");
					te5.setText("");
					te6.setText("");
					te7.setText("");
					te8.setText("");
					te9.setText("");
					pl4.repaint();

					File s = new File("data/panel4.txt");
					try {
						BufferedWriter writer = new BufferedWriter(
								new FileWriter(s));

						for (int i = 0; arr[i][1] != null; i++) {

							if (arr[i][1].equals(te1.getText())) {

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
								writer.newLine();
							}
						}
						writer.flush();
						writer.close();

						JOptionPane.showMessageDialog(null, "删除成功!", "删除",
								JOptionPane.INFORMATION_MESSAGE);

						box1.addActionListener(this);
						te1.setText("");

					} catch (IOException e1) {
						// TODO Auto-generated catch block

						JOptionPane.showMessageDialog(null, "删除失败!", "删除",
								JOptionPane.CANCEL_OPTION);
					}
				}

			}
		}

		// 修改button3按钮
		else if (e.getSource().equals(button3)) {

			te2.setEditable(true);
			te3.setEditable(true);
			te4.setEditable(true);
			te5.setEditable(true);
			te6.setEditable(true);
			te7.setEditable(true);
			te8.setEditable(true);
			te9.setEditable(true);

			button3.setVisible(false);
			button4.setVisible(true);
		}

		// 保存button4按钮
		else if (e.getSource().equals(button4)) {

			File s = new File("data/panel4.txt");
			try {
				BufferedWriter write = new BufferedWriter(new FileWriter(s));

				for (int i = 0; arr[i][2] != null; i++) {

					if (arr[i][2].equals(te1.getText())) {

						write.append(te2.getText());
						write.append(" ");
						write.append(te3.getText());
						write.append(" ");
						write.append(te4.getText());
						write.append(" ");
						write.append(te5.getText());
						write.append(" ");
						write.append(te6.getText());
						write.append(" ");
						write.append(te7.getText());
						write.append(" ");
						write.append(te8.getText());
						write.append(" ");
						write.append(te9.getText());
						write.newLine();
					}

					else {

						write.append(arr[i][0]);
						write.append(" ");
						write.append(arr[i][1]);
						write.append(" ");
						write.append(arr[i][2]);
						write.append(" ");
						write.append(arr[i][3]);
						write.append(" ");
						write.append(arr[i][4]);
						write.append(" ");
						write.append(arr[i][5]);
						write.append(" ");
						write.append(arr[i][6]);
						write.append(" ");
						write.append(arr[i][7]);
						write.newLine();
					}
				}
				write.flush();
				write.close();

				JOptionPane.showMessageDialog(null, "修改成功!", "修改",
						JOptionPane.INFORMATION_MESSAGE);

				box1.addActionListener(this);
				button3.setVisible(true);
				button4.setVisible(false);

				te2.setEditable(false);
				te3.setEditable(false);
				te4.setEditable(false);
				te5.setEditable(false);
				te6.setEditable(false);
				te7.setEditable(false);
				te8.setEditable(false);
				te9.setEditable(false);

			} catch (IOException e1) {
				// TODO Auto-generated catch block

				JOptionPane.showMessageDialog(null, "修改失败!", "修改",
						JOptionPane.CANCEL_OPTION);
			}

		}

	}

}
