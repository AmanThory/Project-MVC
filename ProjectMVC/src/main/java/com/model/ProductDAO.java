package com.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("productDAO")
@Transactional 
public class ProductDAO implements IProductDAO {
	private Transaction trans;
	private Session sess;
	private DbConfig db;
	private boolean b = true;
	/* (non-Javadoc)
	 * @see com.model.IProductDAO#insertProduct(com.model.Product)
	 */
	public ProductDAO()
	{
		db = new DbConfig();
	}
	
	public boolean insertProduct(Product p) {
		try
		{
			sess = db.getSess();
			trans = sess.beginTransaction();
			sess.save(p);
			trans.commit();
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
			trans.rollback();
			b = false;
		}
		return b;
	}

	public List<Product> getProducts() {

		sess = db.getSess();
		Query<Product> quer = sess.createQuery("FROM Product", Product.class);
		List<Product> al = quer.getResultList();
		return al;
	}
	public Product getProduct(int id)
	{
		sess = db.getSess();
		return (Product)sess.get(Product.class, Integer.valueOf(id));
	}
	
	public boolean updateProduct(Product p)
	{
		try
		{
		sess = db.getSess();
		trans = sess.beginTransaction();
		sess.update(p);
		trans.commit();
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
			trans.rollback();
			b = false;
		}
		return b;

	}
	
	public boolean deleteProduct(Product p)
	{
		try
		{
			sess = db.getSess();
			trans = sess.beginTransaction();
			sess.delete(p);
			trans.commit();
		}
		catch(Exception ex) {
			ex.printStackTrace();
			trans.rollback();
			b= false;
		}
		return b;
	}
	
	
}






