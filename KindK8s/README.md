# Kind k8s Set up for Go To Cloud Appointment App
---

* Use this for Basic Set Up:
    * https://github.com/akashdktyagi/kind-k8s
---

### Implementation Details
* Set Up a Kind Cluster with Ingress setting: Check here: [kind Cluster with Ingress](deploy-with-ingress/kind-cluster-with-ingress.yml)
  * Run command: ```kind create cluster --config kind-cluster-with-ingress.yml```
* You need to install Ingress Controller. Run this command: ``` kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/main/deploy/static/provider/kind/deploy.yaml``` 
  * Run ```kubectl get ns```. This will show a new ns 'ingress-ngix'. Check at the bottom for ingress documentation.
* Run this Command to make sure it is working.
```shell
kubectl wait --namespace ingress-nginx \
  --for=condition=ready pod \
  --selector=app.kubernetes.io/component=controller \
  --timeout=90s
  
#  you will see this message if it ingress controller successfully installed
  pod/ingress-nginx-controller-56d4b5df54-zw268 condition met
```
* Install k8s dashboard as well if you want. Details kept here: https://github.com/akashdktyagi/kind-k8s
* Run the Deployment file: [Deployment File](deploy-with-ingress/deployment.yml)
  * Run the command: ```kubectl apply -f deployment.yml```
  * Run ```kubectl get deployments```  . This will show all the deployments in default name space.
  * Run ```kubectl describe deployment backend``` . This will show the details of the deployment with lavel as backend.
* This will deploy the back end and front end with the ingress rules setting.
* App should be up at localhost/frontend (this could change, check the file to see the logs)

* Usefull commands if something does not work:
  * Check the Official Cheat Sheet: https://kubernetes.io/docs/reference/kubectl/cheatsheet/
  * Get all pods: ```kubectl get pods```
  * Get Logs from pods: ```kubectl logs my-pod```

### Reference Links:

* For Kind Ingress: https://kind.sigs.k8s.io/docs/user/ingress/
* For Kind in General: https://kind.sigs.k8s.io/docs/user/quick-start/
* For k8s: https://kubernetes.io/docs/tasks/access-application-cluster/
* For k8s and deploy front end and back end (this is using Load balancer, but we are using Ingress): https://kubernetes.io/docs/tasks/access-application-cluster/connecting-frontend-backend/ 

### Some Explanation Snippets on Different Topics:

* About Ingress: Source: https://stackoverflow.com/questions/59844622/ingress-configuration-for-k8s-in-different-namespaces
  * Ingress Controller(essentially a separate Pod/Deployment along with a Service that can be used to utilize routing and proxying. Based on nginx container for example);
  * Ingress rules(a separate Kubernetes resourse with kind: Ingress. Will only take effect if Ingress Controller is already deployed)
  * Now, Ingress Controller can be deployed in any namespace and is, in fact, usually deployed in a namespace separate from your app services. It can out-of-the-box see Ingress rules in all namespaces in the cluster and will pick them up.
  * The Ingress rules, however, must reside in the namespace where the app that they configure reside.
  * There are some workarounds for that, but this is the most common approach.
  
* Cheat Sheet: Interacting with running pods
```shell
kubectl logs my-pod                                 # dump pod logs (stdout)
kubectl logs -l name=myLabel                        # dump pod logs, with label name=myLabel (stdout)
kubectl logs my-pod --previous                      # dump pod logs (stdout) for a previous instantiation of a container
kubectl logs my-pod -c my-container                 # dump pod container logs (stdout, multi-container case)
kubectl logs -l name=myLabel -c my-container        # dump pod logs, with label name=myLabel (stdout)
kubectl logs my-pod -c my-container --previous      # dump pod container logs (stdout, multi-container case) for a previous instantiation of a container
kubectl logs -f my-pod                              # stream pod logs (stdout)
kubectl logs -f my-pod -c my-container              # stream pod container logs (stdout, multi-container case)
kubectl logs -f -l name=myLabel --all-containers    # stream all pods logs with label name=myLabel (stdout)
kubectl run -i --tty busybox --image=busybox:1.28 -- sh  # Run pod as interactive shell
kubectl run nginx --image=nginx -n mynamespace      # Start a single instance of nginx pod in the namespace of mynamespace
kubectl run nginx --image=nginx                     # Run pod nginx and write its spec into a file called pod.yaml
--dry-run=client -o yaml > pod.yaml

kubectl attach my-pod -i                            # Attach to Running Container
kubectl port-forward my-pod 5000:6000               # Listen on port 5000 on the local machine and forward to port 6000 on my-pod
kubectl exec my-pod -- ls /                         # Run command in existing pod (1 container case)
kubectl exec --stdin --tty my-pod -- /bin/sh        # Interactive shell access to a running pod (1 container case) 
kubectl exec my-pod -c my-container -- ls /         # Run command in existing pod (multi-container case)
kubectl top pod POD_NAME --containers               # Show metrics for a given pod and its containers
kubectl top pod POD_NAME --sort-by=cpu              # Show metrics for a given pod and sort it by 'cpu' or 'memory'
```