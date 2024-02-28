/*
Write a program that given a String representation of a DNA sequence and returns its transcribed RNA
sequence. The main differences that distinguish DNA from RNA is that RNA contains the sugar ribose,
while DNA contains the slightly different sugar deoxyribose (a type of ribose that lacks one oxygen
atom),
Constraints
• All	characters	in	the	DNA	sequences	∈	{‘A’, ‘C’, ‘G’, ‘T’}
Output Format
For	each	String,	return (and	print	to	console)	the	corresponding	RNA	sequence
 */

public class dnaToRna {

    public static String DnaRna(String strand) {
        String newString = "";
        char[] array = new char[strand.length()];

        for (int i = 0; i < strand.length(); i++) {
            if (strand.charAt(i) == 'A') {
                array[i] = 'U';
            } else if (strand.charAt(i) == 'T') {
                array[i] = 'A';
            } else if (strand.charAt(i) == 'C') {
                array[i] = 'G';
            } else if (strand.charAt(i) == 'G') {
                array[i] = 'C';
            } else {
                array[i] = strand.charAt(i);
            }
        }

        for (int i = 0; i < array.length; i++) {
            newString += array[i];
        }
        return newString;
    }

    public static void main(String[] args) {
        System.out.println(DnaRna("AGCTGGGAAACGTAGGCCTA"));
        System.out.println(DnaRna("TTTTTTTTTTGGCGCG"));
        System.out.println(DnaRna("CTTTGGGACTAGTAACCCATTTCGGCT"));
    }
}
