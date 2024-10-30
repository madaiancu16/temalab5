package exercitiul4;

import java.util.Arrays;

public class Placa {
    private String descriere;
    private int lungime;
    private int latime;
    private String tipDimensiune;
    private boolean[] canturi;
    private int nr_bucati;


    public Placa(String descriere, int lungime, int latime, String tipDimensiune, boolean[] canturi, int nr_bucati) {
        this.descriere = descriere;
        this.lungime = lungime;
        this.latime = latime;
        this.tipDimensiune = tipDimensiune;
        this.canturi = Arrays.copyOf(canturi, canturi.length);
        this.nr_bucati = nr_bucati;
    }

    public String getDescriere() {
        return descriere;
    }

    public int getLungime() {
        return lungime;
    }

    public int getLatime() {
        return latime;
    }

    public String getTipDimensiune() {
        return tipDimensiune;
    }

    public boolean[] getCanturi() {
        return canturi;
    }

    public int calculeazaArie() {
        return lungime * latime;
    }

    public int getNrBucati() {
        return nr_bucati;
    }

    @Override
    public String toString() {
        return "Placa{" +
                "descriere='" + descriere + '\'' +
                ", lungime=" + lungime +
                ", latime=" + latime +
                ", tipDimensiune='" + tipDimensiune + '\'' +
                ", canturi=" + Arrays.toString(canturi) +
                ", nr_bucati=" + nr_bucati +
                '}';
    }
}

