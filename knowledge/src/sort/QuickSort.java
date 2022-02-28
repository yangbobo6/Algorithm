package sort;

/**
 * @Author: yangbo
 * @Date: 2022-02-28-11:22
 * @Description:
 */
public class QuickSort {


    public static void main(String[] args) {
        int[] arr = new int[]{3,5,4,2,6,7};
        int num = 4;
        int x = -1;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] <= num){
                swap(arr, i, ++x);
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
        if (i == j)
            return ;
        //异或运算  两数交换
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }


}
