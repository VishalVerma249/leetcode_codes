class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();

        int[][] distance = new int[n][n];

        for (int[] row : distance) {
            Arrays.fill(row, -1);
        }

        Queue<int[]> queue = new LinkedList<>();

        
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid.get(row).get(col) == 1) {
                    queue.offer(new int[]{row, col});
                    distance[row][col] = 0;
                }
            }
        }

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

       
        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (newRow >= 0 && newRow < n
                        && newCol >= 0 && newCol < n
                        && distance[newRow][newCol] == -1) {

                    distance[newRow][newCol] = distance[row][col] + 1;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }

        
        PriorityQueue<int[]> maxHeap =
            new PriorityQueue<>((a, b) -> b[0] - a[0]);

        boolean[][] visited = new boolean[n][n];

        maxHeap.offer(new int[]{
            distance[0][0],
            0,
            0
        });

        
        while (!maxHeap.isEmpty()) {
            int[] current = maxHeap.poll();

            int safeness = current[0];
            int row = current[1];
            int col = current[2];

            if (visited[row][col]) {
                continue;
            }

            visited[row][col] = true;

            if (row == n - 1 && col == n - 1) {
                return safeness;
            }

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (newRow >= 0 && newRow < n
                        && newCol >= 0 && newCol < n
                        && !visited[newRow][newCol]) {

                    int newSafeness = Math.min(
                        safeness,
                        distance[newRow][newCol]
                    );

                    maxHeap.offer(new int[]{
                        newSafeness,
                        newRow,
                        newCol
                    });
                }
            }
        }

        return 0;
    }
}