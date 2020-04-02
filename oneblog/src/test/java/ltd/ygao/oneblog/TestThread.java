package ltd.ygao.oneblog;

import io.swagger.models.auth.In;
import ltd.ygao.oneblog.config.RedisConfig;
import ltd.ygao.oneblog.utils.RedisUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.zip.CheckedOutputStream;

/**
 * @author Kevin
 * @version 1.0
 * @date 2020/3/24 15:52
 */
 class TestThread extends Thread{
    private String name;
    public TestThread(String name){
        this.name=name;
    }
    public void run(){
        System.out.println(Thread.currentThread().getName()+"线程开始运行");
        for (int i = 0; i < 5; i++) {
            System.out.println("子进程"+name+"运行"+i+"次");
            try {
                Thread.sleep((int) Math.random() * 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"线程运行结束");
    }
}
class Main{
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+"主线程开始运行");
        TestThread tt1=new TestThread("高勇");
        TestThread tt2=new TestThread("刘萍");
        tt1.start();
        tt2.start();
        try {
            tt1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            tt2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"主线程结束运行");

    }

}
class AutoUnboxingTest {
    public static void main(String[] args) {
        StringBuffer sb=new StringBuffer();
        ArrayList<String> arrayList=new ArrayList();
        Integer a=new Integer(3);
        Integer b=3;
        int c=3;
        System.out.println(a==b);
        System.out.println(a==c);
        System.out.println(a.equals(c));
    }
}
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class RedisAutoTest{
     @Autowired
    private RedisUtils redisUtils;
     @Test
    public void save(){
         redisUtils.set("1","高勇");
         System.out.println("我运行了");
         Assert.assertEquals("高勇",redisUtils.get("1"));
     }


}
