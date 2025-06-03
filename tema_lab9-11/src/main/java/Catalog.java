import java.util.*;

public class Catalog extends TreeMap<Integer, List<Student>> {

    public Catalog(Comparator<Integer> comparator) {
        super(comparator);
    }

    private int rotunjesteMedie(float medie) {
        return Math.round(medie);
    }
    private void valideazaMedie(float medie) {
        if (medie < 0.0f || medie > 10.0f) {
            throw new IllegalArgumentException(
                    "Media trebuie sa fie intre 0 si 10. Media primita: " + medie
            );
        }
    }
    public void add(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Studentul nu poate fi null");
        }

        valideazaMedie(student.getMedie());

        int medieRotunjita = rotunjesteMedie(student.getMedie());


        if (!this.containsKey(medieRotunjita)) {
            this.put(medieRotunjita, new ArrayList<>());
        }
        this.get(medieRotunjita).add(student);
    }


    public void sorteazaStudentiiAlfabetic() {
        for (List<Student> listaStudenti : this.values()) {
            listaStudenti.sort(Comparator.comparing(Student::getNume));
        }
    }

    public void afiseazaCatalog() {
        System.out.println("CATALOG STUDENTI ");
        for (Map.Entry<Integer, List<Student>> entry : this.entrySet()) {
            System.out.println("Media " + entry.getKey() + ":");
            for (Student student : entry.getValue()) {
                System.out.println("  " + student);
            }
            System.out.println();
        }
    }
}