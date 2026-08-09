package com.lingqiantong;
import java.util.Scanner;

public class Houserent {
    public static void main(String[] args) {
    /**
     * 需求：房屋出租系统
     * 1. 新增房源 （姓名， 电话， 地址， 月租， 状态（未出租、已出租））
     * 2. 查找房屋  通过你要查找的id去查询
     * 3. 删除房屋  通过你要删除的id去删除（二次确定）
     * 4. 修改房屋信息 通过你要修改的id去修改（-1退出， 不进行修改直接回车）
     * 5. 房屋列表
     * 6. 退出系统
     *
     * */
        HouseService houseService = new HouseService();
        houseService.start();

    }
}

class House{
    private int id;
    private String name; // 姓名
    private String phone; // 电话
    private String address; // 地址
    private double rent; // 租金
    private String status;  // 状态（0： 未出租， 1： 已出租）
    private Boolean loop = true;

    public House(String name, String phone, String address, double rent, String status) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.rent = rent;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

class HouseService {
    private House[] houses = new House[0];
//    新增房源
    public void add(House house) {
        if(houses.length == 0) {
            houses = new House[1];
            houses[0] = house;
        } else {
            House[] temp = new House[houses.length + 1];
            for(int i = 0; i < houses.length; i++) {
                temp[i] = houses[i];
            }
            temp[houses.length-1] = house;
            houses = temp;
        }
    }

//  修改房源
    public void updata(int id) {
        House house = find(id);
        if(house != null) {
            System.out.println("请输入新的姓名：");
            String name = new Scanner(System.in).nextLine();
            System.out.println("请输入新的电话：");
            String phone = new Scanner(System.in).nextLine();
            System.out.println("请输入新的地址：");
            String address = new Scanner(System.in).nextLine();
            System.out.println("请输入新的月租：");
            double rent = new Scanner(System.in).nextDouble();
            System.out.println("请输入新的状态（0： 未出租， 1： 已出租）：");
            String status = new Scanner(System.in).nextLine();
            house.setName(name);
            house.setPhone(phone);
            house.setAddress(address);
            house.setRent(rent);
            house.setStatus(status);
            System.out.println("修改成功");
            list();
        }

    }
//    删除房源
    public void delete(int id) {
        for (int i = 0; i < houses.length; i++) {
            if(houses[i].getId() == id) {
                System.out.println("请确认是否删除（y/n）：");
                String confirm = new Scanner(System.in).nextLine();
                if("y".equals(confirm)) {
                    House[] temp = new House[houses.length - 1];
                    for(int j = 0; j < i; j++) {
                        temp[j] = houses[j];
                    }
                    for(int j = i + 1; j < houses.length; j++) {
                        temp[j - 1] = houses[j];
                    }
                    houses = temp;
                    System.out.println("删除成功");
                    list();
                    return;
                }
            }
        }
    }
//    查找房源
    public House find(int id) {
        House house = null;
        for(int i = 0; i < houses.length; i++) {
            if(houses[i].getId() == id) {
                System.out.println("id\t\t姓名\t\t电话\t\t地址\t\t月租\t\t状态");
                System.out.println(houses[i].getId() + "\t\t" + houses[i].getName() + "\t\t" + houses[i].getPhone() + "\t\t" + houses[i].getAddress() + "\t\t" + houses[i].getRent() + "\t\t" + houses[i].getStatus());
                return  houses[i];
            }
        }
        System.out.println("------------未找到该房源------------");
        return null;
    }
//    查看房源
    public void list() {
        if(houses.length == 0) {
            System.out.println("------------暂无房源------------");
        }else {
            System.out.println("id\t\t姓名\t\t电话\t\t地址\t\t月租\t\t状态");
            for(int i = 0; i < houses.length; i++) {
                System.out.println(houses[i].getId() + "\t\t" + houses[i].getName() + "\t\t" + houses[i].getPhone() + "\t\t" + houses[i].getAddress() + "\t\t" + houses[i].getRent() + "\t\t" + houses[i].getStatus());
            }
        }
    }

//    开始程序
    public void start() {
        boolean loop = true;
        System.out.println("------------欢迎使用房屋出租系统------------");
        System.out.println("1. 新增房源");
        System.out.println("2. 查找房屋");
        System.out.println("3. 删除房屋");
        System.out.println("4. 修改房屋信息");
        System.out.println("5. 房屋列表");
        System.out.println("6. 退出系统");
        System.out.println("请输入你的选择：");

        do {
            int choice = new Scanner(System.in).nextInt();
            switch (choice) {
                case 1:
                    System.out.println("请输入姓名：");
                    String name = new Scanner(System.in).nextLine();
                    System.out.println("请输入电话：");
                    String phone = new Scanner(System.in).nextLine();
                    System.out.println("请输入地址：");
                    String address = new Scanner(System.in).nextLine();
                    System.out.println("请输入月租：");
                    double rent = new Scanner(System.in).nextDouble();
                    System.out.println("请输入状态（0： 未出租， 1： 已出租）：");
                    String status = new Scanner(System.in).nextLine();
                    House house = new House(name, phone, address, rent, status);
                    add(house);
                    break;
                case 2:
                    System.out.println("请输入你要查找的id：");
                    int id = new Scanner(System.in).nextInt();
                    find(id);
                    break;
                case 3:
                    System.out.println("请输入你要删除的id：");
                    int id2 = new Scanner(System.in).nextInt();
                    delete(id2);
                    break;
                case 4:
                    System.out.println("请输入你要修改的id：");
                    int id3 = new Scanner(System.in).nextInt();
                    updata(id3);
                    break;
                case 5:
                    list();
                    break;
                case 6:
                    System.out.println("------------欢迎下次使用------------");
                    loop = false;
                    break;
                default:
                    System.out.println("------------输入错误------------");
                    start();
                    break;
            }
        }while (loop);

    }
}
