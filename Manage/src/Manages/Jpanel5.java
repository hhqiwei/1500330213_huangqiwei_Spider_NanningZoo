package Manages;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Jpanel5 extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 公司收入情况界面面板
	private JPanel panel5;
	// 公司收入情况界面按钮
	private JButton but1, but2, but3;
	// 公司收入情况界面JTextField
	private JTextField Text1, Text2, Text3, Text4, Text5;
	// 公司收入情况界面JLabel
	private JLabel Label, Label1, Label2, Label3, Label4, Label5, Label6,
			Label7, Label8, Label9;

	public Jpanel5() {
		// TODO Auto-generated constructor stub

		// 公司收入情况界面面板
		panel5 = new JPanel() {

			/**
					 * 
					 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {

				ImageIcon images1 = new ImageIcon(
						"image/203054u50ggzx19cu7a0i0.jpg");
				java.awt.Image im1 = images1.getImage();
				g.drawImage(im1, 0, 0, 650, 500, images1.getImageObserver());

				g.setColor(Color.darkGray);
				g.drawLine(310, 353, 510, 353);

				g.setColor(new Color(149, 79, 114));
				g.setFont(new Font("楷体", Font.PLAIN, 26));
				g.drawString("(元)", 512, 348);
			}
		};
		panel5.setLayout(null);
		panel5.setBounds(0, 0, 650, 500);

		but1 = new JButton("<");
		but1.setBounds(0, 310, 30, 60);
		but1.setFont(new Font("楷体", Font.PLAIN, 13));
		but1.setForeground(Color.black);
		but1.setFocusPainted(false);
		but1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		but1.addActionListener(this);

		but2 = new JButton("计算");
		but2.setBounds(200, 410, 100, 33);
		but2.setFont(new Font("华文彩云", Font.PLAIN, 15));
		but2.setForeground(Color.black);
		but2.setFocusPainted(false);
		but2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		but2.addActionListener(this);

		but3 = new JButton("保存");
		but3.setBounds(350, 410, 100, 33);
		but3.setFont(new Font("华文彩云", Font.PLAIN, 15));
		but3.setForeground(Color.black);
		but3.setFocusPainted(false);
		but3.setEnabled(false);
		but3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		but3.addActionListener(this);

		Label1 = new JLabel("公司收支情况汇总");
		Label1.setFont(new Font("楷体", Font.ITALIC, 30));
		Label1.setForeground(Color.blue);
		Label1.setBounds(200, 20, 300, 40);

		Label2 = new JLabel("支出:");
		Label2.setFont(new Font("楷体", Font.PLAIN, 27));
		Label2.setForeground(Color.blue);
		Label2.setBounds(155, 65, 100, 40);

		Label3 = new JLabel("公司员工总支出(元):");
		Label3.setFont(new Font("楷体", Font.PLAIN, 22));
		Label3.setForeground(Color.gray);
		Label3.setBounds(245, 65, 240, 40);

		Label4 = new JLabel("维护维修支出(元):");
		Label4.setFont(new Font("楷体", Font.PLAIN, 22));
		Label4.setForeground(Color.gray);
		Label4.setBounds(245, 113, 240, 40);

		Label5 = new JLabel("配件购买支出(元):");
		Label5.setFont(new Font("楷体", Font.PLAIN, 22));
		Label5.setForeground(Color.gray);
		Label5.setBounds(245, 159, 240, 40);

		Label6 = new JLabel("收入:");
		Label6.setFont(new Font("楷体", Font.PLAIN, 27));
		Label6.setForeground(Color.yellow);
		Label6.setBounds(175, 200, 100, 40);

		Label7 = new JLabel("广告收入(元):");
		Label7.setFont(new Font("楷体", Font.PLAIN, 22));
		Label7.setForeground(Color.gray);
		Label7.setBounds(259, 203, 150, 40);

		Label8 = new JLabel("其他收入(元):");
		Label8.setFont(new Font("楷体", Font.PLAIN, 22));
		Label8.setForeground(Color.gray);
		Label8.setBounds(259, 253, 150, 40);

		Label9 = new JLabel("公司盈利:");
		Label9.setFont(new Font("楷体", Font.PLAIN, 29));
		Label9.setForeground(Color.magenta);
		Label9.setBounds(180, 320, 150, 40);

		Text1 = new JTextField();
		Text1.setBounds(465, 73, 140, 30);

		Text2 = new JTextField();
		Text2.setBounds(465, 118, 140, 30);

		Text3 = new JTextField();
		Text3.setBounds(465, 163, 140, 30);

		Text4 = new JTextField();
		Text4.setBounds(413, 209, 140, 30);

		Text5 = new JTextField();
		Text5.setBounds(413, 256, 140, 30);

		Label = new JLabel();
		Label.setBounds(315, 325, 200, 30);
		Label.setFont(new Font("楷体", Font.ROMAN_BASELINE, 27));

		panel5.add(but1);
		panel5.add(but2);
		panel5.add(but3);
		panel5.add(Text1);
		panel5.add(Text2);
		panel5.add(Text3);
		panel5.add(Text4);
		panel5.add(Text5);
		panel5.add(Label);
		panel5.add(Label1);
		panel5.add(Label2);
		panel5.add(Label3);
		panel5.add(Label4);
		panel5.add(Label5);
		panel5.add(Label6);
		panel5.add(Label7);
		panel5.add(Label8);
		panel5.add(Label9);

		this.add(panel5);

		this.setSize(650, 500);
		this.setTitle("物主信息管理--公司收入");
		this.setIconImage((new ImageIcon(
				"image/Company_house_48px_520461_easyicon.net.png")).getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// 公司收支情况面板--返回按钮
		if (e.getSource().equals(but1)) {

			new MyManages();
			this.dispose();
		}

		// 公司收支情况面板--计算按钮
		else if (e.getSource().equals(but2)) {

			if (Text1.getText().isEmpty() | Text2.getText().isEmpty()
					| Text3.getText().isEmpty() | Text4.getText().isEmpty()
					| Text5.getText().isEmpty()) {

				JOptionPane.showMessageDialog(null, "请输入完整的信息!", "警告",
						JOptionPane.CANCEL_OPTION);
			}

			else {

				try{
					
					double m1 = Double.parseDouble(Text1.getText());
					double m2 = Double.parseDouble(Text2.getText());
					double m3 = Double.parseDouble(Text3.getText());
					double m4 = Double.parseDouble(Text4.getText());
					double m5 = Double.parseDouble(Text5.getText());

					double result = m4 + m5 - m1 - m2 - m3;
					Label.setText(Double.toString(result));

					but3.setEnabled(true);
				}catch(Exception e1){
					
					JOptionPane.showMessageDialog(null, "输入不正确!请重新输入.", "警告",
							JOptionPane.CANCEL_OPTION);
				}
			}
		}

		// 公司收支情况面板--保存按钮
		else if (e.getSource().equals(but3)) {

			File s = new File("data/panel5.txt");
			try {
				BufferedWriter write = new BufferedWriter(new FileWriter(s));

				write.append(Text1.getText());
				write.append(" ");
				write.append(Text2.getText());
				write.append(" ");
				write.append(Text3.getText());
				write.append(" ");
				write.append(Text4.getText());
				write.append(" ");
				write.append(Text5.getText());
				write.append(" ");
				write.append(Label.getText());
				write.newLine();
				write.flush();
				write.close();

				JOptionPane.showMessageDialog(null, "保存成功!", "保存",
						JOptionPane.INFORMATION_MESSAGE);

			} catch (IOException e1) {
				// TODO Auto-generated catch block

				JOptionPane.showMessageDialog(null, "保存失败!", "保存",
						JOptionPane.CANCEL_OPTION);
			}
		}
	}

}
