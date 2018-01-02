import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
        }
        System.out.println(answer(m,n,magazine,ransom));
    }
    
    public static String answer(int m,int n,String[] magazine,String[] ransom ){
        Hashtable<String,Integer> table=new Hashtable<>();
        for(String s:magazine){
            if(table.containsKey(s))
                table.put(s,table.get(s)+1);
            else
                table.put(s,1);
        }
        for(String s:ransom){
            if(!table.containsKey(s)) return "No";
            else{
                table.put(s,table.get(s)-1);
                if(table.get(s)==0) table.remove(s);
            }
            
        }return "Yes";
    }

}
