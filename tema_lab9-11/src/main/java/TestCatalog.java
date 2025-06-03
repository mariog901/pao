import java.util.List;
import java.util.ArrayList;
public class TestCatalog {
    public static void main(String[] args) {
        System.out.println(" TESTAREA CLASEI CATALOG \n");

        Catalog catalog = new Catalog(new ComparatorDescrescator());
        System.out.println("1. Adaugarea studentilor:");

        try {
            catalog.add(new Student("Popescu Ion", 8.7f));
            catalog.add(new Student("Ionescu Maria", 9.2f));
            catalog.add(new Student("Georgescu Ana", 7.8f));
            catalog.add(new Student("Petrescu Mihai", 8.1f));
            catalog.add(new Student("Constantinescu Elena", 9.7f));
            catalog.add(new Student("Radu Bogdan", 7.6f));
            catalog.add(new Student("Stanescu Cristina", 8.9f));
            catalog.add(new Student("Marin Alexandru", 6.5f));
            catalog.add(new Student("Dinu Andreea", 9.1f));
            catalog.add(new Student("Vasile George", 8.3f));

            System.out.println(" Studentii au fost adaugați cu succes");
            System.out.println("\n2. Catalogul inainte de sortarea alfabetica:");
            catalog.afiseazaCatalog();


            System.out.println("3. Sortarea alfabetica a studentilor pentru fiecare nota:");
            catalog.sorteazaStudentiiAlfabetic();

            System.out.println("4. Catalogul dupa sortarea alfabetica:");
            catalog.afiseazaCatalog();

            System.out.println("5. Testarea validarii mediei:");
            try {
                catalog.add(new Student("Student Invalid", 11.0f));
            } catch (IllegalArgumentException e) {
                System.out.println(" Exceptie prinsa pentru media invalida: " + e.getMessage());
            }

            try {
                catalog.add(new Student("Student Invalid 2", -1.0f));
            } catch (IllegalArgumentException e) {
                System.out.println(" Excepție prinsa pentru media negativa: " + e.getMessage());
            }

            // Statistici
            System.out.println("\n6. Statistici:");
            System.out.println("Numarul de note diferite: " + catalog.size());
            int totalStudenti = catalog.values().stream()
                    .mapToInt(List::size)
                    .sum();
            System.out.println("Numarul total de studenti: " + totalStudenti);

        } catch (Exception e) {
            System.err.println("Eroare neasteptata: " + e.getMessage());
            e.printStackTrace();
        }
    }
}