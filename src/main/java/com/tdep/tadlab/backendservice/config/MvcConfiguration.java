package com.tdep.tadlab.backendservice.config;

import com.tdep.tadlab.backendservice.data.dao.JobDAO;
import com.tdep.tadlab.backendservice.data.dao.JobDAOImpl;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.tdep.tadlab.backendservice")
@EnableWebMvc
public class MvcConfiguration implements WebMvcConfigurer {

  private static final String PG_URL = System.getenv("POSTGRES_URL");
  private static final String PG_USER = System.getenv("POSTGRES_USER");
  private static final String PG_PWD = System.getenv("POSTGRES_PWD");

  @Bean
  public ViewResolver getViewResolver() {
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setPrefix("/views/");
    resolver.setSuffix(".jsp");
    return resolver;
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
  }

  @Bean
  public DataSource getDataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("org.postgresql.Driver");
    dataSource.setUrl(PG_URL);
    dataSource.setUsername(PG_USER);
    dataSource.setPassword(PG_PWD);

    return dataSource;
  }

  @Bean
  public JobDAO getJobDAO() {
    return new JobDAOImpl(getDataSource());
  }
}
