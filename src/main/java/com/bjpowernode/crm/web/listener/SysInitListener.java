package com.bjpowernode.crm.web.listener;

import com.bjpowernode.crm.settings.domain.DicValue;
import com.bjpowernode.crm.settings.service.DicService;
import com.bjpowernode.crm.settings.service.impl.DicServiceImpl;
import com.bjpowernode.crm.utils.ServiceFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.*;

public class SysInitListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent event) {
//        System.out.println("上下文域对象创建了");
        System.out.println("服务器缓存处理数据字典开始");

        ServletContext application = event.getServletContext();
        DicService ds = (DicService) ServiceFactory.getService(new DicServiceImpl());

        Map<String, List<DicValue>> map = ds.getAll();
        // 将map解析为上下文域对象中保存的键值对
        Set<String> set = map.keySet();
        for (String key : set) {
            application.setAttribute(key, map.get(key));
        }
        System.out.println("服务器缓存处理数据字典结束");

        Map<String,String> pMap = new HashMap<String,String>();

        ResourceBundle rb = ResourceBundle.getBundle("Stage2Possibility");

        Enumeration<String> e = rb.getKeys();

        while (e.hasMoreElements()) {
            // 阶段
            String key = e.nextElement();
            // 可能性
            String value = rb.getString(key);
            pMap.put(key,value);
        }
        application.setAttribute("pMap",pMap);


    }
}
