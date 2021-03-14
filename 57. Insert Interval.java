class Solution {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    if (intervals == null || intervals.length == 0) return new int[][] {newInterval};
    
    LinkedList<int[]> res = new LinkedList<>();
    int i = 0, n = intervals.length;
    
    // add interval before meet newInterval
    while (i < n && intervals[i][1] < newInterval[0]) {
      res.add(intervals[i]);
      i++;
    }
    
    // check if current one intersect with newInterval
    if (i < n) {
      int[] curr = intervals[i];
      int low = Math.max(curr[0], newInterval[0]);
      int high = Math.min(curr[1], newInterval[1]);
      
      if (low <= high) { // intersection exists
        curr[0] = Math.min(curr[0], newInterval[0]);
        curr[1] = Math.max(curr[1], newInterval[1]);
        res.add(curr);
      } else {
        res.add(newInterval);
        res.add(curr);
      }
      i++;
    } else {
      res.add(newInterval);
    }
    
    // add rest of intervals to res
    while (i < n) {
      int[] last = res.getLast();
      if (last[1] >= intervals[i][0]) { // merge
        last[1] = Math.max(last[1], intervals[i][1]);
      } else {
        res.add(intervals[i]);
      }
      i++;
    }
    
    return res.toArray(new int[res.size()][]);
  }
}