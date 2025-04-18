import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long q1_sum = 0, q2_sum = 0;
        
        Deque<Integer> q1 = new ArrayDeque<>();
        Deque<Integer> q2 = new ArrayDeque<>();
        
        int size = queue1.length;
        for(int i = 0; i < size; i++){
            q1_sum += queue1[i];
            q2_sum += queue2[i];
            q1.addLast(queue1[i]);
            q2.addLast(queue2[i]);
        }
        
        for(int i = 0, newSize = size * 4; i < newSize; i++){
            if(q1_sum == q2_sum) return i;
            
            else if(q1_sum < q2_sum){
                int popped = q2.removeFirst();
                q1.addLast(popped);
                q1_sum += popped;
                q2_sum -= popped;
            }
            else{
                int popped = q1.removeFirst();
                q2.addLast(popped);
                q2_sum += popped;
                q1_sum -= popped;
            }
        }
        
        return -1;
    }
}