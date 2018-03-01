package com.baidu.hui.common.test.biz.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Java RMI 指的是远程方法调用 (Remote Method Invocation)。它是一种机制，能够让在某个 Java 虚拟机上的对象调用另一个
 * Java 虚拟机中的对象上的方法。可以用此方法调用的任何对象必须实现该远程接口。
 * 
 * Java RMI不是什么新技术（在Java1.1的时代都有了），但却是是非常重要的底层技术。
 * 大名鼎鼎的EJB都是建立在rmi基础之上的，现在还有一些开源的远程调用组件，其底层技术也是rmi。
 * 
 * 在大力鼓吹Web Service、SOA的时代，是不是每个应用都应该选用笨拙的Web
 * Service组件来实现，通过对比测试后，RMI是最简单的，在一些小的应用中是最合适的。
 * 
 * @author yinhaomin
 * @date 2016/10/28
 */
public interface IHello extends Remote {

    /**
     * 简单的返回“Hello World！"字样
     * 
     * @return 返回“Hello World！"字样
     * @throws java.rmi.RemoteException
     */
    public String helloWorld() throws RemoteException;

    /**
     * 一个简单的业务方法，根据传入的人名返回相应的问候语
     * 
     * @param someBodyName
     *            人名
     * @return 返回相应的问候语
     * @throws java.rmi.RemoteException
     */
    public String sayHelloToSomeBody(String someBodyName) throws RemoteException;

}
