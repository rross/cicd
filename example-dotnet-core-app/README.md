# Hello Application (Dotnet Core 2.2) example

This requires you to run through the following steps to upload the image:

- export PROJECT_ID="$(gcloud config get-value project -q)"
- dotnet build
- docker build -t gcr.io/${PROJECT_ID}/hello-app-dotnet:v1 .

Verify that the image has been built using:

- docker images

Upload the container image to the Google Container Registry

- gcloud auth configure-docker

And use docker to push the image to GCR

- docker push gcr.io/${PROJECT_ID}/hello-app-dotnet:v1

- docker run --rm -it -p 8080:8080 gcr.io/${PROJECT_ID}/hello-app-dotnet:v1

View the output using Curl or a Browser (http://localhost:8080)

- curl http://localhost:8080

You should see something similar to this:

    Hello, world!
    Version: 1.0.0
    Hostname: d15aa12dc956

If you want to deploy version 2 of the application, edit the src/Program.cs and update the version number field. Then run through the following commands to build and deploy version 2. Notice the v2 in these commands

Building the new dotnet core executable/assembly file:

- dotnet build
- docker build -t gcr.io/${PROJECT_ID}/hello-app-dotnet:v2 .
- docker push gcr.io/${PROJECT_ID}/hello-app-dotnet:v2

And if you want to test this locally run:

- docker run --rm -it -p 8080:8080 gcr.io/${PROJECT_ID}/hello-app-dotnet:v2
