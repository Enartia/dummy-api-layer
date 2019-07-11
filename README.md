# Proof of Concept (PoC): Common HTTP-based API contract supporting multiple DB schemas (deployment-specific)

The aim of this PoC is to demonstrate how the same service (Spring Boot API back-end) can be deployed for different types of brands, which one of which has its own DB schema, while keeping the API contract the same. Besides that, focus is given on how deployment-specific implementations are loaded dynamically while keeping the same service interfacing.

## Prerequisites
- Java 8+
- Maven 3.5+

## Deployment
```
mvn clean package
mv target/dummy-api-layer-0.0.1-SNAPSHOT.jar docker/application/dummy-api-layer.jar
cd docker
docker-compose build
docker-compose up
```
## Credentials & Roles

The PoC has predefined users/roles and is using BasicAuth for authenticating requests.

- Username: `user` - Password: `user` (role: user - can only retrieve domain names owned by him/her)
- Username: `admin` - Password: `admin` (role: admin - can create new domain names and retrieve domain names owned by him/her)

## Endpoints
1. Deployment 1 (Papaki)
- GET: http://localhost:8080/api/v1/domains , Headers: Accept: application/json [retrieves list of user's domain names]
- POST: http://localhost:8080/api/v1/domains, Headers: Accept: application/json, Content-Type: application/json, Payload: {"domain":"value.gr"} [creates new domain name]

2. Deployment 2 (top.host)
- GET: http://localhost:8081/api/v1/domains , Headers: Accept: application/json [retrieves list of user's domain names]
- POST: http://localhost:8081/api/v1/domains, Headers: Accept: application/json, Content-Type: application/json, Payload: {"domain":"value.gr"} [creates new domain name]