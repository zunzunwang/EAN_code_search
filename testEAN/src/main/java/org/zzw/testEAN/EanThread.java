package org.zzw.testEAN;
import java.util.ArrayList;
import java.util.List;

public class EanThread extends Thread {
    private PrintList list;
 
    public EanThread(PrintList shuzu) {
        this.list = shuzu;
    }
 
    @Override
    public void run() {
        String url = list.getElement();
        while (url != null) {//只要没读完就继续读，每个线程
            System.out.println(Thread.currentThread().getName() + ",  " + url);
            //Thread.yield();
            url = list.getElement();
        }
    }
 
    public static void main(String[] args) {
        int n = 0;
        List list = new ArrayList<String>();
        list.add("日");
        list.add("月");
        list.add("水");
        list.add("火");
        list.add("上");
        list.add("中");
        list.add("下");
        list.add("大");
        list.add("小");
        list.add("多");
        PrintList obj = new PrintList(list);
        for (int j = 0; j <= 4; j++) {
            new EanThread(obj).start();
        }
    }
}