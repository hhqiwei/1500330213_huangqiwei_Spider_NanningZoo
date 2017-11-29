package util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.stream.FileImageOutputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

/**
 * @ClassName: Download_Image
 * @Description: 爬取图片到文件夹中
 * @author 黄启威
 * @date 2017年11月19日 下午4:27:35
 *
 */
public class Download_Image {

	public static void main(String[] args) {
		String newImgUrl = downloadImg("www.baidu.com", "/home/test/workspace/images",
				"test" + System.currentTimeMillis() + ".png");
	}

	public static String downloadImg(String imgUri, String directory, String fileName) {
		HttpClient client = HttpClients.createDefault();
		HttpGet get = new HttpGet(imgUri);
		FileImageOutputStream fios = null;
		InputStream in = null;
		ByteArrayOutputStream baos = null;
		try {
			baos = new ByteArrayOutputStream();
			HttpResponse hr = client.execute(get);
			HttpEntity entity = hr.getEntity();
			in = entity.getContent();
			byte[] buffer = new byte[1024];
			int len = -1;
			while ((len = in.read(buffer)) > 0) {
				baos.write(buffer, 0, len);
			}
			byte[] b = baos.toByteArray();
			// 创建目录
			File dir = new File(directory);
			if (!dir.exists()) {
				dir.mkdirs();
				File file = new File(dir, fileName);
				if (!file.exists()) {
					file.createNewFile();
					fios = new FileImageOutputStream(file);
					fios.write(b);
				}
			} else {
				File file = new File(dir, fileName);
				file.createNewFile();
				fios = new FileImageOutputStream(file);
				fios.write(b);
			}
			return dir + "/" + fileName;
		} catch (IOException e) {
			// 异常处理
			if (null != fios) {
				try {
					fios.close();
				} catch (IOException e1) {

				}
			}

		}
		return null;
	}
}
