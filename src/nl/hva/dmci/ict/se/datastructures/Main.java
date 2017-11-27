package nl.hva.dmci.ict.se.datastructures;

import static nl.hva.dmci.ict.se.datastructures.Quicksort.quickSort10;

public class Main {

    public static void main(String[] args) {
        opdracht1();
    }

    /*
     * Functie die opdracht 1 uitvoert (het testen van efficientie van mijn quicksort
     */
    public static void opdracht1() {
        /* Variable Declarations */
        Student[] lijst1;
        /* Lijst van studenten (in array-vorm) (10.000) */
        Student[] lijst2;
        /* Lijst van studenten (in array-vorm) (20.000) */
        Student[] lijst3;
        /* Lijst van studenten (in array-vorm) (40.000) */
        Student[] lijst4;
        /* Lijst van studenten (in array-vorm) (80.000) */
        Student[] lijst5;
        /* Lijst van studenten (in array-vorm) (160.000) */
        long[] tijden = new long[10];
        /* Array die de tijden bijhoudt */

 /* Genereert de studenten willekeurig */
        lijst1 = StudentGenerator.genereerStudenten(3);
        lijst2 = StudentGenerator.genereerStudenten(20000);
        lijst3 = StudentGenerator.genereerStudenten(40000);
        lijst4 = StudentGenerator.genereerStudenten(80000);
        lijst5 = StudentGenerator.genereerStudenten(160000);

        //stop studenten in de binary search tree voor het sorteren om een omgebalanceerde BST te voorkomen
        BinarySearchTree<Double, Integer> tree = new BinarySearchTree();

        for (Student student : lijst1) {
            tree.put(student.getCijfer(), student.getStudentnummer());
        }
        System.out.println(tree);

        /* Sorteert de lijsten */
        tijden[0] = System.currentTimeMillis();
        quickSort10(lijst1, 0, (lijst1.length - 1));
        tijden[1] = System.currentTimeMillis();
        tijden[2] = System.currentTimeMillis();
        quickSort10(lijst2, 0, (lijst2.length - 1));
        tijden[3] = System.currentTimeMillis();
        tijden[4] = System.currentTimeMillis();
        quickSort10(lijst3, 0, (lijst3.length - 1));
        tijden[5] = System.currentTimeMillis();
        tijden[6] = System.currentTimeMillis();
        quickSort10(lijst4, 0, (lijst4.length - 1));
        tijden[7] = System.currentTimeMillis();
        tijden[8] = System.currentTimeMillis();
        quickSort10(lijst5, 0, (lijst5.length - 1));
        tijden[9] = System.currentTimeMillis();

        for (int i = 0; i < lijst1.length; ++i) {
            System.out.println(lijst1[i].getCijfer() + " " + lijst1[i].getStudentnummer() + " " + lijst1[i].getKlas());
        }

        /* Prints for table */
        System.out.println("\\begin{tabular}{|r|l|}");
        System.out.println("\\textbf{Aantal Studenten} & \\textbf{Tijd (in milliseconden)}\\\\\\hline");
        System.out.printf("10.000 & %d\\\\\\hline\n", (tijden[1] - tijden[0]));
        System.out.printf("20.000 & %d\\\\\\hline\n", (tijden[3] - tijden[2]));
        System.out.printf("40.000 & %d\\\\\\hline\n", (tijden[5] - tijden[4]));
        System.out.printf("80.000 & %d\\\\\\hline\n", (tijden[7] - tijden[6]));
        System.out.printf("160.000 & %d\\\\\\hline\n", (tijden[9] - tijden[8]));
        System.out.println("\\end{tabular}\n\n");

        /* Prints for graph */
        System.out.println("\\begin{tikzpicture}");
        System.out.println("\\begin{axis}[");
        System.out.println("xlabel=Studenten, ylabel=Tijd (in milliseconden), xmin=10000, ymin=0, xmax=160000, ymax=500]");
        System.out.println("\\addplot[color=black]");
        System.out.println("coordinates {");
        System.out.printf("(10000 , %d)\n", (tijden[1] - tijden[0]));
        System.out.printf("(20000 , %d)\n", (tijden[3] - tijden[2]));
        System.out.printf("(40000 , %d)\n", (tijden[5] - tijden[4]));
        System.out.printf("(80000 , %d)\n", (tijden[7] - tijden[6]));
        System.out.printf("(160000 , %d)};\n", (tijden[9] - tijden[8]));
        System.out.println("\\end{axis}");
        System.out.println("\\end{tikzpicture}");

        System.out.println("");

        System.out.println("\\begin{tabular}{|r|l|}");
        System.out.println("\\textbf{Cijfer} & \\textbf{Rank}\\\\\\hline");
        for (int i = 10; i < 100; i += 1) { //rekenen met doubles is niet heel precies, dus worden integers gebruikt om dat te fixen.
            double j = i / 10.0;
            System.out.printf(j + " & %d\\\\\\hline\n", tree.rank(j));
        }
        System.out.println("\\end{tabular}\n\n");
    }
}
