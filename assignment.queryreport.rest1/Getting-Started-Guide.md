# Getting Started

## Introduction

This project introduces a wrapper to [SWAPI](https://swapi.co/) (Star Wars API) data source.

SWAPI is an open source data source giving access to Star Wars data as RESTful APIs.

SWAPI has 6 resources, People, Films, Starships, Species, Vehicles and Planet and a Root resource which has information about other resources.

It provides an easy interface to access the complete resource data or resources based id or search fields by API URLs. The response data is in simple JSON format which you can easily play around with.

  
## Installation

No installation needed. There is a Javascript Library which you can use directly by placing in your project or extended it based on the requirement.

  
## How to use

The project provides a basic Javascript library `WebContent/lib/swapi-starwars.js` which can be directly used and extended.

It has functions to access all the APIs provided by SWAPI to access its resources. You can modify the functions and also use frameworks to integrate with UI/backend as per your need.

The functions are described below in detail to help you understand and use the library.

<enter>

* __getAllResources:__

This function internally calls a method which calls the root URL and returns the data of Root resource.
It internally calls the URL `https://swapi.co/api/`

Method Call:
```javascript
getAllResources
``` 

Sample output:
```
{
    "films": "https://swapi.co/api/films/",
    "people": "https://swapi.co/api/people/",
    "planets": "https://swapi.co/api/planets/",
    "species": "https://swapi.co/api/species/",
    "starships": "https://swapi.co/api/starships/",
    "vehicles": "https://swapi.co/api/vehicles/"
}
```

* __getAllForResource:__

This function takes resource name as argument and returns the whole data of that resource. You can further use this data as per your wish for comparing or sorting etc.
It internally calls the URL `https://swapi.co/api/{resource_name}/`

Method Call:
```javascript
getAllForResource("vehicles")
``` 

* __getPeopleById:__

This function takes an id as argument and returns a single People resource with the given id.
It internally calls the URL `https://swapi.co/api/people/{id}/`

Method Call:
```javascript
getPeopleById(1)
``` 

Sample output:
```
{
    "birth_year": "19 BBY",
    "eye_color": "Blue",
    "films": [
        "https://swapi.co/api/films/1/",
        ...
    ],
    "gender": "Male",
    "hair_color": "Blond",
    "height": "172",
    "homeworld": "https://swapi.co/api/planets/1/",
    "mass": "77",
    "name": "Luke Skywalker",
    "skin_color": "Fair",
    "created": "2014-12-09T13:50:51.644000Z",
    "edited": "2014-12-10T13:52:43.172000Z",
    "species": [
        "https://swapi.co/api/species/1/"
    ],
    "starships": [
        "https://swapi.co/api/starships/12/",
        ...
    ],
    "url": "https://swapi.co/api/people/1/",
    "vehicles": [
        "https://swapi.co/api/vehicles/14/"
        ...
    ]
}
```

* __getFilmById:__

This function takes an id as argument and returns a single Film resource with the given id.
It internally calls the URL `https://swapi.co/api/films/{id}/`

Method Call:
```javascript
getFilmById(1)
``` 

Sample output:
```
{
    "characters": [
        "https://swapi.co/api/people/1/",
        ...
    ],
    "created": "2014-12-10T14:23:31.880000Z",
    "director": "George Lucas",
    "edited": "2014-12-12T11:24:39.858000Z",
    "episode_id": 4,
    "opening_crawl": "It is a period of civil war.\n\nRebel spaceships, striking\n\nfrom a hidden base, have won\n\ntheir first victory against\n\nthe evil Galactic Empire.\n\n\n\nDuring the battle, Rebel\n\nspies managed to steal secret\r\nplans to the Empire's\n\nultimate weapon, the DEATH\n\nSTAR, an armored space\n\nstation with enough power\n\nto destroy an entire planet.\n\n\n\nPursued by the Empire's\n\nsinister agents, Princess\n\nLeia races home aboard her\n\nstarship, custodian of the\n\nstolen plans that can save her\n\npeople and restore\n\nfreedom to the galaxy....",
    "planets": [
        "https://swapi.co/api/planets/1/",
        ...
    ],
    "producer": "Gary Kurtz, Rick McCallum",
    "release_date": "1977-05-25",
    "species": [
        "https://swapi.co/api/species/1/",
        ...
    ],
    "starships": [
        "https://swapi.co/api/starships/2/",
        ...
    ],
    "title": "A New Hope",
    "url": "https://swapi.co/api/films/1/",
    "vehicles": [
        "https://swapi.co/api/vehicles/4/",
        ...
    ]
}
```

* __getStarshipById:__

This function takes an id as argument and returns a single Starship resource with the given id.
It internally calls the URL `https://swapi.co/api/starships/{id}/`

Method Call:
```javascript
getStarshipById(9)
``` 

Sample output:
```
{
    "MGLT": "10 MGLT",
    "cargo_capacity": "1000000000000",
    "consumables": "3 years",
    "cost_in_credits": "1000000000000",
    "created": "2014-12-10T16:36:50.509000Z",
    "crew": "342953",
    "edited": "2014-12-10T16:36:50.509000Z",
    "hyperdrive_rating": "4.0",
    "length": "120000",
    "manufacturer": "Imperial Department of Military Research, Sienar Fleet Systems",
    "max_atmosphering_speed": "n/a",
    "model": "DS-1 Orbital Battle Station",
    "name": "Death Star",
    "passengers": "843342",
    "films": [
        "https://swapi.co/api/films/1/"
    ],
    "pilots": [],
    "starship_class": "Deep Space Mobile Battlestation",
    "url": "https://swapi.co/api/starships/9/"
}
```

* __getVehicleById:__

This function takes an id as argument and returns a single Starship resource with the given id.
It internally calls the URL `https://swapi.co/api/vehicles/{id}/`

Method Call:
```javascript
getVehicleById(4)
``` 

Sample output:
```
{
    "cargo_capacity": "50000",
    "consumables": "2 months",
    "cost_in_credits": "150000",
    "created": "2014-12-10T15:36:25.724000Z",
    "crew": "46",
    "edited": "2014-12-10T15:36:25.724000Z",
    "length": "36.8",
    "manufacturer": "Corellia Mining Corporation",
    "max_atmosphering_speed": "30",
    "model": "Digger Crawler",
    "name": "Sand Crawler",
    "passengers": "30",
    "pilots": [],
    "films": [
        "https://swapi.co/api/films/1/"
    ],
    "url": "https://swapi.co/api/vehicles/4/",
    "vehicle_class": "wheeled"
}
```

* __getSpeciesById:__

This function takes an id as argument and returns a single Starship resource with the given id.
It internally calls the URL `https://swapi.co/api/species/{id}/`

Method Call:
```javascript
getSpeciesById(3)
``` 

Sample output:
```
{
    "average_height": "2.1",
    "average_lifespan": "400",
    "classification": "Mammal",
    "created": "2014-12-10T16:44:31.486000Z",
    "designation": "Sentient",
    "edited": "2014-12-10T16:44:31.486000Z",
    "eye_colors": "blue, green, yellow, brown, golden, red",
    "hair_colors": "black, brown",
    "homeworld": "https://swapi.co/api/planets/14/",
    "language": "Shyriiwook",
    "name": "Wookie",
    "people": [
        "https://swapi.co/api/people/13/"
    ],
    "films": [
        "https://swapi.co/api/films/1/",
        "https://swapi.co/api/films/2/"
    ],
    "skin_colors": "gray",
    "url": "https://swapi.co/api/species/3/"
}
```

* __getPlanetById:__

This function takes an id as argument and returns a single Starship resource with the given id.
It internally calls the URL `https://swapi.co/api/planets/{id}/`

Method Call:
```javascript
getPlanetById(1)
``` 

Sample output:
```
{
    "climate": "Arid",
    "created": "2014-12-09T13:50:49.641000Z",
    "diameter": "10465",
    "edited": "2014-12-15T13:48:16.167217Z",
    "films": [
        "https://swapi.co/api/films/1/",
        ...
    ],
    "gravity": "1",
    "name": "Tatooine",
    "orbital_period": "304",
    "population": "120000",
    "residents": [
        "https://swapi.co/api/people/1/",
        ...
    ],
    "rotation_period": "23",
    "surface_water": "1",
    "terrain": "Dessert",
    "url": "https://swapi.co/api/planets/1/"
}
```

* __getReourceBySearchFields:__

This function takes resource name and value of search field as arguments and returns a set of resources having the given search field value. It uses use case-insensitive partial matches and internally calls the URL `https://swapi.co/api/{resourceName}/?search={searchFieldValue}`

Method Call:
```javascript
getPlanetById(1)
``` 

Sample output:
```
{
    "climate": "Arid",
    "created": "2014-12-09T13:50:49.641000Z",
    "diameter": "10465",
    "edited": "2014-12-15T13:48:16.167217Z",
    "films": [
        "https://swapi.co/api/films/1/",
        ...
    ],
    "gravity": "1",
    "name": "Tatooine",
    "orbital_period": "304",
    "population": "120000",
    "residents": [
        "https://swapi.co/api/people/1/",
        ...
    ],
    "rotation_period": "23",
    "surface_water": "1",
    "terrain": "Dessert",
    "url": "https://swapi.co/api/planets/1/"
}
```