package com.bStar.mportal.util;

import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class Dbutil {
	private static DataSource myDataSource = null;
	// ��ĳһ�������뵱ǰ�̰߳���һ��
	private static ThreadLocal<Connection> connLocal = new ThreadLocal<Connection>();

	private Dbutil() {
	}

	static {
		try {
			Properties prop = new Properties();
			InputStream in = Dbutil.class
					.getResourceAsStream("/dbcp.properties");
			prop.load(in);
			myDataSource = BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static DataSource getDataSource() {
		return myDataSource;
	}

	public static Connection getConnection() throws SQLException {
		// return DriverManager.getConnection(url, user, password);
		Connection conn = connLocal.get();
		if (conn == null) {
			conn = myDataSource.getConnection();
			connLocal.set(conn);
		}
		return conn;
	}

	public static void closeConnection() throws SQLException {
		Connection conn = connLocal.get();
		// important
		connLocal.set(null);
		if (conn != null)
			conn.close();
	}
}
