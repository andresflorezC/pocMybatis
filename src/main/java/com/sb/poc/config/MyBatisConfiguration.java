package com.sb.poc.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.inject.Named;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = { "com.sb.poc.cursorsmybatis.repository" ,"com.sb.poc.transactions.repository" },
        sqlSessionTemplateRef = "TestSessionTemplate")
public class MyBatisConfiguration {

    private static final String TESTDB_SESSION_FACTORY = "TestDBSessionFactory";

    /**
     * Aquí se define la interface SqlSession para la base de datos de prueba usada en este POC.
     * Se define la ubicación de los mappers relacionados con esa base de datos con setMapperLocations
     * @param anotherDataSource
     * @return

    **/
    @Bean(name = TESTDB_SESSION_FACTORY, destroyMethod = "")
    public SqlSessionFactoryBean crvSqlSessionFactory(
            @Named(DatabaseConfiguration.TEST_DATASOURCE) final DataSource anotherDataSource) {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(anotherDataSource);

        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResource("classpath:sqlmapper/mapper.xml"));

        return sqlSessionFactoryBean;
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(
            @Qualifier(DatabaseConfiguration.TEST_DATASOURCE) DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "TestSessionTemplate")
    public SqlSessionTemplate secondarySessionTemplate(@Qualifier(TESTDB_SESSION_FACTORY) SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
