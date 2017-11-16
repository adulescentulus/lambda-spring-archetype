# a Spring Boot app on AWS Lambda

## Quick Start
1. Setup a [AWS CodeStar](https://aws.amazon.com/de/codestar/) account and choose the _Java Spring_ template for 
"Web service" and "AWS Lambda". Replace everything in your newly configured CodeStar repo with this new Maven multi module.
1. Install [Docker](https://www.docker.com/get-docker) and [AWS SAM Local](#aws-sam-local) for testing.
1. Start editing in the folder `lambda-backend` for your lambda function

## Details

### Spring Boot and AWS Lambda
This project is based on [this](https://github.com/awslabs/aws-serverless-java-container) project, a Java wrapper made by 
AWS Labs. It basically provides a generic entrypoint (Lambda handler) for your serverless function. You then provide your 
Spring configuration and upon instantiation your `ApplicationContext` is brought to life.

In this Maven multi module project one submodule contains the Lambda handler code and 
one pretty simple submodule containing everything to run a `SpringBootApplication`.

You now can easily switch between the two worlds running the Spring Boot application out of your IDE, as standalone Java 
application or even as Docker container or on the other side deployed as a Lambda function. You can take advantage of 
low AWS fees for prototypes or small projects and take advantage of the great scaling capabilities of AWS when you suddenly 
get a raise of users. However you can always switch to a big standalone app server or even facilitate container orchestration 
when your costs of billions of Lambda invocations would require you to rethink your hosting concept.

### Local Lambda testing with AWS SAM Local
For local Lambda testing use [AWS SAM Local](https://github.com/awslabs/aws-sam-local). With it you 
can run your Lambda code locally through the use of Docker. You can utilize the tool not only to send specific events to 
your function but also to simulate an AWS API Gateway, i.e. you use local endpoints and AWS SAM Local spawns your Lambda 
instances.

To call your function run `./aws-sam-local.exe local start-api -t cfn/aws-resources.yml` and connect 
to `http://localhost:3000/hello/world`!