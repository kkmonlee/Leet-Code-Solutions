class Solution(object):
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        if numRows == 1:
        	return s
        counter, diag = 2 * numRows - 2, ""
        for i in xrange(numRows):
        	for j in xrange(i, len(s), counter):
        		diag += s[j]
        		if 0 < i < numRows - 1 and j + counter - 2 * i < len(s):
        			diag += s[j + counter - 2 * i]
        return diag

if __name__ == "__main__":
	print Solution().convert("PAYPALISHIRING", 3)