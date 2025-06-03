public class Student {
    private String nume;
    private float medie;

    public Student(String nume, float medie) {
        this.nume = nume;
        this.medie = medie;
    }

    public String getNume() {
        return nume;
    }

    public float getMedie() {
        return medie;
    }

    @Override
    public String toString() {
        return "Student{nume='" + nume + "', medie=" + medie + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return Float.compare(student.medie, medie) == 0 &&
                nume.equals(student.nume);
    }

    @Override
    public int hashCode() {
        return nume.hashCode() + Float.hashCode(medie);
    }
}