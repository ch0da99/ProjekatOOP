
package Statistike;

import Zgrada_sa_stanovima.*;
import java.util.ArrayList;

public class Statistika_Pol extends Statistika {
    
    public Statistika_Pol(){
        broj_uzoraka=0;
        stanovi=new ArrayList<Stan>();
    }
    
    public Statistika_Pol(int broj_uzoraka, ArrayList<Stan> stanovi){
        this.broj_uzoraka=broj_uzoraka;
        this.stanovi=stanovi;
    }
    
    @Override
    public int statistika_broj() {
        int suma=0;
        for(Stan s:stanovi){
            for(Stanar st:s.getStanari()){
                if(st.getPol().equals("Muski"))
                suma++;
            }
        }
        return suma;
    }

    @Override
    public double statistika_procenat() {
        int suma=0, ukupno=0;
        for(Stan s:stanovi){
            for(Stanar st:s.getStanari()){
                if(st.getPol().equals("Muski"))
                suma++;
            }
            ukupno+=s.brojStanaraUStanu();
        }
        return 100*(double)suma/ukupno;
    }
    
}
