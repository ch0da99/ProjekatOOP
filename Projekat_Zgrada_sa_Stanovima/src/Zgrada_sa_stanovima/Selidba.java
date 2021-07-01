
package Zgrada_sa_stanovima;

import java.util.ArrayList;

public interface Selidba {
    public void useljenje(int br_stana, ArrayList<Stanar> novistanari);
    public void doseljenje(int br_stana, ArrayList<Stanar> novistanari);
    public void iseljenje(int br_stana);
}
