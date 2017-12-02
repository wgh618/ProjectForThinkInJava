package com.will.innerClass;

/**
 * ClassName:Parcel
 * Description:局部内部类--它是嵌套在方法和作用域内的，对于这个类的使用主要是应用与解决比较复杂的问题，想创建一个类来辅助我们的解决方案，
 * 到那时又不希望这个类是公共可用的，所以就产生了局部内部类，局部内部类和成员内部类一样被编译，只是它的作用域发生了改变，
 * 它只能在该方法和属性中被使用，出了该方法和属性就会失效。
 * @Author Will Wu
 * @Email willwu618@gmail.com
 * @Date 2017-12-02
 */
public class Parcel {
    public Destionation destionation(String str){
        class PDestionation implements Destionation{
            private String label;
            private PDestionation(String whereTo){
                label = whereTo;
            }
            public String readLabel(){
                return label;
            }
        }
        return new PDestionation(str);
    }

    public static void main(String[] args) {
        Parcel parcel = new Parcel();
        Destionation d = parcel.destionation("chenssy");
    }
}
