package com.lingqiantong;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class lqt {
    public static void main(String[] args) {
/**
 * 项目需求说明
 * 使用java开发零钱通项目，可以完成收益入账，消费，查看明细，退出系统等功能
 *  输入： 1. 零钱通明细 2. 消费入账 3. 消费 4. 退出系统
 * */
        System.out.println("-------------------零钱通菜单-------------------");
        System.out.println("\t \t 1. 零钱通明细");
        System.out.println("\t \t 2. 消费入账");
        System.out.println("\t \t 3. 消费");
        System.out.println("\t \t 4. 退出系统");
        System.out.println("请输入你的选择：");
        String key = "";
        Boolean loop = true;
        Scanner scanner1 = new Scanner(System.in);
        SmallChangeService smallChangeService = new SmallChangeService();
        do{
            key = scanner1.next();
            LocalDateTime now = LocalDateTime.now();

            // 格式化为指定格式
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String format = now.format(formatter);
            switch (key) {
                case "1":
                    System.out.println("-----------零钱通明细-----------");
                    smallChangeService.show();
                    break;
                case "2":
                    System.out.println("-----------消费入账-----------");
                    System.out.println("请输入你的金额：");
                    double money = scanner1.nextDouble();
                    SmallChange smallChange = new SmallChange(money, format, "1");
                    smallChangeService.add(smallChange);

                    break;
                case "3":
                    System.out.println("-----------消费-----------");
                    System.out.println("请输入你的金额：");
                    double money2 = scanner1.nextDouble();
                    SmallChange smallChange2 = new SmallChange(money2, format, "2");
                    smallChangeService.add(smallChange2);
                    break;
                case "4":
                    System.out.println("-----------退出系统-----------");
                    loop = false;
                    break;
                default:
                    System.out.println("输入有误，请重新输入");
                    break;
            }
        }while (loop);
        System.out.println("系统退出成功");

    }
}

class SmallChange {
    private double money;  // 入账活出账
    private String time;  // 时间
    private String type;  // 类型 1 收入 2 支出
    private double sum; // 余额

    public SmallChange(double money, String time, String type) {
        this.money = money;
        this.time = time;
        this.type = type;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }


}

class SmallChangeService {
    private SmallChange[] smallChanges = new SmallChange[0];
    private double balance = 0;  // 当前余额

    public void add(SmallChange smallChange) {
//        计算累计余额：收入加，支出减，并设置到当前记录
        balance = balance + ("1".equals(smallChange.getType()) ? smallChange.getMoney() : -smallChange.getMoney());
        smallChange.setSum(balance);
//        判断是否有空位
        if (smallChanges.length == 0) {
            this.smallChanges = new SmallChange[1];
            this.smallChanges[0] = smallChange;
        } else {
            SmallChange[] temp = new SmallChange[smallChanges.length + 1];
            for (int i = 0; i < smallChanges.length; i++) {
                temp[i] = smallChanges[i];
            }
            temp[smallChanges.length] = smallChange;
            this.smallChanges = temp;
            temp = null;
        }
        System.out.println(("1".equals(smallChange.getType()) ? "收益入账" : "支出入账") + "\t" + smallChange.getMoney() + "\t" + smallChange.getTime() +  "\t" + smallChange.getSum());

    }

    public SmallChange[] getSmallChanges() {
        return smallChanges;
    }

    public void setSmallChanges(SmallChange[] smallChanges) {
        this.smallChanges = smallChanges;
    }

//    查看零钱通明细
    public void show() {
        System.out.println("类型\t\t金额\t\t时间\t\t余额");
        for(int i = 0; i < smallChanges.length; i++) {
            System.out.println(("1".equals(smallChanges[i].getType()) ? "收益入账" : "支出入账") + "\t" + smallChanges[i].getMoney() + "\t" + smallChanges[i].getTime() +  "\t" + smallChanges[i].getSum());
        }
    }
}
