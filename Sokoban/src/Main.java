import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static String title = """
            ╔═╗╔═╗╦╔═╔═╗╔╗ ╔═╗╔╗╔
            ╚═╗║ ║╠╩╗║ ║╠╩╗╠═╣║║║
            ╚═╝╚═╝╩ ╩╚═╝╚═╝╩ ╩╝╚╝
            """;

    static int map = 1;

    public static void main(String[] args){
        String dir;

        mainMenu();

        Maps.setMap(1);
        Maps.render();

        while(true){
            System.out.print("Move: ");
            dir = scanner.nextLine().toUpperCase();

            Player.move(dir);

            Maps.render();
            if(areAllBoxesOnMarks()){
                System.out.print("YOU WIN! Play again? (yes/no): ");
                String playAgain = scanner.nextLine();
                if(playAgain.toUpperCase().equals("YES")){
                    System.out.println();
                    Maps.playerPlaced = false;
                    Maps.setMap(map);
                    Maps.render();
                }
                else{
                    System.exit(0);
                }
            }
        }
    }

    static void mainMenu(){
        String play;

        do{
            System.out.println(title);
            System.out.print("Play? ");
            play = scanner.nextLine();
        }while(!play.toUpperCase().equals("YES"));
    }

    static boolean areAllBoxesOnMarks(){
        for (int i = 0; i < Maps.chosenMapBoxes.length; i++) {
            for (int j = 0; j < Maps.chosenMapBoxes[i].length; j++) {
                if (Maps.chosenMapBoxes[i][j].type.equals("box")) {
                    if (!Maps.chosenMap[i][j].type.equals("mark")) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
