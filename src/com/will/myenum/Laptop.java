package com.will.myenum;

/**
 * ClassName:Laptop
 * Description:
 * @Author Will Wu
 * @Email willwu618@gmail.com
 * @Date 2017-12-25
 */
public enum Laptop {
    CPU("This is CPU"),MEMORY("This is MEMORY");
    private String description;
    Laptop(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        System.out.println(Laptop.CPU.getDescription());
        System.out.println(Laptop.MEMORY.getDescription());
    }
}
