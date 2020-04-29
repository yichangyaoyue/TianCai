package test;

public class Test5 {

    public static void main(String[] args) {
        AddAndGet aag = new AddAndGet();
        //存任务
        Runnable add = new Add(aag);

        //取任务
        Runnable get = new Get(aag);

        //3个线程同时执行存任务
        new Thread(add).start();
        new Thread(add).start();
        new Thread(add).start();

        //3个线程同时执行取任务
        new Thread(get).start();
        new Thread(get).start();
        new Thread(get).start();

    }


}

class AddAndGet {

    private Integer[] arr = new Integer[10];
    private int count = 1;

    //获取数组中的某个空位的索引
    private int getNullPosition(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                return i;
            }
        }
        return -1;

    }

    //获取数组中的某个非空位的值，并置空
    private Integer getNumber(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                Integer result = arr[i];
                arr[i] = null;
                return result;
            }
        }
        return null;
    }

    //存
    public synchronized void add() {
        this.notifyAll(); //唤醒所有等待中的线程
        //数组中是否有空位，没有空位需等待
        while (getNullPosition(arr) == -1) {
            try {
                this.wait();//没有空位，等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        arr[getNullPosition(arr)] = count++;
        System.out.println(Thread.currentThread().getName() + "存入" + count);

    }

    //取
    public synchronized Integer get() {
        this.notifyAll();
        //数组是否为全空，全空需要等待
        while (getNumber(arr) == null) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        return getNumber(arr);

    }


}

//存线程，不断往数组中存值
class Add implements Runnable {

    private AddAndGet aag;

    public Add(AddAndGet aag) {
        this.aag = aag;
    }

    @Override
    public void run() {
        while (true) {
            aag.add();
        }

    }
}

class Get implements Runnable {

    private AddAndGet aag;

    public Get(AddAndGet aag) {
        this.aag = aag;
    }

    @Override
    public void run() {
        while (true) {
            Integer num = aag.get();
            System.out.println(Thread.currentThread().getName() + "取出" + num);
        }
    }
}
