package com.expediagroup.sdk.lodgingconnectivity;

import com.expediagroup.sdk.lodgingconnectivity.configuration.ClientConfiguration;
import com.expediagroup.sdk.lodgingconnectivity.configuration.ClientEnvironment;
import com.expediagroup.sdk.lodgingconnectivity.filemanagement.client.FileManagementClient;

import java.io.File;
import java.io.IOException;

public class FileManagementExample {
    static FileManagementClient client = new FileManagementClient(
            ClientConfiguration.builder()
                    .key("KEY")
                    .secret("SECRET")
                    .environment(ClientEnvironment.TEST)
                    .build()
    );

    public static void main(String[] args) throws IOException {
        client.upload(
                new File("code/src/main/resources/test.txt"),
                "messageThreadId",
                "6ddb1317-bf3d-4759-bcdf-d52642cfac88"
        );
    }
}
