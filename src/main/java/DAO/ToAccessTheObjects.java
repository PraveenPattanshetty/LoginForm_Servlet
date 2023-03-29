package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.mysql.cj.Query;

import DTO.UserInfo;

public class ToAccessTheObjects {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void insert(UserInfo userinfo) {
		entityTransaction.begin();
		entityManager.persist(userinfo);
		entityTransaction.commit();
	}

	// entityManager.createNativeQuery(SQL Query) used to write SQL Query
	// entityManager.createQuery(JPQL Query);

	public UserInfo fetch(int id) {
		return entityManager.find(UserInfo.class, id);
	}

	public void delete(UserInfo user) {
		entityTransaction.begin();
		entityManager.remove(user);
		entityTransaction.commit();
	}

	public void update(UserInfo user) {
		entityTransaction.begin();
		entityManager.merge(user);
		entityTransaction.commit();
	}

//	public UserInfo update(int id) {
//		return entityManager.find(UserInfo.class, id);
//	}

	public UserInfo fetch(String email) {
		List<UserInfo> list = entityManager.createQuery("select y from UserInfo y where Email=?1")
				.setParameter(1, email).getResultList(); // write class name not
															// table name
		if (list.isEmpty()) {
			return null;

		} else {
			return list.get(0);
		}
	}

	public UserInfo fetch(long mobile) {

		List<UserInfo> list = entityManager.createQuery("Select x from UserInfo x where mobile=?1")
				.setParameter(1, mobile).getResultList();
		if (list.isEmpty()) {
			return null;

		} else {
			return list.get(0);
		}
	}

	public List<UserInfo> fetchAll() {
		return entityManager.createQuery("select x from UserInfo x").getResultList();
	}
}
