
package Zgrada_sa_stanovima;

import java.util.ArrayList;

public class Zgrada implements Selidba {
    String adresa;
    ArrayList<Stan> stanovi;
    
    public Zgrada(){
        adresa="";
        stanovi=new ArrayList<Stan>(10);
        
    }
    public Zgrada(int brStanova){
        adresa="";
        stanovi=new ArrayList<Stan>();
        for(int i=0;i<brStanova;i++)
            stanovi.add(new Stan(i));
        
    }
    public Zgrada(String adresa, ArrayList<Stan> stanovi) {
        this.adresa = adresa;
        this.stanovi = stanovi;
    }
    public int brojStanova(){
        return stanovi.size();
    }
    public int brojStanara(){
        int brstanara=0;
        for(Stan s:stanovi){
            brstanara+=s.brojStanaraUStanu();
        }
        return brstanara;
    }
    @Override
    public String toString() {
        int ukupno=0;
        for(Stan s:stanovi){
            if(s.stanari!=null){
                ukupno+=s.stanari.size();
            }
        }
        String izlaz="Zgrada na adresi: " + adresa +", ima ukupno " + ukupno + " stanara u " + brojStanova() + " stanova." + "\n";
        for(Stan s:stanovi){
            izlaz+="Stan broj: "+(s.broj_stana+1);
            if(!s.stanari.isEmpty()){
                for(Stanar st:s.stanari){
                   izlaz+="\n\t"+st.toString();
                }
                
                if(s.izmireniDugovi)
                    izlaz+="\n\t\tDugovanja za ovaj mesec:  Izmirena.\n";
                else
                    izlaz+="\n\t\tDugovanja za ovaj mesec:  Nisu Izmirena!\n";
            }
            else{
                izlaz+="\tOvaj stan je prazan!\n";
            }
        }
        return izlaz;
    }
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
    public void setStanovi(ArrayList<Stan> stanovi) {
        this.stanovi = stanovi;
    }
    public String getAdresa() {
        return adresa;
    }
    public ArrayList<Stan> getStanovi() {
        return stanovi;
    }
    @Override
    public void useljenje(int br_stana, ArrayList<Stanar> novistanari) {
        stanovi.get(br_stana-1).stanari=novistanari;
    }
    @Override
    public void doseljenje(int br_stana, ArrayList<Stanar> novistanari) {
        stanovi.get(br_stana-1).stanari.addAll(novistanari);
    }
    @Override
    public void iseljenje(int br_stana) {
        stanovi.get(br_stana-1).stanari=new ArrayList<Stanar>();
    }

    
}
