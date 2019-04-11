package com.finance.qiongcang.util;

import java.util.Random;
import java.util.UUID;

public class UuidUtil {

	public static String get32UUID() {
		String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
		return uuid;
	}

	public static String get19Date() {
		Random r = new Random();
		//得到时间戳+6位随机数
		return String.valueOf(System.currentTimeMillis())+(r.nextInt(900000) + 100000);
	}
}
