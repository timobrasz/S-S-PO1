package nl.hva.dmci.ict.se.datastructures;

public class StudentGenerator {

    public static Student[] genereerStudenten(int aantal) {
        /* Verklaring van variabelen */
        int studentnummer;
        double cijfer;
        Student[] studentenLijst = new Student[aantal];
        String[] klassen = KlasGenerator.maakKlassen(aantal);

        /* Genereert studenten */
        studentnummer = 50080001;
        for (int i = 0; i < aantal; ++i) {
            cijfer = ((int) ((Math.random() * 91) + 10)) / 10.0;
            studentenLijst[i] = new Student(studentnummer, cijfer, klassen[i]);
            ++studentnummer;
        }

        return studentenLijst;
    }
}