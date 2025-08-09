package com.archit.recursion;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Archit Saxena
 * Date: 29/06/25
 * Time: 5:57 pm
 * Tekion Corp. © 2025
 */
public class Substrings {
    public static void main(String[] args) {
        Substrings obj= new Substrings();
        List<String> result= new LinkedList<>();
        System.out.println(obj.findAllSubstrings(result, "", "arc"));
    }
    public List<String> findAllSubstrings(List<String> result, String s, String str) {
        if (str.isEmpty()) {
            result.add(s);
            return null;
        }
        char ch = str.charAt(0);
        findAllSubstrings(result, s, str.substring(1));
        findAllSubstrings(result, s + ch, str.substring(1));
        return result;
    }
}
