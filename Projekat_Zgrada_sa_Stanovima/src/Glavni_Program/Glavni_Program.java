
package Glavni_Program;

import Statistike.*;
import Zgrada_sa_stanovima.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Glavni_Program {
    public static void main(String[] args){
        Stan[] stanovi=new Stan[10];
        Zgrada zgrada=new Zgrada(10);
        Scanner s=new Scanner(System.in);
        ArrayList<Stanar> novistanari=new ArrayList<Stanar>();
        int opcija=-1, podopcija=-1, brstana=-1, brstanara=-1;
        
        try{
            FileReader fr=new FileReader("Zgrada.json");
            JsonReader jr=new JsonReader(fr);
            Gson gson=new Gson();
            zgrada=gson.fromJson(jr, new TypeToken<Zgrada>(){}.getType());
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        System.out.println("Welcome!\n ");
        do{
            try{
                System.out.println("Unesite broj operacije koju zelite da izvrsite:\n1 - Prikaz svih stanova sa stanarima u njima\n2 - Useljenje novih stanara\n3 - Iseljenje stanara\n4 - Dugovanja stanara\n5 - Statistike\n\n0 - Izlaz iz programa");
                opcija=s.nextInt();
                switch((char)opcija){
                    case 1: 
                        System.out.println("\n\nIzabrali ste opciju prikaza svih stanova sa stanarima u njima:\n"+zgrada.toString()); break;
                    case 2: 
                        do{ 
                            try{
                                System.out.println("Izabrali ste opciju za useljavanje stanara. Izaberite jednu od podopcija:\n1 - Useljavanje u prazan stan\n2 - Doseljavanje u vec useljen stan\n0 - Povratak na glavni meni");
                                podopcija=s.nextInt();
                                if(podopcija<0 || podopcija>2){
                                    System.out.println("Pogresan unos! Ta opcija ne postoji!");
                                }
                                else if(podopcija==1){
                                    do{
                                        try{
                                            System.out.println("\nUseljavanje u prazan stan. Sada izaberite prazan stan u koji zelite da uselite nekoga (Upisite 0 ako zelite da se vratite korak unazad): ");
                                            brstana=s.nextInt();
                                            if(brstana<0 || brstana>10){
                                                System.out.println("Pogresan unos, broj stana moze biti 1-10, ili 0 ako zelite da se vratite korak unazad: ");
                                            }
                                            if(brstana==0)break;
                                            if(zgrada.getStanovi().get(brstana-1).brojStanaraUStanu()!=0) System.out.println("Ovaj stan nije prazan, izaberite neki drugi!");
                                            else{
                                                do{
                                                    try{
                                                        System.out.println("Useljavate stan broj "+brstana+", koliko ljudi zelite da uselite u njega: ");
                                                        novistanari.clear();
                                                        brstanara=s.nextInt();
                                                        s.nextLine();
                                                        if(brstanara<0){
                                                            System.out.println("Broj stanara mora biti pozitivan broj, dragi menadzeru...\nUnesite broj stanara:");
                                                        }
                                                        if(brstanara==0)break;
                                                        else{
                                                            System.out.println("U redu, useljujete "+brstanara+" stanara, unesite njihove podatke: ");
                                                            novistanari=provera(brstanara);
                                                            zgrada.doseljenje(brstana, novistanari);
                                                            System.out.println("Stanar/i uspesno useljen/i!\n");
                                                        }
                                                    }catch(InputMismatchException ex){
                                                        System.out.println("\nGreska pri unosu, uneli ste slovo tamo gde treba da budu samo brojevi!\n");
                                                        s.nextLine();
                                                    }
                                                }while(brstanara<0);
                                            }
                                        }catch(InputMismatchException ex){
                                            System.out.println("\nGreska pri unosu, uneli ste slovo tamo gde treba da budu samo brojevi!\n");
                                            s.nextLine();
                                        }
                                    }while(brstana<0 || brstana>10);
                                }
                                else if(podopcija==2){
                                    do{
                                        try{
                                            System.out.println("Izabrali ste opciju za doseljavanje stanara u vec useljen stan. Izaberite neki stan koji je vec useljen ( 0 - za vracanje korak unazad: ");
                                            brstana=s.nextInt();
                                            if(brstana==0)break;
                                            if(brstana<0||brstana>10) System.out.println("Pogresan unos, broj stana mora biti 1-10");
                                            if(zgrada.getStanovi().get(brstana-1).brojStanaraUStanu()==0) System.out.println("Ovaj stan nije naseljen, izaberite neki drugi!");
                                            else{
                                                do{
                                                    try{
                                                        System.out.println("Doseljavate u stan broj "+brstana+", koliko ljudi zelite da doselite u njega: ");
                                                        novistanari.clear();
                                                        brstanara=s.nextInt();
                                                        s.nextLine();
                                                        if(brstanara<0){
                                                            System.out.println("Broj stanara mora biti pozitivan broj, dragi menadzeru...\nUnesite broj stanara:");
                                                        }
                                                        else if(brstanara==0)break;
                                                        else{
                                                            System.out.println("U redu, useljujete "+brstanara+" stanara, unesite njihove podatke: ");
                                                            novistanari=provera(brstanara);
                                                            zgrada.doseljenje(brstana, novistanari);
                                                            System.out.println("Stanar/i uspesno useljen/i!\n");
                                                        }
                                                    }catch(InputMismatchException ex){
                                                        System.out.println("\nGreska pri unosu, uneli ste slovo tamo gde treba da budu samo brojevi!\n");
                                                        s.nextLine();
                                                    }
                                                }while(brstanara<0);
                                            }
                                        }catch(InputMismatchException ex){
                                            System.out.println("\nGreska pri unosu, uneli ste slovo tamo gde treba da budu samo brojevi!\n");
                                            s.nextLine();
                                        }
                                    }while(brstana<0||brstana>10);
                                }
                                else{
                                    System.out.println("Pogresna opcija!");
                                }
                            }catch(InputMismatchException ex){
                                System.out.println("\nGreska pri unosu, uneli ste slovo tamo gde treba da budu samo brojevi!\n");
                                s.nextLine();
                            }
                        }while(podopcija!=0);
                        break;
                    case 3:
                        do{
                            try{
                                System.out.println("\nIzabrali ste opciju za iseljenje stanara. Izaberite stan iz kog zelite da iselite sve stanare (0 - ako zelite da se vratite unazad): ");
                                brstana=s.nextInt();
                                if(brstana<0||brstana>10)System.out.println("Greska, brojevi stanova su izmedju 1 i 10!");
                                else if(brstana==0)break;
                                else if(zgrada.getStanovi().get(brstana-1).getStanari().isEmpty()) System.out.println("Stan koji ste izabrali je vec prazan!");
                                else{
                                    zgrada.getStanovi().get(brstana-1).getStanari().clear();
                                    System.out.println("Stan broj " + brstana + " je uspesno iseljen!\n");
                                }
                            }catch(InputMismatchException ex){
                                System.out.println("\nGreska pri unosu, uneli ste slovo tamo gde treba da budu samo brojevi!\n");
                                s.nextLine();
                            }
                        }while(brstana<0||brstana>10);
                        break;
                    case 4:
                        do{
                            try{
                                System.out.println("\nIzabrali ste opciju za pregled i izmenu dugovanja stanara. Izaberite radnju koju zelite da izvrsite:\n1 - Pregled dugovanja po stanovima\n2 - Izmirenje dugova za izabrani stan\n3 - Novi mesec (resetovanje liste)\n0 - Nazad");
                                podopcija=s.nextInt();
                                if(podopcija<0 || podopcija>3)System.out.println("Ta opcija ne postoji!");
                                else if(podopcija==1){
                                    System.out.println("Lista dugovanja po stanovima:\n");
                                    for(int i=0 ; i<zgrada.getStanovi().size(); i++){
                                        if(zgrada.getStanovi().get(i).brojStanaraUStanu()!=0){
                                            if(zgrada.getStanovi().get(i).isIzmireniDugovi())
                                                System.out.println("Stan broj " + (i+1) + ": Izmireni.");
                                            else
                                                System.out.println("Stan broj " + (i+1) + ": Nisu izmireni.");
                                        }
                                        else{
                                            System.out.println("Stan broj " + (i+1) + " je prazan.");
                                        }
                                    }
                                }
                                else if(podopcija==2){
                                    do{
                                        try{
                                            System.out.println("Izabrali ste opciju za izmirivanje dugova za odredjeni stan. Unesite broj stana za koji zelite postavite dugove izmirenim ( 0 za vracanje unazad): ");
                                            brstana=s.nextInt();
                                            if(brstana<0 || brstana>10) System.out.println("Pogresan unos, broj stana moze biti izmedju 0 i 10!");
                                            else if(brstana==0) break;
                                            else if(zgrada.getStanovi().get(brstana-1).isIzmireniDugovi()) System.out.println("Za ovaj stan su vec izmireni dugovi!");
                                            else if(zgrada.getStanovi().get(brstana-1).getStanari().isEmpty()) System.out.println("U ovom stanu niko ne zivi!");
                                            else{
                                                zgrada.getStanovi().get(brstana-1).setIzmireniDugovi(true);
                                                System.out.println("Dugovi za stan broj " + brstana + " su uspesno izmireni");
                                            }
                                        }catch(InputMismatchException ex){
                                            System.out.println("\nGreska pri unosu, uneli ste slovo tamo gde treba da budu samo brojevi!\n");
                                            s.nextLine();
                                        }
                                        
                                    }while(brstana<0 || brstana>10);
                                }
                                else if(podopcija==3){
                                    do{
                                        System.out.print("Da li ste sigurni da zelite da resetujete listu dugovanja? Odgovorite sa da/ne: ");
                                        s.nextLine();
                                        String pom=s.nextLine();
                                        if(pom.equals("da")){
                                            for(int i=0; i<zgrada.brojStanova(); i++){
                                                zgrada.getStanovi().get(i).setIzmireniDugovi(false);
                                            }
                                            break;
                                        }
                                        else if(pom.equals("ne"))break;
                                        else{
                                            System.out.println("Pogresan odgovor!");
                                        }
                                    }while(true);

                                }
                                else{
                                    System.out.println("Pogresna opcija!");
                                }
                            }
                            catch(InputMismatchException ex){
                                System.out.println("\nGreska pri unosu, uneli ste slovo tamo gde treba da budu samo brojevi!\n");
                                s.nextLine();
                            }
                            
                        }while(podopcija!=0);
                    case 5:
                        do{
                            try{
                                System.out.println("\nIzabrali ste opciju za prikaza statistike stanara, izaberite neku od sledecih opcija:\n1 - Statistika stanara po polu\n2 - Statistika stanara po zaposlenosti\n3 - Nazad");
                                podopcija=s.nextInt();
                                if(podopcija<0 || podopcija>2)System.out.println("Pogresan unos opcija!");
                                else if(podopcija==1){
                                    Statistika_Pol stat_pol=new Statistika_Pol(zgrada.brojStanara(),zgrada.getStanovi());
                                    System.out.println("U zgradi, od ukupno " + zgrada.brojStanara() + " stanara, " + stat_pol.statistika_broj() + " su muskarci, dok su " + (zgrada.brojStanara()-stat_pol.statistika_broj())+" zene.");
                                    System.out.println("Odnosno, ako to prikazemo procentualno:\n\tMuskarci: " + String.format("%.2f",stat_pol.statistika_procenat()) + "%\n\tZene: " + String.format("%.2f",(100-stat_pol.statistika_procenat())) + "%");
                                }
                                else if(podopcija==2){
                                    Statistika_Zaposlenost stat_zap=new Statistika_Zaposlenost(zgrada.brojStanara(),zgrada.getStanovi());
                                    System.out.println("U zgradi, od ukupno " + zgrada.brojStanara() + " stanara, " + stat_zap.statistika_broj() + " su zaposleni, a " +(zgrada.brojStanara()-stat_zap.statistika_broj()) + " nisu:");
                                    System.out.println("Odnosno, ako to prikazemo procentualno:\n\tZaposleni: " + String.format("%.2f",stat_zap.statistika_procenat()) + "%\n\tNezaposleni: " + String.format("%.2f",(100-stat_zap.statistika_procenat())) + "%");
                                }
                            }catch(InputMismatchException ex){
                                System.out.println("\nGreska pri unosu, uneli ste slovo tamo gde treba da budu samo brojevi!\n");
                                s.nextLine();
                            }
                        }while(podopcija!=0);
                    case 0: break;
                    default: throw new PogresnaOpcijaException(); 
                }
            }catch(PogresnaOpcijaException ex){
                ex.getMessage();
                System.out.println("Pogresna opcija!");
            }
            catch(InputMismatchException ex){
                System.out.println("\nGreska pri unosu, uneli ste slovo tamo gde treba da budu samo brojevi!\n");
                s.nextLine();
            }
        }while(opcija!=0);
        try{
            FileWriter fw=new FileWriter("Zgrada.json");
            Gson gson=new Gson();
            gson.toJson(zgrada,fw);
            fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("Goodbye!");
        
        
     }
    
    private static ArrayList<Stanar> provera(int brstanara){
       Scanner s=new Scanner(System.in);
       ArrayList<Stanar> novistanari=new ArrayList<Stanar>();
       String pol, posao;
       for(int i=0;i<brstanara;i++)
       {
       Stanar stanar=new Stanar();
           do{
               System.out.println("Ime i prezime: ");
               stanar.setIme_prezime(s.nextLine());
               if(stanar.getIme_prezime().split(" ").length!=2){
                   System.out.println("Greska, ime i prezime moraju biti u formatu Ime_Prezime (sa razmakom izmedju.\n");
               }
           }while(stanar.getIme_prezime().split(" ").length!=2);
           do{
               try{
               System.out.println("Godine: ");
               stanar.setGodine(s.nextInt());
               break;
               }catch(InputMismatchException ex){
                    System.out.println("\nGreska pri unosu, uneli ste slovo tamo gde treba da budu samo brojevi!\n");
                    s.nextLine();
               }
           }while(true);
           s.nextLine();
           do{
               System.out.println("Pol: \n\tm - muski\n\tz - zenski");
               pol=s.nextLine();
               if(pol.equals("m")){
                   stanar.setPol("Muski");
               }
               else if(pol.equals("z")){
                   stanar.setPol("Zenski");
               }
               else{
                   System.out.println("Pogresan unos!");
               }
           }while(!stanar.getPol().equals("Muski") && !stanar.getPol().equals("Zenski"));
           do{
               System.out.println("Zaposlen: \n\t1 - da\n\t2 - ne");
               posao=s.nextLine();
               if(posao.equals("da")){
                   stanar.setZaposlen(true);
               }
               else if(posao.equals("ne")){
                   stanar.setZaposlen(false);
               }
               else{
                   System.out.println("Pogresan unos!");
               }
           }while(!posao.equals("da") && !posao.equals("ne"));
           novistanari.add(stanar);
       }
       return novistanari;
    }
}

