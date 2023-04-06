import java.util.LinkedList;

public class BackspaceStringCompare {
    public static boolean backspaceCompare(String s, String t) {
        LinkedList<Character> s1 = new LinkedList<>();
        LinkedList<Character> s2 = new LinkedList<>();
        for(char letter : s.toCharArray()){
            if(letter=='#'){
                s1.pollLast();
            }else {
                s1.add(letter);
            }
        }
        for(char letter : t.toCharArray()){
            if(letter=='#'){
                s2.pollLast();
            }else {
                s2.add(letter);
            }
        }
        System.out.println(s1);
        System.out.println(s2);
        return  s1.equals(s2);
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("a##c","#a#c"));
    }
}
