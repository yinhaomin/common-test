package com.island.common.test.service.tomcat3.startup;

import com.island.common.test.service.tomcat3.connector.http.HttpConnector;

public final class Bootstrap {
  public static void main(String[] args) {
    HttpConnector connector = new HttpConnector();
    connector.start();
  }
}