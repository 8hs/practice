package net.weever.poj;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by weever on 7/22/17.
 * Java 1.8， Can not pass poj.org java 1.5
 */
public class p1002 {
    public static void main(String[] args) {
        HashMap<String,Integer> hm = new HashMap<>();
        Scanner in = new Scanner(System.in);
        int col = in.nextInt();
        for(int i = 0; i < col; i++){
            StringBuffer sb = new StringBuffer();
            String next = in.next();
            for(char c : next.toCharArray()){
                if(c != '-'){
                    if(c >='0' && c<='9')
                        sb.append( c - '0');
                    else
                        sb.append(getNum(c));
                }
            }
            String key = sb.toString();
            if(!hm.containsKey(key))
                hm.put(key,0);
            hm.put(key,hm.get(key)+1);
        }
        Object[] keys = hm.keySet().toArray();
        Arrays.sort(keys);
        boolean b = false;
        for(Object o: keys){
            String s = (String) o;
            if(hm.get(s) > 1){
                b = true;
                System.out.println(s.substring(0,3) + "-" + s.substring(3) + " " +hm.get(s));
            }
        }
        if(!b)
            System.out.println("No duplicates.");
    }

    private static int getNum(char c){
        if(c=='A'||c=='B'||c=='C')return 2;
        else if(c=='D'||c=='E'||c=='F')return 3;
        else if(c=='G'||c=='H'||c=='I')return 4;
        else if(c=='J'||c=='K'||c=='L')return 5;
        else if(c=='M'||c=='N'||c=='O')return 6;
        else if(c=='P'||c=='R'||c=='S')return 7;
        else if(c=='T'||c=='U'||c=='V')return 8;
        else return 9;
    }
}
