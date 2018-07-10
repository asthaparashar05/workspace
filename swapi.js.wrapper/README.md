# Wrapper for SWAPI - Star Wars API

Basic wrapper for [SWAPI](https://swapi.co/) to access all the available resources.
Contains Javascript library to fetch the whole data or single resource by id or set of resources by search fields for each resource.

There are 7 resources - People, Films, Starships, Vehicles, Species, Planets and Root.

## The wrapper provides following cool functions:

### getAllResources():

Returns the root resource which has details about all the other resources.

### getAllForResource(resource):

Returns the whole data for the resource in the argument.
Example:
```javascript
getAllForResource("people")
``` 
This will return all the people resources present in SWAPI data source.

### getPeopleById(id): 

Returns a single people resource for the id passed as parameter.
Example:
```javascript
getPeopleById(1)
``` 
This will return the Person – ‘Luke Skywalker’ and all its details as it has Id 1.

### getFilmById(id):

Returns a single film resource for the id passed as parameter.
Example:
```javascript
getFilmById(1)
``` 
This will return the Film – ‘A New Hope’ and all the other attributes of the resource.

### getStarshipById(id):

Returns a single starship resource for the id passed as parameter.
Example:
```javascript
getStarshipById(9)
```
This will return the Starship – ‘Death Star’ and all its attributes.

### getVehicleById(id):

Returns a single vehicle resource for the id passed as parameter.
Example:
```javascript
getVehicleById(4)
```
This will return the Vehicle – ‘Sand Crawler’ and all its attributes.

### getSpeciesById(id):

Returns a single species resource for the id passed as parameter.
Example:
```javascript
getSpeciesById(3)
```
This will return the Species – ‘Wookie’ and all its attributes.

### getPlanetById(id):

Returns a single planet resource for the id passed as parameter.
Example:
```javascript
getPlanetById(1)
```
This will return the Planet – ‘Tatooine’ and all its attributes.

### getReourceBySearchFields(resourcePath,searchValue):

Returns set of resources for the resource as the given resourcePath argument and having the value of search fields as the searchValue argument.
Example:
```javascript
getReourceBySearchFields('people','Luke')
```
This will return the People resource with name – ‘Luke Skywalker’ and all its attributes.

---

There is also a `Getting-Started-Guide` attached to the project which you use to understand and how to use the library better.