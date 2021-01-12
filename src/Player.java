public class Player {
    private int MaxHp;
    private int CurrHp;
    private int MinDmg;
    private int MaxDmg;
    private String Name;
    public int Row;
    public int Col;

    public Player(int maxHp, int minDmg, int maxDmg, String name) {
        MaxHp = maxHp;
        CurrHp = this.MaxHp;
        MinDmg = minDmg;
        MaxDmg = maxDmg;
        Name = name;
        Row = 1;
        Col = 0;
    }

    public void move(String direction){
        switch (direction.toUpperCase()){
            case "NORTH":
                Row--;
                break;
            case "SOUTH":
                Row++;
                break;
            case "EAST":
                Col++;
                break;
            case "WEST":
                Col--;
                break;
            default:
                System.out.println("Error");
                break;

        }
    }

    public int getMaxHp() {
        return MaxHp;
    }

    public void setMaxHp(int maxHp) {
        MaxHp = maxHp;
    }

    public int getCurrHp() {
        return CurrHp;
    }

    public void setCurrHp(int currHp) {
        CurrHp = currHp;
    }

    public int getMinDmg() {
        return MinDmg;
    }

    public void setMinDmg(int minDmg) {
        MinDmg = minDmg;
    }

    public int getMaxDmg() {
        return MaxDmg;
    }

    public void setMaxDmg(int maxDmg) {
        MaxDmg = maxDmg;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int attack(){
        return (int) ((Math.random() * (MaxDmg - MinDmg)) + MinDmg);
    }

    public void printHealthBar() {
        System.out.print(this.Name.toUpperCase());
        System.out.println("'s Health percentage: " + this.CurrHp + "%");
    }
}

