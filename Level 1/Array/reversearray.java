
public class reversearray {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        
        reverse(arr);
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    public static void reverse(int[] arr){
        int temp,start=0, end=arr.length-1;
        while (start < end)
        {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        
    }
}