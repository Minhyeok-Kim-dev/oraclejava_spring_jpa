package kr.oraclejava.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

public class App3 {

	private static ApplicationContext context;
	private static EntityManager manager;
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("classpath:/bean.xml");
		LocalContainerEntityManagerFactoryBean factory =
				context.getBean(LocalContainerEntityManagerFactoryBean.class);
		manager = factory.getNativeEntityManagerFactory().createEntityManager();

		Phone uplus = new Phone();
		uplus.setName("중고폰");
		uplus.setPrice(1000000);
		
		EntityTransaction tran = manager.getTransaction();
		
		tran.begin();		
		manager.persist(uplus);	// persist -> insert
		manager.flush();
		tran.commit();
	}

}
