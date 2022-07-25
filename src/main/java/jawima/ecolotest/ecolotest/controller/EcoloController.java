package jawima.ecolotest.ecolotest.controller;


import jawima.ecolotest.ecolotest.repository.EcoloTestRepository;
import jawima.ecolotest.ecolotest.util.UrlConnection;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="/api")
public class EcoloController {

    private final UrlConnection urlConnection;
    @Autowired
    EcoloTestRepository ecoloTestRepository;

    private JSONObject object;

    public EcoloController(UrlConnection urlConnection) {
        this.urlConnection = urlConnection;
    }

    @GetMapping(value = "/link/{link}")
    public List<Object> metdata(@PathVariable(value = "link") String  link)  {
        String link1="https://"+link;
        String url1="https://api.websitecarbon.com/site?url=";
        String url2="https://api.urlmeta.org/?url=";
        String url3="https://admin.thegreenwebfoundation.org/greencheck/";
        String result1=this.urlConnection.getMetadata(url1 ,link1);
        String result2=this.urlConnection.getMetadata(url2,link1);
        String result3=this.urlConnection.getMetadata(url3,link);
        JSONArray jsonArray=new JSONArray(Arrays.asList(result1,result2,result3));
        return jsonArray.toList();
    }
}
