package productcrudapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import productcrudapp.dao.productDao;
import productcrudapp.model.Product;
@Controller
public class MainController {
	
	@Autowired
	private productDao productdao;

	@RequestMapping("/")
	public String home(Model m) {
		List<Product> products=productdao.getProducts();
		m.addAttribute("product",products);
		return "index";
	}
	
	@RequestMapping("/add-product")
	public String addProduct(Model model) {
		model.addAttribute("title","add-product");
		return "add_product_details";
	}
	
	@RequestMapping(value = "/handle-product", method = RequestMethod.POST)
	public RedirectView productHandler(@ModelAttribute Product product,HttpServletRequest request) {
		System.out.println(product);
		System.out.println("update");
		productdao.createProduct(product);
		return new RedirectView("/", true);
	}
		
	@RequestMapping("/delete/{productId}")
	public RedirectView handlerDelete(@PathVariable("productId") int productId,HttpServletRequest request) {
		this.productdao.deleteProduct(productId);
		return new RedirectView("/",true);
	}
	
	@RequestMapping("/update/{productId}")
	public String handlerUpdate(@PathVariable("productId") int pid,Model m) {
	Product product=this.productdao.getProduct(pid);
		m.addAttribute("product",product);
		return "update_form";
	}
}
