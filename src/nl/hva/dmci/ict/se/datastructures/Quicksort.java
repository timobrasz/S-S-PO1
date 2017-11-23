/*
 * Library that Sorts Students using QuickSort (in-place) v1.1
 * Copyright (C) 2017  Timo Brasz (500711490)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package nl.hva.dmci.ict.se.datastructures;

public abstract class Quicksort {

    /*
     * Function that sorts students using QuickSort (in-place)
     * Parameters:
     *   students = Array of students
     *   firstpos = Position of the first element in the array (Usually 0)
     *   lastpos = Position of the final element in the array (Usually (students.length - 1))
     */
    public static void quickSort11(Student[] students, int firstpos, int lastpos) {
		/* Variable Declarations */
        Student temp; /* Temporary Student needed to swap places */
        int i, j; /* Integers i and j for moving data around pivots */

		/* Quits if the list is one item or less */
        if ((lastpos - firstpos) < 1) return;

		/* Determines pivot as best out of three and sets it as first */
        if ((lastpos - firstpos) >= 2) {
            i = 0;
            if (students[firstpos].compareTo(students[firstpos + 1]) > 0) i |= 1;
            if (students[firstpos + 1].compareTo(students[firstpos + 2]) > 0) i |= 2;
            if (students[firstpos].compareTo(students[firstpos + 2]) > 0) i |= 4;
            switch (i) {
                case 0:
                case 7:
                    temp = students[firstpos];
                    students[firstpos] = students[firstpos + 1];
                    students[firstpos + 1] = temp;
                    break;
                case 2:
                case 5:
                    temp = students[firstpos];
                    students[firstpos] = students[firstpos + 2];
                    students[firstpos + 2] = temp;
                    break;
            }
        }

		/* Sets up i and j */
        i = (firstpos + 1);
        j = lastpos;

		/* Moves data around the pivot (firstpos) */
        while (i < j) {
			/* Moves i forwards through the array */
            while ((i < j) && ((students[i].compareTo(students[firstpos])) < 0)) ++i;
            if (i == j) break;
			/* Moves j backwards through the array */
            while ((i < j) && ((students[j].compareTo(students[firstpos])) >= 0)) --j;
            if (i == j) break;
			/* Swaps j and i */
            temp = students[i];
            students[i] = students[j];
            students[j] = temp;
        }

		/* Puts pivot in the correct location if it isn't already */
        while (students[i].compareTo(students[firstpos]) > 0) --i;
        if (i != firstpos) {
            temp = students[i];
            students[i] = students[firstpos];
            students[firstpos] = temp;
        }

		/* Sorts the sublists on either side of the pivot */
        quickSort11(students, firstpos, (i - 1));
        quickSort11(students, (i + 1), lastpos);
    }

    /*
     * Function that sorts students using QuickSort (in-place)
     * Parameters:
     *   students = Array of students
     *   firstpos = Position of the first element in the array (Usually 0)
     *   lastpos = Position of the final element in the array (Usually (students.length - 1))
     */
    public static void quickSort10(Student[] students, int firstpos, int lastpos) {
		/* Variable Declarations */
        Student temp; /* Temporary Student needed to swap places */
        int i, j; /* Integers i and j for moving data around pivots */

		/* Quits if the list is one item or less */
        if ((lastpos - firstpos) < 1) return;

		/* Sets up i and j */
        i = (firstpos + 1);
        j = lastpos;

		/* Moves data around the pivot (firstpos) */
        while (i < j) {
			/* Moves i forwards through the array */
            while ((i < j) && ((students[i].compareTo(students[firstpos])) < 0)) ++i;
            if (i == j) break;
			/* Moves j backwards through the array */
            while ((i < j) && ((students[j].compareTo(students[firstpos])) >= 0)) --j;
            if (i == j) break;
			/* Swaps j and i */
            temp = students[i];
            students[i] = students[j];
            students[j] = temp;
        }

		/* Puts pivot in the correct location if it isn't already */
        while (students[i].compareTo(students[firstpos]) > 0) --i;
        if (i != firstpos) {
            temp = students[i];
            students[i] = students[firstpos];
            students[firstpos] = temp;
        }

		/* Sorts the sublists on either side of the pivot */
        quickSort10(students, firstpos, (i - 1));
        quickSort10(students, (i + 1), lastpos);
    }
}
