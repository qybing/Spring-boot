package com.tiye.IntelligentClass.service;

import com.tiye.IntelligentClass.dao.SysMenuMapper;
import com.tiye.IntelligentClass.model.SysAccount;
import com.tiye.IntelligentClass.model.SysMenu;
import com.tiye.IntelligentClass.util.StringTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project:IntelligentClass
 * @PackageName:com.tiye.IntelligentClass.service
 * @Auther: 张颖
 * @Date: 2018年05月15日 11:06
 * @Description:
 */
@Service
public class SysMenuService {
    @Autowired
    private SysMenuMapper  dao;

    public List<SysMenu>  getMenus(SysAccount account){
        if(account==null){

        }
        List<SysMenu> allMenus=dao.getUserMenus(account.getId());//获取所有菜单
        List<SysMenu> rootMenus=new ArrayList<SysMenu>();//所有父菜单
        for(SysMenu allMenu:allMenus){
            if(allMenu.getPid()==null){
                rootMenus.add(allMenu);
            }
        }
        for(SysMenu rootMenu:rootMenus){
            rootMenu.setSubMenus(getMenuChildren(rootMenu.getId(),allMenus));
        }
        return rootMenus;
    }
    public List<SysMenu> getMenuChildren(Long pid,List<SysMenu> allMenus){
        List<SysMenu> childList = new ArrayList<SysMenu>();// 子菜单
        for (SysMenu menu : allMenus) {//遍历所有节点，将父菜单id与传过来的id比较
            if (menu.getPid()!=null) {
                if (menu.getPid().equals(pid)) {
                    childList.add(menu);
                }
            }
            //menu.setSubMenus(getMenuChildren(menu.getId(),allMenus));
        }
        for (SysMenu menu : childList) {
            menu.setSubMenus(getMenuChildren(menu.getId(), allMenus));
        }
        if (childList!=null&&childList.size() >0) {
            return childList;
        }
        return null;
    }

}
