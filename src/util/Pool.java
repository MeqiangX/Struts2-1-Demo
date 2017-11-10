package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;

public class Pool {
     private static BasicDataSource datasource = new BasicDataSource();
     
     //获取连接池对象
     static {
    	 Properties pr = new Properties();
    	 try {
			pr.load(Pool.class.getClassLoader().getResourceAsStream("DBconfig.properties"));
			
			//加载配置文件  配置四大参数
			datasource.setDriverClassName(pr.getProperty("driver"));
			datasource.setUrl(pr.getProperty("url"));
			datasource.setUsername(pr.getProperty("user"));
			datasource.setPassword(pr.getProperty("password"));
			
			//配置池参数  最小空闲连接数  最大连接数 最大等待时间
			datasource.setMinIdle(3);
			datasource.setMaxTotal(20);
			datasource.setMaxWaitMillis(1000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
     }
     
     public static Connection getConnection() {
    	 try {
			return datasource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 return null;
     }
}
