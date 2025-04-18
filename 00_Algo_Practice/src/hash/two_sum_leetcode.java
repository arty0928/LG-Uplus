import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0, size = nums.length; i < size; i++){
            int rest = target - nums[i];

            if(map.containsKey(rest)){
                return new int[]{map.get(rest),i};
            }
            map.putIfAbsent(nums[i],i);
        }
        return null;
    }
}