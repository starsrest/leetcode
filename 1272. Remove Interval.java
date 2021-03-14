class Solution {
  public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
    // time O(n)
    // space O(n) n for output list
    List<List<Integer>> res = new ArrayList<>();
    
    int i = 0, n = intervals.length;
    
    // add intervals has no intersection with target interval to list
    while (i < n && intervals[i][1] <= toBeRemoved[0]) { 
      res.add(Arrays.asList(intervals[i][0], intervals[i][1]));
      i++;
    }
    
    while (i < n && intervals[i][0] < toBeRemoved[1]) {
      int[] curr = intervals[i];
      if (curr[0] < toBeRemoved[0]) {
        res.add(Arrays.asList(curr[0], toBeRemoved[0]));
      }
      if (curr[1] > toBeRemoved[1]) {
        res.add(Arrays.asList(toBeRemoved[1], curr[1]));
      }
      i++;
    }
    
    // add the rest of intervals to res
    while (i < n) {
      res.add(Arrays.asList(intervals[i][0], intervals[i][1]));
      i++;
    }
    
    return res;
  }
}