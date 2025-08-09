package com.archit.recursion;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Archit Saxena
 * Date: 30/06/25
 * Time: 12:20 am
 * Tekion Corp. © 2025
 */
public class Combinations {
    public static void main(String[] args) {
        Combinations obj= new Combinations();
        System.out.println(obj.letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        String[] digitList= new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result= new LinkedList<>();
        if(digits.length()==0 || digits.equals("")) return result;
        getCombinations(digits, result, digitList, 0, new StringBuilder());
        return result;
    }
    public void getCombinations(String digits, List<String> result, String[] digitList, int index, StringBuilder temp){
        if(temp.length()==digits.length()){
            result.add(temp.toString());
            return;
        }
        String str = digitList[(int)(digits.charAt(index) - '0')];
        for(int j=0;j<str.length();j++){
            temp.append(str.charAt(j));
            getCombinations(digits, result, digitList, index+1, temp);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
