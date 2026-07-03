package com.Basic;
import java.util.Scanner;
public class games {
    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
// 剪刀石头布游戏 0 表示 剪刀， 1 表示石头 2 表示 布
class Game {
//  保存记录
    public int[][] gameList;

    public void play() {
        this.gameList = new int[3][2];
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入你需要出的手势： 0 表示 剪刀， 1 表示石头 2 表示布 ========");
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            int computer = this.random();
            if(input == 0 && computer == 2) {
                System.out.println("你赢了");
            } else if (input == 1 && computer == 0) {
                System.out.println("你赢了");
            } else if (input == 2 && computer == 1) {
                System.out.println("你赢了");
            } else if (input == computer) {
                System.out.println("平局");
            } else {
                System.out.println("你输了");
            }
            // 保存数据
            this.save(input, computer, i);
        }

//        打印日志信息
        this.printLog();
    }
//  机器生成一个0-3的随机数
    public int random() {
        return (int) (Math.random() * 3);
    }
    // 保存数据
    public void save(int input, int computer, int index) {
        int[] game = new int[2];
        game[0] = input;
        game[1] = computer;
        this.gameList[index] = game;
    }
//    打印日志信息
    public void printLog() {
        for (int i = 0; i < this.gameList.length; i++) {
            System.out.println("第" + (i + 1) + "局： 你出的是" + this.gameList[i][0] + "， 机器出的是" + this.gameList[i][1]);
        }
    }
}
