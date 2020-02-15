package be.kanea.project.bodymassindex;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class BMIHistoricDAO {
private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	public List<BMIHistoric> selectAll() {
		List<BMIHistoric> liste;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			liste = session.createQuery("from BMIHistoric", BMIHistoric.class).getResultList();
			transaction.commit();
		} catch (Exception e) {
			liste = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return liste;
	}
	
	public BMIHistoric selectById(int id) {
		BMIHistoric bmi = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("from BMIHistoric where id = :id");
			query.setParameter("id", id);
			bmi = (BMIHistoric) query.getSingleResult();
			transaction.commit();
		} catch (Exception e) {
			bmi = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return bmi;
	}
	
	public int insert(BMIHistoric bmi) {
		int result = 0;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			session.save(bmi);
			result = bmi.getId();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return result;
	}
	
	public boolean update(BMIHistoric bmi) {
		boolean result = true;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(bmi);
			transaction.commit();
		} catch (Exception e) {
			result = false;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return result;
	}
	
	public boolean delete(int id) {
		boolean result = true;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.delete(selectById(id));
			transaction.commit();
		} catch (Exception e) {
			result = false;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return result;
	}
}
