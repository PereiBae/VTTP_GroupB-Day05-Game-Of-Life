package Project;

import java.io.*;

public class GOLMain {
    
    public static void main(String[] args) throws IOException{
        
        if (args.length != 1){
            System.out.println("Please Provide File to read to begin GOL");
            return;
        }

        String filePath = args[0];

        Object[] fileData = Instructions.readFile(filePath);
        int gridSizeX = (int) fileData[0];
        int gridSizeY = (int) fileData[1];
        int startX = (int) fileData[2];
        int startY = (int) fileData[3];
        String initialData = (String) fileData[4];

        Life GameOfLife = new Life(gridSizeX,gridSizeY);
        
        GameOfLife.initialAlive(startX, startY, initialData);

        System.out.println("Generation 0:");
        GameOfLife.printGrid();

        Rules rules = new Rules();

        for (int generation = 1; generation <= 5; generation++){
            GameOfLife.setGrid(rules.nextGeneration(GameOfLife.getGrid()));
            System.out.println("Generation " + generation + ":");
            GameOfLife.printGrid();
        }

    }

}
