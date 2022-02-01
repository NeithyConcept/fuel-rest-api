#Fuel REST API

An API to find fuel at the lowest price ⛽

##🚧 Install
**1. Clone the repository**

```
git clone https://github.com/NeithyConcept/fuel-rest-api.git
```

**2. Build and run the application with Maven**

```
mvn clean install
java -jar target/fuelapi-0.0.1-SNAPSHOT.jar
```

The application run at http://localhost:7070/

##🌍 Get a list of records by latitude/longitude

**Request**

`GET /search/{latitude}/{longitude}/{radius}`

```
curl -i -H 'Accept: application/json' http://localhost:7070/search/48.856614/2.3522219/10000
```

**Response**

```
HTTP/1.1 200
vary: accept-encoding
Content-Type: application/json
Transfer-Encoding: chunked
Date: Tue, 01 Feb 2022 14:10:29 GMT

{"parameters":{"citySearch":null,"rows":20,"sort":["update"]},"records":[{"id":"8e6a2c220fcbbe1bf2b38b33b0239b562bf5e633","fields":{"point":{"latitude":48.86115,"longitude":2.34107},"city":"PARIS","brand":"Oil France","name":"Halles garage sa.","address":"8,10,10bis Rue Bailleul","cp":"75001","lastUpdate":"2021-11-05T15:41:41+00:00","fuels":{"SP98":1.97,"GAZOLE":1.89,"SP95":1.94}}}]}
```

##📌 Get a list of records by city

**Request**

`GET /search/{city}`

```
curl -i -H 'Accept: application/json' http://localhost:7070/search/Marseillan
```

**Response**

```
HTTP/1.1 200
vary: accept-encoding
Content-Type: application/json
Transfer-Encoding: chunked
Date: Tue, 01 Feb 2022 14:14:07 GMT

{"parameters":{"citySearch":"Marseillan","rows":20,"sort":["update"]},"records":[{"id":"5b8066e5f763a58df2ce542eb22e70fdbddd07da","fields":{"point":{"latitude":43.35764,"longitude":3.51294},"city":"MARSEILLAN","brand":"Carrefour Market","name":"Carrefour Market","address":"Route de Bessan","cp":"34340","lastUpdate":"2022-01-31T08:15:12+00:00","fuels":{"SP98":1.784,"GAZOLE":1.644,"E10":1.704,"SP95":1.744}}}]}
```

##⛽ Get a list of fuel types

**Request**

`GET /fuels`

```
curl -i -H 'Accept: application/json' http://localhost:7070/fuels
```

**Response**

```
HTTP/1.1 200
vary: accept-encoding
Content-Type: application/json
Transfer-Encoding: chunked
Date: Tue, 01 Feb 2022 14:15:45 GMT

["E10","E85","GAZOLE","SP98","SP95","GPLC"]
```
