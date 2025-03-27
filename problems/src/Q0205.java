import java.util.HashMap;
import java.util.Map;

public class Q0205 {
    public static void main(String[] args) {
    Q0205 obj = new Q0205();

        System.out.println(obj.isIsomorphic("badc", "baba"));
    }

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> forwardCharacterMap = new HashMap<>();
        Map<Character, Character> reverseCharacterMap = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if(forwardCharacterMap.containsKey(sChar)){
                char tCharExpected = forwardCharacterMap.get(sChar);
                if(tCharExpected != tChar){
                    return false;
                }
            }else{
                if(reverseCharacterMap.containsKey(tChar)){
                    return false;
                }

                forwardCharacterMap.put(sChar, tChar);
                reverseCharacterMap.put(tChar, sChar);

            }
        }

        return true;
    }

}

