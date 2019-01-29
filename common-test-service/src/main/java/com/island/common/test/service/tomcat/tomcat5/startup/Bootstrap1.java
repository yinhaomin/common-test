package com.island.common.test.service.tomcat.tomcat5.startup;

import org.apache.catalina.Loader;
import org.apache.catalina.Pipeline;
import org.apache.catalina.Valve;
import org.apache.catalina.Wrapper;
import org.apache.catalina.connector.http.HttpConnector;

import com.island.common.test.service.tomcat.tomcat5.core.SimpleLoader;
import com.island.common.test.service.tomcat.tomcat5.core.SimpleWrapper;
import com.island.common.test.service.tomcat.tomcat5.valves.ClientIPLoggerValve;
import com.island.common.test.service.tomcat.tomcat5.valves.HeaderLoggerValve;

@SuppressWarnings("deprecation")
public final class Bootstrap1 {

    public static void main(String[] args) {

        /*
         * call by using http://localhost:8080/ModernServlet, but could be invoked by any name
         */

        HttpConnector connector = new HttpConnector();
        Wrapper wrapper = new SimpleWrapper();
        wrapper.setServletClass("ModernServlet");
        Loader loader = new SimpleLoader();
        Valve valve1 = new HeaderLoggerValve();
        Valve valve2 = new ClientIPLoggerValve();

        wrapper.setLoader(loader);
        ((Pipeline) wrapper).addValve(valve1);
        ((Pipeline) wrapper).addValve(valve2);

        connector.setContainer(wrapper);

        try {
            connector.initialize();
            connector.start();

            // make the application wait until we press a key.
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}