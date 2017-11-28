package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @ClassName: Connect_MySql
 * @Description: 连接数据库方法
 * @author 黄启威
 * @date 2017年11月16日 下午8:43:41
 *
 */
public class Connect_MySql {
	/**
	 * @Title: Connect_MySQL @Description: 将数据保存到Spider_NanningZoo表中 @param
	 *         username @param comments 设定文件 @return void 返回类型 @throws
	 */
	public static void Connect_MySQL(String username, String comments) {
		// 声明connection对象
		Connection con;
		// 驱动程序名称
		String driver = "com.mysql.jdbc.Driver";
		// URL指向要访问的数据库名mydata
		String url = "jdbc:mysql://localhost:3306/1500330213_黄启威_NanningZoo_Spider";
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

			PreparedStatement psql;

			// 预处理添加数据，其中有两个参数--“？”
			psql = con.prepareStatement("insert into Spider_NanningZoo (username,comments)" + "values(?,?)");

			psql.setString(1, username); // 设置参数1，
			psql.setString(2, comments);// 设置参数2，name
			psql.executeUpdate(); // 执行更新

		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("Sorry,can't find the Driver!");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO: handle exception
			// 数据库连接失败异常处理
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			System.out.println("数据库连接成功！！");
		}
	}

	/**
	 * @Title: Save_Informaton_MySQL @Description:
	 *         将数据保存到Spider_information表中 @param @param username @param @param
	 *         comments 设定文件 @return void 返回类型 @throws
	 */
	public void Save_Informaton_MySQL(String title, String address, String tickets, String score, String open_time,
			String attractions, String travel_information) {
		// 声明connection对象
		Connection con;
		// 驱动程序名称
		String driver = "com.mysql.jdbc.Driver";
		// URL指向要访问的数据库名mysql
		String url = "jdbc:mysql://localhost:3306/1500330213_huangqiwei_NanningZoo_Spider";
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

			PreparedStatement psql;

			// 预处理添加数据，其中有两个参数--“？”
			psql = con.prepareStatement(
					"insert into spider_information (title,address,tickets,score,open_time,attractions,travel_information)"
							+ "values(?,?,?,?,?,?,?)");

			psql.setString(1, title); // 设置参数1，
			psql.setString(2, address);// 设置参数2，
			psql.setString(3, tickets); // 设置参数3，
			psql.setString(4, score);// 设置参数4，
			psql.setString(5, open_time); // 设置参数5，
			psql.setString(6, attractions);// 设置参数6，
			psql.setString(7, travel_information); // 设置参数7，
			psql.executeUpdate(); // 执行更新

		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("Sorry,can't find the Driver!");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO: handle exception
			// 数据库连接失败异常处理
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			System.out.println("保存到数据库Spider_information表成功！！");
		}
	}
}
