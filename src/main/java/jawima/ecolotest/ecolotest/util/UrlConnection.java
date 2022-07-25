package jawima.ecolotest.ecolotest.util;


import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@Component
public class UrlConnection {
    public String getMetadata(String url1 ,String url2){
        try {
            URL url= new URL(url1+url2);
            HttpURLConnection conn= (HttpURLConnection) url.openConnection();
            String userCredentials = "lucapameni@gmail.com:0UOIOmiPMSSav3Lf1Nro";
            String base64Credentials="Basic " + new String(Base64.encodeBase64(userCredentials.getBytes(StandardCharsets.UTF_8)));
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            System.out.println(base64Credentials);
            if(url1=="https://api.urlmeta.org/?url="){
                conn.setRequestProperty ("Authorization", base64Credentials);
            }
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Content-Length", "" + base64Credentials.getBytes().length);
            BufferedReader r  = new BufferedReader(new InputStreamReader(conn.getInputStream(), Charset.forName("UTF-8")));

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = r.readLine()) != null) {
                sb.append(line);
            }
            return  sb.toString();
        }catch (Exception e){
            return  e.toString();
        }


    }
}
