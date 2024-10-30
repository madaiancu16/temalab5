package exercitiul3;
import exercitiul3.PerecheNumere;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.util.List;
import java.util.Arrays;

public class MainAppex1 {

    public static void scriere(List<PerecheNumere> lista) {
        Gson gson = new Gson();
        try (Writer writer = new FileWriter("src/main/resources/perechiNumere.json")) {
            gson.toJson(lista, writer);
            System.out.println("Lista a fost salvată în perechiNumere.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static List<PerecheNumere> citire() {
        Gson gson = new Gson();
        try (Reader reader = new FileReader("src/main/resources/perechiNumere.json")) {
            List<PerecheNumere> lista = gson.fromJson(reader, new TypeToken<List<PerecheNumere>>() {}.getType());
            System.out.println("Lista a fost încărcată din perechiNumere.json");
            return lista;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) {

        List<PerecheNumere> lista = Arrays.asList(
                new PerecheNumere(3, 5),
                new PerecheNumere(6, 8),
                new PerecheNumere(22, 44)
        );


        scriere(lista);


        List<PerecheNumere> listaIncarcata = citire();
        if (listaIncarcata != null) {
            System.out.println("Lista încărcată din JSON:");
            for (PerecheNumere pereche : listaIncarcata) {
                System.out.println(pereche);
            }
        } else {
            System.out.println("Eroare la citirea listei din JSON.");
        }
    }
}

