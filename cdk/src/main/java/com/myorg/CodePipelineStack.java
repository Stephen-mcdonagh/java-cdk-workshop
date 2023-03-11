package com.myorg;

import java.util.List;
import java.util.Map;

import software.amazon.awscdk.Stage;
import software.amazon.awscdk.services.codecommit.Repository;
import software.constructs.Construct;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.pipelines.CodeBuildStep;
import software.amazon.awscdk.pipelines.CodePipeline;
import software.amazon.awscdk.pipelines.CodePipelineSource;

public class CodePipelineStack extends Stack {

    public CodePipelineStack(final Construct parent, final String id) {

    }

    //todo fix code pipeline
    public CodePipelineStack(final Construct parent, final String id, final StackProps props) {
        super(parent, id, props);

        // This creates a new CodeCommit repository called 'WorkshopRepo'
        final Repository repo = Repository.Builder.create(this, "cdk-workshop-repository")
                .repositoryName("cdk-workshop")
                .build();

        // The basic pipeline declaration. This sets the initial structure
        // of our pipeline
        final CodePipeline pipeline = CodePipeline.Builder.create(this, "Pipeline")
                .pipelineName("cdkPipeline")
                .synth(CodeBuildStep.Builder.create("SynthStep")
                        .input(CodePipelineSource.codeCommit(repo, "master"))
                        .installCommands(List.of(
                                "npm install -g aws-cdk"

                        ))
                        .commands(List.of(
                                "mvn package",
                                "npx cdk synth"
                        )).build())
                .build();
    }
}
