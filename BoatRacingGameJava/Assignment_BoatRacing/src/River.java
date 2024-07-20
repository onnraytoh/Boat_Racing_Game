import java.util.ArrayList;
import java.util.Random;

public class River {
    private ArrayList<RiverObjects> objectlist = new ArrayList<RiverObjects>();
    Boat player1 = new Boat(1);
    Boat player2 = new Boat(2);

    private Dice dice;

    public River() {
        dice = new Dice();
        Random rand = new Random();
        int no_current = rand.nextInt(10);
        int no_traps = rand.nextInt(10);
        int no_rocks = rand.nextInt(7);

        for (int i=0; i<no_current; i++) {
            objectlist.add(new Current());
        }
        for (int i=0; i<no_traps; i++) {
            objectlist.add(new Trap());
        }
        for (int i=0; i<no_rocks; i++) {
            objectlist.add(new Rocks());
        }
    }

    public void player1turn() {
        int rollnum = dice.rolldice();
        player1.move(rollnum);
        System.out.println("Player 1 rolled a " + rollnum);
        for(RiverObjects r: objectlist) {
            if (r.getLocation() == player1.getLocation()) {
                if (r instanceof Current) {
                    int move = ((Current)r).getStrength();
                    player1.move(move);
                    System.out.println("Player 1 received a boost forward by " + move + " from a current!");
                }
                if (r instanceof Trap) {
                    int move = ((Trap)r).getStrength();
                    player1.move(-move);
                    System.out.println("Player 1 got stuck in a trap, player 1 is set back by " + move);
                }
                if (r instanceof Rocks) {
                    System.out.println("Player 1 got stuck in a rock, player 1 will skip next round!");
                }
            }
        }
        System.out.println("Player 1 is currently at position " + player1.getLocation());
    }

    public void player2turn() {
        int rollnum = dice.rolldice();
        player2.move(rollnum);
        System.out.println("Player 2 rolled a " +rollnum);
        for(RiverObjects r: objectlist) {
            if (r.getLocation() == player2.getLocation()) {
                if (r instanceof Current) {
                    int move = ((Current)r).getStrength();
                    player2.move(move);
                    System.out.println("Player 2 received a boost forward by " + move + " from a current!");
                }
                if (r instanceof Trap) {
                    int move = ((Trap)r).getStrength();
                    player2.move(-move);
                    System.out.println("Player 2 got stuck in a trap, player 2 is set back by " + move );
                }
                if (r instanceof Rocks) {
                    System.out.println("Player 2 got stuck in a rock, player 2 will skip next round!");
                }
            }
        }
        System.out.println("Player 2 is currently at position " + player2.getLocation());
    }

    public void display() {
        for(int i=0; i<100; i++) {
            boolean isOccupied = false;

            if (player1.getLocation() == player2.getLocation()) {
                if (player1.getLocation() == i) {
                    isOccupied = true;
                    System.out.print("½");
                }
            }
            else {
                if (player1.getLocation() == i) {
                    isOccupied = true;
                    System.out.print(player1.getPlayerno());
                }
                if (player2.getLocation() == i) {
                    isOccupied = true;
                    System.out.print(player2.getPlayerno());
                }
            }

            for(RiverObjects r: objectlist) {
                if (r.getLocation() == i && r.getLocation() != player1.getLocation() && r.getLocation() != player2.getLocation()) {
                    isOccupied = true;
                    System.out.print(r.getSymbol());
                }
            }
            if (!isOccupied) {
                System.out.print(" ");
            }
        }
        System.out.print("\n");
    }
}
