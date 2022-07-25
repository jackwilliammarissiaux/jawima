package jawima.ecolotest.ecolotest.util;


import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    private final UrlConnection urlConnection;

    public AppStartupEvent(UrlConnection urlConnection) {
        this.urlConnection = urlConnection;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {

      String result1 =this.urlConnection.getMetadata("https://api.websitecarbon.com/site?url=","https://www.youtube.com/");
      String result2=this.urlConnection.getMetadata("https://api.urlmeta.org/?url=","https://www.youtube.com");
      String result3=this.urlConnection.getMetadata("https://admin.thegreenwebfoundation.org/greencheck/","www.youtube.com");

       JSONArray jsonArray=new JSONArray(Arrays.asList(result1,result2,result3));
       System.out.println(jsonArray);

    }
}
