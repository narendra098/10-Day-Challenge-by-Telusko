package task1;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


class URLService{
    private String chars = "abcdef";
    Random random = new Random();
    static Map<String, String> urlMap = new HashMap<>();

    
    public String generate(String ourl){
        String surl = "";
        if(urlMap.containsKey(ourl)){
            return urlMap.get(ourl);
        }
        else{
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<6;i++){
        int index = random.nextInt(6);
        sb.append(chars.charAt(index));}
        surl = sb.toString();
        urlMap.put(ourl, "telu.sko/"+surl);
        return surl;
    }

}
}

public class Main {
    public static void main(String[] args) {
        String ourl = "https://www.youtube.com/watch?v=2Gik4bFYJbM";
        URLService service = new URLService();
        String surl = service.generate(ourl);
        System.out.println("urlmap: "+URLService.urlMap);
        System.out.println("short url: telu.sko/"+surl);


    }
}
