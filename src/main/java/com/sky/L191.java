package com.sky;

public class L191 {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0){
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        L191 l191 = new L191();
        System.out.println(l191.hammingWeight(128));
    }
}
