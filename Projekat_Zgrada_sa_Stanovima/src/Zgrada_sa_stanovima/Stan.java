
package Zgrada_sa_stanovima;

import java.util.ArrayList;

public class Stan {
    int broj_stana;
    ArrayList<Stanar> stanari;
    boolean izmireniDugovi;

    public Stan(int broj_stana, ArrayList<Stanar> stanari) {
        this.broj_stana = broj_stana;
        this.stanari = stanari;
        izmireniDugovi=false;
    }
    public Stan(int broj_stana){
        this.broj_stana=broj_stana;
        stanari=new ArrayList<Stanar>();
        izmireniDugovi=false;
    }
    @Override
    public String toString() {
        String izlaz="";
        for(Stanar s:stanari){
            izlaz+=s.toString()+"\n";
        }
        return "U stanu sa brojem: " + broj_stana + "zive stanari: " + izlaz;
    }
    public int brojStanaraUStanu(){
        return stanari.size();
    }
    public int getBroj_stana() {
        return broj_stana;
    }
    public boolean isIzmireniDugovi() {
        return izmireniDugovi;
    }
    public ArrayList<Stanar> getStanari() {
        return stanari;
    }
    public void setBroj_stana(int broj_stana) {
        this.broj_stana = broj_stana;
    }
    public void setStanari(ArrayList<Stanar> stanari) {
        this.stanari = stanari;
    }
    public void setIzmireniDugovi(boolean izmireniDugovi) {
        this.izmireniDugovi = izmireniDugovi;
    }
}
