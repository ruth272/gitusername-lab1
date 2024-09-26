
public class Enigma{

    private String rotorInit[] = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"};


    private Rotor rotors[];
        
    public Enigma(int id1, int id2, int id3, String start){

        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1-1], start.charAt(0));
        rotors[1] = new Rotor(rotorInit[id2-1], start.charAt(1));
        rotors[2] = new Rotor(rotorInit[id3-1], start.charAt(2));
        
    }


    public String decrypt(String message){        
        //TODO
        char[] letters = message.toCharArray();
        String decrypted = null;
        char startChar = rotors[0].charAt(0);           //holds first character before rotating
        char secStartChar = rotors[1].charAt(0);           //holds first character before rotating

        for(int i=0; i < letters.length; i++) {
            char firstLetter = rotors[0].charAt(i);          //finds the charater at the index of the inner rotor

            int index = rotors[0].indexOf(firstLetter);           //finds index of the character in the inner most rotor
            char letter = rotors[2].charAt(i);          //finds the charater at the index of the outter rotor

            char secLetter = rotors[1].charAt(index);    //finds the same letter in the middle rotor
            int secIndex = rotors[3].indexOf(secLetter); //finds the same space in the outter rotor
            char thirdLetter = rotors[3].charAt(secIndex);      //finds the letter at the outter rotor
            
            decrypted += (thirdLetter);     //append encrpted letter to string
            rotate();               //rotates the rotors as needed

        }

        return decrypted;
        }

    
    public String encrypt(String message){
        //TODO
        return message;
    }
    
    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
    
}
