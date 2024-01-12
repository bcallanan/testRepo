package com.brianc.testRepo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Invitae {
    private String start_codon = "AUG";
    private String stop_codon = "STOP";
    private Map<String, String> codon_to_amino_acid = new HashMap<String, String>() {{
        put("AUG", "Met");
        put("CAA", "Gln");
        put("CAG", "Gln");
        put("GGU", "Gly");
        put("GCG", "Ala");
        put("UUU", "Phe");
        put("UUC", "Phe");
        put("UGG", "Trp");
        put("UAA", stop_codon);
        put("UAG", stop_codon);
        put("UGA", stop_codon);
    }};

    public static List<String> splitMethod( String text, int n) {
        
        String[] results = text.split("(?<=\\G.{" + n + "})");

    return Arrays.asList(results);

 }
    public String protein_synthesis_part_one(String inputDna) {
        
        List<String> dnas = splitMethod( inputDna, 3);
        
        StringBuffer output = new StringBuffer();
        boolean foundStart = false;
        for (String dna : dnas) {
             String amino = codon_to_amino_acid.get( dna );
             
             if ( amino == null && dna.toLowerCase().startsWith( "a")) {
                 output.append( "Met");
                 output.append( " " );

                 foundStart = true;
             }

            if (amino != null) {
                
                 if ( amino != null && dna.equalsIgnoreCase( start_codon ) && ! foundStart  ) {
                    output.append( amino );
                    output.append( " " );
                    foundStart = true;
                 }
                 else if ( foundStart && ! amino.equalsIgnoreCase( stop_codon) ) {
                     output.append( amino );
                     output.append( " " );
                 }
                 else if ( amino.equalsIgnoreCase( stop_codon) ) {
                    break;
                 }
            }
        }
        // Write your code here
        return output.toString();
    }

	public static void main(String[] args) {
		Invitae invitae = new Invitae();
		
		String prot =  invitae.protein_synthesis_part_one( "CAAATGCAGGCGTAA" );
		System.out.println( prot);
	}

}
