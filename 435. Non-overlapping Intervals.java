class Solution {
  public int eraseOverlapIntervals(int[][] intervals) {
    // time O(nlogn)
    // space O(1)
    // edge case
    if (intervals == null || intervals.length == 0) return 0;
    
    Arrays.sort(intervals, (i1, i2) -> i1[1] - i2[1]); // sort by end
    int merge = intervals[0][1];
    
    // sorting by end means the smaller end we put into the merged interval
    // the larger space for fitting more intervals.
    // Thus the merged one can contains the max intervals from the given intervals
    int count = 1;
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] >= merge) {
        merge = intervals[i][1];
        count++;
      }
    }
    return intervals.length - count;
  }
}