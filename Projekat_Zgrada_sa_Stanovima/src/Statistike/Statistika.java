
package Statistike;

import Zgrada_sa_stanovima.*;
import java.util.ArrayList;

public abstract class Statistika {
    protected int broj_uzoraka;
    protected ArrayList<Stan> stanovi;
    protected abstract int statistika_broj();
    protected abstract double statistika_procenat();
}
