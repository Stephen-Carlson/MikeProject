package BaseClasses;
import java.util.Hashtable;

public class Party{
    //private fields
    private String Name;
    private Hashtable<String, Character> Players;
    //public methods
    public Party(){
        Name = "";
        Players = new Hashtable<String, Character>();
    }
    public Party(Character[] p){
        for(int i = 0; i<p.length; ++i){
            Players.put(p[i].getName(), p[i]);
        }
    }
    //Getters & Setters
    public String getName(){ return Name; }
    public Hashtable<String, Character> getPlayers() {return Players;}
    public void setName(String n){ Name = n;}
    public void addPlayer(Character c){Players.put(c.getName(),c);}
    public void deletePlayer(Character c){Players.remove(c.getName());}

}