package com.myorg;

import software.amazon.awscdk.App;
import software.amazon.awscdk.Environment;
import software.amazon.awscdk.StackProps;

import java.util.Arrays;

public class CdkApp {
    public static void main(final String[] args) {
        App app = new App();

        Environment devEu = createEnv("252819530464", "eu-west-1");
        Environment preProdUs = createEnv("252819530464", "us-east-2");
        Environment prodUS = createEnv("252819530464", "us-east-1");

//        new CodePipelineStack(app,"devCodePipelineStack", StackProps.builder()
//                .env(devEu)
//                .build());
        new SqsSnsStack(app, "devStackEu", StackProps.builder()
                .env(devEu)
                .build());
        new LambdaStack(app,"devLambdaStackEu", StackProps.builder()
                .env(devEu)
                .build());
        app.synth();
    }

    // Helper method to build an environment
    static Environment createEnv(String account, String region) {
        return Environment.builder()
                .account(account)
                .region(region)
                .build();
    }
}

