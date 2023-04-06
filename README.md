# SETUP

```
./run.sh
```

# PART II

#### POST

```
curl -X POST http://localhost:8080/employees -H ‘Content-type:application/json’ -d '{"name": "Samwise Gamgee", "role": "gardener"}'
```

#### PUT

```
curl -X PUT http://localhost:8080/employees/3 -H ‘Content-type:application/json’ -d '{"name": "Samwise Gamgee", "role": "ring bearer"}'
```

# PART III

#### GET

```
curl -X GET http://localhost:8080/ratings/4
```

#### GET ERROR

```
curl -X GET http://localhost:8080/ratings/0
```

#### POST

```
curl -X POST http://localhost:8080/ratings/ -H ‘Content-type:application/json’ -d '{"user": "1234", "movie": "4321", "rating": 2, "timestamp": "1234"}'
```

#### PUT

```
curl -X PUT http://localhost:8080/ratings/ -H ‘Content-type:application/json’ -d '{"\_id":"ObjectId(1234)", "user": "1234", "movie": "4321", "rating": 2, "timestamp": "1234"}'
```
