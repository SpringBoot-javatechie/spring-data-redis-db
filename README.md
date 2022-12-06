# spring-data-redis-db

link to setup redis : https://redis.io/docs/getting-started/installation/

Basic theory about redis : https://www.educative.io/blog/what-is-redis

***cURL***

POST Request :

```
curl --location --request POST 'http://localhost:9191/customers' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": 1,
    "firstName": "Swaraj",
    "lastName": "KR",
    "email": "swaraj@gmail.com",
    "dob": "12/02/1990",
    "phone": "43646376376"
}'
```

PUT Request 

```
curl --location --request PUT 'http://localhost:9191/customers/2' \
--header 'Content-Type: application/json' \
--data-raw '{
    "firstName": "Basant",
    "lastName": "Hota",
    "email": "basant.hota@gmail.com",
    "dob": "15/02/1993",
    "phone": "74389374838"
}'
```

