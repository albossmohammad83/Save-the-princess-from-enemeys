public class Wrestler {
    private int MaxHp;
    private int CurrHp;
    private int MinDmg;
    private int MaxDmg;
    private String Name;


    public Wrestler(int maxHp, int minDmg, int maxDmg, String name) {
        MaxHp = maxHp;
        CurrHp = this.MaxHp;
        MinDmg = minDmg;
        MaxDmg = maxDmg;
        Name = name;
    }

    public int getMaxHp() {
        return MaxHp;
    }

    public int getCurrHp() {
        return CurrHp;
    }

    public int getMinDmg() {
        return MinDmg;
    }

    public int getMaxDmg() {
        return MaxDmg;
    }

    public String getName() {
        return Name;
    }

    public void setCurrHp(int currHp) {
        CurrHp = currHp;
    }
    public int attack(){
      return (int) ((Math.random() * (MaxDmg - MinDmg)) + MinDmg);
    }
    public void printHealthBar() {
        System.out.print(this.Name.toUpperCase());
        System.out.println("'s Health percentage: " + this.CurrHp + "%");
    }
}
