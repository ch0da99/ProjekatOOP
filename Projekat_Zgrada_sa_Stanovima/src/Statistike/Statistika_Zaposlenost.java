/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Statistike;

import Zgrada_sa_stanovima.*;
import java.util.ArrayList;

/**
 *
 * @author Ch0da
 */
public class Statistika_Zaposlenost extends Statistika {
    
    
    public Statistika_Zaposlenost(){
        broj_uzoraka=0;
        stanovi=new ArrayList<Stan>();
    }
    
    public Statistika_Zaposlenost(int broj_uzoraka, ArrayList<Stan> stanovi){
        this.broj_uzoraka=broj_uzoraka;
        this.stanovi=stanovi;
    }
    
    @Override
    public int statistika_broj() {
        int suma=0;
        for(Stan s:stanovi){
            for(Stanar st:s.getStanari())
                if(st.isZaposlen())
                suma++;
        }
        return suma;
    }

    @Override
    public double statistika_procenat() {
        int suma=0, ukupno=0;
        for(Stan s:stanovi){
            for(Stanar st:s.getStanari())
                if(st.isZaposlen())
                    suma++;
            ukupno+=s.brojStanaraUStanu();
        }
        return 100*(double)suma/ukupno;
    }
}
