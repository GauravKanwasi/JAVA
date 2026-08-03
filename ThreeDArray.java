class Solution {
public:
    string stoneGameIII(vector<int>& stoneValue) {
        int n = stoneValue.size();
        int dp1 = 0, dp2 = 0, dp3 = 0, cur;

        for (int i = n - 1; i >= 0; --i) {
            cur = INT_MIN;
            int take = 0;

            take += stoneValue[i];
            cur = max(cur, take - dp1);

            if (i + 1 < n) {
                take += stoneValue[i + 1];
                cur = max(cur, take - dp2);
            }

            if (i + 2 < n) {
                take += stoneValue[i + 2];
                cur = max(cur, take - dp3);
            }

            dp3 = dp2;
            dp2 = dp1;
            dp1 = cur;
        }

        return dp1 > 0 ? "Alice" : dp1 < 0 ? "Bob" : "Tie";
    }
};
