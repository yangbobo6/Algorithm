package top101.binarySearch;

/**
 * @Author: yangbo
 * @Date: 2022-07-12-21:08
 * @Description:
 */
public class BM18_Find {
    //方法一  横向遍历，纵向二分查找
    public boolean Find(int target, int [][] array) {
        int rowLen = array.length;
        int colLen = array[0].length;

        if(rowLen==1&&colLen==0){
            return false;
        }

        for (int i = 0;i<rowLen;i++){
            if(target<array[i][0]||target>array[i][colLen-1]){
                continue;
            }else {
                boolean ans = binarySearch(i,colLen,target,array);
                if(ans){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean binarySearch(int row,int colLen,int target,int [][] array){
        int left = 0;
        int right = colLen-1;
        while (left<=right){
            int mid = (left+right)/2;
            if(target==array[row][mid]){
                return true;
            } else if(target>array[row][mid]){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return false;
    }
    
    
    
    //方法二  从左下角开始寻找
    public boolean Find1(int target, int [][] array) {

        if(array.length==0){
            return false;
        }

        int rowLen = array.length;   //行
        int colLen = array[0].length;//列
        int left = 0;
        int down = rowLen-1;

        //从数组的左下角开始搜索
        while(left<colLen && down>=0){
            int temp = array[down][left];
            if(temp == target){
                return true;
            }else if (temp<target){
                left++;
            }else {
                down--;
            }
        }
        return false;
    }
}
