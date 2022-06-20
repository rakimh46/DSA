import java.util.HashMap;

class ITwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        // In case there is no solution, we'll just return null
        return null;
    }
    public static void main(String[] args) {
        int[] arr ={2,7,11,15};
        int target =9;
        int ans[]=twoSum(arr,target);

        for(int i=0;i<ans.length;i++){
            System.out.print("["+ans[i]+" ");
        }
        System.out.print("]");
        
    }
}