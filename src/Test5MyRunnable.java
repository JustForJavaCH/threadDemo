import java.util.Objects;

public class Test5MyRunnable implements Runnable {
    public Object object1 = new Object();
    public Object object2 = new Object();
    public String flag;

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag.equals("a")) {
            synchronized (object1) {
                System.out.println("执行a1");
                try {
                    Thread.sleep(2000);//休眠5秒钟，等待其他线程执行b块代码
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }//方法执行完即释放对象锁
            synchronized (object2) {
                System.out.println("执行a2");
            }
        }
        if (flag.equals("b")) {
            synchronized (object2) {
                System.out.println("执行b2");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (object1) {//此处竞争
                System.out.println("执行b1");
            }
        }

    }
}
