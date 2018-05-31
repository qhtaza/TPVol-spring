package vol.dao;

import java.util.List;

public interface Dao<T, PK> {
	List<T> findAll();

	T findOne(PK id);

	void create(T obj);

	T update(T obj);

	void delete(T obj);
}
