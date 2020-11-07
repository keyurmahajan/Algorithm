package algorithms.puzzles;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Create producer consumer example code
 *
 * @author Keyur Mahajan
 */
public class ProducerConsumer {

    private static class MyBlockingQueue<T> {

        private int limit;
        private LinkedList<T> queue = new LinkedList<>();
        private final ReentrantLock lock = new ReentrantLock();
        private final Condition addedSignal = lock.newCondition();
        private final Condition removedSignal = lock.newCondition();


        MyBlockingQueue(int limit) {
            this.limit = limit;
        }

        public void put(T t) throws InterruptedException {
            lock.lock();
            try {
                // while queue is full wait to get empty
                while (queue.size() == limit) {
                    System.out.println("Waiting on Put");
                    removedSignal.await();
                }

                // add to queue and notify consumer thread
                queue.add(t);
                System.out.println(Thread.currentThread().getName() + " Added : " + t);
                addedSignal.signalAll();

            } finally {
                lock.unlock();
            }

        }

        public T take() throws InterruptedException {
            lock.lock();
            try {
                // block call if queue is empty
                while (queue.size() == 0) {
                    System.out.println("Waiting on Put");
                    addedSignal.await();
                }

                // if removed then notify producer threads to add
                T obj = queue.poll();
                removedSignal.signalAll();
                return obj;

            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {


        MyBlockingQueue<Integer> queue = new MyBlockingQueue<>(100);


        new Thread(() -> {
            for (int i = 20; i < 30; i++) {
                try {
                    Thread.sleep(20);
                    queue.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Producer-2").start();

        new Thread(() -> {
            while (true){
            try {
                System.out.println(Thread.currentThread().getName() + " Consumed : " + queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            }
        }, "Consumer-1").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(20);
                    queue.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Producer-1").start();



        new Thread(() -> {
            while (true){
                try {
                    System.out.println(Thread.currentThread().getName()+ " Consumed : "+ queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        },"Consumer-2").start();
    }
}
