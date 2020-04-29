package test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BuyTickets {


    public static void main(String[] args) {

        function_01();

    }

    //买票
    public static void function_01() {

        Task task = new Task();
        Thread t1 = new Thread(task, "窗口001");
        Thread t2 = new Thread(task, "窗口002");
        Thread t3 = new Thread(task, "窗口003");

        t1.start();
        t2.start();
        t3.start();

    }


}

class Task implements Runnable {

    int ticket = 1000;
    private Object obi = new Object();

    //lock锁
    Lock lock = new ReentrantLock();

    @Override
    public void run() {

        while (ticket > 0) {

//            synchronized (this) {
//                System.out.println(Thread.currentThread().getName() + "正在销售" + ticket + "张票");
//                ticket--;
//            }


        }


    }

    private void method_01() {
        while (ticket > 0) {
            lock.lock();//上锁
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "正在销售" + ticket + "张票");
                ticket--;
                if (ticket == 0) {
                    System.out.println(Thread.currentThread().getName() + "票已售完");
                }

            } else {
                System.out.println(Thread.currentThread().getName() + "票已售完");
            }
            lock.unlock();
        }
    }


}