package com.springmvc.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.Entity.User;

@Transactional
@Repository
public class UserRepository {
	//@Autowired
    //private HibernateTemplate hibernateTemplate;
    @Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
    public List<User> getAllUsers()
    {
    	Session session=this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		//List<User> user=session.createQuery("from User").list();
		
		//Criteria c=session.createCriteria(User.class);
		//c.add(Restrictions.gt("id", 2));
		
		Query query=session.getNamedQuery("findAll");
		List<User> user=query.list();
		//List<User> user=c.list();
		tx.commit();
		session.close();
		return user;
    }
    
//    public Integer createUser(User user)
//    {
//        User mergeUser = this.hibernateTemplate.merge(user);
//        return mergeUser.getId();
//    }
    public void saveUser(User user) {
    		Session session=this.sessionFactory.openSession();
    		Transaction tx=session.beginTransaction();
    		session.persist(user);
    		tx.commit();
    		session.close();
    }
}
