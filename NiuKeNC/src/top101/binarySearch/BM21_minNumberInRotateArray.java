package top101.binarySearch;

/**
 * @Author: yangbo
 * @Date: 2022-07-12-21:15
 * @Description:
 */
public class BM21_minNumberInRotateArray {
    //有序数组进行旋转之后，寻找最小值  （二分法）
    public int minNumberInRotateArray(int [] array) {
        int len = array.length;
        int left = 0;
        int right = len-1;

        while(left<right){
            int mid = (left+right)/2;
            //肯定在右边
            if(array[mid]>array[right]){
                left = mid+1;
            }else if(array[mid]<array[right]){
                //肯定在左边
                right = mid;
            }else {
                //无法比较
                right = right-1;
            }
        }
        return array[left];
    }
}
