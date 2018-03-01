package com.baidu.hui.common.test.biz.classloader;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * 测试ClassLoader
 * 
 * @author yinhaomin
 *
 */
public class TestClassLoader extends ClassLoader {

    // 定义文件所在目录
    private static final String DEAFAULTDIR = "D:/GithubOld/common-test/common-test-biz/bin/";

    public Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] b = null;
        try {
            b = loadClassData(GetClassName(name));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defineClass(name, b, 0, b.length);
    }

    @Override
    protected synchronized Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        if (name.startsWith("java.")) {
            try {
                return super.loadClass(name, false);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        byte[] b = null;
        try {
            b = loadClassData(GetClassName(name));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defineClass(name, b, 0, b.length);
    }

    private byte[] loadClassData(String filepath) throws Exception {
        int n = 0;
        BufferedInputStream br = new BufferedInputStream(new FileInputStream(new File(filepath)));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ((n = br.read()) != -1) {
            bos.write(n);
        }
        br.close();
        return bos.toByteArray();
    }

    public static String GetClassName(String name) {
        return DEAFAULTDIR + name.replace('.', '/') + ".class";
    }

    @SuppressWarnings({ "rawtypes", "unused" })
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
            IllegalAccessException {
        TestClassLoader loader = new TestClassLoader();
        Class clazz = loader.loadClass("");
        TestClassLoader2 tloader = (TestClassLoader2) clazz.newInstance();
        // TestClassLoaderThread runner = new TestClassLoaderThread();
        // runner.setContextClassLoader(loader);

        // runner.start();
    }

}
