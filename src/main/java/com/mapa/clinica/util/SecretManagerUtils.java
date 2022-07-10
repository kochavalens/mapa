package com.mapa.clinica.util;

import java.io.IOException;
import com.google.cloud.secretmanager.v1.SecretManagerServiceClient;
import com.google.cloud.secretmanager.v1.SecretVersionName;
import com.google.cloud.secretmanager.v1.AccessSecretVersionResponse;
import com.mashape.unirest.http.exceptions.UnirestException;

public class SecretManagerUtils {
    private GcpProjectUtils projectUtils = new GcpProjectUtils();

    public String getSecret(String secret) throws IOException, UnirestException {
        String project = projectUtils.GetProjectid();

        SecretManagerServiceClient client = SecretManagerServiceClient.create();
        SecretVersionName name = SecretVersionName.of(project, secret, "latest");
        AccessSecretVersionResponse response = client.accessSecretVersion(name);        

        return response.getPayload().getData().toStringUtf8();        
    }

    public SecretManagerUtils() {}
}
