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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Jpanel2 extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 业主车辆管理界面面板
	private JPanel panel2, panel2_1, panel2_2, pl3;
	// 业主车辆管理界面标签
	private JLabel be1, be2, be3, be4, be5, be6, be7, be8, be9, be10, be11,
			be12, be13, be14;
	// 业主交费情况界面按钮
	private JButton bu1, bu2, bu3, bu4, bu5, bu6, bu7, bu8;
	private JButton CleanBt;
	// 业主车辆管理界面面板的JComboBox
	private JComboBox<?> bo1;
	private JComboBox<String> box2;
	// 业主车辆管理界面面板的JScrollBar
	private JScrollBar ba1, ba2;
	// 业主车辆管理界面面板JTextField
	private JTextField te1, te2, te3, te4, te5;
	private JTextField text1, text2, text3, text4, text5;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Jpanel2() {
		// TODO Auto-generated constructor stub

		String s1[][] = new String[100][5];
		int numbers = 0;
		// 读取panel2文件
		try {

			int i = 0, j = 0;

			File s = new File("data/panel2.txt");
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

		// 业主车辆管理界面面板
		panel2 = new JPanel() {

			/**
					 * 
					 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {

				ImageIcon images1 = new ImageIcon("image/2010122016182789.jpg");
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
		panel2.setLayout(null);
		panel2.setBounds(0, 0, 650, 500);

		panel2_1 = new JPanel();
		panel2_1.setLayout(null);
		panel2_1.setBounds(130, 70, 520, 430);
		panel2_1.setOpaque(false);

		be1 = new JLabel("业主车辆管理");
		be1.setFont(new Font("楷体", Font.PLAIN, 30));
		be1.setBounds(205, 20, 200, 30);

		be2 = new JLabel(new ImageIcon(
				"image/arrow_right_27.399141630901px_1188313_easyicon.net.png"));
		be2.setBounds(101, 105, 30, 20);

		be3 = new JLabel(new ImageIcon(
				"image/arrow_right_27.399141630901px_1188313_easyicon.net.png"));
		be3.setBounds(101, 165, 30, 20);
		be3.setVisible(false);

		be4 = new JLabel("车辆类型:");
		be4.setFont(new Font("楷体", Font.PLAIN, 22));
		be4.setBounds(30, 50, 150, 30);

		te1 = new JTextField();
		te1.setBounds(130, 55, 110, 28);

		be5 = new JLabel("车辆主人:");
		be5.setFont(new Font("楷体", Font.PLAIN, 22));
		be5.setBounds(250, 50, 150, 30);

		te2 = new JTextField();
		te2.setBounds(350, 55, 100, 28);

		be6 = new JLabel("车牌号码:");
		be6.setFont(new Font("楷体", Font.PLAIN, 22));
		be6.setBounds(30, 110, 150, 30);

		te3 = new JTextField();
		te3.setBounds(130, 115, 110, 28);

		be7 = new JLabel("车辆品牌:");
		be7.setFont(new Font("楷体", Font.PLAIN, 22));
		be7.setBounds(250, 110, 150, 30);

		te4 = new JTextField();
		te4.setBounds(350, 115, 100, 28);

		be8 = new JLabel("车辆颜色:");
		be8.setFont(new Font("楷体", Font.PLAIN, 22));
		be8.setBounds(30, 165, 150, 30);

		ba1 = new JScrollBar();

		bo1 = new JComboBox(new Object[] { "白色", "黑色", "红色", "银色", "黄色", "蓝色",
				"其他" });
		bo1.setBounds(130, 170, 110, 27);
		bo1.setMaximumRowCount(3);
		bo1.setFont(new Font("楷体", Font.PLAIN, 15));
		bo1.setFocusable(false);

		bu1 = new JButton("录入");
		bu1.setBounds(10, 100, 90, 30);
		bu1.setFont(new Font("华文彩云", Font.PLAIN, 15));
		bu1.setForeground(Color.lightGray);
		bu1.setFocusPainted(false);
		bu1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bu1.addActionListener(this);

		bu2 = new JButton("查看");
		bu2.setBounds(10, 160, 90, 30);
		bu2.setFont(new Font("华文彩云", Font.PLAIN, 15));
		bu2.setForeground(Color.lightGray);
		bu2.setFocusPainted(false);
		bu2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bu2.addActionListener(this);

		bu3 = new JButton("返回");
		bu3.setBounds(10, 420, 100, 30);
		bu3.setFont(new Font("华文彩云", Font.PLAIN, 15));
		bu3.setForeground(Color.black);
		bu3.setFocusPainted(false);
		bu3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bu3.addActionListener(this);

		bu4 = new JButton("保存");
		bu4.setBounds(133, 295, 100, 30);
		bu4.setFont(new Font("华文彩云", Font.PLAIN, 15));
		bu4.setForeground(Color.black);
		bu4.setFocusPainted(false);
		bu4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bu4.addActionListener(this);
		
		CleanBt = new JButton("清空");
		CleanBt.setBounds(248, 295, 100, 30);
		CleanBt.setFont(new Font("华文彩云", Font.PLAIN, 15));
		CleanBt.setForeground(Color.black);
		CleanBt.setToolTipText("清空所有内容");
		CleanBt.setFocusPainted(false);
		CleanBt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		CleanBt.addActionListener(this);

		panel2_2 = new JPanel();
		panel2_2.setLayout(null);
		panel2_2.setBounds(130, 70, 520, 430);
		panel2_2.setOpaque(false);

		be9 = new JLabel("请输入车主的姓名:");
		be9.setBounds(10, 20, 200, 30);
		be9.setFont(new Font("楷体", Font.PLAIN, 23));

		ba2 = new JScrollBar();

		box2 = new JComboBox<String>(s2);
		box2.setBounds(215, 20, 140, 30);
		box2.setMaximumRowCount(3);
		box2.setFont(new Font("楷体", Font.PLAIN, 15));
		box2.setFocusable(false);
		box2.addActionListener(this);

		te5 = new JTextField();
		te5.setBounds(215, 20, 120, 30);

		bu5 = new JButton("确定");
		bu5.setBounds(370, 20, 90, 30);
		bu5.setFont(new Font("华文彩云", Font.PLAIN, 15));
		bu5.setForeground(Color.black);
		bu5.setFocusPainted(false);
		bu5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bu5.addActionListener(this);

		pl3 = new JPanel() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {

				g.drawLine(20, 30, 460, 30);
				g.drawLine(20, 240, 460, 240);
				g.drawLine(20, 30, 20, 240);
				g.drawLine(460, 30, 460, 240);

				g.drawLine(20, 100, 460, 100);
				g.drawLine(20, 170, 460, 170);
				g.drawLine(230, 30, 230, 170);
			}
		};
		pl3.setLayout(null);
		pl3.setBounds(0, 56, 520, 430);
		pl3.setOpaque(false);

		bu6 = new JButton("删除");
		bu6.setBounds(140, 280, 90, 30);
		bu6.setFont(new Font("华文彩云", Font.PLAIN, 15));
		bu6.setForeground(Color.black);
		bu6.setFocusPainted(false);
		bu6.setEnabled(false);
		bu6.setToolTipText("删除此人信息");
		bu6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bu6.addActionListener(this);

		bu7 = new JButton("修改");
		bu7.setBounds(250, 280, 90, 30);
		bu7.setFont(new Font("华文彩云", Font.PLAIN, 15));
		bu7.setForeground(Color.black);
		bu7.setFocusPainted(false);
		bu7.setEnabled(false);
		bu7.setToolTipText("修改此人信息");
		bu7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bu7.addActionListener(this);

		bu8 = new JButton("保存");
		bu8.setBounds(250, 280, 90, 30);
		bu8.setFont(new Font("华文彩云", Font.PLAIN, 15));
		bu8.setForeground(Color.black);
		bu8.setFocusPainted(false);
		bu8.setVisible(false);
		bu8.setToolTipText("保存此人信息");
		bu8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bu8.addActionListener(this);

		be10 = new JLabel("车辆类型:");
		be10.setBounds(30, 50, 120, 30);
		be10.setFont(new Font("楷体", Font.PLAIN, 20));

		be11 = new JLabel("车辆主人:");
		be11.setBounds(240, 50, 120, 30);
		be11.setFont(new Font("楷体", Font.PLAIN, 20));

		be12 = new JLabel("车牌号码:");
		be12.setBounds(30, 120, 120, 30);
		be12.setFont(new Font("楷体", Font.PLAIN, 20));

		be13 = new JLabel("车辆品牌:");
		be13.setBounds(240, 120, 120, 30);
		be13.setFont(new Font("楷体", Font.PLAIN, 20));

		be14 = new JLabel("车辆颜色:");
		be14.setBounds(30, 190, 120, 30);
		be14.setFont(new Font("楷体", Font.PLAIN, 20));

		text1 = new JTextField();
		text1.setBounds(119, 47, 110, 40);
		text1.setFont(new Font("楷体", Font.PLAIN, 20));
		text1.setBorder(new EmptyBorder(0, 0, 0, 0));
		text1.setOpaque(false);
		text1.setEditable(false);

		text2 = new JTextField();
		text2.setBounds(340, 47, 120, 40);
		text2.setFont(new Font("楷体", Font.PLAIN, 20));
		text2.setBorder(new EmptyBorder(0, 0, 0, 0));
		text2.setOpaque(false);
		text2.setEditable(false);

		text3 = new JTextField();
		text3.setBounds(119, 117, 110, 40);
		text3.setFont(new Font("楷体", Font.PLAIN, 20));
		text3.setBorder(new EmptyBorder(0, 0, 0, 0));
		text3.setOpaque(false);
		text3.setEditable(false);

		text4 = new JTextField();
		text4.setBounds(340, 117, 120, 40);
		text4.setFont(new Font("楷体", Font.PLAIN, 20));
		text4.setBorder(new EmptyBorder(0, 0, 0, 0));
		text4.setOpaque(false);
		text4.setEditable(false);

		text5 = new JTextField();
		text5.setBounds(119, 187, 150, 40);
		text5.setFont(new Font("楷体", Font.PLAIN, 20));
		text5.setBorder(new EmptyBorder(0, 0, 0, 0));
		text5.setOpaque(false);
		text5.setEditable(false);

		panel2.add(be1);
		panel2.add(be2);
		panel2.add(be3);
		panel2.add(bu1);
		panel2.add(bu2);
		panel2.add(bu3);
		panel2.add(panel2_1);
		panel2_1.add(be4);
		panel2_1.add(be5);
		panel2_1.add(be6);
		panel2_1.add(be7);
		panel2_1.add(be8);
		panel2_1.add(bu4);
		panel2_1.add(CleanBt);
		bo1.add(ba1);
		panel2_1.add(bo1);
		panel2_1.add(te1);
		panel2_1.add(te2);
		panel2_1.add(te3);
		panel2_1.add(te4);

		panel2_2.add(be9);
		panel2_2.add(te5);
		box2.add(ba2);
		panel2_2.add(box2);
		panel2_2.add(bu5);
		panel2_2.add(pl3);
		pl3.add(bu6);
		pl3.add(bu7);
		pl3.add(bu8);
		pl3.add(be10);
		pl3.add(be11);
		pl3.add(be12);
		pl3.add(be13);
		pl3.add(be14);
		pl3.add(text1);
		pl3.add(text2);
		pl3.add(text3);
		pl3.add(text4);
		pl3.add(text5);

		this.add(panel2);

		this.setSize(650, 500);
		this.setTitle("物主信息管理——车辆管理");
		this.setIconImage((new ImageIcon(
				"image/Company_house_48px_520461_easyicon.net.png")).getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String arr[][] = new String[100][5];
		int num = 0;
		boolean b = false;

		// 读取panel2文件
		try {

			int i = 0, j = 0;

			File s = new File("data/panel2.txt");
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

		// 业主车辆管理界面面板--录入按钮
		if (e.getSource().equals(bu1)) {

			// 清空pl2上的内容
			te1.setText("");
			te2.setText("");
			te3.setText("");
			te4.setText("");

			be2.setVisible(true);
			be3.setVisible(false);

			panel2.remove(panel2_2);
			panel2.add(panel2_1);
			panel2.validate();
			panel2.repaint();
		}

		// 业主车辆管理界面面板--查看按钮
		else if (e.getSource().equals(bu2)) {

			be2.setVisible(false);
			be3.setVisible(true);

			te5.setText("");
			// 清空pl3上的内容
			text1.setText("");
			text2.setText("");
			text3.setText("");
			text4.setText("");
			text5.setText("");

			bu6.setEnabled(false);
			bu7.setEnabled(false);

			panel2.remove(panel2_1);
			panel2.add(panel2_2);
			panel2.validate();
			panel2.repaint();
		}

		// 业主车辆管理界面面板--返回按钮
		else if (e.getSource().equals(bu3)) {

			new MyManages();
			this.dispose();
		}

		// 业主车辆管理界面面板--保存按钮
		else if (e.getSource().equals(bu4)) {

			if (te1.getText().isEmpty() | te2.getText().isEmpty()
					| te3.getText().isEmpty() | te4.getText().isEmpty()) {

				JOptionPane.showMessageDialog(null, "请输入完整的信息!", "警告",
						JOptionPane.CANCEL_OPTION);
			}

			else {

				File s = new File("data/panel2.txt");
				try {
					BufferedWriter writer = new BufferedWriter(new FileWriter(
							s, true));

					writer.append(te1.getText());
					writer.append(" ");
					writer.append(te2.getText());
					writer.append(" ");
					writer.append(te3.getText());
					writer.append(" ");
					writer.append(te4.getText());
					writer.append(" ");
					writer.append(bo1.getSelectedItem().toString());
					writer.newLine();
					writer.flush();
					writer.close();

					JOptionPane.showMessageDialog(null, "保存成功!", "保存",
							JOptionPane.INFORMATION_MESSAGE);

					// box2添加子项
					box2.addItem(te2.getText());

				} catch (IOException e1) {
					// TODO Auto-generated catch block

					JOptionPane.showMessageDialog(null, "保存失败!", "保存",
							JOptionPane.CANCEL_OPTION);
				}
			}
		}

		//清空按钮
		else if(e.getSource().equals(CleanBt)){
			
			int a = 1;
			a = JOptionPane.showConfirmDialog(null, "是否清空所有内容?", "提示",
					JOptionPane.YES_NO_OPTION);
			
			// 选择yes
			if(a==0){
				
				te1.setText("");
				te2.setText("");
				te3.setText("");
				te4.setText("");
			}
		}
		
		// 业主车辆管理界面面板--确定按钮
		else if (e.getSource().equals(bu5)) {

			// 清空pl3上的内容
			text1.setText("");
			text2.setText("");
			text3.setText("");
			text4.setText("");
			text5.setText("");

			for (int a = 0; a < 100; a++) {

				if (te5.getText().equals(ss[a])) {

					b = true;
					num = a;
					break;
				}

			}

			if (b == false) {

				JOptionPane.showMessageDialog(null, "查无此人!", "提示",
						JOptionPane.CANCEL_OPTION);

				te5.setText("");

			}

			else {

				text1.setText(arr[num][0]);
				text2.setText(arr[num][1]);
				text3.setText(arr[num][2]);
				text4.setText(arr[num][3]);
				text5.setText(arr[num][4]);

				pl3.repaint();

				bu6.setEnabled(true);
				bu7.setEnabled(true);
			}

		}

		// 业主车辆管理界面面板--删除按钮
		else if (e.getSource().equals(bu6)) {

			if (te5.getText().isEmpty()) {

				JOptionPane.showMessageDialog(null, "请确定要删除车主的姓名!", "提示",
						JOptionPane.CANCEL_OPTION);
			}

			else {

				int a = 1;
				a = JOptionPane.showConfirmDialog(null, "是否删除此人信息?", "提示",
						JOptionPane.YES_NO_OPTION);

				// 选择yes
				if (a == 0) {

					box2.removeActionListener(this);
					String str = te5.getText();
					box2.removeItem(str);

					bu6.setEnabled(false);
					// 清空pl3上的内容
					text1.setText("");
					text2.setText("");
					text3.setText("");
					text4.setText("");
					text5.setText("");
					pl3.repaint();

					File s = new File("data/panel2.txt");
					try {
						BufferedWriter writer = new BufferedWriter(
								new FileWriter(s));

						for (int i = 0; arr[i][1] != null; i++) {

							if (arr[i][1].equals(te5.getText())) {

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
								writer.newLine();
							}
						}
						writer.flush();
						writer.close();

						JOptionPane.showMessageDialog(null, "删除成功!", "删除",
								JOptionPane.INFORMATION_MESSAGE);

						box2.addActionListener(this);
						te5.setText("");

					} catch (IOException e1) {
						// TODO Auto-generated catch block

						JOptionPane.showMessageDialog(null, "删除失败!", "删除",
								JOptionPane.CANCEL_OPTION);
					}
				}

			}
		}

		// 业主车辆管理界面面板--box2按钮
		else if (e.getSource().equals(box2)) {

			String s = box2.getSelectedItem().toString();
			te5.setText(s);
		}

		// 修改按钮
		else if (e.getSource().equals(bu7)) {

			text1.setEditable(true);
			text2.setEditable(true);
			text3.setEditable(true);
			text4.setEditable(true);
			text5.setEditable(true);

			bu7.setVisible(false);
			bu8.setVisible(true);
		}

		// 保存按钮
		else if (e.getSource().equals(bu8)) {

			File s = new File("data/panel2.txt");
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(s));

				for (int i = 0; arr[i][1] != null; i++) {

					if (arr[i][1].equals(te5.getText())) {

						writer.append(text1.getText());
						writer.append(" ");
						writer.append(text2.getText());
						writer.append(" ");
						writer.append(text3.getText());
						writer.append(" ");
						writer.append(text4.getText());
						writer.append(" ");
						writer.append(text5.getText());
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
						writer.newLine();
					}
				}
				writer.flush();
				writer.close();

				JOptionPane.showMessageDialog(null, "修改成功!", "修改",
						JOptionPane.INFORMATION_MESSAGE);

				box2.addActionListener(this);
				bu7.setVisible(true);
				bu8.setVisible(false);

				text1.setEditable(false);
				text2.setEditable(false);
				text3.setEditable(false);
				text4.setEditable(false);
				text5.setEditable(false);

			} catch (IOException e1) {
				// TODO Auto-generated catch block

				JOptionPane.showMessageDialog(null, "修改失败!", "修改",
						JOptionPane.CANCEL_OPTION);
			}

		}
	}

}
