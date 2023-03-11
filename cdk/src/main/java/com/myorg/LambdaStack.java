package com.myorg;

import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.apigateway.LambdaRestApi;
import software.amazon.awscdk.services.lambda.Code;
import software.amazon.awscdk.services.lambda.Function;
import software.amazon.awscdk.services.lambda.Runtime;
import software.constructs.Construct;

public class LambdaStack extends Stack {

    public LambdaStack(final Construct parent, final String id) {

    }

    public LambdaStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        //lambda function definition, uses javascript file under the /lambdaDirectory
        final Function testFunction = Function.Builder.create(this, "HelloHandler")
                .runtime(Runtime.NODEJS_14_X)    // execution environment
                .code(Code.fromAsset("lambda"))  // code loaded from the "lambda" directory
                .handler("testFunction.handler")        // file is "hello", function is "handler"
                .build();

        //apapi gateway to test simple lambda function described above
        LambdaRestApi.Builder.create(this, "Endpoint")
                .handler(testFunction)
                .build();

    }
}
