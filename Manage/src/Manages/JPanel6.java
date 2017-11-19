package Manages;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanel6 extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panel6, panel6_1, panel6_2;

	private JButton returnBtn, arrearsBtn, earnBtn;

	// panel6_1的标签
	private JLabel Lb1, Lb2, Lb3, Lb4, Lb5, Lb6, Lb7;

	private JLabel bel1, bel2, bel3;

	// panel6_2的标签
	private JLabel label1, label2, label3, label4, label5, label6, label7,
			label8, label9, label10;

	int numbers = 0;
	int num = 0;

	double dou1, dou2, dou3;

	public JPanel6() {
		// TODO Auto-generated constructor stub

		String arr[][] = new String[100][9];
		double money = 0;
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

		// 判断业主是否欠费
		for (int a = 0; a < 100; a++) {

			if (arr[a][0] == null) {

				numbers = a;
				break;
			}

			if (Integer.parseInt(arr[a][4]) > 0) {

				num++;
				money = money + Double.parseDouble(arr[a][4]);
			}
		}

		panel6 = new JPanel() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {

				ImageIcon images2 = new ImageIcon("image/panel6_3.png");
				Image im2 = images2.getImage();
				g.drawImage(im2, -13, -20, 685, 540, images2.getImageObserver());
			}
		};
		panel6.setLayout(null);
		panel6.setOpaque(false);
		panel6.setBounds(0, 0, 650, 500);

		arrearsBtn = new JButton("业主欠费情况");
		arrearsBtn.setFont(new Font("楷体", Font.PLAIN, 18));
		arrearsBtn.setBounds(65, 90, 160, 30);
		arrearsBtn.setContentAreaFilled(false);
		arrearsBtn.setBorderPainted(false);
		arrearsBtn.setFocusable(false);
		arrearsBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		arrearsBtn.addActionListener(this);

		earnBtn = new JButton("公司收支情况");
		earnBtn.setFont(new Font("楷体", Font.PLAIN, 18));
		earnBtn.setBounds(65, 122, 160, 30);
		earnBtn.setContentAreaFilled(false);
		earnBtn.setBorderPainted(false);
		earnBtn.setFocusable(false);
		earnBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		earnBtn.addActionListener(this);

		returnBtn = new JButton("返回");
		returnBtn.setFont(new Font("楷体", Font.PLAIN, 20));
		returnBtn.setBounds(100, 260, 100, 30);
		returnBtn.setContentAreaFilled(false);
		returnBtn.setBorderPainted(false);
		returnBtn.setFocusable(false);
		returnBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		returnBtn.addActionListener(this);

		panel6_1 = new JPanel() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {

				// 横线
				g.drawLine(0, 30, 360, 30);
				g.drawLine(0, 360, 360, 360);
				g.drawLine(0, 70, 360, 70);
				g.drawLine(0, 110, 360, 110);
				g.drawLine(0, 150, 360, 150);
				g.drawLine(0, 190, 360, 190);

				// 竖线
				g.drawLine(0, 30, 0, 360);
				g.drawLine(360, 30, 360, 360);
				g.drawLine(180, 30, 180, 190);

				// 小正方形
				g.setColor(Color.blue);
				g.fillRect(180, 216, 18, 18);

				g.setColor(Color.darkGray);
				g.fillRect(180, 257, 18, 18);

				g.setColor(Color.white);
				g.fillRect(180, 297, 18, 18);

				if (numbers == 0) {

					// 圆饼
					g.setColor(Color.white);
					g.fillArc(20, 220, 110, 110, 0, 360);
				}

				else {

					double a = (double) numbers;
					double b = (double) num;
					double n1 = 360 - ((a - b) / a) * 360;

					// 圆饼
					g.setColor(Color.darkGray);
					g.fillArc(20, 220, 110, 110, 0, (int) n1);

					g.setColor(Color.blue);
					g.fillArc(20, 220, 110, 110, (int) n1, 360 - (int) n1);
				}

			}
		};
		panel6_1.setLayout(null);
		panel6_1.setBounds(210, 65, 380, 390);
		panel6_1.setOpaque(false);
		panel6_1.setVisible(false);

		Lb1 = new JLabel("统计");
		Lb1.setBounds(240, 40, 100, 30);
		Lb1.setFont(new Font("楷体", Font.PLAIN, 24));

		Lb2 = new JLabel("欠费总人数");
		Lb2.setBounds(20, 73, 120, 30);
		Lb2.setFont(new Font("楷体", Font.PLAIN, 22));

		Lb3 = new JLabel("欠费总金额");
		Lb3.setBounds(20, 113, 120, 30);
		Lb3.setFont(new Font("楷体", Font.PLAIN, 22));

		Lb4 = new JLabel(Integer.toString(num) + "人");
		Lb4.setBounds(240, 73, 120, 30);
		Lb4.setFont(new Font("楷体", Font.PLAIN, 22));

		Lb5 = new JLabel(Double.toString(money) + "元");
		Lb5.setBounds(230, 113, 120, 30);
		Lb5.setFont(new Font("楷体", Font.PLAIN, 22));

		Lb6 = new JLabel("总人数");
		Lb6.setBounds(30, 153, 120, 30);
		Lb6.setFont(new Font("楷体", Font.PLAIN, 22));

		Lb7 = new JLabel(Integer.toString(numbers) + "人");
		Lb7.setBounds(240, 153, 120, 30);
		Lb7.setFont(new Font("楷体", Font.PLAIN, 22));

		bel1 = new JLabel("不欠费人数比例");
		bel1.setBounds(200, 210, 160, 30);
		bel1.setFont(new Font("楷体", Font.PLAIN, 20));

		bel2 = new JLabel("欠费人数比例");
		bel2.setBounds(200, 250, 160, 30);
		bel2.setFont(new Font("楷体", Font.PLAIN, 20));

		bel3 = new JLabel("业主总人数为0");
		bel3.setBounds(200, 290, 160, 30);
		bel3.setFont(new Font("楷体", Font.PLAIN, 20));

		String array[][] = new String[100][6];
		// 读取panel5文件
		try {

			int i = 0, j = 0;

			File s = new File("data/panel5.txt");
			FileReader fr = new FileReader(s);
			BufferedReader t = new BufferedReader(fr);
			String str = t.readLine();
			while (str != null) {
				StringTokenizer st = new StringTokenizer(str, " ");
				// 将文件进行分割
				while (st.hasMoreTokens()) {
					// 将文件写入到数组中
					array[j][i] = st.nextToken();
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

		// 计算总收入和总支出
		dou1 = Double.parseDouble(array[0][0])
				+ Double.parseDouble(array[0][1])
				+ Double.parseDouble(array[0][2]);
		dou2 = Double.parseDouble(array[0][3])
				+ Double.parseDouble(array[0][4]);
		dou3 = Double.parseDouble(array[0][5]);

		panel6_2 = new JPanel() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {

				// 横线
				g.drawLine(0, 30, 360, 30);
				g.drawLine(0, 360, 360, 360);
				g.drawLine(0, 70, 360, 70);
				g.drawLine(0, 110, 360, 110);
				g.drawLine(0, 150, 360, 150);
				g.drawLine(0, 190, 360, 190);

				// 竖线
				g.drawLine(0, 30, 0, 360);
				g.drawLine(360, 30, 360, 360);
				g.drawLine(180, 30, 180, 190);

				// 坐标轴
				// x轴
				g.drawLine(15, 340, 200, 340);
				g.setFont(new Font("楷体", Font.PLAIN, 16));
				g.drawString(">", 195, 346);
				// y轴
				g.drawLine(15, 200, 15, 340);
				g.setFont(new Font("楷体", Font.PLAIN, 14));
				g.drawString("∧", 9, 208);

				// 小正方形
				g.setColor(Color.blue);
				g.fillRect(210, 216, 18, 18);

				g.setColor(Color.gray);
				g.fillRect(210, 257, 18, 18);

				g.setColor(Color.magenta);
				g.fillRect(210, 297, 18, 18);

				// 矩形
				g.setColor(Color.blue);
				g.fillRect(50, 240, 18, 100);

				g.setColor(Color.gray);
				g.fillRect(68, 340 - (int) ((dou1 / dou2) * 100), 18,
						(int) ((dou1 / dou2) * 100));

				g.setColor(Color.magenta);
				g.fillRect(120, 340 - (int) ((dou3 / dou2) * 100), 18,
						(int) ((dou3 / dou2) * 100));

			}
		};
		panel6_2.setLayout(null);
		panel6_2.setBounds(210, 65, 380, 390);
		panel6_2.setOpaque(false);
		panel6_2.setVisible(false);

		label1 = new JLabel("统计");
		label1.setBounds(240, 40, 100, 30);
		label1.setFont(new Font("楷体", Font.PLAIN, 24));

		label2 = new JLabel("总收入");
		label2.setBounds(50, 73, 120, 30);
		label2.setFont(new Font("楷体", Font.PLAIN, 22));

		label3 = new JLabel("总支出");
		label3.setBounds(50, 113, 120, 30);
		label3.setFont(new Font("楷体", Font.PLAIN, 22));

		label4 = new JLabel(Double.toString(dou2) + "元");
		label4.setBounds(210, 73, 180, 30);
		label4.setFont(new Font("楷体", Font.PLAIN, 22));

		label5 = new JLabel(Double.toString(dou1) + "元");
		label5.setBounds(210, 113, 180, 30);
		label5.setFont(new Font("楷体", Font.PLAIN, 22));

		label6 = new JLabel("公司纯收益");
		label6.setBounds(30, 153, 160, 30);
		label6.setFont(new Font("楷体", Font.PLAIN, 22));

		label7 = new JLabel(array[0][5] + "元");
		label7.setBounds(210, 153, 180, 30);
		label7.setFont(new Font("楷体", Font.PLAIN, 22));

		label8 = new JLabel("总收入");
		label8.setBounds(230, 210, 160, 30);
		label8.setFont(new Font("楷体", Font.PLAIN, 20));

		label9 = new JLabel("总支出");
		label9.setBounds(230, 250, 160, 30);
		label9.setFont(new Font("楷体", Font.PLAIN, 20));

		label10 = new JLabel("纯收益");
		label10.setBounds(230, 290, 160, 30);
		label10.setFont(new Font("楷体", Font.PLAIN, 20));

		this.add(panel6);
		panel6.add(panel6_1);
		panel6.add(panel6_2);
		panel6.add(returnBtn);
		panel6.add(arrearsBtn);
		panel6.add(earnBtn);
		panel6_1.add(Lb1);
		panel6_1.add(Lb2);
		panel6_1.add(Lb3);
		panel6_1.add(Lb4);
		panel6_1.add(Lb5);
		panel6_1.add(Lb6);
		panel6_1.add(Lb7);
		panel6_1.add(bel1);
		panel6_1.add(bel2);
		panel6_1.add(bel3);
		panel6_2.add(label1);
		panel6_2.add(label2);
		panel6_2.add(label3);
		panel6_2.add(label4);
		panel6_2.add(label5);
		panel6_2.add(label6);
		panel6_2.add(label7);
		panel6_2.add(label8);
		panel6_2.add(label9);
		panel6_2.add(label10);

		this.setSize(650, 500);
		this.setTitle("物主信息管理--表格信息");
		this.setIconImage((new ImageIcon(
				"image/Company_house_48px_520461_easyicon.net.png")).getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		// 返回主界面
		if (e.getSource().equals(returnBtn)) {

			this.dispose();
			new MyManages();
		}

		else if (e.getSource().equals(arrearsBtn)) {

			panel6_1.setVisible(true);
			panel6_2.setVisible(false);
		}

		else if (e.getSource().equals(earnBtn)) {

			panel6_1.setVisible(false);
			panel6_2.setVisible(true);
		}
	}

}
