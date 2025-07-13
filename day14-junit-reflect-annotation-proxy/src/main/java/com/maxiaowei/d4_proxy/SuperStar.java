package com.maxiaowei.d4_proxy;

public class SuperStar implements Star {
    private String name;

    public SuperStar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String sing(String name) {
        System.out.println(this.name + "唱歌一首：" + name);
        return "谢谢！谢谢！";
    }

    @Override
    public void dance(String name) {
        System.out.println(this.name + "跳了一支：" + name);
    }
}
