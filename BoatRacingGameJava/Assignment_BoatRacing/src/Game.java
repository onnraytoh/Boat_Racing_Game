import java.util.Scanner;

public class Game {

    private Scanner input;
    private River river;
    private Menu menu;
    private Dice dice;

    public Game() {
        input = new Scanner(System.in);
        river = new River();
        menu = new Menu();
        dice = new Dice();
    }

    public void start() {
        //Display Menu
        menu.diplay();
        int choice = input.nextInt();
        //Play Game
        if (choice == 1){
            while (river.player1.getLocation() < 100 && river.player2.getLocation() < 100) {
                displayOutline();
                river.display();
                displayOutline();
                pressEnterToContinue();
                river.player1turn();
                displayOutline();
                river.display();
                displayOutline();
                pressEnterToContinue();
                river.player2turn();
            }
            if (river.player1.getLocation() > 100){
                System.out.print("Player 1 Won!");
            }
            if (river.player2.getLocation() > 100){
                System.out.print("Player 2 Won!");
            }
        }
        //Print Instruction
        else if (choice == 2) {
            menu.instruction();
        }
        //Print Top Score
        else if (choice == 3) {

        }
        //Exit Game
        else if (choice == 4) {
            menu.exit();
        }
    }

    public void displayOutline() {
        for (int i = 0; i < 100; i++ ){
            System.out.print("=");
        }
        System.out.print("\n");
    }

    private void pressEnterToContinue()
    {
        System.out.println("Press Enter key to continue...");
        try
        {
            System.in.read();
            input.nextLine();
        }
        catch(Exception e)
        {}
    }

}
