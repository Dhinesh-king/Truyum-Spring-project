package com.cognizant.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.CartDaoCollectionImpl;
import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.dao.MenuItemDaoCollectionImpl;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

@Service("cartService")
public class CartService {

	ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
	CartDaoCollectionImpl cartDaoImpl = (CartDaoCollectionImpl) context.getBean("cartDaoImpl");
	// MenuItemDaoCollectionImpl menuItemImpl=(MenuItemDaoCollectionImpl)
	// context.getBean("menuItemDaoImpl");

	public void addCartItem(long userId, long menuItemId) {
		cartDaoImpl.addCartItem(userId, menuItemId);
	}

	public Cart getAllCartItems(long userId) throws CartEmptyException {
		Cart cart = null;
		// The following Comment is done as a returning of Cart instead of returning
		// List!!!

		List<MenuItem> menuList = cartDaoImpl.getAllCartItems(userId);
		long price = 0;
		for (MenuItem item : menuList) {
			price = (long) (price + item.getPrice());
		}
		cart = new Cart(menuList, price);

		return cart;
	}

	public List<MenuItem> getAllCartItemsList(long Userid) throws CartEmptyException {

		return cartDaoImpl.getAllCartItems(Userid);

	}

	public void removeCartItem(long userId, long menuItemId) {
		cartDaoImpl.removeCartItem(userId, menuItemId);
	}
}
