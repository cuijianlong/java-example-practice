package top.lstech.thread.concurrent;

public class Join {
    public static void main(String[] args) {
        Thread previous = Thread.currentThread();
        for (int i=0; i<10; i++){
            // 每个线程拥有前一个线程的引用， 等待前一个线程终止，才能返回
            Thread thread = new Thread(new Domino(previous) , String.valueOf(i));
            thread.start();
            previous = thread;
        }
    }
    static class Domino implements Runnable{
        private Thread thread;

        public Domino(Thread thread){
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            }catch (Exception e){
            }
            System.out.println(Thread.currentThread().getName() + "terminate.");
        }
    }
}
