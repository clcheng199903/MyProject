package asia.clcheng.example;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class CustomClassLoader extends URLClassLoader {

    public CustomClassLoader(URL[] urls) {
        super(urls);
    }

    public void addURL(URL url) {
        super.addURL(url);
    }

    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String path = "C:\\Users\\clcheng\\WorkSpace\\Spring\\MyProject\\DateUtilDemo\\target\\DateUtilDemo-1.0-SNAPSHOT.jar";

        File file = new File(path);
        URL[] urls = new URL[] {file.toURI().toURL()};
        CustomClassLoader loader = new CustomClassLoader(urls);
        loader.addURL(file.toURI().toURL());

        Class<?> aClass = Class.forName("asia.clcheng.example.Hello", true, loader);
        Object o = aClass.getConstructor().newInstance();
        Method method = aClass.getMethod("sayHello", String.class);
        method.invoke(o, "ccl");
    }
}
