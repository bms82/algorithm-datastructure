package bms.algorithm;

import java.util.*;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        List<Integer> numsList = new ArrayList<>();
        Arrays.stream(nums).forEach(e -> numsList.add(e));
        Set<Integer> numsSet = new HashSet<>(numsList);
        if (numsList.size() == numsSet.size()) return false;
        return true;
    }

}
