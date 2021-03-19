class Solution {
  public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
    // time O(klogk) k = max(m, n)
    // nlogn for sorting. For the while loop, O(m + n)
    // space O(logk) arrays.sort() the call stack
    Arrays.sort(slots1, (a, b) -> (a[0] - b[0])); // sorted by start time
    Arrays.sort(slots2, (a, b) -> (a[0] - b[0]));
    
    int i = 0, j = 0, m = slots1.length, n = slots2.length;
    while (i < m && j < n) {
      
      // skip invalid slots
      while (i < m && (slots1[i][1] - slots1[i][0] < duration)) i++;
      while (j < n && (slots2[j][1] - slots2[j][0] < duration)) j++;
      if (i == m || j == n) break;
      
      // compare each head slot from slots1 and slots2
      int[] s1 = slots1[i], s2 = slots2[j];
      int start = Math.max(s1[0], s2[0]);
      int end = Math.min(s1[1], s2[1]);
      
      if (end - start >= duration) {
        return new ArrayList<Integer>(Arrays.asList(start, start + duration));
      }
      
      // always move the one that ends earlier
      if (s1[1] < s2[1]) i++;
      else j++;
    }
    return new ArrayList<>();
  }
}