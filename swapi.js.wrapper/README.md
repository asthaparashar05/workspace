# Wrapper for SWAPI - Star Wars API

Basic wrapper for [SWAPI](https://swapi.co/) to access all the available resources.
Contains functions to fetch the whole data or single record by id for each resource.

There are 7 resources People, Films, Starships, Vehicles, Species, Planets and Root.

### Below functions are supported by the wrapper:
##### getAllForResource(resource):
---
Returns the whole data for the resource in the argument.
Example:
```javascript
getAllForResource("people")
``` 

##### getPeopleById(id): 
---
Returns a single people resource for the id passed as parameter.
Example:
```javascript
getPeopleById(1)
``` 

##### getFilmById(id):
---
Returns a single film resource for the id passed as parameter.
Example:
```javascript
getFilmById(1)
``` 

##### getStarshipById(id):
---
Returns a single starship resource for the id passed as parameter.
Example:
```javascript
getStarshipById(1)
```

##### getVehicleById(id):
---
Returns a single vehicle resource for the id passed as parameter.
Example:
```javascript
getVehicleById(1)
```

##### getSpeciesById(id):
---
Returns a single species resource for the id passed as parameter.
Example:
```javascript
getSpeciesById(1)
```

##### getPlanetById(id):
---
Returns a single planet resource for the id passed as parameter.
Example:
```javascript
getPlanetById(1)
```