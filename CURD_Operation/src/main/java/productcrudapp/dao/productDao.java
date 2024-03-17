package productcrudapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import productcrudapp.model.Product;

@Component
public class productDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	//create
	public void createProduct(Product product) {
		this.hibernateTemplate.saveOrUpdate(product);
	}
	// get all products
	public List<Product> getProducts(){
		List<Product> products=this.hibernateTemplate.loadAll(Product.class);
	 return products;
	}
	
	// delete
	@Transactional
	public void deleteProduct(int pid) {
		Product p=this.hibernateTemplate.load(Product.class,pid);
		this.hibernateTemplate.delete(p);
	}
	// get single product
	public Product getProduct(int pid) {
		return this.hibernateTemplate.get(Product.class,pid);
	}

	
	
}
