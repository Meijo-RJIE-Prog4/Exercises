/**
 * クラスメンバへのアクセス確認用ソースコード
 * @author  Hidekazu Suzuki
 * @date    2017/10/10
 * @version 1.0
 */
class Static {
    private static int s ;
    private int a;

    public static void m1() {
        System.out.println("m1() method is called.");
    }
    public void f1() {
        System.out.println("f1() method is called.");
    }
    public static void m2(int x) {
        System.out.println("m2() method is called.");
        s = x;
        a = x;
        m1();
        f1();
    }
    public void f2(int x) {
        System.out.println("f2() method is called.");
        s = x;
        a = x;
        m1();
        f1();
        System.out.println("s = " + s + ", a = " + a);
    }
}

/**
 * クラスメンバへのアクセス確認実行用ソースコード
 * @author  Hidekazu Suzuki
 * @date    2017/10/10
 * @version 1.0
 */
public class StaticTest {
    public static void main(String[] args) {
        Static c1 = new Static();
        Static c2 = new Static();

        Static.m2(5);
        c1.f2(10);
        c2.f2(20);
    }
}
