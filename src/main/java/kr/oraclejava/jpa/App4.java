package kr.oraclejava.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

public class App4 {

	private static ApplicationContext context;
	private static EntityManager manager;
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("classpath:/bean.xml");
		LocalContainerEntityManagerFactoryBean factory =
				context.getBean(LocalContainerEntityManagerFactoryBean.class);
		manager = factory.getNativeEntityManagerFactory().createEntityManager();

		uplusDao<Phone> dao = new uplusDaoImpl(manager);
		//List<Uplus> uList = dao.getAllEntity();
		List<Phone> uList = dao.findByField("name", "LG G6");
		
		for(Phone u : uList) {
			System.out.println(u);
		}
	}

}
