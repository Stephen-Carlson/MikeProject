package BaseClasses;
abstract class Class{
    //private fields
    private int hitDie;
    private int level;
    //public fields
    public Class(int hd){hitDie = hd;}
    public abstract void level();
    public void setHidDie(int h){hitdie = h;}
    public int getHitDie(){return hitDie;}
    public void setLevel(int l){level = l;}
    public int getLevel(){return level;}

}
class Artificer extends Class{
        //private fields
        //public fields
                public Artificer(){super();}
        }

class Barbarian extends Class{
        //private fields
        //public fields
                public Barbarian(){super(12);}
        }
class Bard extends Class{
//private fields
//public fields
        public Bard(){super(8);}
}
class BloodHunter extends Class{
//private fields
//public fields
        public BloodHunter(){super();}
}
class Cleric extends Class{
        //private fields
        //public fields
                public Cleric(){super(8);}
        }
class Druid extends Class{
//private fields
//public fields
        public Druid(){super(8);}
}
class Fighter extends Class{
//private fields
//public fields
        public Fighter(){super(10);}
}
class Monk extends Class{
//private fields
//public fields
        public Monk(){super(8);}
}
class Paladin extends Class{
        //private fields
        //public fields
                public Paladin(){super(10);}
        }
class Ranger extends Class{
        //private fields
        //public fields
                public Ranger(){super(10);}
        }
class Rogue extends Class{
//private fields
//public fields
        public Rogue(){super(8);}
}
class Sorcerer extends Class{
        //private fields
        //public fields
                public Sorcerer(){super(6);}
        }
class Warlock extends Class{
//private fields
//public fields
        public Warlock(){super(8);}
}
class Wizard extends Class{
        //private fields
        //public fields
                public Wizard(){super(6);}
        }
