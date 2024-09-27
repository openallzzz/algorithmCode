package org.example;

public class _240927 {

    int N = 200010;
    int[][] pre = new int[N][3];

    public int takeCharacters(String s, int k) {
        if (k == 0) return 0;
        int l = 1, r = s.length(), n = s.length(); s += s;
        for (int i = 0; i < s.length(); i ++) {
            pre[i + 1][s.charAt(i) - 'a'] ++;
            pre[i + 1][0] += pre[i][0];
            pre[i + 1][1] += pre[i][1];
            pre[i + 1][2] += pre[i][2];
        }

        while (l < r) {
            int mid = (l + r) / 2;
            if(check(mid, k, n)) r = mid;
            else l = mid + 1;
        }

        if (check(r, k, n)) return r;
        return -1;
    }

    protected boolean check(int mid, int k, int n) {
        for (int i = 1; i + mid - 1 < N; i ++) {
            int cntA = pre[i + mid - 1][0] - pre[i - 1][0];
            int cntB = pre[i + mid - 1][1] - pre[i - 1][1];
            int cntC = pre[i + mid - 1][2] - pre[i - 1][2];
            if (cntA >= k && cntB >= k && cntC >= k) {
                if (i > n) continue;
                if (i == 1) return true;
                if (i + mid - 1 >= n) return true;
            }
        }
        return false;
    }

}
