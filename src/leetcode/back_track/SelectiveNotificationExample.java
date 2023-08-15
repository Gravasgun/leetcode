package leetcode.back_track;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SelectiveNotificationExample {
    // 创建可重入锁实例
    private ReentrantLock lock = new ReentrantLock();
    // 创建条件对象
    private Condition condition = lock.newCondition();
    // 条件标志位
    private boolean flag = false;

    private void waitForCondition() {
        // 获取锁
        lock.lock();
        try {
            // 当条件不满足时
            while (!flag) {
                System.out.println("条件不满足，持续等待中！");
                // 等待条件满足，当前线程进入等待状态，释放锁
                condition.await();
            }
            System.out.println("条件满足，不用继续等待了！");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放锁
            lock.unlock();
        }
    }

    private void notifyForCondition() {
        // 获取锁
        lock.lock();
        try {
            // 设置条件为满足
            flag = true;
            // 唤醒一个等待该条件的线程
            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放锁
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        SelectiveNotificationExample example = new SelectiveNotificationExample();
        Thread thread = new Thread(() -> {
            // 创建线程并执行等待条件的方法
            example.waitForCondition();
        });
        // 启动线程
        thread.start();
        try {
            // 主线程等待10秒，模拟条件改变的延迟
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // 发送条件满足的信号
        example.notifyForCondition();
    }
}