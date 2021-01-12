import java.util.Scanner;

public class WWEGameDriver {
    private Map Map;
    private Player Player;
    public void run(Map map, Player player, String currLoc){
        map = new Map();Map = map;
        Player = player;
        Scanner input = new Scanner(System.in);

        while(true){
            currLoc = map.roomDescription(player.Row, player.Col); // print the player location and the surroundings and keep track of the player location
            if(currLoc == "Exit"){
                break;
            }
            if(map.checkCombat(player.Row, player.Col)){
                System.out.println("oh uh you encounter a WWE wrestler!");
                new Combat(map.getWrestlers(player.Row, player.Col),player).run();
                if(player.getCurrHp() <= 0){
                    System.out.println("You died game over!");
                    System.exit(0);
                } else{
                    System.out.println("You Won the Combat!");
                }

            } else if(map.checkProtein(player.Row, player.Col)) {
                System.out.println("You found a "+map.getProteinShake(player.Row, player.Col));
                System.out.println("This shake is going to boost your Health\n" +
                                   "press 1 to drink it\n" +
                                   "press any number to smash it");
                int protein = input.nextInt();
                if(protein == 1){
                    player.setCurrHp(player.getCurrHp()+map.getProteinShakePower(player.Row, player.Col));
                    System.out.println("+Your health is up by "+map.getProteinShakePower(player.Row, player.Col) +"%+");
                    player.printHealthBar();
                    }
            }
            while(!move(currLoc)){ // keep prompting the user to enter the right direction
                move(currLoc);
            }

        }

        System.out.println("****************************\n" +
                           "*        Game over!        *\n" +
                           "*you have found the way out*\n" +
                           "*  of this castle to meet  *\n" +
                           "*       your princess      *\n" +
                           "*     Congratulations !!!  *\n" +
                           "****************************");

    }

    public boolean move(String loc){ // method to move the player
        boolean pass = false; // boolean variable to check if the move is valid or not
        Scanner input = new Scanner(System.in); // scanner to get input from user
        System.out.println("(direction N: North, S: South, W: West, E: East) Or (Help) to show your location ");
        String move = input.next();
        move = move.toUpperCase(); // store the user input and change it to uppercase
        // keep prompting the user to enter a valid direction
        while(!move.equalsIgnoreCase("N") && !move.equalsIgnoreCase("S") &&
                !move.equalsIgnoreCase("W") && !move.equalsIgnoreCase("E") &&
                !move.equalsIgnoreCase("Help")){
            System.out.println("Please enter a valid direction (N: North, S: South, W: West, E: East)" +
                    " Or (Help) to show your location ");
            move = input.next();
            move = move.toUpperCase();
        }
        // creat a temp indices to make sure the movement is not out of bound
        int r = Player.Row;
        int c = Player.Col;
        // check to see if the player wants to go North, South, East, or West and also check if the move is valid
        switch (move){
            case "N":
                r--;
                if(Map.checkIndex(r,c)){
                    Player.Row--;
                    pass = true;
                }
                else {
                    return pass;
                }
                break;
            case "S":
                r++;
                if(Map.checkIndex(r,c)){
                    Player.Row++;
                    pass = true;
                }
                else {
                    return pass;
                }
                break;
            case "W":
                c--;
                if(Map.checkIndex(r,c)){
                    Player.Col--;
                    pass = true;
                }
                else{
                    return pass;
                }
                break;
            case "E":
                c++;
                if(Map.checkIndex(r,c)){
                    Player.Col++;
                    pass = true;
                }
                else{
                    return pass;
                }
                break;
            case "HELP":
                Map.printMap(loc);
                pass = true;
                break;
        }
        return pass;
    }
}
