package com.will.innerClass;

/**
 * ClassName:OuterClass
 * Description:成员内部类--他是可以无限制的访问外围类的所有成员属性和方法，包括private的，
 * 但是外围类要访问内部类的成员属性和方法则需要通过内部类实例来访问。
 * 在成员内部类中要注意两点，第一：成员内部类中不能存在任何static的变量和方法；
 *                       第二：成员内部类是依附于外围类的，所以只有先创建了外围类才能够创建内部类。
 * @Author Will Wu
 * @Email willwu618@gmail.com
 * @Date 2017-12-02
 */
public class OuterClass {
    private String str;

    public void outerDisplay(String str) {
        System.out.println("OuterClass..." + str);
    }

    public class InnerClass {
        public void innerDisplay() {
            //访问外部类的属性与方法
            str = "xxxxx";
            outerDisplay(str);
        }
    }

    /*推荐使用getxxx()来获取成员内部类，尤其是该内部类的构造函数无参数时 */
    public InnerClass getInnerClass(){
        return new InnerClass();
    }

    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.getInnerClass();
        inner.innerDisplay();
    }
}
