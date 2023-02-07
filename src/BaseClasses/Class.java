package BaseClasses;

import java.util.logging.Level;

abstract class Class{
    //private fields
    private int hitDie;
    private int level;
    //public fields
    //Constructor
    public Class(int hd){hitDie = hd;}
    //methods
    public abstract void level();
    public void setHidDie(int h){hitdie = h;}
    public int getHitDie(){return hitDie;}
    public void setLevel(int l){level = l;}
    public int getLevel(){return level;}

}
class Artificer extends Class{
        //private fields
        //public fields
        public Artificer(){super(8);}
        public level(){}
        }

class Barbarian extends Class{
        //private fields
        //public fields
        public Barbarian(){super(12);}
        public level(){}
        }
class Bard extends Class{
        //private fields
        int inspirationDie;
        //public fields
        public Bard(){
                super(8);
                inspirationDie = 6;
        }
        public level(){}
}
class BloodHunter extends Class{
//private fields
//public fields
        public BloodHunter(){super(10);}
        public level(){}
}
class Cleric extends Class{
        //private fields
        //public fields
        public Cleric(){super(8);}
        public level(){}
        }
class Druid extends Class{
//private fields
//public fields
        public Druid(){super(8);}
        public level(){}
}
class Fighter extends Class{
//private fields
//public fields
        public Fighter(){super(10);}
        public level(){}
}
class Monk extends Class{
//private fields
//public fields
        public Monk(){super(8);}
        public level(){}
}
class Paladin extends Class{
        //private fields
        //public fields
        public Paladin(){super(10);}
        public level(){}
        }
class Ranger extends Class{
        //private fields
        //public fields
        public Ranger(){super(10);}
        public level(){}
        }
class Rogue extends Class{
//private fields
//public fields
        public Rogue(){super(8);}
        public level(){}
}
class Sorcerer extends Class{
        //private fields
        //public fields
        public Sorcerer(){super(6);}
        public level(){}
        }
class Warlock extends Class{
//private fields
//public fields
        public Warlock(){super(8);}
        public level(){}
}
class Wizard extends Class{
        //private fields
        //public fields
        public Wizard(){super(6);}
        public level(){}
        }
