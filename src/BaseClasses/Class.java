package BaseClasses;

abstract class PlayerClass{
    //private fields
    private int hitDie;
    private int level;
    //public fields
    //Constructor
    public PlayerClass(int hd){hitDie = hd;}
    //methods - Getters & Setters
    public abstract void level();
    public void setHidDie(int h){hitDie = h;}
    public int getHitDie(){return hitDie;}
    public void setLevel(int l){level = l;}
    public int getLevel(){return level;}
    // other Methods

}
class Artificer extends PlayerClass{
        //private fields
        //public fields
        public Artificer(){super(8);}
        public void level(){}
        }

class Barbarian extends PlayerClass{
        //private fields
        //public fields
        public Barbarian(){super(12);}
        public void level(){}
        }
class Bard extends PlayerClass{
        //private fields
        int inspirationDie;
        //public fields
        public Bard(){
                super(8);
                inspirationDie = 6;
        }
        public void level(){}
}
class BloodHunter extends PlayerClass{
//private fields
//public fields
        public BloodHunter(){super(10);}
        public void level(){}
}
class Cleric extends PlayerClass{
        //private fields
        //public fields
        public Cleric(){super(8);}
        public void level(){}
        }
class Druid extends PlayerClass{
//private fields
//public fields
        public Druid(){super(8);}
        public void level(){}
}
class Fighter extends PlayerClass{
//private fields
//public fields
        public Fighter(){super(10);}
        public void level(){}
}
class Monk extends PlayerClass{
//private fields
//public fields
        public Monk(){super(8);}
        public void level(){}
}
class Paladin extends PlayerClass{
        //private fields
        //public fields
        public Paladin(){super(10);}
        public void level(){}
        }
class Ranger extends PlayerClass{
        //private fields
        //public fields
        public Ranger(){super(10);}
        public void level(){}
        }
class Rogue extends PlayerClass{
//private fields
//public fields
        public Rogue(){super(8);}
        public void level(){}
}
class Sorcerer extends PlayerClass{
        //private fields
        //public fields
        public Sorcerer(){super(6);}
        public void level(){}
        }
class Warlock extends PlayerClass{
//private fields
//public fields
        public Warlock(){super(8);}
        public void level(){}
}
class Wizard extends PlayerClass{
        //private fields
        //public fields
        public Wizard(){super(6);}
        public void level(){}
        }
