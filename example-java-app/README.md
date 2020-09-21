# Hello Application (Java) example

## Configuration

Configure your environment with the following command:

- gcloud config set project <PROJECT_NAME>
- export PROJECT_ID="$(gcloud config get-value project -q)"

## Build an Image with Buildpacks

There are two ways to build the image. The first way is to use Google Cloud Builpacks. Use the following command to build the image, making sure you are in the folder where the pom.xml resides:

- pack build gcr.io/${PROJECT_ID}/hello-app-java:v1 --builder gcr.io/buildpacks/builder:v1

## Build an Image with Docker
Alternatively, you can use docker to build and upload the image:

- docker build -t gcr.io/${PROJECT_ID}/hello-app-java:v1 .

## Uploading the image to Google Container Repository

Verify that the image has been built using:

- docker images

Upload the container image to the Google Container Registry

- gcloud auth configure-docker

And use docker to push the image to GCR

- docker push gcr.io/${PROJECT_ID}/hello-app-java:v1

- docker run --rm -p 8080:8080 gcr.io/${PROJECT_ID}/hello-app-java:v1

When the application has started, you can view the output using Curl or a Browser (http://localhost:8080)

- curl http://localhost:8080

You should see something similar to this:

    Hello, world!
    Version: 1.0.0
    Hostname: 2fbb31ae1b5e

If you want to deploy version 2 of the application, edit the src/main/java/com/google/demo/helloappjava/HelloAppController.java and update the version number field. Then run through the following commands to build and deploy version 2. Notice the v2 in these commands

## Building a new image with Buildpacks

- pack build gcr.io/${PROJECT_ID}/hello-app-java:v2 --builder gcr.io/buildpacks/builder:v1

## Building a new image with Docker the new Java Jar file:

- ./mvnw package
- docker build -t gcr.io/${PROJECT_ID}/hello-app-java:v2 .
- docker push gcr.io/${PROJECT_ID}/hello-app-java:v2

And if you want to test this locally run:

- docker run --rm -p 8080:8080 gcr.io/${PROJECT_ID}/hello-app-java:v2


----

# Deploying to GKE On-Prem

Be sure you have selected your project
Enable Google Container Registry on your project

- gcloud services enable containerregistry.googleapis.com

Set the environment up

- export PROJECT_ID="$(gcloud config get-value project -q)"

Build a docker image locally, setting up to be uploaded to GCR

- docker build -t gcr.io/${PROJECT_ID}/hello-app-java:v1 .

Verify that the image has been built using:

- docker images

Upload the container image to the Google Container Registry

- gcloud auth configure-docker

And use docker to push the image to GCR (tagged with a v1)

- docker push gcr.io/${PROJECT_ID}/hello-app-java:v1

Create the following manifest:

```
apiVersion: apps/v1
kind: Deployment
metadata:
  name: hello-world-java
spec:
  selector:
    matchLabels:
      app: hello-world-java
  replicas: 1 # tells deployment to run 1 pods matching the template
  template:   # create pods using pod definition in this template
    metadata:
      labels:
        app: hello-world-java
    spec:
      containers:
      - name: hello-world-java
        image: gcr.io/rranthos/hello-app-java:v1 
        ports:
        - containerPort: 8080
          name: server
---
apiVersion: v1
kind: Service
metadata:
  name: hello-world-java-ingress
spec:
  type: LoadBalancer
  selector:
    app: hello-world-java
  ports:
  - name: http
    port: 80
    targetPort: 8080
  loadBalancerIP: 10.0.10.10 # change if necessary
```

And deploy the service (from the netservicesvm)

- kubectl apply -f ./hello-world-manifest.yaml

To view if the deployment was successful

- kubectl get pods

To view the service details 

- kubectl get svc

To delete the pod

- kubectl delete deployment hello-world-java

Deleted the service

- kubectl delete svc hello-world-java-ingress

