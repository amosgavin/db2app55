package com.ai.bce.auto.plugin.version.hand.util;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

public class SqlUtil {

	static String temp_insert = "insert into {0} ({1}) values ({2});";
	static String temp_update = "update {0} set {1} where {2};";
	static String temp_delete = "delete {0} where {1};";

	public static String exportSqlByDtl(String tableName, Map oldValue,
			Map newValue, String[] pk, String opType, Map columnType) {
		// TODO Auto-generated method stub
		String sql = "";
		int IopType = Integer.valueOf(opType).intValue();
		switch (IopType) {
		case 1:
			// 执行新增操作
			sql = exportSqlByInsert(tableName, oldValue, newValue, pk, opType,
					columnType);
			;
			break;
		case 2:
			// 执行删除操作
			sql = exportSqlByDelte(tableName, oldValue, newValue, pk, opType,
					columnType);
			break;
		case 3:
			// 执行更新操作
			sql = exportSqlByUpdate(tableName, oldValue, newValue, pk, opType,
					columnType);
			;
			break;
		default:
			break;
		}
		return sql;
	}

	public static String exportSqlByInsert(String tableName, Map oldValue,
			Map newValue, String[] pk, String opType, Map columnType) {
		// TODO Auto-generated method stub
		StringBuffer columnName = new StringBuffer();
		StringBuffer columnValue = new StringBuffer();
		Set set = newValue.entrySet();
		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			Entry entry = (Entry) iterator.next();
			String value2 = (String) entry.getValue();
			String keys = (String) entry.getKey();
			String key = (String) columnType.get(entry.getKey());
			columnName.append(keys + ",");
			String value = getValueByAType(value2, key);
			columnValue.append(value + ",");
		}
		String columnName_s = columnName.toString();
		if (columnName_s.length() > 1)
			columnName_s = columnName_s.substring(0, columnName_s.length() - 1);
		String values = columnValue.toString();
		if (values.length() > 1)
			values = values.substring(0, values.length() - 1);
		String[] params = new String[] { tableName, columnName_s, values };
		return replaceSql(temp_insert, params);
	}

	public static String getValueByAType(String value, String type) {
		if ("DATE".equals(type) || Date.class.getName().equals(type)) {
			return " to_date('" + value + "','yyyymmdd hh24:mm:ss') ";
		}
		return "'" + value + "'";
	}

	public static String exportSqlByDelte(String tableName, Map oldValue,
			Map newValue, String[] pkes, String opType, Map columnType) {
		// TODO Auto-generated method stub
		StringBuffer keyValue = new StringBuffer();
		for (int i = 0; i < pkes.length; i++) {
			String pk = pkes[i];
			// String value = (String) oldValue.get(pk);
			String value2 = (String) oldValue.get(pk);
			String key = (String) columnType.get(pk);
			String value = getValueByAType(value2, key);
			keyValue.append(pk + "=" + value + " ");
			if (i != pkes.length - 1)
				keyValue.append(" and ");
		}
		return replaceSql(temp_delete, new String[] { tableName,
				keyValue.toString() });
	}

	public static String exportSqlByUpdate(String tableName, Map oldValue,
			Map newValue, String[] pkes, String opType, Map columnType) {
		// TODO Auto-generated method stub
		StringBuffer keyValue = new StringBuffer();

		for (int i = 0; i < pkes.length; i++) {
			String pk = pkes[i];
			// String value = (String) oldValue.get(pk);
			String value2 = (String) oldValue.get(pk);
			String key = (String) columnType.get(pk);
			String value = getValueByAType(value2, key);
			keyValue.append(pk + "=" + value + " ");
			if (i != pkes.length - 1)
				keyValue.append(" and ");
		}

		StringBuffer columnValue = new StringBuffer();
		Set set = newValue.entrySet();
		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			Entry entry = (Entry) iterator.next();
			String key = (String) entry.getKey();
			String value2 = (String) entry.getValue();
			String type = (String) columnType.get(entry.getKey());
			String value = getValueByAType(value2, type);
			if (!isPk(pkes, key))
				columnValue.append(key + " = " + value + " ,");
		}
		String values = columnValue.toString();
		if (columnValue.toString().length() > 1)
			values = values.substring(0, values.length() - 1);
		return replaceSql(temp_update, new String[] { tableName, values,
				keyValue.toString() });
	}

	private static boolean isPk(String[] pkes, String key) {
		boolean isPk = false;
		for (int i = 0; i < pkes.length; i++) {
			if (key.equals(pkes[i])) {
				isPk = true;
				break;
			}
		}
		return isPk;
	}

	public static String replaceSql(String sql, String[] params) {
		// TODO Auto-generated method stub
		for (int i = 0; i < params.length; i++) {
			String param = params[i];
			sql = StringUtils.replace(sql, "{" + i + "}", param);
		}
		return sql;
	}

}
