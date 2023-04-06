import java.util.ArrayList;
import java.util.HashMap;

public class TournamentWinner {
    public static String tournamentWinner(
            ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        // Write your code here.
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(ArrayList list : competitions){
            String name1 = (String) list.get(0);
            String name2 = (String) list.get(1);
            if(!hashMap.containsKey(name1)){
                hashMap.put(name1,0);
            }
            if(!hashMap.containsKey(name2)){
                hashMap.put(name2,0);
            }
        }
        for(int i = 0; i< results.size(); i++){
            int score = results.get(i);
            String name;
            if(score==0){
                name = competitions.get(i).get(1);
            }else {
                name = competitions.get(i).get(0);
            }
            hashMap.put(name,hashMap.get(name)+3);
        }
        System.out.println(hashMap);
        int result = 0;
        String answer ="";
        for(String name : hashMap.keySet()){
            if(hashMap.get(name)>result){
                result = hashMap.get(name);
                answer = name;
            }
        }
        return  answer;
    }

    public static void main(String[] args) {
        String[][] competition = {{"Bulls", "Eagles"},{"Bulls", "Bears"},{"Bears", "Eagles"}};
        int[] score = {0,0,0};
        ArrayList<ArrayList<String>> competitions = new ArrayList<>();
        for(int i =0; i<competition.length; i++){
            competitions.add(new ArrayList<>());
        }
        for(int i = 0; i<competition.length; i++){
            for(int j = 0; j<competition[i].length; j++){
                competitions.get(i).add(competition[i][j]);
            }
        }
        ArrayList<Integer> results = new ArrayList<>();
        for(int num : score){
            results.add(num);
        }
        System.out.println(tournamentWinner(competitions,results));
    }
}
