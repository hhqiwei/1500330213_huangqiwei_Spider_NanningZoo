package parse;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import db.Connect_MySql;

/**
 * @ClassName: Parse_Web1
 * @Description: (途牛http://menpiao.tuniu.com/t_4805)解析途牛网页的网页标题、景点地址、门票、评分、开放时间、景点介绍、交通信息
 * @author 黄启威
 * @date 2017-11-18 星期六 11:00:14
 *
 */
public class Parse_Web2 {

	public static void Get_LocalHtml(Document doc) {

		// 网页标题head > title
		Elements title = doc.select("head").select("title");
		// System.out.println("网页标题：" + title.text());

		// 景点地址address,.v2_detail_address > span:nth-child(1)
		Elements address = doc.select(".v2_detail_address").select("span:nth-child(1)");
		// System.out.println("景点地址：" + address.text());

		// 门票tickets，.v2-price
		Elements tickets = doc.select(".v2-price");
		// 去掉“价 格：”
		// System.out.println("门票：" + tickets.text().replace("价 格：", ""));

		// 评分score，.v2_tp_sat > span:nth-child(1)
		Elements score = doc.select(".v2_tp_sat").select("span:nth-child(1)");
		// System.out.println("评分/满意度：" + score.text());

		// 开放时间open_time，.order_detail_imfor > dl:nth-child(1) > dd:nth-child(2)
		Elements open_time = doc.select(".order_detail_imfor").select("dl:nth-child(1)").select("dd:nth-child(2)");
		// System.out.println("开放时间：" + open_time.text());

		// 景点简介attractions,.v2_di
		Elements attractions = doc.select(".v2_di");
		// System.out.println("景点介绍：" + attractions.text());

		// 交通信息travel_information,li.clearfix:nth-child(1) > p:nth-child(2)
		Elements travel_information = doc.select("li.clearfix:nth-child(1)").select("p:nth-child(2)");
		// System.out.println("交通信息：" + travel_information.text());

		// System.out.println("+++++++解析完成！+++++++");

		// 将解析出的数据存入数据库spider_informaiton中
		Connect_MySql cMySql = new Connect_MySql();
		cMySql.Save_Informaton_MySQL(title.text(), address.text(), tickets.text().replace("价　　格：", ""), score.text(),
				open_time.text(), attractions.text(), travel_information.text());
	}
}
