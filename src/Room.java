public class Room{
    private boolean hasCombat;
    private boolean hasProteinShake;
    private Wrestler wrestlers;
    String proteinShakeName;
    int proteinShakePower;

    public Room(boolean hasCombat, boolean hasProteinShake){
        this.hasCombat = hasCombat;
        this.hasProteinShake = hasProteinShake;
        if(this.hasCombat){
            String[] wrestlersNames = {"Randy Orton", "Triple H", "The Undertaker", "John Cena", "Hulk Hogan"};
            int numWrestlers = (int) ((Math.random() * (4 - 0)) + 0);
            switch (numWrestlers){
                case 0:
                    wrestlers = new Wrestler(80, 5, 15, wrestlersNames[0]);
                    break;
                case 1:
                    wrestlers = new Wrestler(75, 5, 15, wrestlersNames[1]);
                    break;
                case 2:
                    wrestlers = new Wrestler(60, 5, 15, wrestlersNames[2]);
                    break;
                case 3:
                    wrestlers = new Wrestler(90, 5, 15, wrestlersNames[3]);
                    break;
                case 4:
                    wrestlers = new Wrestler(85, 5, 15, wrestlersNames[4]);
                    break;

            }
        }
        if(this.hasProteinShake){
            String[] ProteinShakeNames = {"Gold standard protein", "Premier Protein Shake", "Organic Plant-Based Protein", "muscle milk protein shake"};
            int numProteinShake = (int) ((Math.random() * (3 - 0)) + 0);
            int numProteinShakePower = (int) ((Math.random() * (20 - 0)) + 10);
            proteinShakeName = ProteinShakeNames[numProteinShake];
            proteinShakePower = numProteinShakePower;
            }
    }

    public Wrestler getWrestlers() {
        return wrestlers;
    }
    public String getProteinShake(){
        return proteinShakeName;
    }

    public int getProteinShakePower(){
        return proteinShakePower;
    }

    public boolean hasProteinShake(){
        return hasProteinShake;
    }

    public boolean hasCombat() {
        return hasCombat;
    }

}
