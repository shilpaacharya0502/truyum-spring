package com.cognizant.truyum.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.model.MenuItem;

@Service("menuItemService")
public class MenuItemService implements MenuItemDao{

    @Autowired
    private MenuItemDao menuItemDao;

    public MenuItemDao getMenuItemDao() {
        return menuItemDao;
    }

    public void setMenuItemDao(MenuItemDao menuItemDao) {
        this.menuItemDao = menuItemDao;
    }
    @Override
    public List<MenuItem> getMenuItemListAdmin() throws ClassNotFoundException, IOException, SQLException{
        ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-config.xml");
        menuItemDao=(MenuItemDao)ctx.getBean("MenuItemDaoCollectionImpl");
        return menuItemDao.getMenuItemListAdmin();
    }
    
    public List<MenuItem> getMenuItemListCustomer() throws ClassNotFoundException, IOException, SQLException{
        ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-config.xml");
        menuItemDao=(MenuItemDao)ctx.getBean("MenuItemDaoCollectionImpl");
        return menuItemDao.getMenuItemListCustomer();
    }
    
    public MenuItem getMenuItem(long menuItemId) {
        return null;
    }
    public void editMenuItem(MenuItem menutItem) {
        
    }

    @Override
    public void modifyMenuItem(MenuItem menuItem) throws ClassNotFoundException, IOException, SQLException {
        // TODO Auto-generated method stub
        
    }
}
