class Solution {
  public int maximalSquare(char[][] matrix) {
    // dp
    // time O(m * n)
    // space O(m * n)
    int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
    int[][] dp = new int[rows][cols];
    int maxlen = 0;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
          maxlen = Math.max(maxlen, dp[i][j]);
        } else if (matrix[i][j] == '1') {
          dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
          maxlen = Math.max(maxlen, dp[i][j]);
        }
      }
    }
    return maxlen * maxlen;
  }
}