package kashif;

import java.io.*;
import java.util.*;

public class Url{
    private static final String baseurl= "https://short.ly/";
    private static final String filepath="urlmappings.txt";

    private final Map<String,String> shorttolong=new HashMap<>();
    private final Map<String,String> longtoshort=new HashMap<>();
    private long counter=1;

    public Url(){ readfile(); }

    public String shorturl(String longurl){
        
        //agar pehle se shorten hua hai,same short url return karo
        if(longtoshort.containsKey(longurl)){ return baseurl+longtoshort.get(longurl); }

        //naya short code banao base62 encoding se
        String shortcode=A.encode(counter);
        counter++;

        //mapping ko memory me save karo,shortcode ke against long url store karo
        shorttolong.put(shortcode,longurl);
        
        //long url ke against shortcode store karo,taky agar dobara same URL aaye to naya code na banay
        longtoshort.put(longurl,shortcode);

        //file mein save karo
        writefile(shortcode,longurl);

        return baseurl+shortcode;
    }

    public String expandurl(String shorturl){
        //short URL format check karo
        if(!shorturl.startsWith(baseurl)){ return "Invalid short URL"; }

        //short code nikalo
        String shortcode=shorturl.substring(baseurl.length());

        //agar mapping mile toh long url return karo
        if(shorttolong.containsKey(shortcode)){ return shorttolong.get(shortcode); }

        return "URL not found";
}

private void writefile(String shortcode,String longurl){
        try(FileWriter fw=new FileWriter(filepath,true)){
            fw.write(shortcode + "," + longurl + "\n");
        }catch(IOException e){
            System.out.println("Error writing to file.");
    }
}

private void readfile(){
        File f=new File(filepath);
        if(!f.exists()) return;

        try(BufferedReader br=new BufferedReader(new FileReader(f))){
            String line;
            
            while((line = br.readLine()) != null){
                String[] parts=line.split(",", 2);
                if(parts.length==2){
                    String shortcode=parts[0];
                    String longurl=parts[1];

                    shorttolong.put(shortcode,longurl);
                    longtoshort.put(longurl,shortcode);

                    //counter update
                    long decoded=A.decode(shortcode);
                    if(decoded>=counter){ counter=decoded+1; }
                }
            }
        }
        catch(IOException e){
            System.out.println("Error reading from file.");
        }
    }
}


