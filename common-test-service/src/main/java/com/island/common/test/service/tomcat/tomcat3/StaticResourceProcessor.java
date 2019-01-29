package com.island.common.test.service.tomcat.tomcat3;

import com.island.common.test.service.tomcat.tomcat3.connector.http.HttpRequest;
import com.island.common.test.service.tomcat.tomcat3.connector.http.HttpResponse;
import java.io.IOException;

public class StaticResourceProcessor {

  public void process(HttpRequest request, HttpResponse response) {
    try {
      response.sendStaticResource();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

}
