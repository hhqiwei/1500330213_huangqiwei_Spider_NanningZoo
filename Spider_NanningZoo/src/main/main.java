package main;

import org.jsoup.nodes.Document;

import db.Clean_MySql;
import db.Show_MySql;
import parse.Parse_Web;
import parse.Parse_Web1;
import parse.Parse_Web2;
import parse.Parse_Web3;
import parse.Parse_Web4;
import util.Delete_Files;
import util.DownloadHtml;
import util.Show_Time;

public class main {

	public static void main(String[] args) {
		// 携程：http://piao.ctrip.com/dest/t8812.html
		// 途牛:http://menpiao.tuniu.com/t_4805
		// 访问链接并获取页面内容保存为HTML文件
		DownloadHtml dlh = new DownloadHtml();
		Show_MySql sms = new Show_MySql();
		Clean_MySql cms = new Clean_MySql();
		Parse_Web pWeb = new Parse_Web();
		Parse_Web1 pWeb1 = new Parse_Web1();
		Parse_Web2 pWeb2 = new Parse_Web2();
		Parse_Web3 pWeb3 = new Parse_Web3();
		Parse_Web4 pWeb4 = new Parse_Web4();
		Show_Time st = new Show_Time();
		Delete_Files df = new Delete_Files();

		// 删除文件
		Delete_Files.delFolder("temp_html");
		st.show_time();
		// 清空spider_information数据表
		cms.clean_mysql("spider_information");

		// string数组用来存放网页
		String[] strArray = { "http://piao.ctrip.com/dest/t8812.html", "http://menpiao.tuniu.com/t_4805",
				"https://baike.baidu.com/item/%E5%8D%97%E5%AE%81%E5%8A%A8%E7%89%A9%E5%9B%AD/8663899?fr=aladdin",
				"http://www.mafengwo.cn/poi/5435132.html" };
		// string数组用来存放文件名字
		String[] strArray1 = { "携程", "途牛", "百度百科", "马蜂窝" };
		//
		Document[] doc = { null, null, null, null };
		for (int i = 0; i < 4; i++) {
			doc[i] = dlh.getHtmlTextByPath(strArray1[i], strArray[i]);
		}

		pWeb.Get_LocalHtml(doc[0]);

		pWeb1.Get_LocalHtml(doc[0]);
		pWeb2.Get_LocalHtml(doc[1]);
		pWeb3.Get_LocalHtml(doc[2]);
		pWeb4.Get_LocalHtml(doc[3]);

		// Show_MySql.Show_Spider_Informatin_MySQL();
		// Show_MySql.Show_Spider_NanningZoo_MySQL();
		st.show_time();
	}
}
