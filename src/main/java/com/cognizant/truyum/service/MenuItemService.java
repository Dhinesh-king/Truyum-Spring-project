package com.cognizant.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.MenuItemDaoCollectionImpl;
import com.cognizant.truyum.model.MenuItem;

@Service
public class MenuItemService {

	ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
	MenuItemDaoCollectionImpl menuItemDao = (MenuItemDaoCollectionImpl) context.getBean("menuItemDaoImpl");

	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemDao.getMenuItemListAdmin();
	}

	public List<MenuItem> getMenuItemListCustomer() {
		return menuItemDao.getMenuItemListCustomer();
	}

	public void modifyMenuItem(MenuItem menuItem) {
		menuItemDao.modifyMenuItem(menuItem);
	}

	public MenuItem getMenuItem(long menuItemId) {
		return menuItemDao.getMenuItem(menuItemId);
	}
}
