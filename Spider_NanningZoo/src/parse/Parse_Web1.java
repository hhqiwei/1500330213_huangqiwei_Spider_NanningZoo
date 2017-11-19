package parse;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import db.Connect_MySql;

/**
 * @ClassName: Parse_Web1
 * @Description: (携程http://piao.ctrip.com/dest/t8812.html)解析携程网页的网页标题、景点地址、门票、评分、开放时间、、景点介绍、交通信息
 * @author 黄启威
 * @date 2017年11月17日 下午3:43:49
 *
 */
public class Parse_Web1 {

	public static void Get_LocalHtml(Document doc) {

		// 网页标题head > title
		Elements title = doc.select("head").select("title");
		System.out.println("网页标题：" + title.text());

		// 景点地址address,#media-wrapper > div.media-right > ul > li:nth-child(1) >
		// span
		Elements address = doc.select("#media-wrapper").select("div.media-right").select("ul").select("li:nth-child(1)")
				.select("span");
		System.out.println("景点地址：" + address.text());

		// 门票tickets，#media-wrapper > div.media-price > div > span
		// #media-wrapper > div.media-price > div
		Elements tickets = doc.select("#media-wrapper").select("div.media-price");
		System.out.println("门票：" + tickets.text());

		// 评分/满意度score，#J-grade > i
		Elements score = doc.select("#J-grade").select("i");
		System.out.println("评分/满意度：" + score.text());

		// 开放时间open_time，.j-limit
		// Element open_time = containerDoc1.select("span:contains(1)").first();
		Elements open_time = doc.select(".j-limit");
		System.out.println("开放时间：" + open_time.text());

		// 景点简介attractions,.feature-content
		Elements attractions = doc.select(".feature-content");
		System.out.println("景点介绍：" + attractions.text());

		// 交通信息travel_information
		Elements travel_information = doc.getElementsByClass("feature-traffic");
		// container3.text().replace("交通信息", "")去除读取到的"交通信息"
		System.out.println("交通信息：" + travel_information.text().replace("交通信息", ""));

		System.out.println("+++++++解析完成！+++++++");

		// 将解析出的数据存入数据库spider_informaiton中
		Connect_MySql cMySql = new Connect_MySql();
		cMySql.Save_Informaton_MySQL(title.text(), address.text(), tickets.text(), score.text(), open_time.text(),
				attractions.text(), travel_information.text().replace("交通信息", ""));
	}
}
