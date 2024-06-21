# Ingress
To access an application in a k8s cluster, an ingress controller must be deployed.

## Deploy Ingress-Nginx
```bash
helm upgrade --install ingress-nginx ingress-nginx \
--repo https://kubernetes.github.io/ingress-nginx \
--namespace ingress-nginx --create-namespace
```

# Application
The application needs to be built before deploying it to k8s.

## Build

> [!IMPORTANT]
> It is necessary to adjust or remove the `dockerClient` configuration in the `build.gradle` file before building the application.
> ```groovy
> dockerClient {
>     executable = '/Users/cschaible/.rd/bin/docker'
> }
> ```

```bash
./gradlew clean build jibDockerBuild
```

## Deployment
```
cd charts
helm upgrade --install k8s-deployment k8s-deployment
cd -
```

# Port forwarding
```bash
kubectl port-forward --namespace=ingress-nginx service/ingress-nginx-controller 8080:80
```

# Accessing it
```bash
curl http://localhost:8080/data
```