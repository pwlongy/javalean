import com.packageLearn.Dog;

import java.util.Arrays;

public class packageLearn {

    public static void main(String[] args){
        // 引入包
        Dog dog = new Dog() ;

        int[] arr = {3, 9, 10, 7, 99, 23};
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]+"\t");
        }
    }


}
