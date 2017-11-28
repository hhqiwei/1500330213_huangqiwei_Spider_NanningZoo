package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @ClassName: Clean_MySql
 * @Description: 清空数据库的内容
 * @author 黄启威
 * @date 2017年11月18日 下午4:15:48
 *
 */
public class Clean_MySql {
	/**
	 * @Title: clean_mysql @Description: 清空数据表，tablename为要清空的数据表 @param
	 *         设定文件 @return void 返回类型 @throws
	 */
	public void clean_mysql(String tablename) {
		// 声明connection对象
		Connection con;
		// 驱动程序名称
		String driver = "com.mysql.jdbc.Driver";
		// URL指向要访问的数据库名mydata
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
			// 清空数据库指令
			psql = con.prepareStatement("truncate table " + tablename);
			psql.executeUpdate(); // 执行更新
		} catch (ClassNotFoundException e) {
			System.out.println("Sorry,can't find the Driver!");
			e.printStackTrace();
		} catch (SQLException e) {
			// 数据库连接失败异常处理
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("+++++清空数据表" + tablename + "成功。+++++");
		}
	}
}
