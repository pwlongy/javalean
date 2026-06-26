package com.Basic;

public class MiGong {
    public static void main(String[] args){
        MiGongMap mapMIgong = new MiGongMap();
        int[][] map = mapMIgong.getMap();
        mapMIgong.findWay(1, 1);
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class MiGongMap {
    public int[][] map = new int[8][7];
    public int[][] getMap() {
        for (int i = 0; i < this.map.length - 1; i++) {
            for (int j = 0; j < this.map[0].length; j++) {
//            设置第一行以及最后一行为1
                if(i == 0 || i == this.map.length - 1) {
                    this.map[0][j] = 1;
                    this.map[this.map.length -1][j] = 1;
                }
//              设置第一列以及最后一列为1
                if(j == 0 || j == this.map[0].length - 1) {
                    this.map[i][j] = 1;
                }
            }
        }
        this.map[3][1] = 1;
        this.map[3][2] = 1;
        this.map[2][2] = 1;
        return this.map;
    }
    public Boolean findWay(int i, int j) {
        if(this.map[6][5] == 2) {
            return true;
        } else {
            if(this.map[i][j] == 0) {
                this.map[i][j] = 2;
                if(findWay(i+1, j)) {
                    return true;
                } else if(findWay(i, j+1)) {
                    return true;
                } else if(findWay(i-1, j)) {
                    return true;
                } else if(findWay(i, j-1)) {
                    return true;
                } else {
                    this.map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}

class hannuo {

}
