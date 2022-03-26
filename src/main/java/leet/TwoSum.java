package leet;

import java.util.HashMap;

/**
 * @author alireza_bayat
 * created on 3/26/22
 */
public class TwoSum {

    public int[] twoSumFirstSolution(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            int arrIndex = searchInArray(nums, sub, i);

            if (arrIndex != -1) {
                result[0] = i;
                result[1] = arrIndex;
                break;
            }
        }
        return result;
    }

    //O(n)
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> loggedRecords = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int targetDiff = target - nums[i];
            if (loggedRecords.containsKey(targetDiff))
                return new int[]{loggedRecords.get(targetDiff), i};
            loggedRecords.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    private int searchInArray(int[] nums, int target, int currentIndex) {
        for (int i = 0; i < nums.length; i++) {
            if (i == currentIndex)
                continue;
            if (target == nums[i])
                return i;
        }
        return -1;
    }

}
