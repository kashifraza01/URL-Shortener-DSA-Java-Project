package kashif;

public class A{
private static final String charset="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

public static String encode(long num){
        StringBuilder sb=new StringBuilder();
        while(num>0){
            sb.append(charset.charAt((int)(num%62)));
            num/=62;
        }
        return sb.reverse().toString();
   }

public static long decode(String s){
        long num=0;
        for(int i=0; i<s.length(); i++){
            num=num*62+charset.indexOf(s.charAt(i));
        }
        return num;
   }
}

