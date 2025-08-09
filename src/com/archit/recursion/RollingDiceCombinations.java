package com.archit.recursion;

import java.util.LinkedList;
import java.util.List;

public class RollingDiceCombinations {
    public static void main(String[] args) {
        RollingDiceCombinations obj = new RollingDiceCombinations();
        int[] dice = new int[]{1, 2, 3, 4, 5, 6};
        List<List<Integer>> result = new LinkedList<>();
        obj.findDiceCombinations(dice, result, new LinkedList<>(), 0, 0, 4);
        System.out.println(result);
    }

    public void findDiceCombinations(int[] dice, List<List<Integer>> result, List<Integer> temp, int sum, int pos, int target) {
        if (sum == target) {
            result.add(new LinkedList<>(temp));
            return;
        }
        for (int i = pos; i < dice.length; i++) {
            if (sum + dice[i] <= target) {
                sum = sum + dice[i];
                temp.add(dice[i]);
                findDiceCombinations(dice, result, temp, sum, i ,target);
                sum = sum - dice[i];
                temp.remove(temp.size() - 1);
            } else
                return;
        }
    }

}
