package no.runsafe.framework;

import java.util.Properties;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class RunsafeDatabaseHandler implements IDatabase {
	
	private Configuration hibernateConfig;
	private SessionFactory sessionFactory;

	@SuppressWarnings("rawtypes")
	public RunsafeDatabaseHandler(IConfiguration config, IDatabaseTypeProvider typeProvider)
	{
		Properties props = new Properties();
		props.put("hibernate.dialect", String.format("org.hibernate.dialect.%s", config.getConfigValueAsString("database.dialect"))); 
		props.put("hibernate.connection.driver_class", config.getConfigValueAsString("database.driver"));
		props.put("hibernate.connection.url", config.getConfigValueAsString("database.url"));
		props.put("hibernate.connection.username", config.getConfigValueAsString("database.username"));
		props.put("hibernate.connection.password", config.getConfigValueAsString("database.password"));
		props.put("hibernate.connection.pool_size", "1");
		props.put("hibernate.hbm2ddl.auto", "create");
		
		props.put("hibernate.show_sql", "false");
		props.put("hibernate.jdbc.use_streams_for_binary", "true");
		props.put("hibernate.use_outer_join", "false");
		props.put("hibernate.jdbc.batch_size", "0");
		props.put("hibernate.jdbc.use_scrollable_resultset", "true");
		props.put("hibernate.statement_cache.size", "0");
		
		hibernateConfig = new Configuration().setProperties(props);
		for (Class modelType : typeProvider.getModelClasses()) 
		{
			hibernateConfig.addClass(modelType);
		}
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(hibernateConfig.getProperties()).buildServiceRegistry();
		sessionFactory = hibernateConfig.buildSessionFactory(serviceRegistry);
	}
	
	@Override
	public Session getSession()
	{
		return sessionFactory.openSession();
	}
}
