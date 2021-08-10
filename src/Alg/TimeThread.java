package Alg;

/**
 * @author zhangsan
 * @date 2021-05-31 21:17
 */
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 编写TimeThread，负责计时，并打出当前的时间,输出小时分钟秒钟，
 时间格式要求为： 12:35:28。并做测试。
 *
 * 程序分析：
 * 1.计时功能要使用线程来实现
 * 2.显示时间的格式用SimpleDateFormat类
 * */

public class TimeThread extends Thread{

    public static void main(String[] args) {
        //一进来就开始计时
        new TimeThread().start();
    }

    @Override
    public void run() {
        super.run();
        //让线程一直在跑
        while (true) {
            // 需要显示出来的时间的格式,SimpleDateFormat类的使用
            SimpleDateFormat s = new SimpleDateFormat("HH:mm:ss");// 参数代表的是时间的显示格式
            System.out.println("当前的时间是：" + s.format(new Date()));// new Date()是当前时间的对象

            //显示时间后睡眠1秒
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

