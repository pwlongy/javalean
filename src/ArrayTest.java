import java.util.Scanner;

public class ArrayTest {
    public static void main(String[] args) {
        int[] arr = {5, 9, 20, 66, 88, 45, 86, 99, 126, 512};
        MyTools myTools = new MyTools();
        myTools.bubble(arr);
        System.out.println("=====排序后的数据");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
            System.out.println();
            Scanner myScanner = new Scanner(System.in);
        }
    }
}

class MyTools {
    String name;
    int age;

    public MyTools(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void bubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

    }
}
