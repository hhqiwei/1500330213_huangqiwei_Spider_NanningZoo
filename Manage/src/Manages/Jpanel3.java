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

public class Jpanel3 extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 业主交费情况界面面板
	private JPanel panel3, panel3_1, panel3_2, pl3;
	// 业主交费情况界面按钮
	private JButton butt1, butt2, butt3, butt4, butt5;
	
	// 业主交费情况面板标签
	private JLabel JLabel1, JLabel2, JLabel3, JLabel4, JLabel5, JLabel6,
			JLabel7, JLabel8, JLabel9, JLabel10, JLabel11, JLabel12, JLabel13;
	
	// 业主交费情况面板JTextField
	private JTextField text_1, text_2, text_3, text_4, text_5, text_6, text_7;
	// 业主交费界面JComboBox
	private JComboBox<?> com_1;
	// 业主交费界面面板的JCheckBox和ButtonGroup
	private JCheckBox box_1, box_2;
	private ButtonGroup group1;
	// panel3_2面板的标签
	private JLabel label1, label2, label3, label4, label5, label6, label7,
			label8, label9, label10, label11;
	// panel3_2面板的JTextField
	private JTextField te1, te2, te3, te4, te5, te6, te7, te8, te9, te10;
	// panel3_2面板的JComboBox
	private JComboBox<String> box1;
	// panel3_2面板的JScrollBar
	private JScrollBar ba1;
	// panel3_2面板的按钮
	private JButton button1, button2, button3, button4;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Jpanel3() {
		// TODO Auto-generated constructor stub

		String s1[][] = new String[100][9];
		int numbers = 0;
		// 读取panel3文件
		try {

			int i = 0, j = 0;

			File s = new File("data/panel3.txt");
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

		// 业主交费情况界面面板
		panel3 = new JPanel() {

			/**
					 * 
					 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {

				ImageIcon images1 = new ImageIcon("image/2011102511180935.jpg");
				java.awt.Image im1 = images1.getImage();
				g.drawImage(im1, 0, 0, 650, 500, images1.getImageObserver());

				g.setColor(Color.darkGray);
				g.drawLine(130, 0, 130, 500);

				g.setColor(Color.gray);
				g.drawLine(0, 130, 130, 130);
				
				g.setColor(Color.gray);
				g.drawLine(0, 400, 130, 400);

			}

		};
		panel3.setLayout(null);
		panel3.setBounds(0, 0, 650, 500);

		butt1 = new JButton("返回");
		butt1.setBounds(10, 420, 100, 30);
		butt1.setFont(new Font("华文彩云", Font.PLAIN, 15));
		butt1.setForeground(Color.black);
		butt1.setFocusPainted(false);
		butt1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		butt1.addActionListener(this);

		butt2 = new JButton("录入信息");
		butt2.setBounds(10, 30, 90, 30);
		butt2.setFont(new Font("华文彩云", Font.PLAIN, 15));
		butt2.setForeground(Color.lightGray);
		butt2.setFocusPainted(false);
		butt2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		butt2.addActionListener(this);

		butt3 = new JButton("查看信息");
		butt3.setBounds(10, 80, 90, 30);
		butt3.setFont(new Font("华文彩云", Font.PLAIN, 15));
		butt3.setForeground(Color.lightGray);
		butt3.setFocusPainted(false);
		butt3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		butt3.addActionListener(this);

		JLabel1 = new JLabel(new ImageIcon(
				"image/arrow_right_27.399141630901px_1188313_easyicon.net.png"));
		JLabel1.setBounds(101, 35, 30, 20);

		JLabel2 = new JLabel(new ImageIcon(
				"image/arrow_right_27.399141630901px_1188313_easyicon.net.png"));
		JLabel2.setBounds(101, 85, 30, 20);
		JLabel2.setVisible(false);

		// 业主交费情况面板panel3_1
		panel3_1 = new JPanel();
		panel3_1.setLayout(null);
		panel3_1.setBounds(130, 0, 520, 500);
		panel3_1.setOpaque(false);

		JLabel3 = new JLabel("业主交费管理");
		JLabel3.setFont(new Font("楷体", Font.PLAIN, 30));
		JLabel3.setBounds(140, 30, 200, 40);

		JLabel4 = new JLabel("业主编号:");
		JLabel4.setFont(new Font("楷体", Font.PLAIN, 20));
		JLabel4.setBounds(30, 115, 100, 30);

		text_1 = new JTextField();
		text_1.setBounds(120, 115, 120, 30);

		JLabel5 = new JLabel("业主姓名:");
		JLabel5.setFont(new Font("楷体", Font.PLAIN, 20));
		JLabel5.setBounds(250, 115, 100, 30);

		text_2 = new JTextField();
		text_2.setBounds(350, 115, 130, 30);

		JLabel6 = new JLabel("交费标准:");
		JLabel6.setFont(new Font("楷体", Font.PLAIN, 20));
		JLabel6.setBounds(30, 170, 100, 30);

		com_1 = new JComboBox(new Object[] { "每个月一次", "两个月一次", "三个月一次" });
		com_1.setBounds(120, 170, 120, 30);
		com_1.setMaximumRowCount(3);
		com_1.setFont(new Font("楷体", Font.PLAIN, 15));
		com_1.setFocusable(false);

		JLabel7 = new JLabel("交费金额:");
		JLabel7.setFont(new Font("楷体", Font.PLAIN, 20));
		JLabel7.setBounds(250, 170, 100, 30);

		text_3 = new JTextField();
		text_3.setBounds(350, 170, 130, 30);

		JLabel8 = new JLabel("欠费金额:");
		JLabel8.setFont(new Font("楷体", Font.PLAIN, 20));
		JLabel8.setBounds(30, 220, 100, 30);

		text_4 = new JTextField();
		text_4.setBounds(120, 220, 120, 30);

		JLabel9 = new JLabel("交费时间:");
		JLabel9.setFont(new Font("楷体", Font.PLAIN, 20));
		JLabel9.setBounds(30, 270, 100, 30);

		text_5 = new JTextField();
		text_5.setBounds(120, 270, 80, 30);
		text_5.setHorizontalAlignment(JTextField.RIGHT);
		text_5.setToolTipText("格式:xxxx");

		JLabel10 = new JLabel("年");
		JLabel10.setFont(new Font("楷体", Font.PLAIN, 20));
		JLabel10.setBounds(200, 270, 30, 30);

		text_6 = new JTextField();
		text_6.setBounds(220, 270, 70, 30);
		text_6.setHorizontalAlignment(JTextField.RIGHT);
		text_6.setToolTipText("格式:x");

		JLabel11 = new JLabel("月");
		JLabel11.setFont(new Font("楷体", Font.PLAIN, 20));
		JLabel11.setBounds(295, 270, 30, 30);

		text_7 = new JTextField();
		text_7.setBounds(315, 270, 70, 30);
		text_7.setHorizontalAlignment(JTextField.RIGHT);
		text_7.setToolTipText("格式:xx");

		JLabel12 = new JLabel("日");
		JLabel12.setFont(new Font("楷体", Font.PLAIN, 20));
		JLabel12.setBounds(390, 270, 30, 30);

		JLabel13 = new JLabel("是否设置提醒:");
		JLabel13.setFont(new Font("楷体", Font.PLAIN, 25));
		JLabel13.setBounds(80, 335, 200, 30);

		box_1 = new JCheckBox("是");
		box_1.setBounds(250, 335, 60, 30);
		box_1.setFocusable(false);
		box_1.setFont(new Font("楷体", Font.PLAIN, 16));
		box_1.setSelected(true);
		box_1.addActionListener(this);

		box_2 = new JCheckBox("否");
		box_2.setBounds(320, 335, 60, 30);
		box_2.setFocusable(false);
		box_2.setFont(new Font("楷体", Font.PLAIN, 16));

		group1 = new ButtonGroup();

		butt4 = new JButton("保存");
		butt4.setBounds(135, 400, 90, 30);
		butt4.setFont(new Font("华文彩云", Font.PLAIN, 15));
		butt4.setForeground(Color.gray);
		butt4.setFocusPainted(false);
		butt4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		butt4.addActionListener(this);
		
		butt5 = new JButton("清空");
		butt5.setBounds(255, 400, 90, 30);
		butt5.setFont(new Font("华文彩云", Font.PLAIN, 15));
		butt5.setForeground(Color.gray);
		butt5.setFocusPainted(false);
		butt5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		butt5.addActionListener(this);

		// 业主交费情况面板panel3_1
		panel3_2 = new JPanel();
		panel3_2.setLayout(null);
		panel3_2.setBounds(130, 0, 520, 500);
		panel3_2.setOpaque(false);

		label1 = new JLabel("请输入业主的姓名:");
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

		pl3 = new JPanel() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {

				g.drawLine(20, 30, 460, 30);
				g.drawLine(20, 290, 460, 290);
				g.drawLine(20, 30, 20, 290);
				g.drawLine(460, 30, 460, 290);

				g.drawLine(20, 80, 460, 80);
				g.drawLine(20, 130, 460, 130);
				g.drawLine(20, 180, 460, 180);
				g.drawLine(20, 230, 460, 230);
				g.drawLine(230, 30, 230, 130);
			}
		};
		pl3.setLayout(null);
		pl3.setBounds(0, 56, 520, 430);
		pl3.setOpaque(false);

		button2 = new JButton("删除");
		button2.setBounds(140, 320, 90, 30);
		button2.setFont(new Font("华文彩云", Font.PLAIN, 15));
		button2.setForeground(Color.black);
		button2.setFocusPainted(false);
		button2.setEnabled(false);
		button2.setToolTipText("删除此人信息");
		button2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button2.addActionListener(this);

		button3 = new JButton("修改");
		button3.setBounds(250, 320, 90, 30);
		button3.setFont(new Font("华文彩云", Font.PLAIN, 15));
		button3.setForeground(Color.black);
		button3.setFocusPainted(false);
		button3.setEnabled(false);
		button3.setToolTipText("修改此人信息");
		button3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button3.addActionListener(this);

		button4 = new JButton("保存");
		button4.setBounds(250, 320, 90, 30);
		button4.setFont(new Font("华文彩云", Font.PLAIN, 15));
		button4.setForeground(Color.black);
		button4.setFocusPainted(false);
		button4.setVisible(false);
		button4.setToolTipText("保存此人信息");
		button4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button4.addActionListener(this);

		label2 = new JLabel("业主编号:");
		label2.setFont(new Font("楷体", Font.PLAIN, 20));
		label2.setBounds(30, 40, 100, 30);

		label3 = new JLabel("业主姓名:");
		label3.setFont(new Font("楷体", Font.PLAIN, 20));
		label3.setBounds(240, 40, 100, 30);

		label4 = new JLabel("交费标准:");
		label4.setFont(new Font("楷体", Font.PLAIN, 20));
		label4.setBounds(30, 90, 100, 30);

		label5 = new JLabel("交费金额:");
		label5.setFont(new Font("楷体", Font.PLAIN, 20));
		label5.setBounds(240, 90, 100, 30);

		label6 = new JLabel("欠费金额:");
		label6.setFont(new Font("楷体", Font.PLAIN, 20));
		label6.setBounds(30, 140, 100, 30);

		label7 = new JLabel("交费时间:");
		label7.setFont(new Font("楷体", Font.PLAIN, 20));
		label7.setBounds(30, 190, 100, 30);
		
		label8 = new JLabel("年");
		label8.setFont(new Font("楷体", Font.PLAIN, 20));
		label8.setBounds(165, 190, 30, 30);
		
		label9 = new JLabel("月");
		label9.setFont(new Font("楷体", Font.PLAIN, 20));
		label9.setBounds(210, 190, 30, 30);
		
		label10 = new JLabel("日");
		label10.setFont(new Font("楷体", Font.PLAIN, 20));
		label10.setBounds(250, 190, 30, 30);

		label11 = new JLabel("是否设置提醒:");
		label11.setFont(new Font("楷体", Font.PLAIN, 20));
		label11.setBounds(30, 240, 150, 30);

		te2 = new JTextField();
		te2.setBounds(120, 35, 110, 40);
		te2.setFont(new Font("楷体", Font.PLAIN, 20));
		te2.setBorder(new EmptyBorder(0, 0, 0, 0));
		te2.setOpaque(false);
		te2.setEditable(false);

		te3 = new JTextField();
		te3.setBounds(330, 35, 110, 40);
		te3.setFont(new Font("楷体", Font.PLAIN, 20));
		te3.setBorder(new EmptyBorder(0, 0, 0, 0));
		te3.setOpaque(false);
		te3.setEditable(false);

		te4 = new JTextField();
		te4.setBounds(120, 85, 110, 40);
		te4.setFont(new Font("楷体", Font.PLAIN, 20));
		te4.setBorder(new EmptyBorder(0, 0, 0, 0));
		te4.setOpaque(false);
		te4.setEditable(false);

		te5 = new JTextField();
		te5.setBounds(330, 85, 110, 40);
		te5.setFont(new Font("楷体", Font.PLAIN, 20));
		te5.setBorder(new EmptyBorder(0, 0, 0, 0));
		te5.setOpaque(false);
		te5.setEditable(false);

		te6 = new JTextField();
		te6.setBounds(120, 135, 110, 40);
		te6.setFont(new Font("楷体", Font.PLAIN, 20));
		te6.setBorder(new EmptyBorder(0, 0, 0, 0));
		te6.setOpaque(false);
		te6.setEditable(false);

		te7 = new JTextField();
		te7.setBounds(120, 185, 60, 40);
		te7.setFont(new Font("楷体", Font.PLAIN, 20));
		te7.setBorder(new EmptyBorder(0, 0, 0, 0));
		te7.setOpaque(false);
		te7.setEditable(false);
		
		te8 = new JTextField();
		te8.setBounds(183, 185, 60, 40);
		te8.setFont(new Font("楷体", Font.PLAIN, 20));
		te8.setBorder(new EmptyBorder(0, 0, 0, 0));
		te8.setOpaque(false);
		te8.setEditable(false);
		
		te9 = new JTextField();
		te9.setBounds(230, 185, 60, 40);
		te9.setFont(new Font("楷体", Font.PLAIN, 20));
		te9.setBorder(new EmptyBorder(0, 0, 0, 0));
		te9.setOpaque(false);
		te9.setEditable(false);

		te10 = new JTextField();
		te10.setBounds(165, 235, 200, 40);
		te10.setFont(new Font("楷体", Font.PLAIN, 20));
		te10.setBorder(new EmptyBorder(0, 0, 0, 0));
		te10.setOpaque(false);
		te10.setEditable(false);

		panel3.add(butt1);
		panel3.add(butt2);
		panel3.add(butt3);
		panel3.add(JLabel1);
		panel3.add(JLabel2);
		panel3.add(panel3_1);
		panel3_1.add(JLabel3);
		panel3_1.add(JLabel4);
		panel3_1.add(JLabel5);
		panel3_1.add(JLabel6);
		panel3_1.add(JLabel7);
		panel3_1.add(JLabel8);
		panel3_1.add(JLabel9);
		panel3_1.add(JLabel10);
		panel3_1.add(JLabel11);
		panel3_1.add(JLabel12);
		panel3_1.add(JLabel13);
		panel3_1.add(butt4);
		panel3_1.add(butt5);
		panel3_1.add(text_1);
		panel3_1.add(text_2);
		panel3_1.add(text_3);
		panel3_1.add(text_4);
		panel3_1.add(text_5);
		panel3_1.add(text_6);
		panel3_1.add(text_7);
		panel3_1.add(com_1);
		group1.add(box_1);
		group1.add(box_2);
		panel3_1.add(box_1);
		panel3_1.add(box_2);
		panel3_2.add(label1);
		panel3_2.add(te1);
		box1.add(ba1);
		panel3_2.add(box1);
		panel3_2.add(button1);
		panel3_2.add(pl3);
		pl3.add(button2);
		pl3.add(button3);
		pl3.add(button4);
		pl3.add(label2);
		pl3.add(label3);
		pl3.add(label4);
		pl3.add(label5);
		pl3.add(label6);
		pl3.add(label7);
		pl3.add(label8);
		pl3.add(label9);
		pl3.add(label10);
		pl3.add(label11);
		pl3.add(te2);
		pl3.add(te3);
		pl3.add(te4);
		pl3.add(te5);
		pl3.add(te6);
		pl3.add(te7);
		pl3.add(te8);
		pl3.add(te9);
		pl3.add(te10);

		this.add(panel3);

		this.setSize(650, 500);
		this.setTitle("物主信息管理--业主交费");
		this.setIconImage((new ImageIcon(
				"image/Company_house_48px_520461_easyicon.net.png")).getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String arr[][] = new String[100][9];
		int num = 0;
		boolean b = false;

		// 读取panel3文件
		try {

			int i = 0, j = 0;

			File s = new File("data/panel3.txt");
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
		for (int a = 0, c = 1; a < 100; a++) {

			ss[a] = arr[a][c];
			if (ss[a] == null) {

				break;
			}
		}

		// 业主交费界面面板--返回按钮
		if (e.getSource().equals(butt1)) {

			new MyManages();
			this.dispose();
		}

		// 业主交费界面面板--录入按钮
		else if (e.getSource().equals(butt2)) {

			JLabel1.setVisible(true);
			JLabel2.setVisible(false);

			panel3.remove(panel3_2);
			panel3.add(panel3_1);
			panel3.validate();
			panel3.repaint();
		}

		// 业主交费界面面板--查看按钮
		else if (e.getSource().equals(butt3)) {

			JLabel1.setVisible(false);
			JLabel2.setVisible(true);

			button2.setEnabled(false);
			button3.setEnabled(false);

			panel3.remove(panel3_1);
			panel3.add(panel3_2);
			panel3.validate();
			panel3.repaint();
		}

		// 保存按钮
		else if (e.getSource().equals(butt4)) {

			if (text_1.getText().isEmpty() | text_2.getText().isEmpty()
					| text_3.getText().isEmpty() | text_4.getText().isEmpty()
					| text_5.getText().isEmpty() | text_6.getText().isEmpty()
					| text_7.getText().isEmpty()) {

				JOptionPane.showMessageDialog(null, "请输入完整的信息!", "警告",
						JOptionPane.CANCEL_OPTION);
			}

			else {

				File s = new File("data/panel3.txt");
				try {
					BufferedWriter writer = new BufferedWriter(new FileWriter(
							s, true));

					writer.append(text_1.getText());
					writer.append(" ");
					writer.append(text_2.getText());
					writer.append(" ");
					writer.append(com_1.getSelectedItem().toString());
					writer.append(" ");
					writer.append(text_3.getText());
					writer.append(" ");
					writer.append(text_4.getText());
					writer.append(" ");
					writer.append(text_5.getText());
					writer.append(" ");
					writer.append(text_6.getText());
					writer.append(" ");
					writer.append(text_7.getText());
					if (box_1.isSelected()) {

						writer.append(" ");
						writer.append(box_1.getText());
					} else {

						writer.append(" ");
						writer.append(box_2.getText());
					}
					writer.newLine();
					writer.flush();
					writer.close();

					JOptionPane.showMessageDialog(null, "保存成功!", "保存",
							JOptionPane.INFORMATION_MESSAGE);

					// box1添加子项
					box1.addItem(text_2.getText());

				} catch (IOException e1) {
					// TODO Auto-generated catch block

					JOptionPane.showMessageDialog(null, "保存失败!", "保存",
							JOptionPane.CANCEL_OPTION);
				}
			}
		}

		//清空按钮
		else if(e.getSource().equals(butt5)){
			
			int a = 1;
			a = JOptionPane.showConfirmDialog(null, "是否清空所有内容?", "提示",
					JOptionPane.YES_NO_OPTION);
			
			// 选择yes
			if(a==0){
				
				text_1.setText("");
				text_2.setText("");
				text_3.setText("");
				text_4.setText("");
				text_5.setText("");
				text_6.setText("");
				text_7.setText("");
			}
		}
		
		// 业主交费面面板--box1按钮
		else if (e.getSource().equals(box1)) {

			String s = box1.getSelectedItem().toString();
			te1.setText(s);
		}

		// 确定button1按钮
		else if (e.getSource().equals(button1)) {

			// 清空pl3上的内容
			te2.setText("");
			te3.setText("");
			te4.setText("");
			te5.setText("");
			te6.setText("");
			te7.setText("");
			te8.setText("");
			te9.setText("");
			te10.setText("");

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
				te10.setText(arr[num][8]);

				pl3.repaint();

				button2.setEnabled(true);
				button3.setEnabled(true);
			}

		}

		// 删除button2按钮
		else if (e.getSource().equals(button2)) {

			if (te1.getText().isEmpty()) {

				JOptionPane.showMessageDialog(null, "请确定要删除车主的姓名!", "提示",
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
					// 清空pl3上的内容
					te2.setText("");
					te3.setText("");
					te4.setText("");
					te5.setText("");
					te6.setText("");
					te7.setText("");
					te8.setText("");
					te9.setText("");
					te10.setText("");
					pl3.repaint();

					File s = new File("data/panel3.txt");
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
								writer.append(" ");
								writer.append(arr[i][8]);
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
		
		//修改button3按钮
		else if(e.getSource().equals(button3)){
			
			te2.setEditable(true);
			te3.setEditable(true);
			te4.setEditable(true);
			te5.setEditable(true);
			te6.setEditable(true);
			te7.setEditable(true);
			te8.setEditable(true);
			te9.setEditable(true);
			te10.setEditable(true);
			
			button3.setVisible(false);
			button4.setVisible(true);
		}
		
		//保存button4按钮
		else if(e.getSource().equals(button4)){
			
			File s = new File("data/panel3.txt");
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(s));

				for (int i = 0; arr[i][1] != null; i++) {

					if (arr[i][1].equals(te1.getText())) {

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
						writer.newLine();
					}
				}
				writer.flush();
				writer.close();

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
				te10.setEditable(false);

			} catch (IOException e1) {
				// TODO Auto-generated catch block

				JOptionPane.showMessageDialog(null, "修改失败!", "修改",
						JOptionPane.CANCEL_OPTION);
			}

		}
	}

}
