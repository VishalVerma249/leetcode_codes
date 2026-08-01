class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int rows = grid.size();
        int cols = grid.get(0).size();

        int[][] distance = new int[rows][cols];

        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        Deque<int[]> deque = new ArrayDeque<>();

        distance[0][0] = grid.get(0).get(0);
        deque.offerFirst(new int[]{0, 0});

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();

            int row = current[0];
            int col = current[1];

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (newRow < 0 || newRow >= rows
                        || newCol < 0 || newCol >= cols) {
                    continue;
                }

                int cellCost = grid.get(newRow).get(newCol);

                int newDistance =
                    distance[row][col] + cellCost;

                if (newDistance < distance[newRow][newCol]) {
                    distance[newRow][newCol] = newDistance;

                    if (cellCost == 0) {
                        deque.offerFirst(
                            new int[]{newRow, newCol}
                        );
                    } else {
                        deque.offerLast(
                            new int[]{newRow, newCol}
                        );
                    }
                }
            }
        }

        int minimumDamage =
            distance[rows - 1][cols - 1];

        return minimumDamage < health;
    }
}