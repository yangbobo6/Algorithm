package sort;

/**
 * @Author: yangbo
 * @Date: 2022-04-07-18:32
 * @Description:  快排
 */
public class QuickSort {

    /**
     * 分区过程
     * array[] 待分区数组
     *  left 待分区数组最小下标
     *  right 待分区数组最大下标
     */
    public static void quickSort(int[] array,int left,int right){
        //left和right是下标
        if(left<right){
            int temp = qSort(array,left,right);
            quickSort(array,left,temp-1);
            quickSort(array,temp+1,right);
        }
    }
    
    /**
     * 排序过程
     *  a 待排序数组
     *  left 待排序数组最小下标
     *  right 待排序数组最大下标
     * @return 排好序之后基准数的位置下标，方便下次的分区
     */
    public static int qSort(int[] array,int left,int right){
       int temp = array[left];
       while (left<right){
           while (left<right&&array[right]>temp){
               right--;
           }
           if(left<right){
               array[left] = array[right];
               left++;
           }
           while (left<right&&array[left]<temp){
               left++;
           }
           if(left<right){
               array[right] = array[left];
               right --;
           }
       }
       array[left]=temp;
       return left;
    }
}
