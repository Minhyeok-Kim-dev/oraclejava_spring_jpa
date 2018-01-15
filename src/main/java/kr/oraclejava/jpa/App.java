package kr.oraclejava.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

public class App {

	private static ApplicationContext context;
	private static EntityManager manager;
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("classpath:/bean.xml");
		LocalContainerEntityManagerFactoryBean factory =
				context.getBean(LocalContainerEntityManagerFactoryBean.class);
		manager = factory.getNativeEntityManagerFactory().createEntityManager();
		
		List<Phone> phoneList =
				// HQL (Hibernate Query Language)
				manager.createQuery("SELECT u FROM Uplus u where u.name like '갤%'").getResultList();
		
		for(Phone u : phoneList) {
			System.out.printf("%s %s %s\n",
					u.getId(), u.getName(), u.getPrice());
		}
	}

}
