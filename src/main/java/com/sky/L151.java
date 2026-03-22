package com.sky;

public class L151 {

    public String reverseWords(String s) {
        s = " " + s.trim();
        int right = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (right >= 0) {
            int end = right;
            while (right > 0 && Character.isLetterOrDigit(s.charAt(right)))
                right--;
            if (end != right)
                sb.append(s, right + 1, end + 1).append(" ");
            right--;
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public static void main(String[] args) {
        L151 lt = new L151();
        System.out.println(lt.reverseWords("a good   example"));
    }
}
