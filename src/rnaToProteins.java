/*
Constraints
• All	characters	in	the	DNA	sequences	∈	{‘A’, ‘C’, ‘G’, ‘U’}
• The	output	should	use	the	single	letter	representation	for	each	amino	acid as	seen	in	the	wheel
rather	than	the	three-letter	representation	seen	in	the	table
• The codons {UAA, UAG, UGA} will prot to a single period (.)
• If the length of the input is not a multiple of three, end the amino acid sequence with a (.)
Output Format
For	each	String,	return (print	to	console)	the	corresponding	sequence of	amino acids
 */


import java.util.HashMap;
public class rnaToProteins {

    public static String RNAtoProteins(String RNA){
    String proteins = "";
    HashMap<String, Character> prot = new HashMap<>();

        prot.put("UUU", 'F');
        prot.put("UUC", 'F');
        prot.put("UUA", 'L');
        prot.put("UUG", 'L');
        prot.put("CUU", 'L');
        prot.put("CUC", 'L');
        prot.put("CUA", 'L');
        prot.put("CUG", 'L');
        prot.put("AUU", 'I');
        prot.put("AUC", 'I');
        prot.put("AUA", 'I');
        prot.put("AUG", 'M');
        prot.put("GUU", 'V');
        prot.put("GUC", 'V');
        prot.put("GUA", 'V');
        prot.put("GUG", 'V');
        prot.put("UCU", 'S');
        prot.put("UCC", 'S');
        prot.put("UCA", 'S');
        prot.put("UCG", 'S');
        prot.put("CCU", 'P');
        prot.put("CCC", 'P');
        prot.put("CCA", 'P');
        prot.put("CCG", 'P');
        prot.put("ACU", 'T');
        prot.put("ACC", 'T');
        prot.put("ACA", 'T');
        prot.put("ACG", 'T');
        prot.put("GCU", 'A');
        prot.put("GCC", 'A');
        prot.put("GCA", 'A');
        prot.put("GCG", 'A');
        prot.put("UAU", 'Y');
        prot.put("UAC", 'Y');
        prot.put("UAA", '.');
        prot.put("UAG", '.');
        prot.put("CAU", 'H');
        prot.put("CAC", 'H');
        prot.put("CAA", 'Q');
        prot.put("CAG", 'Q');
        prot.put("AAU", 'N');
        prot.put("AAC", 'N');
        prot.put("AAA", 'K');
        prot.put("AAG", 'K');
        prot.put("GAU", 'D');
        prot.put("GAC", 'D');
        prot.put("GAA", 'E');
        prot.put("GAG", 'E');
        prot.put("UGU", 'C');
        prot.put("UGC", 'C');
        prot.put("UGA", '.');
        prot.put("UGG", 'W');
        prot.put("CGU", 'R');
        prot.put("CGC", 'R');
        prot.put("CGA", 'R');
        prot.put("CGG", 'R');
        prot.put("AGU", 'S');
        prot.put("AGC", 'S');
        prot.put("AGA", 'R');
        prot.put("AGG", 'R');
        prot.put("GGU", 'G');
        prot.put("GGC", 'G');
        prot.put("GGA", 'G');
        prot.put("GGG", 'G');

        int i = 0;
        while (i < RNA.length()) {
            //stack overflow for min function
            String codon = RNA.substring(i, Math.min(i + 3, RNA.length()));
            if (codon.length() < 3) {
                proteins += ".";
                break;
            } else {
                proteins += prot.get(codon);
                i += 3;
            }
        }

        return proteins;
    }

    public static void main(String[] args) {
        System.out.println(RNAtoProteins("AGCUGGGAAACGUAGGCCUA"));
        System.out.println(RNAtoProteins("UAAAGAGAAGCCAGC"));
    }
}
