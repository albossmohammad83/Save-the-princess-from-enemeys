public class Map {
    private Room[][] map = new Room[4][4];
    private String[][] stringMap = {  {"  Wall  "," Hall.2 "," Room.1 ","lonHall1"},
                                      {"Entrance"," Room.7 "," Room.8 ","lonHall2"},
                                      {" Room.9 "," Hall.1 ","Room.Exit","lonHall3"},
                                      {"  Wall  "," Room.4 "," Hall.3 ","  Wall  "} };

    public Map(){
        for(int row = 0; row < stringMap.length; row++){
            for(int col = 0; col < stringMap[row].length; col++){
               if(stringMap[row][col].contains("Room")) {
                   map[row][col] = new Room(true, false);
               } else if(stringMap[row][col].contains("Hall")){
                   map[row][col] = new Room(false, true);
               } else{
                   map[row][col] = new Room(false, false);
               }
            }
        }
    }

    public Wrestler getWrestlers(int row, int col){
        return map[row][col].getWrestlers();
    }

    public String getProteinShake(int row, int col){
        return map[row][col].getProteinShake();
    }

    public int getProteinShakePower (int row, int col){
        return map[row][col].getProteinShakePower();
    }

    public boolean checkCombat(int row, int col){
        return map[row][col].hasCombat();
    }

    public boolean checkProtein(int row, int col){
        return map[row][col].hasProteinShake();
    }

    public boolean checkIndex(int row, int col){ // method to make sure the player's next move is valid
        boolean pass = false; // boolean variable to check if the move is valid or not
        if(col < 0 || col > 3){
            System.out.println("cant move to that direction there's a wall blocking you!");
            return pass;
        }
        else if (row < 0 || row > 3){
            System.out.println("cant move to that direction there's a wall blocking you!");
            return pass;
        }
        else if (row == 0 && col == 0){
            System.out.println("cant move to that direction there's a wall blocking you!");
            return pass;
        }
        else if(row == 3 && col == 0){
            System.out.println("cant move to that direction there's a wall blocking you!");
            return pass;
        }
        else if(row == 3 && col == 3){
            System.out.println("cant move to that direction there's a wall blocking you!");
            return pass;
        }
        else{
            pass = true;
        }
        return pass;

    }

    public  String roomDescription(int row, int col){ // method that prints out the details and surroundings in each room/hallway

        switch (stringMap[row][col].trim()) {
            case "Wall":
                System.out.println("cant move to that direction there's a wall blocking you!");
                return "Wall";
            case "Hall.2":
                System.out.println("You find yourself in a hallway with a nice old piano at the end of it, To your south is" +
                        " another room with number 7 on it's door, and to your east is a another room with number" +
                        " 1 on it's door .Which way would you like to go?");
                return "Hall.2";
            case "Room.1":
                System.out.println("You find yourself in a kids play room full of toys and dolls, To your west is" +
                        " the hallway with the nice old piano at the end of it , and to your east is a very long hallway. " +
                        "Which way would you like to go?");
                return "Room.1";
            case "lonHall1":
                System.out.println("You find yourself in the beginning of a long hallway full of very expensive paintings" +
                        ", To your south is continuing the long hallway, and to your east is a another room with number 1 " +
                        "on it's door. Which way would you like to go?");
                return "lonHall1";
            case "Entrance":
                System.out.println("You are at The entrance to the Castle is big and glory. To your south is " +
                        "a room with number 9 on it's door, and to your east is a hallway full of nice and fancy" +
                        " furniture. Which way would you like to go?");
                return "Entrance";
            case "Room.7":
                System.out.println("You find yourself in an office with a big brown book shelf and a l shaped desk," +
                        " To your south is hallway, and to your east is a another room with number 8, and to your north is " +
                        "a hallway. Which way would you like to go?");
                return "Room.7";
            case "Room.8":
                System.out.println("You find yourself in a master bed room with luxurious bed and furniture," +
                        " To your west is hallway. Which way would you like to go?");
                return "Room.8";
            case "lonHall2":
                System.out.println("You find yourself in a the long hallway with different paintings, To your south is" +
                        " continuing the long hallway, and to your east is a another room with number 8 on it's door." +
                        " Which way would you like to go?");
                return "lonHall2";
            case "Room.9":
                System.out.println("You find yourself in the guards' room it's full of swords and arrows and other stuff" +
                        ", To your north is The entrance to the Castle and to your east is a hallway. Which way would " +
                        "you like to go?");
                return "Room.9";
            case "Hall.1":
                System.out.println("You find yourself in a hallway with a nice long red carpet, To your south is" +
                        " another room with number 4, and to your east is a another room with number 6, and " +
                        " To your west is another room with number 9. Which way would you like to go?");
                return "Hall.1";
            case "Exit":
                System.out.println("You have reached the Exit congratulations!!");
                return "Exit";
            case "lonHall3":
                System.out.println("You find yourself in the long hallway with different paintings on the walls, To your " +
                        "west is another room with number 6. Which way would you like to go?");
                return "lonHall3";
            case "Room.4":
                System.out.println("You find yourself in a bathroom with a huge bath tub, To your north is" +
                        " hallway with the red carpet, and to your east is hallway. Which way would you like to go?");
                return "Room.4";
            case "Hall.3":
                System.out.println("You find yourself in a hallway with three monkeys playing around, To your north is" +
                        " another room with number 6, and to your west is a another room with number 4." +
                        " Which way would you like to go?");
                return "Hall.3";

        }
        return null;
    }

    public  void printMap(String loc){ // method to print the map and the player current location in the map
        for (int i = 0; i < stringMap.length; i++){
            for (int j = 0; j < stringMap[i].length; j++){
                System.out.print("|"+stringMap[i][j]+"|");
            }
            System.out.println("\n+--------++--------++--------++--------+");
        }
        System.out.println("Your current location is: " + loc);
    }

}
