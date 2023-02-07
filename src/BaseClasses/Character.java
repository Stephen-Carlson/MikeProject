package BaseClasses;

public class Character{
    //Private Fields
    private String name;
    private PlayerClass[] PlayerClasses;
    private int ChaScore;
    private int DexScore;
    private int IntScore;
    private int StrScore;
    private int ConScore;
    private int WisScore;
    private int AC;
    private int SpellSaveDC;
    private int MaxHP;
    private int CurrentHP;
    private int TempHP;
    private int profBonus;
    private int TotalLevel;
    //Public
    public Character(int str, int dex, int con, int intel,int wis, int cha, int hp, int ac){
        StrScore = str;
        DexScore = dex;
        ConScore = con;
        IntScore = intel;
        WisScore = wis;
        ChaScore = cha;
        MaxHP = hp;
        AC = ac;
        PlayerClasses = new PlayerClass[] {};
        TotalLevel = 0;
    }
    //Getters & Setters
    public String getName(){return name;}
    public PlayerClass getPlayerClass(){return Class;}
    public int[] getScores(){return new int[] {StrScore, DexScore, ConScore, IntScore, WisScore, ChaScore};}
    public void setMaxHP(int h){MaxHP = h;}
    public int getMaxHP(){return MaxHP;}
    public void setCurrentHP(int h){CurrentHP = h;}
    public int getCurrentHP(){return CurrentHP;}
    public void setTempHP(int h){TempHP = h;}
    public int getTempHP(){return TempHP;}
    public void setAC(int a){AC = a;}
    public int getAC(){return AC;}
    public void SetProfBonus(){

        for(PlayerClass c:PlayerClasses){
            TotalLevel += c.getLevel();
        }
        switch(TotalLevel){
            case TotalLevel >=4:{
                profBonus = 2;
            }
            break;
            case TotalLevel > 4 && TotalLevel <= 8:{
                profBonus = 3;
            }
            break;
            case TotalLevel > 8 && TotalLevel <= 12:{
                profBonus = 4;
            }
            break;
            case TotalLevel > 12 && TotalLevel <= 16:{
                profBonus = 6;
            }
            break;
            case TotalLevel > 16:{
                profBonus = 5;
            }
            break;
        }
    }
    public int getProfBonus(){return profBonus;}
    public int getSpellSaveDC(){return SpellSaveDC;}
    //Other Methods
    public String toString(){
        return this.getName()+','+this.getClass().toString()+','+this.ChaScore+','+this.DexScore+','+this.IntScore+','+this.StrScore+','+this.ConScore+','+this.WisScore+','+this.getAC()+' '+this.getMaxHP()+' '+this.getCurrentHP()+' '+this.getTempHP()+' '+this.getProfBonus();
    }
}
