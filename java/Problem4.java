public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int total = n + m, m1 = 0, m2 = 0, i = 0, j = 0;

        for (int k = 1; k <= total / 2 + 1; ++k) {
        	int a = (i == m) ? Integer.MAX_VALUE : nums1[i];
        	int b = (j == n) ? Integer.MAX_VALUE : nums2[j];
        	m1 = m2;
        	m2 = Math.min(a, b);
        	if (a > b) ++j;
        	else ++i;
        }
        if ((total & 1) == 1) return m2;
        else return (m1 + m2) / 2.0;
    }
}