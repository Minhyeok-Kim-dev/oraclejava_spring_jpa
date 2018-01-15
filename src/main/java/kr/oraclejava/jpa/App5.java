package kr.oraclejava.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

public class App5 {

	private static ApplicationContext context;
	private static EntityManager manager;
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("classpath:/bean.xml");
		LocalContainerEntityManagerFactoryBean factory =
				context.getBean(LocalContainerEntityManagerFactoryBean.class);
		manager = factory.getNativeEntityManagerFactory().createEntityManager();

		uplusDao<Phone> dao = new uplusDaoImpl(manager);
		
		//Uplus uplus = new Uplus("Test Phone", 10000000);
		//dao.addEntity(uplus);
		
		Phone uplus = manager.find(Phone.class, 16);
		uplus.setPrice(40000);
		dao.updateEntity(uplus);
		
		dao.removeEntity(uplus);
		
		List<Phone> uList = dao.getAllEntity();
		for(Phone u : uList) {
			System.out.println(u);
		}
	}

}
