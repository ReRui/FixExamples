package test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    static ReentrantLock lock = new ReentrantLock(true);
    public static void main(String[] args){
        A aa = new A();

        synchronized (aa) {
            aa.x = 1;
            aa.s = 1;
        }
        try {
            lock.lock();
            aa.s += 1;
            aa.print();
        }finally {
            lock.unlock();
        }
        int num = 0;
        synchronized (aa) {
            aa.x = 1;
        }
    }
}
