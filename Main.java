import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static public void main(String args[]){
        PrintWriter fileWriter = null;
        FileOutputStream timeFile;
        Scanner scnr = new Scanner(System.in);
        System.out.print("How many times do you want this program to run: ");
        int runTimes = scnr.nextInt();

        try{
            timeFile = new FileOutputStream("TimeToRun.txt", true);
            fileWriter = new PrintWriter(timeFile);
        } catch (FileNotFoundException e){
            System.out.println("File not found");
        }

        //runs through the program and records the time it takes to sort the different size arrays
        //the data can be found in TimeToRun.txt
        for(int n = 10; n < 20_000; n+= 20_000 /runTimes) { //will run the number of times that the user intends
            ArrayList<ChessGame> chessGames = new ArrayList<>();
            createArrayList(chessGames);
            long startTime = System.nanoTime(); //records the time before
            //method call
            sort(chessGames, n);
            long finishTime = System.nanoTime(); // and after the method call
            double elapsedTimeInSeconds = (finishTime - startTime) / 1000000000.0;

            fileWriter.printf(n + " %.9f%n", elapsedTimeInSeconds);
            System.out.printf("Execution Time When N = " + n + ": %.9f seconds%n", elapsedTimeInSeconds);

            printToFile(chessGames, "SortedChessGames.csv", n);
        }

        fileWriter.close();


    }



    //creates an ArrayList with the data set and can be changed based off of what data set wants to be used
    public static void createArrayList(ArrayList<ChessGame> chessGames){
        FileInputStream gameFile = null;
        try {
            gameFile = new FileInputStream("chess_games.csv");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(9);
        }

        Scanner fileReader = new Scanner(gameFile);
        while(fileReader.hasNextLine()){
            String line = fileReader.nextLine();

            ChessGame game = getChessGame(line);

            chessGames.add(game);
        }
    }


    //creates a chess game object from the given line
    private static ChessGame getChessGame(String line) {
        // Splitting the line by commas to get individual values
        String[] gameData = line.split(",");

        // Creating a ChessGame object using parsed values
        ChessGame game = new ChessGame(
                Integer.parseInt(gameData[0]),
                Boolean.parseBoolean(gameData[1]),
                Integer.parseInt(gameData[2]),
                gameData[3],
                gameData[4],
                gameData[5],
                gameData[6],
                Integer.parseInt(gameData[7]),
                gameData[8],
                Integer.parseInt(gameData[9])
        );
        return game;
    }


    //swaps two items in an array
    public static void swap(ArrayList<ChessGame> chessGames, int i1, int i2){
        ChessGame temp = chessGames.get(i1);
        chessGames.set(i1, chessGames.get(i2));
        chessGames.set(i2, temp);
    }




    /** Bubble Sort Method
    The sorting algorithm works by repeatedly stepping through the list, comparing adjacent elements and swaps
them if they are in the wrong order. The pass through the list is repeated until the list is sorted.
So if the original list is:
14 33 27 35 10
the first two elements are compared but they are in order:
14 33 27 35 10
the next two pairs are compared and they are out of order so they
must be swapped:
14 33 27 35 10
14 27 33 35 10
the next two pairs are compared but they are in order:
14 27 33 35 10
the next two pairs are compared and they are out of order so they
must be swapped:
14 27 33 35 10
14 27 33 10 35
We have now reached the end of the array. After one iteration,
notice that the largest element has “bubbled” to the end of the
array:
14 27 33 10 35
after the next iteration, the next largest element moves to the end:
14 27 10 33 35
after the next iteration, the next largest element moves to the end:
14 10 27 33 35
after the next iteration, the next largest element moves to the end:
10 14 27 33 35
after the next iteration, the next largest element moves to the end:
10 14 27 33 35
When there are no swaps required, the sort algorithm determines
that an array is completely sorted and the algorithm ends.
     */
    public static void sort(ArrayList<ChessGame> chessGames, int n){
        boolean isSorted = false;
        AveragePlayerRatingComparator gameComparator = new AveragePlayerRatingComparator();
        while(!isSorted) {
            //sets the isSortedInt to 0 every time the array is parsed through
            int isSortedInt = 0;
            int i;
            for (i = 0; i < n - 1; i++) {

                //if the numbers compared are out of order they are swapped
                if (gameComparator.compare(chessGames.get(i), chessGames.get(i + 1)) > 0) {
                    swap(chessGames, i, i + 1);
                    //resets the isSortedInt in order to show that a number was swapped
                    isSortedInt = -1;
                    continue;
                }

                isSortedInt++;
            }
            //if the isSortedInt is the same as i (no swaps were made) when i is at the end of the array
            if (isSortedInt == i) {
                isSorted = true;
            }
        }
    }



    //Prints the given ArrayList to a file for a given size n
    public static void printToFile(ArrayList<ChessGame> chessGames, String fileName, int n){
        PrintWriter fileWriter = null;
        try{
            fileWriter = new PrintWriter(fileName);
        } catch(FileNotFoundException e){
            System.out.println("File not found");
            System.exit(9);
        }

        for(int i = 0; i < n; i++)fileWriter.println(chessGames.get(i));

        fileWriter.close();
    }
}