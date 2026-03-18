package com.sky;

class L125 {
    public boolean isPalindrome(String s) {
        if (s.isEmpty() || s.length() == 1)
            return true;
        s = s.toLowerCase();
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                ++i;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                --j;
            }
            if (i <= j && s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        L125 l125 = new L125();
        System.out.println(l125.isPalindrome("A man, a plan, a canal: Panama"));
    }
}