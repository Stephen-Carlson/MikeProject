package BaseClasses;

abstract class PlayerPlayerClass{
    //private fields
    private int hitDie;
    private int level;
    //public fields
    //Constructor
    public PlayerClass(int hd){hitDie = hd;}
    //methods - Getters & Setters
    public abstract void level();
    public void setHidDie(int h){hitdie = h;}
    public int getHitDie(){return hitDie;}
    public void setLevel(int l){level = l;}
    public int getLevel(){return level;}
    // other Methods

}
class Artificer extends PlayerClass{
        //private fields
        //public fields
        public Artificer(){super(8);}
        public level(){}
        }

class Barbarian extends PlayerClass{
        //private fields
        //public fields
        public Barbarian(){super(12);}
        public level(){}
        }
class Bard extends PlayerClass{
        //private fields
        int inspirationDie;
        //public fields
        public Bard(){
                super(8);
                inspirationDie = 6;
        }
        public level(){}
}
class BloodHunter extends PlayerClass{
//private fields
//public fields
        public BloodHunter(){super(10);}
        public level(){}
}
class Cleric extends PlayerClass{
        //private fields
        //public fields
        public Cleric(){super(8);}
        public level(){}
        }
class Druid extends PlayerClass{
//private fields
//public fields
        public Druid(){super(8);}
        public level(){}
}
class Fighter extends PlayerClass{
//private fields
//public fields
        public Fighter(){super(10);}
        public level(){}
}
class Monk extends PlayerClass{
//private fields
//public fields
        public Monk(){super(8);}
        public level(){}
}
class Paladin extends PlayerClass{
        //private fields
        //public fields
        public Paladin(){super(10);}
        public level(){}
        }
class Ranger extends PlayerClass{
        //private fields
        //public fields
        public Ranger(){super(10);}
        public level(){}
        }
class Rogue extends PlayerClass{
//private fields
//public fields
        public Rogue(){super(8);}
        public level(){}
}
class Sorcerer extends PlayerClass{
        //private fields
        //public fields
        public Sorcerer(){super(6);}
        public level(){}
        }
class Warlock extends PlayerClass{
//private fields
//public fields
        public Warlock(){super(8);}
        public level(){}
}
class Wizard extends PlayerClass{
        //private fields
        //public fields
        public Wizard(){super(6);}
        public level(){}
        }
