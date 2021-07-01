
package Zgrada_sa_stanovima;

public class Stanar {
    String ime_prezime;
    int godine;
    String pol;
    boolean zaposlen;

    public Stanar(String ime_prezime, int godine, String pol, boolean zaposlen) {
        this.ime_prezime = ime_prezime;
        this.godine = godine;
        this.pol = pol;
        this.zaposlen = zaposlen;
    }
    public Stanar(){
        ime_prezime="";
        godine=0;
        pol="";
        zaposlen=false;
    }
    @Override
    public String toString() {
        if(zaposlen)
            return "Stanar: " +  ime_prezime + ", godine=" + godine + ", pol=" + pol + ", zaposlen= da";
        else
            return "Stanar: " +  ime_prezime + ", godine=" + godine + ", pol=" + pol + ", zaposlen= ne";
    }
    public String getIme_prezime() {
        return ime_prezime;
    }
    public int getGodine() {
        return godine;
    }
    public String getPol() {
        return pol;
    }
    public boolean isZaposlen() {
        return zaposlen;
    }
    public void setIme_prezime(String ime_prezime) {
        this.ime_prezime = ime_prezime;
    }
    public void setGodine(int godine) {
        this.godine = godine;
    }
    public void setPol(String pol) {
        this.pol = pol;
    }
    public void setZaposlen(boolean zaposlen) {
        this.zaposlen = zaposlen;
    }
}
