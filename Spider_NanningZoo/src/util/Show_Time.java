package util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: Show_Time
 * @Description: 显示时间
 * @author 黄启威
 * @date 2017年11月18日 下午4:30:41
 *
 */
public class Show_Time {
	public void show_time() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		String time = simpleDateFormat.format(new Date());
		System.out.println(time);
	}
}
