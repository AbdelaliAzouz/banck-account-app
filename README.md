# banck-account-app
Développement d'une app microservices pour entrainement

### Swagger
On utilise Swagger pour la documentation des endpoints (api) des MS
par exemple :  
http://localhost:8082/swagger-ui/index.html : CUSTOMER-SERVICE  
http://localhost:8081/swagger-ui/index.html : ACCOUNT-SERVICE
![swagger](https://github.com/AbdelaliAzouz/banck-account-app/assets/83044746/4fa5a26b-fbf7-4e8b-8d6a-444167145203)


### Discovery service (Spring Eureka)
Afficher les instances des microservices qui sont démarré  
pour l'implémenter il faut tout simplement ajouter l'annotation : **@EnableEurekaServer** et le **server.port**
http://localhost:8761/
![EUREKA](https://github.com/AbdelaliAzouz/banck-account-app/assets/83044746/a66c9224-3540-4f03-b611-4e13c4a9a2bb)

### Gateway 
Il y a deux façons pour configurer la Gateway :
1) **méthode statique** : avec un fichier _properties.yaml_ qui contient la configuration des routes manuellement : 
![img.png](images/img.png)
2) **méthode dynamique** : 
à travers la classe DiscoveryClientRouteDefinitionLocator : 
![img_1.png](images/img_1.png)
maintenant on peut accéder aux microservices juste à travers la Gateway avec l'url : gateway-service-ipaddr:{gateway-port}/MS-NAME-MAJ/endpoint  
3) Exemple
MS ACCOUNT-SERVICE :
![img_2.png](images/img_2.png)
MS CUSTOMER-SERVICE :   

![img_4.png](images/img_4.png)