/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.findthepair.api;

import com.google.gson.Gson;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 *
 * @author sofiariekkola
 */
public class CatImageService {
    
    public CatImage fetchCatImage() throws IOException {
        OkHttpClient client = new OkHttpClient();
        
        Request request = new Request.Builder()
            .url("https://aws.random.cat/meow")
            .build();

        Response response = client.newCall(request).execute();
        Gson gson = new Gson();
        return gson.fromJson(response.body().string(), CatImage.class);
    }
    
}
