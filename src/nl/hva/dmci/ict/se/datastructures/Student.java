package nl.hva.dmci.ict.se.datastructures;

public class Student implements Comparable {

    private int studentnummer;
    private double cijfer;
    private String klas;

    Student(int studentnummer, double cijfer, String klas) {
        this.studentnummer = studentnummer;
        this.cijfer = cijfer;
        this.klas = klas;
    }

    public int getStudentnummer() {
        return studentnummer;
    }

    public void setStudentnummer(int studentnummer) {
        this.studentnummer = studentnummer;
    }

    public double getCijfer() {
        return cijfer;
    }

    public void setCijfer(double cijfer) {
        this.cijfer = cijfer;
    }

    public String getKlas() {
        return klas;
    }

    public void setKlas(String klas) {
        this.klas = klas;
    }

    /*
     * Functie die twee studenten met elkaar vergelijkt op basis van cijfer en studentnummer.
     */
    @Override
    public int compareTo(Object o) {
        Student studento = (Student) o;
        if (this.getCijfer() > studento.getCijfer()) return 1;
        else if (this.getCijfer() < studento.getCijfer()) return -1;
        else {
            if (this.getStudentnummer() > studento.getStudentnummer()) return 1;
            else if (this.getStudentnummer() < studento.getStudentnummer()) return -1;
            else return 0;
        }

    }
}