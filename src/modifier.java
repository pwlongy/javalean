import com.modifer.A;
import com.modifer.B;
import com.nextmodifer.test;

//  类只有 默认 和 public 修饰类
public class modifier {

    public  static  void main(String[] args){
/*
*       修饰符
*          public 共有的        可以在同类、同包、子类、以及不同包中访问
*          protedted 受保护的    只能在同类、同包、以及子类中访问
*          默认                 只可以在同类和同包中访问数据或方法
*          private 私有的        只能在自身的类中访问数据或方法
* */

       A a = new A();
       a.m1();

       B b = new B();
       b.say();

        test test = new test();
        test.showData();
    }
}
