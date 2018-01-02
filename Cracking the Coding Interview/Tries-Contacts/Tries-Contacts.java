import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
       
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Trie Contacts=new Trie();
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            if (op.equals("add"))  Contacts.add(contact);
            else if(op.equals("find")) System.out.println(Contacts.countFinds(contact));
        }
    }
}
class TrieNode{
    HashMap<Character,TrieNode> links; 
    boolean isFinished;
    int size; 
       
    public TrieNode(){
        links=new HashMap<>();
        isFinished=false;
        size=0;
    }
}
class Trie{
    TrieNode root;
    Trie(){
        root=new TrieNode();
    }
    public Trie(String[] words) {
        for (String word : words) {
            add(word);
        }
    }
    public Trie(String str){
        add(str);
    }    
    public void add(String str){
        TrieNode current=root;
        int length=str.length();
        for(int i=0;i<length;i++){
             char ch=str.charAt(i);
             if(i==length-1) current.isFinished=true;
             current.links.putIfAbsent(ch,new TrieNode());
             current=current.links.get(ch);//move to the child  
             current.size++;
         }
    }
    public int countFinds(String str){
        TrieNode current=root;
        int length=str.length();
        for(int i=0;i<length;i++){
            current=current.links.get(str.charAt(i));
            if(current==null) return 0;
        }
        return current.size;
    }
}
 
