package com.island.common.test.service.tomcat3;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 测试国际化工具ResourceBundle的使用
 * 
 * @author davidyin
 *
 */
public class TestResourceBundle {

    public static void main(String[] args) {
        Locale locale1 = new Locale("zh", "CN");
        ResourceBundle resb1 = ResourceBundle.getBundle("myres", locale1);
        System.out.println(resb1.getString("aaa"));

        ResourceBundle resb2 = ResourceBundle.getBundle("myres", Locale.getDefault());
        System.out.println(resb2.getString("aaa"));

        Locale locale3 = new Locale("en", "US");
        ResourceBundle resb3 = ResourceBundle.getBundle("myres", locale3);
        System.out.println(resb3.getString("aaa"));
    }

}
