package Manages;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;

import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.StringTokenizer;

import org.jvnet.substance.skin.*;

//登录界面
public class MyManage extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panel;
	private JButton button, button1;
	private JLabel label1, label2;
	private JTextField text1;
	private JPasswordField pass;
	static JCheckBox box1, box2;

	private int year, month, day;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			
			UIManager.setLookAndFeel(new SubstanceDustCoffeeLookAndFeel());
			JFrame.setDefaultLookAndFeelDecorated(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				new MyManage();

			}
		});
	}

	public MyManage() {

		String arr[] = new String[4];

		// 读取remember文件
		try {

			int i = 0;

			File s = new File("data/remember.txt");
			FileReader fr = new FileReader(s);
			BufferedReader t = new BufferedReader(fr);
			String str = t.readLine();
			while (str != null) {
				StringTokenizer st = new StringTokenizer(str, " ");
				// 将文件进行分割
				while (st.hasMoreTokens()) {
					// 将文件写入到数组中
					arr[i] = st.nextToken();
					i++;
				}

				str = t.readLine();
			}

			t.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		panel = new JPanel() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				g.setColor(Color.darkGray);
				g.drawRect(20, 150, 120, 120);

				ImageIcon image = new ImageIcon("image/45c58PICBNe.jpg");
				Image im1 = image.getImage();
				g.drawImage(im1, 0, 0, 450, 138, image.getImageObserver());

				ImageIcon image1 = new ImageIcon(
						"image/20130909224346_vSVUh.thumb.600_0.jpg");
				Image im2 = image1.getImage();
				g.drawImage(im2, 20, 150, 120, 120, image1.getImageObserver());
			}
		};
		panel.setLayout(null);
		panel.setSize(450, 350);

		label1 = new JLabel("账号");
		label1.setBounds(180, 143, 50, 35);
		label1.setFont(new Font("魏体", Font.PLAIN, 23));
		label1.setForeground(Color.blue);

		label2 = new JLabel("密码");
		label2.setBounds(180, 195, 50, 35);
		label2.setFont(new Font("魏体", Font.PLAIN, 23));
		label2.setForeground(Color.blue);

		text1 = new JTextField(arr[2]);
		text1.setBounds(250, 143, 170, 30);
		text1.addActionListener(this);

		pass = new JPasswordField(arr[3]);
		pass.setBounds(250, 195, 170, 30);
		pass.addActionListener(this);

		box1 = new JCheckBox("记住账号", Boolean.parseBoolean(arr[0]));
		box1.setBounds(197, 230, 80, 30);
		box1.setFocusable(false);

		box2 = new JCheckBox("记住密码", Boolean.parseBoolean(arr[1]));
		box2.setBounds(300, 230, 80, 30);
		box2.setFocusable(false);

		button = new JButton("登录");
		button.setBounds(185, 270, 110, 35);
		button.setBackground(Color.blue);
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setFocusable(false);
		button.addActionListener(this);

		button1 = new JButton("注册账号");
		button1.setBounds(310, 270, 110, 35);
		button1.setBackground(Color.blue);
		button1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button1.setFocusable(false);
		button1.addActionListener(this);

		panel.add(label1);
		panel.add(label2);
		panel.add(text1);
		panel.add(pass);
		panel.add(box1);
		panel.add(box2);
		panel.add(button);
		panel.add(button1);
		this.add(panel);

		this.setSize(450, 350);
		this.setVisible(true);
		this.setIconImage((new ImageIcon(
				"image/Company_house_48px_520461_easyicon.net.png")).getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("登录");
	}

	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		Calendar al = Calendar.getInstance();
		year = al.get(Calendar.YEAR);
		month = al.get(Calendar.MONTH) + 1;
		day = al.get(Calendar.DAY_OF_MONTH);

		String arr[][] = new String[100][9];
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

		if (e.getSource().equals(button)) {

			if (text1.getText().isEmpty() | pass.getText().isEmpty()) {

				JOptionPane.showMessageDialog(null, "账号和密码不能为空,请输入账号或密码!",
						"提示", JOptionPane.CANCEL_OPTION);
			}

			else {

				boolean boo = false;

				// 读取account文件
				try {
					int i = 0;
					String array[] = new String[2];

					File s = new File("data/account.txt");
					FileReader fr = new FileReader(s);
					BufferedReader t = new BufferedReader(fr);
					String str = t.readLine();
					while (str != null) {
						StringTokenizer st = new StringTokenizer(str, " ");
						// 将文件进行分割
						while (st.hasMoreTokens()) {
							// 将文件写入到数组中
							array[i] = st.nextToken();
							i++;
						}

						// 判断账号和密码是否正确
						if (text1.getText().equals(array[0])
								& pass.getText().equals(array[1])) {

							boo = true;
							break;
						}
						str = t.readLine();
						i = 0;

					}

					t.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

				if (boo) {

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					// 把需要记住的信息写入remember文件
					try {

						boolean lean1, lean2;
						lean1 = box1.isSelected();
						lean2 = box2.isSelected();

						File s = new File("data/remember.txt");
						BufferedWriter writer = new BufferedWriter(
								new FileWriter(s));
						writer.append(Boolean.toString(lean1));
						writer.append(" ");
						writer.append(Boolean.toString(lean2));
						writer.append(" ");
						if (lean1) {

							writer.append(text1.getText());
							writer.append(" ");
						}
						if (lean2) {

							writer.append(pass.getText());
							writer.append(" ");
						}
						writer.flush();
						writer.close();

					} catch (Exception e1) {
						e1.printStackTrace();
					}

					// 打开新的界面
					this.dispose();
					new MyManages();

					try {
						Thread.sleep(500);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// 判断是否提醒
					for (int a = 0; a < 100; a++) {

						if (arr[a][0] == null) {

							break;
						}

						if (arr[a][8].equals("是")) {

							if (arr[a][5].equals(Integer.toString(year))
									&& arr[a][6]
											.equals(Integer.toString(month))
									&& arr[a][7].equals(Integer.toString(day))) {

								JOptionPane.showMessageDialog(null, "业主"
										+ arr[a][1] + "交费时间到了!", "提醒",
										JOptionPane.INFORMATION_MESSAGE);
							}
						}
					}
				}

				else {

					JOptionPane.showMessageDialog(null,
							"账号和密码不正确,请输入正确的账号和密码!", "警告",
							JOptionPane.CANCEL_OPTION);
				}
			}
		}

		else if (e.getSource().equals(button1)) {

			new Register();

		}
	}

}
