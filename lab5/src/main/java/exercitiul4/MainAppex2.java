package exercitiul4;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import exercitiul4.Mobilier;
import exercitiul4.Placa;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MainAppex2 {

    public static void main(String[] args) {
        List<Mobilier> mobilierList = citire("src/main/resources/mobilier.json");

        if (mobilierList == null) {
            System.out.println("Nu s-au putut citi datele din fișierul JSON.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        int optiune;

        do {
            System.out.println("\nMeniu:");
            System.out.println("1. Afișează toate piesele de mobilier și plăcile care le compun");
            System.out.println("2. Afișează caracteristicile plăcilor pentru un mobilier specific");
            System.out.println("3. Afișează numărul total de bucăți pentru toate plăcile");
            System.out.println("4. Estimează numărul de foi de PAL necesare pentru un mobilier specific");
            System.out.println("0. Ieșire din program");
            System.out.print("Selectați o opțiune: ");
            optiune = scanner.nextInt();
            scanner.nextLine();

            switch (optiune) {
                case 1:
                    afisare(mobilierList);
                    break;
                case 2:
                    System.out.print("Introduceți numele mobilierului: ");
                    String nume = scanner.nextLine();
                    afiseazacaracplaci(mobilierList, nume);
                    break;
                case 3:
                    afisarebuc(mobilierList);
                    break;
                case 4:
                    System.out.print("Introduceți numele mobilierului pentru estimarea numărului de foi: ");
                    String numef= scanner.nextLine();
                    estimare(mobilierList, numef);
                    break;
                case 0:
                    System.out.println("Ieșire din program.");
                    break;
                default:
                    System.out.println("Opțiune invalidă! Vă rugăm să alegeți din nou.");
                    break;
            }
        } while (optiune != 0);

        scanner.close();
    }

    public static List<Mobilier> citire(String fisierJson) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(fisierJson)) {
            return gson.fromJson(reader, new TypeToken<List<Mobilier>>() {}.getType());
        } catch (IOException e) {
            System.out.println("Eroare la citirea fișierului JSON: " + e.getMessage());
            return null;
        }
    }

    public static void afisare(List<Mobilier> mobilierList) {
        for (Mobilier mobilier : mobilierList) {
            System.out.println("Mobilier: " + mobilier.getNume());
            for (Placa placa : mobilier.getPlaci()) {
                System.out.println("  " + placa);
            }
        }
    }

    public static void afiseazacaracplaci(List<Mobilier> mobilierList, String nume) {
        for (Mobilier mobilier : mobilierList) {
            if (mobilier.getNume().equalsIgnoreCase(nume)) {
                System.out.println("Caracteristicile plăcilor pentru " + nume + ":");
                for (Placa placa : mobilier.getPlaci()) {
                    System.out.println("  " + placa);
                }
                return;
            }
        }
        System.out.println("Mobilierul " + nume + " nu a fost găsit.");
    }

    public static void afisarebuc(List<Mobilier> mobilierList) {
        int bucati = 0;
        for (Mobilier mobilier : mobilierList) {
            for (Placa placa : mobilier.getPlaci()) {
                bucati += placa.getNrBucati(); //
            }
        }
        System.out.println("Numărul total de bucăți pentru toate plăcile: " + bucati);
    }


    public static void estimare(List<Mobilier> mobilierList, String nume) {
        int dimensiune = 2800 * 2070;
        int arie= 0;

        for (Mobilier mobilier : mobilierList) {
            if (mobilier.getNume().equalsIgnoreCase(nume)) {
                for (Placa placa : mobilier.getPlaci()) {
                    arie += placa.calculeazaArie();
                }
                break;
            }
        }

        int foi = (int) Math.ceil((double) arie / dimensiune);
        System.out.println("Numărul estimat de foi necesare pentru " + nume + ": " + foi);
    }
}
