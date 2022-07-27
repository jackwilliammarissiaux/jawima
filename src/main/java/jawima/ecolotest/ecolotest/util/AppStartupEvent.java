package jawima.ecolotest.ecolotest.util;


import jawima.ecolotest.ecolotest.model.EcoLoTest;
import jawima.ecolotest.ecolotest.repository.EcoloTestRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Arrays;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    private final UrlConnection urlConnection;
    private final EcoloTestRepository ecoloTestRepository;
    public AppStartupEvent(UrlConnection urlConnection, EcoloTestRepository ecoloTestRepository) {
        this.urlConnection = urlConnection;
        this.ecoloTestRepository = ecoloTestRepository;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {

      String result1 =this.urlConnection.getMetadata("https://api.websitecarbon.com/site?url=","https://www.youtube.com/");
      String result2=this.urlConnection.getMetadata("https://api.urlmeta.org/?url=","https://www.youtube.com");
      String result3=this.urlConnection.getMetadata("https://admin.thegreenwebfoundation.org/greencheck/","www.youtube.com");

       JSONArray jsonArray=new JSONArray(Arrays.asList(result1,result2,result3));
        EcoLoTest ecoLoTest ;
        Date date =new Date();
        ecoLoTest=new EcoLoTest("https://www.youtube.com" ,"?",date);
        //this.ecoloTestRepository.save(ecoLoTest);



    }
}
