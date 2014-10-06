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
then you can access [http://localhost:8080/service/sample/](http://localhost:8080/service/sample/)

and you can see `{"message":"sample"}`

* Get JSON documentation

After the start, you can access
[http://localhost:8080/service/api-docs/](http://localhost:8080/service/api-docs)

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
when you can access
[http://localhost:8080/service/api-docs/sample/](http://localhost:8080/service/api-docs/sample/)

```
{"apiVersion": "1.0.0", "swaggerVersion": "1.2", "basePath": "", "resourcePath": "/sample", "produces": ["application/json"], "apis": [
    {
        "path": "/sample",
        "operations": [
            {
                "method": "GET",
                "summary": "just to test the sample api",
                "notes": "",
                "type": "void",
                "nickname": "get",
                "parameters": []
            }
        ]
    }
]}
```
* Get swagger-ui documentation

After the start, you can access [http://localhost:8080/](http://localhost:8080/)

* Run as standalone application

```
./gradlew run
```
then you can access [http://localhost:8080/service/sample/](http://localhost:8080/service/sample/).
