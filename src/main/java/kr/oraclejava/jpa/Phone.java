package kr.oraclejava.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Phone {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UPLUS_SEQ")
	@SequenceGenerator(sequenceName="uplus_seq", allocationSize=1, name="UPLUS_SEQ")
	private int id;
	private String name;
	private int price;

	public Phone() {
	}
	
	public Phone(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Phone [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
}
