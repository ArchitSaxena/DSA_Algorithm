package com.archit.recursion;

import java.util.LinkedList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Permutations obj = new Permutations();
        int[] arr = new int[]{1, 2, 3};
        List<List<Integer>> result = new LinkedList<>();
        List<String> stringResult = new LinkedList<>();
        List<String> list = new LinkedList<>();
        obj.findPermutations(arr, result, new LinkedList<>());
        obj.findStringPermutations("", stringResult, "");
        obj.stringSubstring(list, "", "ABB");

        System.out.println(result);
        System.out.println(stringResult);
        System.out.println(list);
        System.out.println(obj.findStringPermutationsCount("archit", "" ));
    }

    public void findPermutations(int[] arr, List<List<Integer>> result, List<Integer> temp) {
        if (temp.size() == arr.length) {
            result.add(new LinkedList<>(temp));
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (temp.contains(arr[i]))
                    continue;
                temp.add(arr[i]);
                findPermutations(arr, result, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public void findStringPermutations(String str, List<String> result, String temp) {
        if (str.length() == temp.length()) {
            result.add(temp);
        } else {
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (temp.indexOf(ch) >= 0) {
                    continue;
                }
                temp = temp + ch;
                findStringPermutations(str, result, temp);
                temp = temp.substring(0, temp.length() - 1);
            }
        }
    }

    public int findStringPermutationsCount(String str, String temp) {
        if (str.length() == temp.length()) {
            return 1;
        } else {
            int count =0;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (temp.indexOf(ch) >= 0) {
                    continue;
                }
                temp = temp + ch;
                count = count + findStringPermutationsCount(str, temp);
                temp = temp.substring(0, temp.length() - 1);
            }
            return count;
        }
    }

    public void stringSubstring(List<String> result, String str, String up) {
        if (up.isEmpty()) {
            result.add(str);
        } else {
            char ch = up.charAt(0);
            for (int i = 0; i <= str.length(); i++) {
                String left = str.substring(0, i);
                String right = str.substring(i);
                stringSubstring(result, left + ch + right, up.substring(1));
            }
        }
    }
}
