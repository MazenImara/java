package simple.ex.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import simple.ex.models.Item;
import simple.ex.dao.ItemDAO;

public class ItemDAOImpl implements ItemDAO {
    private SessionFactory sessionFactory;
    
    public ItemDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	public void add(Item item) {
	    Session session = sessionFactory.getCurrentSession();
	    try {
	        session.beginTransaction();
	        session.save(item);
	      } catch (HibernateException e) {
	          e.printStackTrace();
	          session.getTransaction().rollback();
	    }
	        session.getTransaction().commit();
	}
	
	@Override
	public void update(Item item) {
	
	    Session session = sessionFactory.getCurrentSession();
	    try {
	        System.out.println("IN Update");
	        session.beginTransaction();
	        session.saveOrUpdate(item);
	        } catch (HibernateException e) {
	            e.printStackTrace();
	            session.getTransaction().rollback();
	        }
	    session.getTransaction().commit();
	}
	
	@Override
	public Item getItem(Long id) {
	    Session session = sessionFactory.getCurrentSession();
	    Item item=null;
	    try {
	        System.out.println("IN GetItaem");
	        session.beginTransaction();
	        item = (Item) session.get(Item.class, id);
	    } catch (HibernateException e) {
	        e.printStackTrace();
	        session.getTransaction().rollback();
	    }
	    session.getTransaction().commit();
	    return item;
	}
	
	@Override
	public void delete(Long id) {
	    Session session = sessionFactory.getCurrentSession();
	    session.beginTransaction();
	    Item item = (Item) session.get(Item.class, id);
	    if(null != item) {
	        session.delete(item);
	    }
	    session.getTransaction().commit();
	    //return item;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Item> list() {
	
	    Session session = sessionFactory.getCurrentSession();
	    session.beginTransaction();
	    List<Item> items = null;
	    try {
	        System.out.println("IN LIST");
	        items = (List<Item>)session.createQuery("from Item").list();
	
	    } catch (HibernateException e) {
	        e.printStackTrace();
	        session.getTransaction().rollback();
	    }
	    session.getTransaction().commit();
	    return items;
	}
}
