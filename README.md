# Project Startup Instruction Through || Iskraemeco

## Run

`$ docker-compose build && docker-compose up`

## Verify the application is running

> Application listens on port 8080.

```
$ http get :8080/BHR

{
   "name":"Bahrain",
   "continent":"Asia",
   "population":617000,
   "life_expectancy":73,
   "country_language":"Arabic"
}

HTTP/1.1 200
Connection: keep-alive

```