jersey-lightweight-app
======================

### Learn jersey the hard way
* Jersey overview
* Starting codebase
* Swagger for API
* Guava: Predicates, Transform, Optional
* Builder pattern - immutable data
* immutable data structure -  immutableList, immutableSet

### Run App

* Run as web application

```
./gradlew jettyEclipseRun
or 
./gradlew jER
```
then you can access [http://localhost:8080/resources/sample/](http://localhost:8080/resources/sample/)

and you can see `{"message":"sample"}`

* Get JSON documentation

After the start, you can access
[http://localhost:8080/resources/api-docs/](http://localhost:8080/resources/api-docs)

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
[http://localhost:8080/resources/api-docs/sample/](http://localhost:8080/resources/api-docs/sample/)

```
{"apiVersion": "1.0.0", "swaggerVersion": "1.2", "basePath": "", 
"resourcePath": "/sample", "produces": ["application/json"], 
"apis": [
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
then you can access [http://localhost:8081/sample/](http://localhost:8081/sample/).

## Learn jersey in action

### order resource

* You need to complete *canCancelledOrders* in order resource, and the business logic is contained in *@ApiOperation*

### Questions

* Why don't need to register *JacksonFeature*?
* Jersey test cannot deserialize joda time from string value? 
 if you use List.class instead of new GenericType<List<Order>>(){},
 it will convert to List<LinkedHashMap<String, String>.

