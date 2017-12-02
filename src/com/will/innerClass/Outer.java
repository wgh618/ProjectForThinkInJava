package com.will.innerClass;

/**
 * ClassName:Outer
 * Description:静态内部类--1、它的创建是不需要依赖于外围类的。
 *                       2、它不能使用任何外围类的非static成员变量和方法。
 * @Author Will Wu
 * @Email willwu618@gmail.com
 * @Date 2017-12-02
 */
public class Outer {
        private String sex;
        public static String name = "outerName";

        /**
         *静态内部类
         */
        static class Inner{
            /* 在静态内部类中可以存在静态成员 */
            public static String name1 = "innerName";

            public void display(){
                /*
                 * 静态内部类只能访问外围类的静态成员变量和方法
                 * 不能访问外围类的非静态成员变量和方法
                 */
                System.out.println("OutClass name :" + name);
            }
        }

        /**
         * 非静态内部类
         */
        class Inner2{
            /* 非静态内部类中不能存在静态成员 */
            public String name2 = "inner";
            /* 非静态内部类中可以调用外围类的任何成员,不管是静态的还是非静态的 */
            public void display(){
                System.out.println("OuterClass name：" + name);
            }
        }

        /**
         * @desc 外围类方法
         * @author chenssy
         * @data 2013-10-25
         * @return void
         */
        public void display(){
            /* 外围类访问静态内部类：内部类. */
            System.out.println(Inner.name1);
            /* 静态内部类 可以直接创建实例不需要依赖于外围类 */
            new Inner().display();

            /* 非静态内部类的创建需要依赖于外围类 */
            Outer.Inner2 inner = new Outer().new Inner2();
            /* 方位非静态内部类的成员需要使用非静态内部类的实例 */
            System.out.println(inner.name2);
            inner.display();
        }

        public static void main(String[] args) {
            Outer outer = new Outer();
            outer.display();
        }
}
