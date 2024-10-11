package Project;

public class Life {
    
    private int gridSizeX;
    private int gridSizeY;
    private int[][] grid;

    public Life (int gridSizeX, int gridSizeY){
        this.gridSizeX = gridSizeX;
        this.gridSizeY = gridSizeY;
        this.grid = new int[gridSizeY][gridSizeX];
    }
    
    public int[][] getGrid() {
        return grid;
    }


    public void setGrid(int[][] newGrid) {
        this.grid = newGrid;
    }

    public void initialAlive(int startX, int startY, String initialData){
        String[] lines = initialData.split("\n");
        for (int row =0; row < lines.length; row++){
            char[] cells = lines[row].toCharArray();
            for( int col = 0; col < cells.length; col++){
                if (cells[col] == '*'){
                    if(startY + row < gridSizeY && startX + col <gridSizeX){
                        grid[startY + row][startX +col] = 1;
                    }
                }
            }
        }
    }

    public void printGrid(){
        for (int i =0; i < gridSizeY ; i++){
            for (int j=0; j < gridSizeX; j++){
                System.out.print(grid[i][j] == 1 ? "0" : ".");
                System.out.print(" ");
            }
            System.out.println();
        }

        System.out.println(); // Print empty line 

    }

}
