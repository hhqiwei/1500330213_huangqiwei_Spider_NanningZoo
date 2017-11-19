package Manages;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//注册界面
class Register extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel label2, label3, label4, label5, label6, label7, label8;
	private JButton button, button1, button2;
	private JTextField text2, text3;
	private JPanel panel, Jpanel;

	private String a, b;

	public Register() {

		label2 = new JLabel("姓名");
		label2.setBounds(70, 70, 60, 30);
		label2.setFont(new Font("魏体", Font.PLAIN, 17));

		label3 = new JLabel("电话号码");
		label3.setBounds(50, 130, 100, 30);
		label3.setFont(new Font("魏体", Font.PLAIN, 17));

		button = new JButton("确定");
		button.setBounds(90, 220, 80, 30);
		button.addActionListener(this);
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		button1 = new JButton("取消");
		button1.setBounds(180, 220, 80, 30);
		button1.addActionListener(this);
		button1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		text2 = new JTextField();
		text2.setBounds(130, 70, 130, 30);

		text3 = new JTextField();
		text3.setBounds(130, 130, 130, 30);

		panel = new JPanel() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {

				ImageIcon image = new ImageIcon("image/2011051823322682.jpg");
				Image im = image.getImage();
				g.drawImage(im, 0, 0, 350, 300, image.getImageObserver());

			}
		};
		panel.setLayout(null);
		panel.setBounds(0, 0, 350, 300);

		Jpanel = new JPanel() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {

				ImageIcon image = new ImageIcon("image/tick.png");
				Image im = image.getImage();
				g.drawImage(im, 30, 50, 90, 90, image.getImageObserver());

			}
		};
		Jpanel.setLayout(null);
		Jpanel.setBounds(0, 0, 350, 300);

		label4 = new JLabel("恭喜你,账号注册成功!");
		label4.setBounds(130, 40, 180, 30);
		label4.setFont(new Font("魏体", Font.PLAIN, 17));

		label5 = new JLabel("帐号:");
		label5.setBounds(130, 90, 60, 30);
		label5.setFont(new Font("魏体", Font.PLAIN, 17));

		label6 = new JLabel();
		label6.setBounds(190, 90, 120, 30);
		label6.setFont(new Font("魏体", Font.PLAIN, 17));

		label7 = new JLabel("密码:");
		label7.setBounds(130, 150, 60, 30);
		label7.setFont(new Font("魏体", Font.PLAIN, 17));

		label8 = new JLabel();
		label8.setBounds(190, 150, 120, 30);
		label8.setFont(new Font("魏体", Font.PLAIN, 17));

		button2 = new JButton("确定");
		button2.setBounds(150, 220, 90, 30);
		button2.addActionListener(this);
		button2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		panel.add(button);
		panel.add(button1);
		panel.add(label2);
		panel.add(label3);
		panel.add(text2);
		panel.add(text3);
		Jpanel.add(label4);
		Jpanel.add(label5);
		Jpanel.add(label6);
		Jpanel.add(label7);
		Jpanel.add(label8);
		Jpanel.add(button2);
		this.add(panel);

		this.setTitle("注册");
		this.setSize(350, 300);
		this.setIconImage((new ImageIcon(
				"image/Company_house_48px_520461_easyicon.net.png")).getImage());
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource().equals(button)) {
			if (text2.getText().isEmpty() | text3.getText().isEmpty()) {

				JOptionPane.showMessageDialog(null, "请输入全部的信息!", "警告",
						JOptionPane.CANCEL_OPTION);
			}

			else {

				// 随机生成账号和密码
				int i = (int) (Math.random() * 900000 + 100000);
				int j = (int) (Math.random() * 900000 + 100000);
				a = Integer.toString(i);
				b = Integer.toString(j);

				// 把账号和密码写入account文件
				try {

					File s = new File("data/account.txt");
					BufferedWriter writer = new BufferedWriter(new FileWriter(
							s, true));
					writer.append(a);
					writer.append(" ");
					writer.append(b);

					writer.newLine();
					writer.flush();
					writer.close();

				} catch (Exception e1) {
					e1.printStackTrace();
				}

				// 把账号和密码现实出来
				label6.setText(a);
				label8.setText(b);

				// 切换面板
				this.remove(panel);
				this.add(Jpanel);
				this.validate();
				this.repaint();
			}
		}

		else if (e.getSource().equals(button1)) {

			this.dispose();
		}

		else if (e.getSource().equals(button2)) {

			this.dispose();
		}
	}
}
