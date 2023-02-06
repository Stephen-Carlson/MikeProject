package BaseClasses;

public class Character{
    //Private Fields
    private String name;
    private Class Class;
    private int ChaScore;
    private int DexScore;
    private int IntScore;
    private int StrScore;
    private int ConScore;
    private int WisScore;
    private int AC;
    private int MaxHP;
    private int CurrentHP;
    private int TempHP;
    //Public
    public Character(){
        ChaScore = 8;
        DexScore = 8;
        IntScore = 8;
        StrScore = 8;
        ConScore = 8;
        WisScore = 8;
        AC = 10;
        MaxHP = 20;
        CurrentHP = MaxHP;
        TempHP = 0;
        Class = "Fighter";
        name = "Pendelton"
    }
    public Character(int str, int dex, int con, int intel,int wis, int cha, int hp, int ac){
        StrScore = str;
        DexScore = dex;
        ConScore = con;
        IntScore = intel;
        WisScore = wis;
        ChaScore = cha;
        MaxHP = hp;
        AC = ac;
    }
    //Getters & Setters
    public String getName(){
        return name;
    }
    public String getClass(){
        return Class;
    }
    public int[] getScores(){
        return [StrScore, DexScore, ConScore, IntScore, WisScore, ChaScore]
    }
    public int getMaxHP(){
        return MaxHP;
    }
    public int getCurrentHP(){
        return CurrentHP;
    }
    public int getTempHP(){
        return TempHP;
    }
    public String[] export(){
        String[] output = new String[];
        output[0] = this.getName();
        output[1] = this.getClass()
    }
}
