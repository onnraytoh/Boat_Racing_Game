public class Boat{

    private int playerno;

    private int location;

    public Boat(int no){
        playerno = no;
        location = 0;
    }

    public int getPlayerno() {
        return playerno;
    }

    public void move(int move) {
        location += move;
    }

    public int getLocation() {
        return location;
    }
}
