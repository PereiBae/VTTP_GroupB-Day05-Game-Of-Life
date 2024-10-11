package Project;

public class Rules {

    // Count live neighbours of each cell
    public int countAliveNeightbours(int[][] grid, int x, int y) {
        int aliveNeighbours = 0;

        for (int i = -1; i <= 1; i++) { // Loop over row of neighbours
            for (int j = -1; j <= 1; j++) { // Loop over column of neighbours

                // Skip i=0 and j=0 because that is the original cell
                if (i == 0 && j == 0)
                    continue;

                int newX = x + i;
                int newY = y + j;

                if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length) { // To ensure that
                                                                                             // neighbours outside the
                                                                                             // grind are not included
                    if (grid[newX][newY] == 1) { // Checks if neighbour cells are alive
                        aliveNeighbours += 1;
                    }

                }
            }

        }
        return aliveNeighbours;
    }

    // Method to compute the next generation
    public int[][] nextGeneration(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] nextGen = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int aliveNeighbours = countAliveNeightbours(grid, i, j);

                // Apply rules of Conway's GOL
                if (grid[i][j] == 1) {
                    if (aliveNeighbours < 2 || aliveNeighbours > 3) {
                        nextGen[i][j] = 0;
                    } else {
                        nextGen[i][j] = 1;
                    }
                } else {
                    if (aliveNeighbours == 3) {
                        nextGen[i][j] = 1;
                    } else {
                        nextGen[i][j] = 0;
                    }
                }
            }
        }
        return nextGen;
    }
}
