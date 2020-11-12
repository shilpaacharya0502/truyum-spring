package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

//@ImportResource("classpath:spring-config.xml")
public class MenuItemDaoCollectionImplTest {
    /*@Autowired
    private List<MenuItem> menuItemList;

   public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    public void setMenuItemList(List<MenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }
    */
    public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
        
        System.out.println("Menu item list for Admin");
        testGetMenuItemListAdmin();
        System.out.println("Menu item list for Customer");
        testGetMenuItemListCustomer();
        testModifyMenuItem();
        // testGetMenuItem();

    }

    public static void testGetMenuItemListAdmin() throws ClassNotFoundException, IOException, SQLException {
        // menuItemDao=(MenuItemDao)ctx.getBean("MenuItemDaoCollectionImpl");
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");

        MenuItemDao menuItemDao = (MenuItemDao) ctx.getBean("MenuItemDaoCollectionImpl");
        for (MenuItem m : menuItemDao.getMenuItemListAdmin()) {
            System.out.print(m.toString());
        }
    }

    public static void testGetMenuItemListCustomer() throws ClassNotFoundException, IOException, SQLException {
        // MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        MenuItemDao menuItemDao = (MenuItemDao) ctx.getBean("MenuItemDaoCollectionImpl");
        for (MenuItem m : menuItemDao.getMenuItemListCustomer()) {
            System.out.print(m.toString());
        }
    }

    public static void testModifyMenuItem() throws ClassNotFoundException, IOException, SQLException {

        try {
            //MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
            ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
            MenuItemDao menuItemDao = (MenuItemDao) ctx.getBean("MenuItemDaoCollectionImpl");
            
            MenuItem mAdd= new MenuItem(2,"Noodles", 49, true, DateUtil.convertToDate("23/10/2020"), "Main Course",
                    false);
            System.out.println(mAdd);
            menuItemDao.modifyMenuItem(mAdd);
            System.out.println("After Modification \n" + menuItemDao.getMenuItem(2));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public static void testGetMenuItem() throws ClassNotFoundException, IOException, SQLException {
        // MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");

        MenuItemDao menuItemDao = (MenuItemDao) ctx.getBean("MenuItemDaoCollectionImpl");
        // admin menu list is displayed
        for (MenuItem m : menuItemDao.getMenuItemListAdmin()) {
            System.out.print(m.toString());
        }
    }
}
