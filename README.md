# Java AWS CDK Project

Some Tutorials around AWS CDK & how to deploy infrastructure as Code

## How To Deploy CDK Stack

All information can be found [here](https://docs.aws.amazon.com/cdk/v2/guide/cli.html) on how to deploy using CDK.

```bash
cdk deploy
```
This will work if you have only 1 stack to deploy. If there is multiple stacks you will need to add the --all argument

```bash
cdk deploy --hotswap
```
Great for development, would not recommend for production as this leads to drift


## Profiles & How to set up for multi account deployment (locally)
If you have a multi account set up on AWS, you can use profiles to manage which changes should be going to specific accounts
```bash
aws configure --profile personal
```
You will need to input 
1. AWS Access Key ID
2. AWS Secret Access Key
3. Default region name

Use the below command to see the list of profiles you have set up
```bash
nano ~/.aws/credentials
``` 

```bash
[default]
aws_access_key_id = <DEFAULT_ACCESS_KEY>
aws_secret_access_key =<DEFAULT_SECRET_ACCESS_KEY>

[dev-eu]
aws_access_key_id = <DEV_ACCESS_KEY>
aws_secret_access_key =<DEV_SECRET_ACCESS_KEY>
[test-eu]
aws_access_key_id = <TEST_ACCESS_KEY>
aws_secret_access_key =<TEST_SECRET_ACCESS_KEY>
[preprod-eu]
aws_access_key_id = <PREPROD_ACCESS_KEY>
aws_secret_access_key =<PREPROD_SECRET_ACCESS_KEY>
``` 
if you dont specify a profile, it will use default one
```bash
cdk deploy --profile dev-eu
``` 


## Code

Creation of AWS API Gateway, AWS Lambda Function, Beginning of AWS codePipeline, AWS SNS topics & SQS queues

