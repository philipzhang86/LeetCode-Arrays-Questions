import java.util.ArrayList;

public class StringSubsequence {
    public static boolean isSubsequence(String s, String t) {
        ArrayList<Character> original = new ArrayList<>();
        ArrayList<Character> sequence = new ArrayList<>();
        for(char letter : s.toCharArray()){
            sequence.add(letter);
        }
        for(char letter : t.toCharArray()){
            original.add(letter);
        }
        int oriIndex = 0;
        int seqIndex = 0;
        while (oriIndex<original.size() && seqIndex<sequence.size()){
            if(original.get(oriIndex).equals(sequence.get(seqIndex))){
                seqIndex++;
            }
            oriIndex++;
        }
        return seqIndex==sequence.size();
    }

    public static boolean isSubsequence2(String s, String t){
        int tIndex = 0;
        int sIndex = 0;
        while (tIndex<t.length() && sIndex<s.length()){
            if(t.charAt(tIndex)==s.charAt(sIndex))  sIndex++;
            tIndex++;
        }
        return sIndex==s.length();
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence2("abc","ahbgdc"));
    }
}
