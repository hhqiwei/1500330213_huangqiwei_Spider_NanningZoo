package parse;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import db.Connect_MySql;

/**
 * @ClassName: Parse_Web1
 * @Description: (马蜂窝http://www.mafengwo.cn/poi/5435132.html)解析马蜂窝网页的网页标题、景点地址、门票、评分、开放时间、景点介绍、交通信息
 * @author 黄启威
 * @date 2017-11-18 星期六 11:18:42
 *
 */
public class Parse_Web4 {

	public void Get_LocalHtml(Document doc) {

		// 网页标题title，head > title
		Elements title = doc.select("head").select("title");
		System.out.println("网页标题：" + title.text());

		// 景点地址address,.sub
		Elements address = doc.select(".sub");
		System.out.println("景点地址：" + address.text());

		// 门票tickets，div.mod:nth-child(2) > dl:nth-child(4) > dd:nth-child(2) >
		// div:nth-child(1)
		Elements tickets = doc.select("div.mod:nth-child(2)").select("dl:nth-child(4)").select("dd:nth-child(2)")
				.select("div:nth-child(1)");
		System.out.println("门票：" + tickets.text());

		// 评分score，.v2_tp_sat > span:nth-child(1)
		Elements score = doc.select(".v2_tp_sat").select("span:nth-child(1)");
		System.out.println("评分/满意度：" + score.text());

		// 开放时间open_time，div.mod:nth-child(2) > dl:nth-child(5) >
		// dd:nth-child(2)
		Elements open_time = doc.select("div.mod:nth-child(2)").select("dl:nth-child(5)").select("dd:nth-child(2)");
		System.out.println("开放时间：" + open_time.text());

		// 景点简介attractions,.summary
		Elements attractions = doc.select(".summary");
		System.out.println("景点介绍：" + attractions.text());

		// 交通信息travel_information,div.mod:nth-child(2) > dl:nth-child(3) >
		// dd:nth-child(2)
		Elements travel_information = doc.select("div.mod:nth-child(2)").select("dl:nth-child(3)")
				.select("dd:nth-child(2)");
		System.out.println("交通信息：" + travel_information.text().replace("[1]", ""));

		System.out.println("+++++++解析完成！+++++++");

		// 将解析出的数据存入数据库spider_informaiton中
		Connect_MySql cMySql = new Connect_MySql();
		cMySql.Save_Informaton_MySQL(title.text(), address.text(), tickets.text().replace("价　　格：", ""), score.text(),
				open_time.text(), attractions.text(), travel_information.text());
	}
}
