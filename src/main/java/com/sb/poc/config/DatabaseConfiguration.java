package com.sb.poc.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration {

    public static final String TEST_DATASOURCE = "TestDS";

    private static final String IP_TEST_DB = "localhost";

    private static final String SERVICE_TEST_DB = "xe";

    private static final String USERNAME_TEST_DB = "allcom";

    private static final String PASSWORD_TEST_DB = "allcom1";

    private static final String PORT_DB = "1521";

    private static final String DRIVER_DB = "oracle.jdbc.OracleDriver";

    @Bean(name = TEST_DATASOURCE, destroyMethod = "")
    public DataSource dataSourceTestDB() {
        System.out.println("Datos de conexion TestDB, ip: " + IP_TEST_DB + ", schema: " + SERVICE_TEST_DB);
        System.out.println("User: " + USERNAME_TEST_DB + ", pass: " + PASSWORD_TEST_DB);

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:oracle:thin:@//" + IP_TEST_DB + ":" + PORT_DB + "/" + SERVICE_TEST_DB);
        config.setUsername(USERNAME_TEST_DB);
        config.setPassword(PASSWORD_TEST_DB);
        config.setDriverClassName(DRIVER_DB);
        return new HikariDataSource(config);
    }
}
