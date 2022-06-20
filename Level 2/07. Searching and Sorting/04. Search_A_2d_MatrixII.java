public class Main {
    public static boolean search(int[][]matrix,int target) {
        //write your code here
        int r=0,c=matrix[0].length-1;
        
        while(r<matrix.length && c>=0){
            if(matrix[r][c]==target){
                return true;
            }else if(matrix[r][c]<target){
                r++;
            }else{
                c--;
            }
        }
        return false;
    }
}
