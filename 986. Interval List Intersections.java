class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
      // time O(min(m, n))
      // space O(max(m, n))
      List<int[]> res = new ArrayList<>();
      int i = 0, j = 0;
      while (i < firstList.length && j < secondList.length) {
        
        // check if there is an intersection between first and second interval
        int low = Math.max(firstList[i][0], secondList[j][0]);
        int high = Math.min(firstList[i][1], secondList[j][1]);
        if (low <= high) res.add(new int[]{low, high});
        
        // the one with less end value move to next
        if (firstList[i][1] < secondList[j][1]) i++;
        else j++;
      }
      return res.toArray(new int[res.size()][]); 
    }
}