# Stakater-Assignment
## Overview
This repo contains task, which will help you start working with Kubernetes (k8s). There are two services that are running on two different pods in k8s cluster. FrontService is calling Backend service using DNS service name. 

## Prerequisites
- [Docker](<https://docs.docker.com/>)
- [Minikube](<https://kubernetes.io/docs/tasks/tools/install-minikube/>)


Check the tools:

```bash
# --- check docker: running containers ---
docker ps

# output:
CONTAINER ID	IMAGE	COMMAND		CREATED		STATUS		PORTS		NAMES

# --- check minikube: version & run minikube ---
minikube -v

# output:
minikube version: v1.21.0
commit: 76d74191d82c47883dc7e1319ef7cebd3e00ee11

minikube start
# output:
* minikube v1.21.0 on Microsoft Windows 10 Home 10.0.19042 Build 19042
* Using the docker driver based on existing profile
* Starting control plane node minikube in cluster minikube
* Pulling base image ...
* Restarting existing docker container for "minikube" ...
! StartHost failed, but will try again: provision: get ssh host-port: unable to inspect a not running container to get SSH port
* Restarting existing docker container for "minikube" ...
* Preparing Kubernetes v1.20.7 on Docker 20.10.7 ...
* Verifying Kubernetes components...

  - Using image gcr.io/k8s-minikube/storage-provisioner:v5

  - Using image kubernetesui/dashboard:v2.1.0
  - Using image kubernetesui/metrics-scraper:v1.0.4
* Enabled addons: storage-provisioner, dashboard, default-storageclass
* Done! kubectl is now configured to use "minikube" cluster and "default" namespace by default

kubectl get all
# output:
NAME                 TYPE        CLUSTER-IP   EXTERNAL-IP   PORT(S)   AGE
service/kubernetes   ClusterIP   10.96.0.1    <none>        443/TCP   5d8h

```
## Prepare your environment

## Build backend image
Move to the back end microservice code base root directory and follow following steps for deployment
```bash
# build backend-service docker image
docker build . -t sardarwaqasahmed/stakater-be:latest
# push the image to docker hub repository
docker push sardarwaqasahmed/stakater-be:latest



```
## Build frontend image
Move to the front end microservice code base root and follow following steps for deployment
```bash

# build frontend-service docker image
docker build . -t sardarwaqasahmed/stakater-fe:latest
# push the image to docker hub repository
docker push sardarwaqasahmed/stakater-fe:latest


```

## Deploying frontend and backend service
issue below command on k8s folder that contains resources manifest for deployment
```bash
# deploy
kubectl apply -f k8s
# output:
deployment.apps/stakater-be-app created
service/stakater-be-service created
deployment.apps/stakater-frontend-app created
service/stakater-fe-service created
```

This will create 2 deployments with 2 pods. 1 pod for front-end service and 1 pod for backend service. each pod has 1 replica set as this is demo purpose.
## Health check:

##### Proof

```bash
# display all resources deployed on k8s
kubectl get all

# display deployments/pods/services deployed on k8s
NAME                                    READY   STATUS    RESTARTS   AGE
stakater-be-app-7bdf45d545-6g8v4        1/1     Running   0          13s
stakater-frontend-app-76bc4cdcc-26h7x   1/1     Running   0          13s

kubectl get all
NAME                                        READY   STATUS    RESTARTS   AGE
pod/stakater-be-app-7bdf45d545-6g8v4        1/1     Running   0          17s
pod/stakater-frontend-app-76bc4cdcc-26h7x   1/1     Running   0          17s

NAME                          TYPE        CLUSTER-IP       EXTERNAL-IP   PORT(S)          AGE
service/kubernetes            ClusterIP   10.96.0.1        <none>        443/TCP          5d9h
service/stakater-be-service   ClusterIP   10.101.181.241   <none>        8081/TCP         17s
service/stakater-fe-service   NodePort    10.107.66.113    <none>        9091:30035/TCP   17s

NAME                                    READY   UP-TO-DATE   AVAILABLE   AGE
deployment.apps/stakater-be-app         1/1     1            1           17s
deployment.apps/stakater-frontend-app   1/1     1            1           17s

NAME                                              DESIRED   CURRENT   READY   AGE
replicaset.apps/stakater-be-app-7bdf45d545        1         1         1       17s
replicaset.apps/stakater-frontend-app-76bc4cdcc   1         1         1       17s
```



## Excercise

It's time for testing the services.


## Play with Frontend service


```bash
# Issue the command to run the front-end service
minikube service stakater-fe-service

# This will open the browser with published IP and port copy it and paste the below url in browser
http://127.0.0.1:59484/stakater-fe/api/v1/print
# output:
2021-06-24 20:51:49 Hello Waqas-Ahmed

# above output is combination of DataTime plus String Hello $NAME_PREFIX ENV var. The ENV variable is read from stakater-be-app manifest file and pass to stakater-be-app container.
Front end service is consuming the backend service and return the concated response back to the client.


```
# Clear the resources
Issue the below command in order to delete all the created resources i.e deployment, pods, container, replicaset etc
```bash

kubectl delete -f k8s
# output:
deployment.apps "stakater-be-app" deleted
service "stakater-be-service" deleted
deployment.apps "stakater-frontend-app" deleted
service "stakater-fe-service" deleted


```
