package com.sky;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class L1044 {

    // 二分查找 + Rabin-Karp 字符串编码
    public String longestDupSubstring(String s) {
        Random random = new Random();
        // 生成两个进制
        int a1 = random.nextInt(75) + 26;
        int a2 = random.nextInt(75) + 26;
        // 生成两个模
        int mod1 = random.nextInt(Integer.MAX_VALUE - 1000000007 + 1) + 1000000007;
        int mod2 = random.nextInt(Integer.MAX_VALUE - 1000000007 + 1) + 1000000007;
        int n = s.length();
        // 先对所有字符进行编码
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = s.charAt(i) - 'a';
        }
        // 二分查找的范围是[1, n-1]
        int l = 1, r = n - 1;
        int length = 0, start = -1;
        while (l <= r) {
            int m = l + (r - l + 1) / 2;
            int idx = check(arr, m, a1, a2, mod1, mod2);
            if (idx != -1) {
                // 有重复子串，移动左边界
                l = m + 1;
                length = m;
                start = idx;
            } else {
                // 无重复子串，移动右边界
                r = m - 1;
            }
        }
        return start != -1 ? s.substring(start, start + length) : "";
    }

    public int check(int[] arr, int m, int a1, int a2, int mod1, int mod2) {
        int n = arr.length;
        long aL1 = pow(a1, m, mod1);
        long aL2 = pow(a2, m, mod2);
        long h1 = 0, h2 = 0;
        for (int i = 0; i < m; ++i) {
            h1 = (h1 * a1 % mod1 + arr[i]) % mod1;
            h2 = (h2 * a2 % mod2 + arr[i]) % mod2;
            if (h1 < 0) {
                h1 += mod1;
            }
            if (h2 < 0) {
                h2 += mod2;
            }
        }
        // 存储一个编码组合是否出现过
        Set<Long> seen = new HashSet<Long>();
        seen.add(h1 * mod2 + h2);
        for (int start = 1; start <= n - m; ++start) {
            h1 = (h1 * a1 % mod1 - arr[start - 1] * aL1 % mod1 + arr[start + m - 1]) % mod1;
            h2 = (h2 * a2 % mod2 - arr[start - 1] * aL2 % mod2 + arr[start + m - 1]) % mod2;
            if (h1 < 0) {
                h1 += mod1;
            }
            if (h2 < 0) {
                h2 += mod2;
            }

            long num = h1 * mod2 + h2;
            // 如果重复，则返回重复串的起点
            if (!seen.add(num)) {
                return start;
            }
        }
        // 没有重复，则返回-1
        return -1;
    }

    public long pow(int a, int m, int mod) {
        long ans = 1;
        long contribute = a;
        while (m > 0) {
            if (m % 2 == 1) {
                ans = ans * contribute % mod;
                if (ans < 0) {
                    ans += mod;
                }
            }
            contribute = contribute * contribute % mod;
            if (contribute < 0) {
                contribute += mod;
            }
            m /= 2;
        }
        return ans;
    }


    // 选择一个大质数作为哈希模数，减少冲突
    private static final long MOD = (long) 1e12 + 7;
    // 哈希基数（类似进制）
    private static final int BASE = 31;


    // 下面的更好理解一点
    public String longestDupSubstring2(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();

        // 二分查找最长重复子串的长度
        int left = 0, right = n;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (check(cs, mid)) {
                // 存在长度为 mid 的重复子串，尝试更长
                left = mid;
            } else {
                // 不存在，缩小长度
                right = mid;
            }
        }

        // 此时 left 就是最长重复子串的长度
        int start = findStart(cs, left);
        return s.substring(start, start + left);
    }

    /**
     * 判断是否存在长度为 len 的重复子串
     */
    private boolean check(char[] cs, int len) {
        int n = cs.length;
        // 用来存已经出现过的哈希值
        Set<Long> seen = new HashSet<>();

        // 预计算 BASE^len % MOD，用于滚动哈希
        long pow = 1;
        for (int i = 0; i < len; i++) {
            pow = (pow * BASE) % MOD;
        }

        // 计算第一个长度为 len 的子串的哈希值
        long hash = 0;
        for (int i = 0; i < len; i++) {
            hash = (hash * BASE + cs[i]) % MOD;
        }
        seen.add(hash);

        // 滑动窗口，计算后面所有长度为 len 的子串
        for (int i = len; i < n; i++) {
            // 减去最左边的字符贡献
            hash = (hash * BASE - cs[i - len] * pow % MOD + MOD) % MOD;
            // 加上新进来的字符贡献
            hash = (hash + cs[i]) % MOD;

            // 如果这个哈希值已经出现过，说明有重复子串
            if (seen.contains(hash)) {
                return true;
            }
            seen.add(hash);
        }
        return false;
    }

    /**
     * 找到长度为 len 的重复子串的起始位置
     */
    private int findStart(char[] cs, int len) {
        int n = cs.length;
        Set<Long> seen = new HashSet<>();

        long pow = 1;
        for (int i = 0; i < len; i++) {
            pow = (pow * BASE) % MOD;
        }

        long hash = 0;
        for (int i = 0; i < len; i++) {
            hash = (hash * BASE + cs[i]) % MOD;
        }
        seen.add(hash);

        for (int i = len; i < n; i++) {
            hash = (hash * BASE - cs[i - len] * pow % MOD + MOD) % MOD;
            hash = (hash + cs[i]) % MOD;

            if (seen.contains(hash)) {
                // 返回重复子串的起始位置
                return i - len + 1;
            }
            seen.add(hash);
        }
        return 0;
    }

}
