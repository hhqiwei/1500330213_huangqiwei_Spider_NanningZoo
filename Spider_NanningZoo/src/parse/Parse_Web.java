package parse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import db.Connect_MySql;

/**
 * @ClassName: Parse_Web
 * @Description: 用JSOUP解析本地的html文件，并存入数据库
 * @author 黄启威
 * @date 2017年11月16日 下午9:18:05
 *
 */
public class Parse_Web {

	public static void Get_LocalHtml(Document doc) {
		// 创建新的对象，将数据存入数据库
		@SuppressWarnings("unused")
		Connect_MySql dlmysql = new Connect_MySql();

		Elements container = doc.getElementsByClass("ttd2_background");
		Document containerDoc = Jsoup.parse(container.toString());

		Elements module = containerDoc.getElementsByClass("l-comments");
		Document moduleDoc = Jsoup.parse(module.toString());

		Elements cmtslist = moduleDoc.getElementsByClass("layoutfix");

		for (Element clearfixli : cmtslist) {
			Document cleardixliDoc = Jsoup.parse(clearfixli.toString());
			// 解析出名字，#J-comments > ul > li:nth-child(1) > div > span
			Elements username = cleardixliDoc.select("div").select("span");
			// 解析出评论内容,#J-comments > ul > li:nth-child(1) > p
			Elements comments = cleardixliDoc.select("p");

			System.out.println("姓名：" + username.text());// 姓名
			System.out.println("评论内容：" + comments.text());// 评论内容
			System.out.println("=================================");
			// 将姓名和评论内容存入数据库
			Connect_MySql.Connect_MySQL(username.text(), comments.text());
		}
		System.out.println("评论解析完成！");
	}
}
