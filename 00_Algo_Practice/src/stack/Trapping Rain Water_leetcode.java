import java.util.*;

class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length -1;
        int left_b = left, right_b = right;
        int rain = 0;

        while(left < right){
            if(height[left] <= height[right]){
                left +=1;

                if(height[left_b] < height[left]){
                    left_b = left;
                }else{
                    rain += height[left_b] - height[left];
                }
            }else{
                right -=1;

                if(height[right_b] < height[right]){
                    right_b = right;
                }else{
                    rain += height[right_b] - height[right];
                }
            }
        }
        return rain;
    }
}
