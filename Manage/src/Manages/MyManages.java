package Manages;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//物主信息管理界面
class MyManages extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 物主信息管理界面面板
	private JPanel Jpanel;
	// 物主信息管理界面按钮
	private JButton button, button0, button1, button2, button3, button4,
			button5;

	@SuppressWarnings({})
	public MyManages() {

		// 信息管理界面面板
		Jpanel = new JPanel() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {

				ImageIcon images = new ImageIcon(
						"image/2009102021214653355.jpg");
				Image im = images.getImage();
				g.drawImage(im, 0, 0, 650, 500, images.getImageObserver());

				ImageIcon images1 = new ImageIcon(
						"image/sign_130.09074410163px_1201346_easyicon.net.png");
				Image im1 = images1.getImage();
				g.drawImage(im1, 530, 390, 120, 110, images1.getImageObserver());

			}
		};
		Jpanel.setLayout(null);
		Jpanel.setBounds(0, 0, 650, 500);

		button0 = new JButton("退出");
		button0.setBounds(540, 410, 80, 30);
		button0.setFont(new Font("华文彩云", Font.PLAIN, 20));
		button0.setForeground(Color.red);
		button0.setBorderPainted(false);
		button0.setFocusable(false);
		button0.setContentAreaFilled(false);
		button0.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button0.addActionListener(this);

		button = new JButton(
				"业主信息管理",
				new ImageIcon(
						"image/business_man_consultancy_staff_user_64px_107_easyicon.net.png"));
		button.setBounds(35, 40, 200, 120);
		button.setFont(new Font("华文彩云", Font.PLAIN, 23));
		button.setForeground(Color.darkGray);
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		button.setVerticalTextPosition(JButton.BOTTOM);
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.addActionListener(this);

		button1 = new JButton(
				"业主车辆管理",
				new ImageIcon(
						"image/maserati_granturismo_sport_car_140.93617021277px_1146341_easyicon.net.png"));
		button1.setBounds(260, 40, 200, 120);
		button1.setFont(new Font("华文彩云", Font.PLAIN, 23));
		button1.setForeground(Color.darkGray);
		button1.setFocusPainted(false);
		button1.setContentAreaFilled(false);
		button1.setVerticalTextPosition(JButton.BOTTOM);
		button1.setHorizontalTextPosition(JButton.CENTER);
		button1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button1.addActionListener(this);

		button2 = new JButton("业主交费情况", new ImageIcon(
				"image/money_77.58024691358px_1202778_easyicon.net.png"));
		button2.setBounds(35, 179, 200, 120);
		button2.setFont(new Font("华文彩云", Font.PLAIN, 23));
		button2.setForeground(Color.darkGray);
		button2.setFocusPainted(false);
		button2.setContentAreaFilled(false);
		button2.setVerticalTextPosition(JButton.BOTTOM);
		button2.setHorizontalTextPosition(JButton.CENTER);
		button2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button2.addActionListener(this);

		button3 = new JButton(
				"公司员工信息",
				new ImageIcon(
						"image/male_man_provider_user_worker_64px_324_easyicon.net.png"));
		button3.setBounds(260, 179, 200, 120);
		button3.setFont(new Font("华文彩云", Font.PLAIN, 23));
		button3.setForeground(Color.darkGray);
		button3.setFocusPainted(false);
		button3.setContentAreaFilled(false);
		button3.setVerticalTextPosition(JButton.BOTTOM);
		button3.setHorizontalTextPosition(JButton.CENTER);
		button3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button3.addActionListener(this);

		button4 = new JButton("公司收入情况", new ImageIcon(
				"image/money_bag_50.859903381643px_1203089_easyicon.net.png"));
		button4.setBounds(35, 320, 200, 120);
		button4.setFont(new Font("华文彩云", Font.PLAIN, 23));
		button4.setForeground(Color.darkGray);
		button4.setFocusPainted(false);
		button4.setContentAreaFilled(false);
		button4.setVerticalTextPosition(JButton.BOTTOM);
		button4.setHorizontalTextPosition(JButton.CENTER);
		button4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button4.addActionListener(this);

		button5 = new JButton("统计表格", new ImageIcon(
				"image/form_64px_534999_easyicon.net.png"));
		button5.setBounds(260, 320, 200, 120);
		button5.setFont(new Font("华文彩云", Font.PLAIN, 23));
		button5.setForeground(Color.darkGray);
		button5.setFocusPainted(false);
		button5.setContentAreaFilled(false);
		button5.setVerticalTextPosition(JButton.BOTTOM);
		button5.setHorizontalTextPosition(JButton.CENTER);
		button5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button5.addActionListener(this);

		Jpanel.add(button);
		Jpanel.add(button0);
		Jpanel.add(button1);
		Jpanel.add(button2);
		Jpanel.add(button3);
		Jpanel.add(button4);
		Jpanel.add(button5);

		this.add(Jpanel);

		this.setSize(650, 500);
		this.setTitle("物主信息管理");
		this.setIconImage((new ImageIcon(
				"image/Company_house_48px_520461_easyicon.net.png")).getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		// 进入业主信息管理界面
		if (e.getSource().equals(button)) {

			new Jpanel1();
			this.dispose();
		}

		// 退出物主信息管理界面
		else if (e.getSource().equals(button0)) {

			System.exit(0);
		}

		// 进入车辆管理界面
		else if (e.getSource().equals(button1)) {

			new Jpanel2();
			this.dispose();
		}

		// 进入业主交费查询界面
		else if (e.getSource().equals(button2)) {

			new Jpanel3();
			this.dispose();
		}

		// 进入公司员工信息管理界面
		else if (e.getSource().equals(button3)) {

			new Jpanel4();
			this.dispose();
		}

		// 进入公司收入情况管理界面
		else if (e.getSource().equals(button4)) {

			new Jpanel5();
			this.dispose();
		}

		// 进入表格管理界面
		else if (e.getSource().equals(button5)) {

			new JPanel6();
			this.dispose();
		}

	}

}
