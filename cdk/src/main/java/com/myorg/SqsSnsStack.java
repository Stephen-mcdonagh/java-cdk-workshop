package com.myorg;

import software.amazon.awscdk.Duration;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.sns.Topic;
import software.amazon.awscdk.services.sns.subscriptions.SqsSubscription;
import software.amazon.awscdk.services.sqs.Queue;
import software.constructs.Construct;

public class SqsSnsStack extends Stack {
    public SqsSnsStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    //define multiple queues & sns topics
    // subscription of queues to topics
    public SqsSnsStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        final Queue firstQueue = Queue.Builder.create(this, "CdkExampleQueue")
                .visibilityTimeout(Duration.seconds(60))
                .queueName("CdkExampleQueue1")
                .build();
        final Queue secondQueue = Queue.Builder.create(this, "CdkExampleQueue2")
                .visibilityTimeout(Duration.seconds(60))
                .queueName("CdkExampleQueue2")
                .build();
        final Queue thirdQueue = Queue.Builder.create(this, "CdkExampleQueue3")
                .visibilityTimeout(Duration.seconds(60))
                .queueName("CdkExampleQueue3")
                .build();
        final Topic firstTopic = Topic.Builder.create(this, "cdkExampleTopic" )
                .topicName("ExampleTopic1")
                .build();
        final Topic secondTopic = Topic.Builder.create(this, "cdkExampleTopic2" )
                .topicName("ExampleTopic2")
                .build();
        firstTopic.addSubscription(new SqsSubscription(firstQueue));
        secondTopic.addSubscription(new SqsSubscription(secondQueue));
        secondTopic.addSubscription(new SqsSubscription(thirdQueue));
    }
}
