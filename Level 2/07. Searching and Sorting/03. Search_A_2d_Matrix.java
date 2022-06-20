// when only row sorted
public class Main {
    public static boolean search(int[][]matrix,int target) {
        //write your code here
        int r=findrightrow(matrix,target);
        if(r==-1){
            return false;
        }
        int lo=0;
        int hi=matrix[0].length-1;
        while(lo<hi){
            int mid=(lo+hi)/2;
            if(matrix[r][mid]==target){
                return true;
            }else if(matrix[r][mid]>target){
                hi=mid;
            }else{
                lo=mid+1;
            }
        }
        return false;
    }
    
    public static int findrightrow(int[][]matrix,int target){
        int lo=0;
        int hi=matrix.length-1;
        int tc=matrix[0].length-1;
        while(lo<hi){
            int mid=(lo+hi)/2;
            if(matrix[mid][0]<=target && matrix[mid][tc]>=target){
                return mid;
            }else if(matrix[mid][0]>target){
                hi=mid;
            }else{
                lo=mid+1;
            }
        }
        return -1;
    }

}
