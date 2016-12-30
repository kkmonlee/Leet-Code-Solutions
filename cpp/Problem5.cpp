class Solution {
public:
    string longestPalindrome(string s) {
        string formatted = preProcess(s);
        const int n = formatted.length();
        vector<int> vArr(n);
        int A = 0, B = 0;
        for (int i = 1; i < n - 1; ++i) {
        	int i_mirror = 2 * A - i;

        	vArr[i] = (B > i) ? min(B - i, vArr[i_mirror]) : 0;

        	while (formatted[i + 1 + vArr[i]] == formatted[i - 1 - vArr[i]]) {
        		++vArr[i];
        	}

        	if (i + vArr[i] > B) {
        		A = i;
        		B = i + vArr[i];
        	}
        }

        int max_i = 0;
        for (int i = 1; i < n - 1; ++i) {
        	if (vArr[i] > vArr[max_i]) {
        		max_i = i;
        	}
        }

        return s.substr((max_i - vArr[max_i]) / 2, vArr[max_i]);
    }

private:
	string preProcess(const string& s) {
		if (s.empty()) {
			return "^$";
		}
		string ret = "^";
		for (int i = 0; i < s.length(); ++i) {
			ret += "#" + s.substr(i, 1);
		}
		ret += "#$";
		return ret;
	}
};