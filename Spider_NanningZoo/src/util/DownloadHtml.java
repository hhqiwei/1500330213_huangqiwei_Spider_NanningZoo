package util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * @ClassName: DownloadHtml
 * @Description: 将网页下载保存到temp_html文件夹中
 * @author 黄启威
 * @date 2017年11月16日 下午9:14:11
 *
 */
public class DownloadHtml {
	// 根据url从网络获取网页文本
	public Document getHtmlTextByUrl(String url) {
		Document doc = null;
		try {
			// doc = Jsoup.connect(url).timeout(5000000).get();
			// 做一个随机延时，防止网站屏蔽
			int i = (int) (Math.random() * 1000);
			while (i != 0) {
				i--;
			}
			// doc = Jsoup.connect(url).data("query", "Java")
			// .userAgent(
			// "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML,
			// like Gecko) Chrome/61.0.3163.100 Safari/537.36")
			// .referrer("http://www.dianping.com/shop/3492262/review_more")
			// .cookie("auth",
			// "_lx_utm=utm_source%3DBaidu%26utm_medium%3Dorganic;
			// _lxsdk_cuid=15f2515d55fc8-0b0306004ddbfd-3e63430c-1fa400-15f2515d56050;
			// _lxsdk=15f2515d55fc8-0b0306004ddbfd-3e63430c-1fa400-15f2515d56050;
			// _hc.v=ea199585-8f97-7082-1b6e-bbc7e4acd02e.1508155709; aburl=1;
			// cy=224; cye=nanning; JSESSIONID=73BDDD5095CD2A7EC7B6D328BF76B529;
			// thirdtoken=73BDDD5095CD2A7EC7B6D328BF76B529;
			// _lxsdk_s=15f2991a94e-f49-470-1c4%7C%7C4")
			// .timeout(3000).get();

			doc = Jsoup.connect(url).data("query", "Java")
					.header("User-Agent",
							"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36")
					.referrer("http://you.ctrip.com/sight/nanning166/8812.html")
					.cookie("auth",
							"ASP.NET_SessionId=lh2qq3atxbjdlb3fi40y54h0; ASP.NET_SessionSvc=MTAuOC4xODkuNTV8OTA5MHxqaW5xaWFvfGRlZmF1bHR8MTUwMDM2MDMzOTk1NQ; appFloatCnt=2; manualclose=1; _abtest_userid=0fab0138-d2f7-4a25-822a-881df6300150; _bfa=1.1508230916896.3x8flt.1.1508230916896.1508577480287.2.4; _bfs=1.3; page_time=1508230918302%2C1508577481561%2C1508577976554%2C1508577982996; _RF1=182.91.227.74; _RSG=Iyqxe15a4BD.NhxcA8hXgB; _RDG=28bd8425859c2a25372add4c35bf097bd9; _RGUID=d2c49050-68ef-4f12-baa1-ac82a6eeb5fe; Session=smartlinkcode=U130026&smartlinklanguage=zh&SmartLinkKeyWord=&SmartLinkQuary=&SmartLinkHost=; Union=AllianceID=4897&SID=130026&OUID=&Expires=1509182783861; _jzqco=%7C%7C%7C%7C%7C1.1734158844.1508230919870.1508577483027.1508577983896.1508577483027.1508577983896.0.0.0.3.3; __zpspc=9.3.1508577983.1508577983.1%232%7Cwww.baidu.com%7C%7C%7C%7C%23; MKT_Pagesource=PC; _bfi=p1%3D290510%26p2%3D100003%26v1%3D4%26v2%3D3")
					.timeout(3000).get();

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("post方法失败");
			try {
				doc = Jsoup.connect(url).timeout(50000).post();
			} catch (IOException e2) {
				e2.printStackTrace();
				System.out.println("get方法失败");
			}
		}
		return doc;
	}

	// 根据本地路径获取网页文本，如果不存在就通过url从网络获取并保存
	/**
	 * @Title: getHtmlTextByPath @Description:
	 *         根据本地路径获取网页文本，如果不存在就通过url从网络获取并保存 @param name @param url @param
	 *         设定文件 @return Document 返回类型 @throws
	 */
	public Document getHtmlTextByPath(String name, String url) {
		String path = "temp_html/" + name + ".html";
		Document doc = null;
		File input = new File(path);
		// String urlcat = url;
		try {
			doc = Jsoup.parse(input, "UTF-8");
			if (!doc.children().isEmpty()) {
				doc = null;
				System.out.println(name + ".html" + "已经存在,即将删除！");
				if (input.delete()) {
					System.out.println("删除成功:" + name + ".html");
				} else {
					System.out.println("删除失败！");
				}
				System.out.println("正在从网络获取" + url + "的源代码.");
				doc = this.getHtmlTextByUrl(url);
				// 并且保存到本地
				this.Save_Html(url, name); // 此处为保存网页的函数
			}
		} catch (IOException e) {
			System.out.println("正在从网络获取" + url + "的源代码.");
			doc = this.getHtmlTextByUrl(url);
			// 并且保存到本地
			this.Save_Html(url, name); // 此处为保存网页的函数
		}
		return doc;
	}

	// 将网页保存在本地（通过url,和保存的名字）
	/**
	 * @Title: Save_Html @Description: 把网页源代码保存到对应的文件中 @param url @param name
	 *         设定文件 @return void 返回类型 @throws
	 */
	public void Save_Html(String url, String name) {
		// 设置时间输出格式
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		String time = simpleDateFormat.format(new Date());
		try {
			name = name + time + ".html";
			// System.out.print(name);
			File dest = new File("temp_html/" + name);
			// 接收字节输入流
			InputStream is;
			// 字节输出流
			FileOutputStream fos = new FileOutputStream(dest);

			URL temp = new URL(url);

			is = temp.openStream();

			// 为字节输入流加缓冲
			BufferedInputStream bis = new BufferedInputStream(is);
			// 为字节输出流加缓冲
			BufferedOutputStream bos = new BufferedOutputStream(fos);

			int length;
			byte[] bytes = new byte[1024 * 20];
			while ((length = bis.read(bytes, 0, bytes.length)) != -1) {
				fos.write(bytes, 0, length);
			}
			System.out.println("保存文件成功！");
			bos.close();
			fos.close();
			bis.close();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
