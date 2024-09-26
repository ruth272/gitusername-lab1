public class Rotor {

    
    private String rotorValues;
    private char startChar;
        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        
        while(!this.rotate());
            
    }
    
    public boolean rotate(){        //rotates one position clockwise
        //TODO
        rotorValues = rotorValues.substring(1) + rotorValues.charAt(0);     //shifts first character to the end

        if (rotorValues.charAt(0) == startChar){        //checks if starting charater is correct
            return true;
        }

        return false;
    }
    

    public int indexOf(char c){             //returns index of a charater
        //TODO 
        return rotorValues.indexOf(c);
    }

    public char charAt(int idx){            //returns the character at an index
        //TODO
        return rotorValues.charAt(idx);
    }
}
    
