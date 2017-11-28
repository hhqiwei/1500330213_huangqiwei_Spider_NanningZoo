package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ClassName: Show_MySql
 * @Description: 显示数据库内容
 * @author 黄启威
 * @date 2017年11月16日 下午8:47:10
 *
 */
public class Show_MySql {
	/**
	 * @Title: Show_MySQL @Description: 显示数据库Spider_NanningZoo内容 @param
	 *         设定文件 @return void 返回类型 @throws
	 */
	public static void Show_Spider_NanningZoo_MySQL() {
		// 声明connection对象
		Connection con;
		// 驱动程序名称
		String driver = "com.mysql.jdbc.Driver";
		// URL指向要访问的数据库名mydata
		String url = "jdbc:mysql://localhost:3306/1500330213_huangqiwei_NanningZoo_Spider?useUnicode=true&amp;characterEncoding=utf-8&useSSL=false";
		// MySQL配置时的用户名
		String user = "root";
		// MySQL配置时的密码
		String password = "huangqiwei";
		// 遍历查询结果集
		try {
			// 加载驱动程序
			Class.forName(driver);
			// 1.getConnection()方法，连接MySQL数据库！！
			con = DriverManager.getConnection(url, user, password);
			if (!con.isClosed()) {
				System.out.println("Succeeded connecting to the Database!");
			}
			// 2.创建statement类对象，用来执行SQL语句！！
			Statement statement = con.createStatement();
			// 要执行的SQL语句
			String sql = "select * from Spider_NanningZoo";
			// 3.ResultSet类，用来存放获取的结果集！！
			ResultSet rs = statement.executeQuery(sql);
			String username;
			String comments;
			System.out.println("+++++++++数据库内容+++++++++");
			while (rs.next()) { // 获取stuname这列数据
				username = rs.getString("username"); // 获取stuid这列数据
				comments = rs.getString("comments"); // 输出结果
				System.out.println("用户名:" + username);
				System.out.println("评论内容：" + comments + '\n');
			}
			rs.close();
			con.close();
		} catch (ClassNotFoundException e) {

			System.out.println("Sorry,can't find the Driver!");
			e.printStackTrace();
		} catch (SQLException e) {

			// 数据库连接失败异常处理
			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			System.out.println("数据库数据成功获取！！");
		}
	}

	/**
	 * @Title: Show_Spider_NanningZoo_MySQL @Description:
	 *         显示数据表Spider_NanningZoo内容，网页标题title、景点地址address、门票tickets、评分score、开放时间open_time、景点介绍attractions、交通信息travel_information @param
	 *         设定文件 @return void 返回类型 @throws
	 */
	public static void Show_Spider_Informatin_MySQL() {
		// 声明connection对象
		Connection con;
		// 驱动程序名称
		String driver = "com.mysql.jdbc.Driver";
		// URL指向要访问的数据库名mydata
		String url = "jdbc:mysql://localhost:3306/1500330213_huangqiwei_NanningZoo_Spider?useUnicode=true&amp;characterEncoding=utf-8&useSSL=false";
		// MySQL配置时的用户名
		String user = "root";
		// MySQL配置时的密码
		String password = "huangqiwei";
		// 遍历查询结果集
		try {
			// 加载驱动程序
			Class.forName(driver);
			// 1.getConnection()方法，连接MySQL数据库！！
			con = DriverManager.getConnection(url, user, password);
			if (!con.isClosed()) {
				System.out.println("Succeeded connecting to the Database!");
			}
			// 2.创建statement类对象，用来执行SQL语句！！
			Statement statement = con.createStatement();
			// 要执行的SQL语句
			String sql = "select * from spider_information";
			// 3.ResultSet类，用来存放获取的结果集！！
			ResultSet rs = statement.executeQuery(sql);

			String title;
			String address;
			String tickets;
			String score;
			String open_time;
			String attractions;
			String travel_information;

			System.out.println("+++++++++spider_information数据表内容+++++++++");
			while (rs.next()) {
				title = rs.getString("title"); // 获取
				address = rs.getString("address"); //
				tickets = rs.getString("tickets"); // 获取
				score = rs.getString("score"); //
				open_time = rs.getString("open_time"); // 获取
				attractions = rs.getString("attractions"); //
				travel_information = rs.getString("travel_information"); // 获取

				System.out.println("网页标题:" + title);
				System.out.println("景点地址：" + address);
				System.out.println("门票:" + tickets);
				System.out.println("评分：" + score);
				System.out.println("开放时间:" + open_time);
				System.out.println("景点介绍：" + attractions);
				System.out.println("交通信息:" + travel_information);
			}
			rs.close();
			con.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Sorry,can't find the Driver!");
			e.printStackTrace();
		} catch (SQLException e) {
			// 数据库连接失败异常处理
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("数据库数据spider_information成功获取！！");
		}
	}

}
