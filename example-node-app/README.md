# Hello Application (Node JS) example

This requires you to run through the following steps to upload the image:

- export PROJECT_ID="$(gcloud config get-value project -q)"
- docker build -t gcr.io/${PROJECT_ID}/hello-app-node:v1 .

Verify that the image has been built using:

- docker images

Upload the container image to the Google Container Registry

- gcloud auth configure-docker

And use docker to push the image to GCR

- docker push gcr.io/${PROJECT_ID}/hello-app-node:v1

- docker run --rm -p 8080:8080 gcr.io/${PROJECT_ID}/hello-app-node:v1

View the output using Curl or a Browser (http://localhost:8080)

- curl http://localhost:8080

You should see something similar to this:

    Hello, world!
    Version: 1.0.0
    Hostname: 2fbb31ae1b5e

If you want to deploy version 2 of the application, edit the index.js and update the version number field. Then run through the following commands to build and deploy version 2. Notice the v2 in these commands

- docker build -t gcr.io/${PROJECT_ID}/hello-app-node:v2 .
- docker push gcr.io/${PROJECT_ID}/hello-app-node:v2

And if you want to test this locally run:

- docker run --rm -p 8080:8080 gcr.io/${PROJECT_ID}/hello-app-node:v2
