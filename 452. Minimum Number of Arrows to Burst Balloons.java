class Solution {
  public int findMinArrowShots(int[][] points) {
    // time O(nlogn)
    // space O(logn) Arrays.sort()
    if (points.length == 0) return 0;
    
    // We can't simply use the o1[1] - o2[1] trick, as this will cause an 
    // integer overflow for very large or small values.
    Arrays.sort(points, (i1, i2) -> Integer.compare(i1[1], i2[1]));
    int res = 1;
    int prevEnd = points[0][1];
    for (int i = 1; i < points.length; i++) {
      if (points[i][0] > prevEnd) {
        prevEnd = points[i][1];
        res++;
      }
    }
    return res;
  }
}