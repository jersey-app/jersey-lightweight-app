jersey-lightweight-app
======================

### Learn jersey the hard way
* Jersey overview
* Starting codebase (a echo app)
* Swagger for API
* Guava: Predicate, Transform
* Builder pattern

### Run App

* Run as web application

```
./gradlew jettyEclipseRun
or 
./gradlew jER
```
then you can access [http://localhost:8080/sample/](http://localhost:8080/sample/)

and you can see `{"message":"sample"}`

* Get JSON documentation

After the start, you can access
[http://localhost:8080/api-docs/](http://localhost:8080/api-docs)

and you can see

```
{"apiVersion": "1.0.0", 
 "swaggerVersion": "1.2", 
 "apis": [
    {
        "path": "/sample",
        "description": "A sample of jersey application"
    }]
}
```


* Run as standalone application

```
./gradlew run
```
then you can access [http://localhost:8081/sample/](http://localhost:8081/sample/).
