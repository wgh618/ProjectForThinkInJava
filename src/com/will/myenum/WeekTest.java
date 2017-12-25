package com.will.myenum;

/**
 * ClassName:WeekTest
 * Description:
 * @Author Will Wu
 * @Email willwu618@gmail.com
 * @Date 2017-12-25
 */
public class WeekTest {
    public static void main(String[] args) {
        for (Week week : Week.values()) {
            System.out.println(week + " ordinal:" + week.ordinal());
            System.out.println(week.name());
            System.out.println(week.getDeclaringClass());
            System.out.println(week.compareTo(Week.FRIDAY));
            System.out.println(week.equals(Week.FRIDAY));
            System.out.println("------------------------------------");
        }
    }
}
