package dotcomobservers;

import extdotcomgame.DotCom;

import java.util.ArrayList;

public class DamageRate implements Observer{
    private DotCom subject;

    public DamageRate (DotCom s){
        subject = s;
    }

    public void update() {
        //damage rate = (100 x (DotCom.size() - # of surviving cells)/DotCom.size())
        ArrayList<String> state = subject.getState();
        int survivingcells = 0;
        for (String cell : state) {
            if (cell != null)
                survivingcells++;
        }
        System.out.print("Damage rate of " + subject.getName() + ": ");
        float damagerate = (100*(subject.getSize() - survivingcells)/ subject.getSize());
        System.out.printf("%.2f", damagerate);
        System.out.println("%");
    }
}
