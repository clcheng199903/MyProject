package asia.clcheng.example;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class MyClassLoader {
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String path = "C:\\Users\\clcheng\\WorkSpace\\Spring\\MyProject\\DateUtilDemo\\target\\DateUtilDemo-1.0-SNAPSHOT.jar";

        File file = new File(path);
        URL[] urls = new URL[] {file.toURI().toURL()};
        URLClassLoader myClassLoader = new URLClassLoader(urls);

        Class<?> aClass = myClassLoader.loadClass("asia.clcheng.example.Hello");

        Constructor<?> constructor = aClass.getConstructor();
        Object o = constructor.newInstance(); // 利用反射创建对象
        Method method = aClass.getMethod("sayHello", String.class); // 获取sayHello方法
        method.invoke(o, "程春亮"); // 调用方法

    }
}
