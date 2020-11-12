package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

@ImportResource("classpath:spring-config.xml")
public class MenuItemDaoCollectionImpl implements MenuItemDao {
    @Autowired
    private List<MenuItem> menuItemList;

   public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    public void setMenuItemList(List<MenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }

    public MenuItemDaoCollectionImpl() {
        super();
    }
    public List<MenuItem> getMenuItemListAdmin() {
        return menuItemList;
    }

    public List<MenuItem> getMenuItemListCustomer() {
        ArrayList<MenuItem> menuItemListC = new ArrayList<>();

        Date today = null;
        try {
            today = DateUtil.convertToDate("21/08/2018");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (MenuItem m : menuItemList) {
            if ((m.getDateOfLaunch().compareTo(today)) == 0 || m.getDateOfLaunch().before(today) == true) 
            {
                if (m.isActive() == true) {
                    menuItemListC.add(m);
                }
            }
        }
        //System.out.println(menuItemListC.size());
        return menuItemListC;
    }

    public void modifyMenuItem(MenuItem menuItem) {
        for (MenuItem m : menuItemList) {
            if (m.getId() == menuItem.getId()) {
                m.setName(menuItem.getName());
                m.setPrice(menuItem.getPrice());
                m.setActive(menuItem.isActive());
                m.setDateOfLaunch(menuItem.getDateOfLaunch());
                m.setCategory(menuItem.getCategory());
                m.setFreeDelivery(menuItem.isFreeDelivery());
            }
        }
    }

    public MenuItem getMenuItem(long menuItemId) {
        MenuItem item = null;
        for (MenuItem m : menuItemList) {
            if (m.getId() == menuItemId) {
                item = m;
            }
        }
        return item;
    }
}
