package kr.oraclejava.jpa;

import java.util.List;

public interface uplusDao<T> {
	public List<T> getAllEntity();
	public List<T> findByField(String field, String find);
	public void addEntity(T entity);
	public void updateEntity(T entity);
	public void removeEntity(T entity);
	public void removeEntity(Integer id);
}
