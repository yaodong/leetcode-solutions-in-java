package leetcode.Q45_JumpGame2;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Solution {

    public int jump(int[] nums) {

        int lastIndex = nums.length - 1;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);

        Set<Integer> visited = new HashSet<>();
        visited.add(0);

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;

            for (int i = 0; i < size; i++) {

                @SuppressWarnings("ConstantConditions")
                int curIndex = queue.poll();

                if (nums[curIndex] > 0) {

                    int nextStart = curIndex + 1;
                    int nextEnd = curIndex + nums[curIndex];

                    for (int nextIndex = nextStart; nextIndex <= nextEnd; nextIndex++) {

                        if (nextIndex == lastIndex) {
                            return step;
                        }

                        if (!visited.contains(nextIndex)) {
                            visited.add(nextIndex);
                            queue.offer(nextIndex);
                        }
                    }
                }
            }
        }

        return step;
    }
}
