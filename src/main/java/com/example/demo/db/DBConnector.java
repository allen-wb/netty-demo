package com.example.demo.db;

import com.example.demo.util.FileUtils;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created on 18/10/22
 *
 * @author wb
 */
public class DBConnector {
    private static final Logger logger = LoggerFactory.getLogger(DBConnector.class);
    private static DBConnector instance;
    private DataSource dataSource;

    public static synchronized DBConnector getInstance() {
        if (null == instance) {
            instance = new DBConnector();
        }
        return instance;
    }

    private DBConnector() {
        Properties hikariProps = FileUtils.loadProperties("hikari.properties");
        HikariConfig hikariConfig = new HikariConfig(hikariProps);
        dataSource = new HikariDataSource(hikariConfig);
        logger.info("DBConnector 已连接");
    }

}
