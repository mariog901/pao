import java.util.Arrays;
import java.util.List;

public class TestCountingCollections {
    public static void main(String[] args) {
        System.out.println("TESTAREA COLECTIILOR CU CONTOR \n");

        System.out.println("1. TESTAREA CountingHashSet:");
        testCountingHashSet();

        System.out.println("\n" + "=".repeat(50) + "\n");

        System.out.println("2. TESTAREA CountingLinkedList:");
        testCountingLinkedList();

        System.out.println("\n" + "=".repeat(50) + "\n");

        System.out.println("3. COMPARATIA SI CONCLUZIILE:");
        afiseazaConcluzii();
    }

    private static void testCountingHashSet() {
        CountingHashSet<Integer> countingSet = new CountingHashSet<>();

        System.out.println("a. Testarea metodei add():");

        countingSet.add(1);
        countingSet.add(2);
        countingSet.add(3);
        countingSet.add(2);
        countingSet.add(4);
        countingSet.add(1);

        System.out.println("Dupa adaugarea elementelor: 1, 2, 3, 2, 4, 1");
        countingSet.afiseazaStatistici();
        System.out.println("Continutul setului: " + countingSet);

        System.out.println("\nb. Testarea metodei addAll():");

        List<Integer> lista = Arrays.asList(5, 6, 7, 2, 8, 3); // 2 si 3 sunt duplicate
        countingSet.addAll(lista);
        System.out.println("Dupa addAll([5, 6, 7, 2, 8, 3]):");
        countingSet.afiseazaStatistici();
        System.out.println("Continutul setului: " + countingSet);

        System.out.println("\nOBSERVATIE pentru HashSet:");
        System.out.println("- HashSet nu permite duplicate");
        System.out.println(
                "- Contorul nostru inregistreaza toate incercarile de adaugare"
        );
        System.out.println(
                "- Diferenta arata cate elemente duplicate au fost respinse"
        );
    }
    private static void testCountingLinkedList() {
        CountingLinkedList<Integer> countingList = new CountingLinkedList<>();

        System.out.println("a. Testarea metodei add():");
        countingList.add(1);
        countingList.add(2);
        countingList.add(3);
        countingList.add(2);
        countingList.add(4);
        countingList.add(1);

        System.out.println("Dupa adaugarea elementelor: 1, 2, 3, 2, 4, 1");
        countingList.afiseazaStatistici();
        System.out.println("Continutul listei: " + countingList);

        System.out.println("\nb. Testarea metodei addAll():");

        List<Integer> lista = Arrays.asList(5, 6, 7, 2, 8, 3);
        countingList.addAll(lista);

        System.out.println("Dupa addAll([5, 6, 7, 2, 8, 3]):");
        countingList.afiseazaStatistici();
        System.out.println("Continutul listei: " + countingList);

        System.out.println("\nOBSERVATIE pentru LinkedList:");
        System.out.println(" LinkedList permite duplicate");
        System.out.println(" Contorul si dimensiunea sunt egale");
        System.out.println(" Toate elementele sunt acceptate");
    }

    private static void afiseazaConcluzii() {
        System.out.println("CONCLUZII IMPORTANTE:");
        System.out.println();

        System.out.println("1. DIFERENTE COMPORTAMENTALE:");
        System.out.println("    HashSet: respinge duplicatele -> contor != dimensiune");
        System.out.println("    LinkedList: accepta duplicatele -> contor = dimensiune");
        System.out.println();

        System.out.println("2. PROBLEMA CU addAll() in HashSet:");
        System.out.println("    addAll() apeleaza add() intern pentru fiecare element");
        System.out.println("    Contorul nostru se incrementeaza pentru fiecare incercare");
        System.out.println("    HashSet-ul respinge duplicatele, dar contorul le inregistreaza");
        System.out.println();

        System.out.println("3. PRINCIPII DE DESIGN:");
        System.out.println("    Mostenirea trebuie folosita cu atentie");
        System.out.println("    Comportamentul clasei parinte influenteaza clasa copil");
        System.out.println("    Composition over inheritance - adesea mai sigur");
        System.out.println();

        System.out.println("4. ALTERNATIVE RECOMANDATE:");
        System.out.println("    Folosirea decoratorului (wrapper) in loc de mostenire");
        System.out.println("    Implementarea directa a interfetelor");
        System.out.println("    Agregarea in loc de mostenire");
    }
}