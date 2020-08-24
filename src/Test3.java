import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test3 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        Class c = Class.forName("MyThread");
        Method methods = c.getMethod("run");
        MyThread object = (MyThread) c.newInstance();
        try {
            methods.invoke(object);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}