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
	@SuppressWarnings("unused")
	public static void Get_LocalHtml(Document doc) {
		// 创建新的对象，将数据存入数据库
		Connect_MySql dlmysql = new Connect_MySql();

		Elements container = doc.getElementsByClass("ttd2_background");
		Document containerDoc = Jsoup.parse(container.toString());

		// 景点介绍
		Elements brightspot = containerDoc.getElementsByClass("normalbox boxsight_v1");
		Document brightspotDoc = Jsoup.parse(brightspot.toString());
		// 亮点
		Elements brightspot2 = containerDoc.getElementsByClass("detailcon bright_spot");
		Document brightspotDoc2 = Jsoup.parse(brightspot2.toString());
		Elements bs = brightspotDoc2.select("li");
		System.out.println("亮点：" + bs.text());

		// 景点介绍
		Elements brightspot1 = containerDoc.getElementsByClass("toggle_s");
		Document brightspotDoc1 = Jsoup.parse(brightspot1.toString());
		Elements cmtslist1 = brightspotDoc1.getElementsByClass("text_style");
		System.out.println("景点介绍：" + cmtslist1.text());
		System.out.println("====================================");

		Elements module = containerDoc.getElementsByClass("comment_ctrip");
		Document moduleDoc = Jsoup.parse(module.toString());

		Elements cmtslist = moduleDoc.getElementsByClass("comment_single");

		for (Element clearfixli : cmtslist) {
			Document cleardixliDoc = Jsoup.parse(clearfixli.toString());
			// 解析出名字
			Element username = cleardixliDoc.select("span a").first();
			// 解析出评论内容
			// Elements comments = cleardixliDoc.select("");
			Elements comments = cleardixliDoc.getElementsByClass("heightbox");
			// 解析出图片
			Elements pic = cleardixliDoc.getElementsByClass("comment_piclist cf");
			Document moduleDoc1 = Jsoup.parse(pic.toString());
			Elements piclist = moduleDoc1.getElementsByClass("ttd_nopic84");
			if (piclist == null) {
				System.out.println("piclist为空");
			}
			for (Element clearsfixli1 : piclist) {

				Elements image = clearsfixli1.select("img[src$=.jpg]");
				if (image == null) {
					System.out.println("为空");
				}
				System.out.println("图片：" + image.text());// 图片
			}

			System.out.println("姓名：" + username.text());// 姓名
			System.out.println("评论内容：" + comments.text());// 评论内容
			// System.out.println("图片：" + pic.text());// 图片
			System.out.println("=================================");
			// 将姓名和评论内容存入数据库
			Connect_MySql.Connect_MySQL(username.text(), comments.text());
		}
		System.out.println("解析完成！");
	}
}
