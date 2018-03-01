package com.island.common.test.service.tomcat2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class PtimitiveServlet implements Servlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init");
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("from getServletConfig");
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("from service");
        PrintWriter out = res.getWriter();
        out.println("Hello. Roses are red.");
        out.println("Violets are blue.");

    }

    @Override
    public String getServletInfo() {
        System.out.println("from getServletInfo");
        
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("from service");

    }

}
