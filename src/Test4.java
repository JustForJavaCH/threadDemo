import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }*/
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < 1000; i++) {
            sb.append(1).append(",");
        }
        System.out.println(sb.toString());
    }
}
