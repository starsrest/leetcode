class Solution {
  public int removeCoveredIntervals(int[][] intervals) {
    // time O(nlogn)
    // space O(logn) Arrays.sort()
    Arrays.sort(intervals, (i1, i2) -> i1[0] == i2[0] ? i2[1] - i1[1] : i1[0] - i2[0]);
    int slow = 0, fast = 1, n = intervals.length, count = 1;
    while (slow < n && fast < n) {
      while (fast < n && contains(intervals[slow], intervals[fast])) {
        fast++;
      }
      if (fast < n) {
        slow = fast;
        count++;
        fast++;
      }
    }
    return count;
  }
  
  private boolean contains(int[] i1, int[] i2) {
    return i1[0] <= i2[0] && i1[1] >= i2[1];
  }
}