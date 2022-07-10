package com.mapa.clinica.util;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class GcpProjectUtils {
    public String GetProjectid() throws UnirestException { 
        String URL = "http://metadata.google.internal/computeMetadata/v1/project/project-id";               
        HttpResponse<String> response = Unirest.get(URL).header("Metadata-Flavor", "Google").asString();

        return response.getBody();        
    }

    public GcpProjectUtils() {}
}
