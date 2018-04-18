package algorithms;

public class LongestPalindromeDP {
	public static void main(String[] args) {
		System.out.println(longestPalindromeDP("bananas"));
	}
	public static String longestPalindromeDP(String s) {
		int n = s.length();
		int longBegin = 0; //最大开始位置
		int maxLen = 1;  // 最大长度
		boolean[][] dp = new boolean[1000][1000];
		for(int i = 0; i < n; i++) {
			dp[i][i] = true;
		}
		for(int i = 0; i< n-1; i++) {
			if(s.charAt(i) == s.charAt(i+1)) {
				dp[i][i+1] = true;
				longBegin = i;
				maxLen = 2;
			}
		}
		for(int len = 3; len <= n; len++) {
			for(int i = 0; i < n - len + 1; i++) {
				int j = i + len - 1;
				if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
					dp[i][j] = true;
					longBegin = i;
					maxLen = len;
				}
			}
		}
		return s.substring(longBegin, longBegin + maxLen);
		  
	}
}
