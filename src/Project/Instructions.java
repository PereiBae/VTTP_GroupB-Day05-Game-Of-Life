package Project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Instructions {
    
    public static Object[] readFile(String filePath) throws IOException{
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        
        String line;
        int gridSizeX = 0;
        int gridSizeY = 0;
        int startX = 0;
        int startY = 0;
        StringBuilder initialData = new StringBuilder();

        while((line = bufferedReader.readLine()) != null){
            line = line.trim();

            if (line.startsWith("#") || line.isEmpty()){
                continue;
            }

            if (line.startsWith("GRID")){
                String[] parts =line.split(" ");
                gridSizeX = Integer.parseInt(parts[1]);
                gridSizeY = Integer.parseInt(parts[2]);

            }

            else if(line.startsWith("START")){
                String[] parts = line.split(" ");
                startX = Integer.parseInt(parts[1]);
                startY = Integer.parseInt(parts[2]);
            }

            else if(line.equals("DATA")){
                while((line = bufferedReader.readLine()) != null && !line.trim().isEmpty()){
                    initialData.append(line).append("\n");
                }
                break;
            }
        }

        bufferedReader.close();

        return new Object[]{gridSizeX, gridSizeY, startX, startY, initialData.toString()};
    }

}
