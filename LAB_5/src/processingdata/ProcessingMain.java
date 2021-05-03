package processingdata;

import forms.*;
import java.io.IOException;

class Address implements Comparable<Address>{
    private String address;
    private int postalCode;

    public Address(String adr, int pc) {
        this.address= adr;
        this.postalCode= pc;
    }
    
    public int postalCode() { 
        return this.postalCode; 
    }
    
    public String toString() {
        return this.address+" at PC("+this.postalCode+")";
    }

    public int compareTo(Address addr){
        if (this.postalCode == addr.postalCode)
            return this.address.compareTo(addr.address);

        return this.postalCode - addr.postalCode;
    }
}

public class ProcessingMain {
    public static void main(String[] args) throws IOException {
        Form censusForm= new Form();
        Field<Address> adr= new Field<Address>(s-> { String[] data= s.split(";");
                                                    return new Address(data[0], Integer.valueOf(data[1].trim()));
                                                    }).
            addValidation(a-> a.postalCode() >= 0, "Postalcode should be positive");
        
        Field<Integer> np= new Field<Integer>(s->Integer.valueOf(s)).
            addValidation(s->s>0, "value greater than 0 expected");
            
        censusForm.add("Enter address and postal code separated by ';'", adr).
            add("Number of people livingin that address?", np);
            
        DataAggregator dag= new DataAggregator();
        
        for(int i=0; i<3; i++)
            dag.add(censusForm.exec());
        
        System.out.println(dag);        
    }
}