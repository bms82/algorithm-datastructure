package bms.algorithm.must;

/**
 * LeetCode # 11. Container with Most Water
 */
public class ContainerMostWater {

    public int maxArea(int[] height) {
        int maxVolume = 0;
        for (int leftIdx = 0; leftIdx < height.length; leftIdx++) {

            for (int rightIdx = height.length - 1; rightIdx > leftIdx; rightIdx--) {
                int width = rightIdx - leftIdx;
                int areaHeight = Math.min(height[leftIdx], height[rightIdx]);
                int volume = width * areaHeight;
                if (maxVolume < volume) {
                    maxVolume = volume;
                }
            }
        }
        return maxVolume;
    }
}
