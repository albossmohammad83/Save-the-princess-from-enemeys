import java.util.Scanner;

public class Combat {
    private Wrestler wrestlers;
    private Player player;

    public Combat (Wrestler wrestlers, Player player){
        this.player = player;
        this.wrestlers = wrestlers;
    }

    public void run (){
        Scanner input = new Scanner(System.in);
        int round = 1;
        boolean isPlayerTurn = true;

        while( player.getCurrHp() >= 0 && wrestlers.getCurrHp() >= 0 ){
            if(round % 2 == 0) {
                isPlayerTurn = false;
                System.out.printf("%s's turn.\n", wrestlers.getName().toUpperCase());
            } else {
                isPlayerTurn = true;
                System.out.printf("%s's turn.\n", player.getName().toUpperCase());
            }
            player.printHealthBar();
            wrestlers.printHealthBar();



            if(isPlayerTurn) {
                System.out.println("Select an Attack by entering 1-4.");
                printAttack();
                int attack = input.nextInt();
                int dmg = useAttack(player.getName(), attack, wrestlers.getCurrHp());
                wrestlers.setCurrHp(wrestlers.getCurrHp() - dmg);

            }else{
                int dmg = wrestlers.attack();
                player.setCurrHp(player.getCurrHp() - dmg);
            }
            round++;
        }

    }
    public String getAttack(int attack) {
        switch(attack) {
            case 1:
                return "Jab";
            case 2:
                return "Cross";
            case 3:
                return "Uppercut";
            case 4:
                return "Pinfall";
        }

        return "000";
    }
    public void printAttack() {
        System.out.println("1.Jab\t\t3.Cross");
        System.out.println("2.Uppercut\t4.Pinfall");
    }
    public int useAttack(String name, int attack, int p2currHp) {
        int dmg = 0;
        switch (attack) {
            case 1:
            case 2:
            case 3:
               return dmg = player.attack();
            case 4:
                if(p2currHp > 10) {
                    System.out.println("your opponent's health is over 10% can't apply Pinfall!");
                return dmg = 0;
                }
                else {
                    System.out.println("1..2..3 You won by Pinfall");
                return dmg = 100;
                }
            default:
                System.out.println("Your wrestler doesn't understand your attack!.");
                return 0;
        }
    }
}
