package array;

/**
 * @Author: yangbo
 * @Date: 2022-04-09-21:39
 * @Description:
 */
public class code4_findMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0,j= 0,z = 0;
        int m = nums1.length,n = nums2.length;
        int[] merge = new int[m+n];
        
        while (i<m && j<n){
            if(nums1[i]>nums2[j]){
                merge[z] = nums2[j];
                j++;
            }else {
                merge[z] = nums1[i];
                i++;
            }
            z++;
        }
        if(i==m){
            while (j!=n){
                merge[z] = nums2[j];
                z++;
                j++;
            }
        }
        if(j==n){
            while (i!=m){
                merge[z]= nums1[i];
                z++;
                i++;
            }
        }
        int mid = (m+n)/2;
        //偶数
        double result;
        if((m+n)%2==0){
            result = (double)(merge[mid-1]+merge[mid])/2;
        }else {
            result = (double)merge[mid];
        }
        return result;
    }
}
