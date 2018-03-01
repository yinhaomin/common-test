package com.baidu.hui.common.test.biz.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class HelloClient {

    public static void main(String[] args) {
        IHello hello;
        try {
            hello = (IHello) Naming.lookup("rmi://localhost:8888/RHello");
            System.out.println(hello.helloWorld());
            System.out.println(hello.sayHelloToSomeBody("LOL"));

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
