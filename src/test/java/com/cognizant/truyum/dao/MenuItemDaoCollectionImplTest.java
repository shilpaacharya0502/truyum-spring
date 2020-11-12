package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest {
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
        //MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");

        MenuItemDao menuItemDao = (MenuItemDao) ctx.getBean("MenuItemDaoCollectionImpl");
        for (MenuItem m : menuItemDao.getMenuItemListCustomer()) {
            System.out.print(m.toString());
        }
    }

    public static void testModifyMenuItem() throws ClassNotFoundException, IOException, SQLException {
        /*
         * try { MenuItem mAdd=new
         * MenuItem(2,"Noodles",49,true,DateUtil.convertToDate("23/10/2020")
         * ,"Main Course",false); MenuItemDao menuItemDao= new
         * MenuItemDaoCollectionImpl(); menuItemDao.modifyMenuItem(mAdd);
         * System.out.println("After Modification \n"+menuItemDao.getMenuItem(2)); }
         * catch (ParseException e) { e.printStackTrace(); }
         */
    }

    public static void testGetMenuItem() throws ClassNotFoundException, IOException, SQLException {
        //MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");

        MenuItemDao menuItemDao = (MenuItemDao) ctx.getBean("MenuItemDaoCollectionImpl");
        // admin menu list is displayed
        for (MenuItem m : menuItemDao.getMenuItemListAdmin()) {
            System.out.print(m.toString());
        }
    }
}
