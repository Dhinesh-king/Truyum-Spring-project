package com.cognizant.truyum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.CartService;

@Controller
@SessionAttributes("userId")
public class CartController {
	@Autowired
	CartService cartService;

	@GetMapping("/show-cart")
	public String showCart(@RequestParam long userId,ModelMap model) {
		double price = 0;
		try {
			List<MenuItem> menuList = cartService.getAllCartItems(userId).getMenuItemList();
			for (MenuItem item : menuList) {
				price = price + item.getPrice();
			}
			model.put("menuItemList", menuList);

			model.put("totalPrice", price);
		} catch (CartEmptyException e) {
			return "empty-cart";
		}
		return "cart";
	}

	@GetMapping("/add-to-cart")
	public String addToCart(@RequestParam int menuItemId, @RequestParam long userId,ModelMap model) {
		cartService.addCartItem(userId, menuItemId);
		List<MenuItem> listMenu;
		double price = 0;
		try {
			listMenu = cartService.getAllCartItems(userId).getMenuItemList();
			for (MenuItem item : listMenu) {
				price = price + item.getPrice();
			}
			model.put("totalPrice", price);
			model.put("menuItemList", listMenu);
		} catch (CartEmptyException e) {
			return "empty-cart";
		}
		return "cart";
	}

	@GetMapping("/remove-cart-item")
	public String removeFromCart(@RequestParam int menuItemId,@RequestParam long userId, ModelMap model) {
		cartService.removeCartItem(userId, menuItemId);
		List<MenuItem> listMenu;
		double price = 0;
		try {
			listMenu = cartService.getAllCartItems(userId).getMenuItemList();
			for (MenuItem menuItem : listMenu) {
				price = price + menuItem.getPrice();
			}
			model.put("totalPrice", price);
			model.put("menuItemList", listMenu);

		} catch (CartEmptyException e) {
			return "empty-cart";
		}
		return "cart";
	}
}
