package com.learn2rise.db;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DataSource {

	private static HikariConfig config = new HikariConfig();
	private static HikariDataSource ds;

	static {
		config.setJdbcUrl("jdbc:postgresql://localhost:5432/rise2earn");
		config.setUsername("postgres");
		config.setPassword("root");
		config.setMaximumPoolSize(2);

		// config.setDataSourceClassName("org.postgresql.ds.PGSimpleDataSource");
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		ds = new HikariDataSource(config);
	}

	public static void main(String args[]) throws Exception {

		Connection con = DataSource.getConnection();

	}

	private DataSource() {
	}

	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
}