package com.ai.bce.auto.plugin.version.hand.util;

import java.sql.Timestamp;
import java.util.Date;

public class BceUtil {

	public static int STATE_NOMAL = 1;

	public static Timestamp getTimestampByDate(Date date) {
		return new Timestamp(date.getTime());
	}

}
