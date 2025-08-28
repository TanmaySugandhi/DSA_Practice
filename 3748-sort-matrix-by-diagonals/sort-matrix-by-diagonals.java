class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;

        // Step 1: Group values by diagonal (key = i - j)
        Map<Integer, PriorityQueue<Integer>> diagMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int d = i - j;

                // For bottom-left including main (d >= 0): use max-heap (descending)
                // For top-right (d < 0): use min-heap (ascending)
                diagMap.putIfAbsent(d, (d >= 0) 
                    ? new PriorityQueue<>(Collections.reverseOrder())
                    : new PriorityQueue<>());

                diagMap.get(d).offer(grid[i][j]);
            }
        }

        // Step 2: Refill matrix with sorted diagonals
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int d = i - j;
                grid[i][j] = diagMap.get(d).poll();
            }
        }

        return grid;
    }
}