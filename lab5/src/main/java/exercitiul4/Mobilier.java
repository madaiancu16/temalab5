package exercitiul4;
import java.util.ArrayList;
import java.util.List;

public class Mobilier {
    private String nume;
    private List<Placa> placi;

    public Mobilier(String nume) {
        this.nume = nume;
        this.placi = new ArrayList<>();
    }

    public void adaugaPlaca(Placa placa) {
        this.placi.add(placa);
    }

    public String getNume() {
        return nume;
    }

    public List<Placa> getPlaci() {
        return placi;
    }

    @Override
    public String toString() {
        return "Mobilier{" +
                "nume='" + nume + '\'' +
                ", placi=" + placi +
                '}';
    }
}
