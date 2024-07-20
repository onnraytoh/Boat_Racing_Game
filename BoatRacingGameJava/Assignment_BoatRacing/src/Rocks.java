import java.util.Random;

public class Rocks extends RiverObjects{

    private RandomNums randomnum;
    public Rocks(){
        super("R");
        randomnum = new RandomNums();
        Random rand = new Random();
        setLocation(randomnum.getRandom());
    }
}
