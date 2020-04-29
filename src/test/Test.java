package test;

import java.util.TimerTask;

public class Test {
    public static void main(String[] args) {
        System.out.println("你好");
    }


}


class MyTask extends TimerTask{


    @Override
    public void run() {

        for (int i=0; i<100; i++)
            System.out.println("任务1：" + i);

    }
}
