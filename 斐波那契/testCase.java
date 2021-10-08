package 斐波那契;

public class testCase {
    public static void main(String[] args){
        _010_斐波那契数列 fib = new _010_斐波那契数列();
        System.out.println(fib.fib(3));
        System.out.println("---------------------------------");
        _010_青蛙跳台阶 te = new _010_青蛙跳台阶();
        System.out.println("青蛙跳台阶：" + te.numWays(7));
        System.out.println("---------------------------------");
        变态跳台阶 t  =new 变态跳台阶();
        System.out.println("变态跳台阶: " + t.jumpFloor(3));
    }
}
