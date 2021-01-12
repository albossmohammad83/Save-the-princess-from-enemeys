import java.util.Scanner;

public class WWEGame {
    public static void main(String[] args) {
        Map map = new Map();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name to start:\n");
        String playerName = input.nextLine();
        Player player = new Player(100,10, 20, playerName);
        String currLoc = "Entrance";
        new WWEGameDriver().run(map, player, currLoc);
    }
}
