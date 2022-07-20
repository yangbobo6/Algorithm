package sort;

/**
 * @Author: yangbo
 * @Date: 2022-07-19-7:33
 * @Description:  堆排序
 */
public class HeapSort {
    
    public static void sort(int[] arr){
        //构建大根堆
        for (int i = arr.length/2-1; i >= 0 ; i--) {
            adjustHeap(arr,i,arr.length);
        }
        for (int i = arr.length-1; i >0 ; i--) {
            swap(arr,0,i);
            adjustHeap(arr,0,i);
        }
    }
    
    public static void adjustHeap(int[] arr,int i,int length){
        int temp = arr[i];
        
        //数组的 位置，
        for (int j = i*2-1; j < length; j = j*2+1) {
            if(j+1<length && arr[j]<arr[j+1]){
                j++;
            }
            if(arr[j]>temp){
                arr[i] = arr[j];
                i=j;
            }else {
                break;
            }
        }
    }
    
    public static void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
