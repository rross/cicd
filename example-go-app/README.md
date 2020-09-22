# Hello Application example

This example shows how to build and deploy a containerized Go web server
application using [Kubernetes](https://kubernetes.io).
# Hello Application example

This example shows how to build and deploy a containerized Go web server
application using [Kubernetes](https://kubernetes.io).

Visit https://cloud.google.com/kubernetes-engine/docs/tutorials/hello-app
to follow the tutorial and deploy this application on [Google Kubernetes
Engine](https://cloud.google.com/kubernetes-engine).

This directory contains:

- `main.go` contains the HTTP server implementation. It responds to all HTTP
  requests with a  `Hello, world!` response.
- `Dockerfile` is used to build the Docker image for the application.

This application is available as two Docker images, which respond to requests
with different version numbers:

- `gcr.io/(Your Project ID)/hello-app-go:1.0`
- `gcr.io/(Your Project ID)/hello-app-go:2.0`

This requires you to run through the following steps to upload the image:

- export PROJECT_ID="$(gcloud config get-value project -q)"
- docker build -t gcr.io/${PROJECT_ID}/hello-app-go:v1 .

Verify that the image has been built using:

- docker images

Upload the container image to the Google Container Registry

- gcloud auth configure-docker

And use docker to push the image to GCR

- docker push gcr.io/${PROJECT_ID}/hello-app-go:v1

To run the image you just created and then use this command

- docker run --rm -p 8080:8080 gcr.io/${PROJECT_ID}/hello-app-go:v1

View the output using Curl or a Browser (http://localhost:8080)

- curl http://localhost:8080

You should see something similar to this:

    Hello, world!
    Version: 1.0.0
    Hostname: 2fbb31ae1b5e

If you want to deploy version 2 of the application, edit main.go and update the version number field. Then run through the following commands to build and deploy version 2. Notice the v2 in these commands

- docker build -t gcr.io/${PROJECT_ID}/hello-app-go:v2 .
- docker push gcr.io/${PROJECT_ID}/hello-app-go:v2

And if you want to test this locally run:

- docker run --rm -p 8080:8080 gcr.io/${PROJECT_ID}/hello-app-go:v2





Visit https://cloud.google.com/kubernetes-engine/docs/tutorials/hello-app
to follow the tutorial and deploy this application on [Google Kubernetes
Engine](https://cloud.google.com/kubernetes-engine).

This directory contains:

- `main.go` contains the HTTP server implementation. It responds to all HTTP
  requests with a  `Hello, world!` response.
- `Dockerfile` is used to build the Docker image for the application.

This application is available as two Docker images, which respond to requests
with different version numbers:

- `gcr.io/(Your Project ID)/hello-app-go:1.0`
- `gcr.io/(Your Project ID)/hello-app-go:2.0`

This requires you to run through the following steps to upload the image:

- export PROJECT_ID="$(gcloud config get-value project -q)"
- docker build -t gcr.io/${PROJECT_ID}/hello-app-go:v1 .

Verify that the image has been built using:

- docker images

Upload the container image to the Google Container Registry

- gcloud auth configure-docker

And use docker to push the image to GCR

- docker push gcr.io/${PROJECT_ID}/hello-app-go:v1

To find the IMAGE ID for the image you just created and then this command

- docker run --rm -p 8080:8080 gcr.io/${PROJECT_ID}/hello-app-go:v1

View the output using Curl or a Browser (http://localhost:8080)

- curl http://localhost:8080

You should see something similar to this:

    Hello, world!
    Version: 1.0.0
    Hostname: 2fbb31ae1b5e

If you want to deploy version 2 of the application, edit main.go and update the version number field. Then run through the following commands to build and deploy version 2. Notice the v2 in these commands

- docker build -t gcr.io/${PROJECT_ID}/hello-app-go:v2 .
- docker push gcr.io/${PROJECT_ID}/hello-app-go:v2

And if you want to test this locally run:

- docker run --rm -p 8080:8080 gcr.io/${PROJECT_ID}/hello-app-go:v2




