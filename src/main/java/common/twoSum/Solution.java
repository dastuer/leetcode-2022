package common.twoSum;

import java.util.*;

public class Solution {
    public static void main(String[] args) {

    }
    public static int[] twoSum(int[] arr,int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int sub = arr[i] - target;
            if (map.containsKey(sub)){
                return new int[]{map.get(sub), i};
            }else {
                map.put(arr[i],i);
            }
        }
        return null;
    }
}
