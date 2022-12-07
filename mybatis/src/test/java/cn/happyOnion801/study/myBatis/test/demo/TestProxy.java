package cn.happyOnion801.study.myBatis.test.demo;


import org.junit.Test;


interface Function {
    double getValue(double x);
}

class MyFun implements Function {

    @Override
    public double getValue(double x) {
        return Math.sin(x) / Math.cos(x);
    }
}

public class TestProxy {

    @Test
    public void test() {
        boolean[][] res = new boolean[1020][1005];
        MyFun myFun = new MyFun();
        for (double i = 0.0; i < 10; i += 0.01) {
            int r = (int) Math.round(myFun.getValue(i) * 100);
            if (r < 0)
                r = 0;
            if (r > 1020 - 1) continue;
            res[r][(int) (i * 100)] = true;
        }
        for (int i = 1020 - 1; i > 0; i--) {
            for (int j = 0; j < 1005; j++) {
                if (res[i][j])
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println("");
        }
    }
}
