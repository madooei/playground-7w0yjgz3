package other;


import java.util.ArrayList;
import java.util.List;

public class Permutation {


    public static void permute(String sofar, String rest){
        if (rest.length()==0){
            System.out.println(sofar);
        } else {
            for(int i=0; i<rest.length(); i++) {
                String remaining = rest.substring(0,i) + rest.substring(i+1);
                permute(sofar + rest.substring(i, i+1), remaining);
            }
        }
    }

    public static void subset(String sofar, String rest){
        if (rest.length()==0){
            System.out.println(sofar);
        } else {
            subset(sofar + rest.substring(0, 1), rest.substring(1));
            subset(sofar, rest.substring(1));
        }
    }

    public static void permute(String s){
        phelper(string2list(s), new ArrayList<>());
    }

    private static List<Character> string2list(String s){
        List<Character> c = new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            c.add(s.charAt(i));
        }
        return c;
    }

    private static String list2string(List<Character> c){
        char[] carray = new char[c.size()];
        for(int i=0; i<c.size(); i++){
            carray[i]=c.get(i);
        }
        return new String(carray);
    }

    private static void phelper(List<Character> word, List<Character> perm){
       if ( word.size()==0 ) {
           System.out.println( list2string(perm) );
       } else {
           for(int i=0; i<word.size(); i++) {
               char selected = word.remove(i);
               perm.add(selected);
               phelper(word, perm);
               perm.remove(perm.size()-1);
               word.add(i, selected);
           }
       }
    }

    public static void main(String[] args) {
//        permute("");
//        permute("a");
//        permute("al");
//        permute("ali");
        // permute("rruu");

        // permute("", "ali");
        subset("", "123");
    }

}
