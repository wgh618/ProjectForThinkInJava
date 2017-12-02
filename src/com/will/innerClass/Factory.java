package com.will.innerClass;

/**
 * ClassName:Factory
 * Description:匿名内部类--1、匿名内部类是没有访问修饰符的。
 *                       2、new 匿名内部类，这个类首先是要存在的。如果我们将那个InnerClass接口注释掉，就会出现编译出错。
 *                       3、注意getFruit()方法的形参，是用final修饰的，在方法的形参需要被匿名内部类使用，那么这个形参就必须为final。
 *                       4、匿名内部类是没有构造方法的。因为它连名字都没有何来构造方法。
 * @Author Will Wu
 * @Email willwu618@gmail.com
 * @Date 2017-12-02
 */
public class Factory {
    public Apple getFruit(final int num) {
        return new Apple() {
            public String getNumber() {
                return num + "个苹果";
            }
        };
    }

    public static void main(String[] args) {
        Factory factory = new Factory();
        Apple inner = factory.getFruit(2);
        System.out.println(inner.getNumber());
    }
}
