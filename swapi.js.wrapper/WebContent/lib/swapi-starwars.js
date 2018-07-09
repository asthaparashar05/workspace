var module = function () {
  var swapiApiURL = 'https://swapi.co/api/';

  //Function to call SWAPI get API based on URL
  function sendRequest(url, data) {
	var xhttp = new XMLHttpRequest();
	xhttp.open('get', url, true);
	xhttp.onreadystatechange = function() {
		console.log("xhttp.readyState: "+xhttp.readyState);
		 if (xhttp.readyState == 4 && xhttp.status == 200) {
			 data(JSON.parse(xhttp.responseText));
		     console.log("ok: "+data);
		 } else{
			 console.log("Error: "+xhttp.status);
		 }
	};
	//Setting headers for CORS
    xhttp.setRequestHeader('Accept', 'application/json');
    xhttp.setRequestHeader('Content-Type', 'application/json');
    xhttp.send();
  }
  
  //To get all the resources
  function getAllResources(data) {
	  sendRequest(swapiApiURL , data);
  }

  //To get all the data for a resource
  function getAllForResource(resourcePath,data) {
	  sendRequest(swapiApiURL + resourcePath + '/', data);
  }

  //To get a single record by id for a resource
  function getResourceById(resourcePath,id,data) {
	  sendRequest(swapiApiURL + resourcePath + '/'+id+'/', data);
  }
  
  //To get records by search fields for a resource
  function getReourceBySearchFields(resourcePath,searchValue,data) {
	  sendRequest(swapiApiURL + resourcePath + '/?search='+searchValue, data);
  }
  
  return{
	  getAllResources: getAllResources,
	  getAllForResource:  getAllForResource,
	  getResourceById: getResourceById, 
	  getReourceBySearchFields: getReourceBySearchFields
  };

}();

//To get root resource (with details of other resources)
function getAllResources() {
	module.getAllResources(function(data) {
		//Logging the response data on console and assigning it to a DOM element. Below code in the function can be changed as per the requirement.
		console.log("getAllResources data", data);
		var stringData=JSON.stringify(data, undefined, 4);
		document.getElementById("allResources").innerHTML = stringData;
	});
}

//To get all the data for a resource
function getAllForResource(resourcePath) {
	module.getAllForResource(resourcePath,function(data) {
		//Logging the response data on console and assigning it to a DOM element. Below code in the function can be changed as per the requirement.
		console.log("getAllForResource data", data);
		var stringData=JSON.stringify(data, undefined, 4);
		document.getElementById("resource").innerHTML = stringData;
	});
}

//To get a single record for people resource by id
function getPeopleById(id) {
	module.getResourceById('people',id,function(data) {
		//Logging the response data on console and assigning it to a DOM element. Below code in the function can be changed as per the requirement.
		console.log("getPeopleById data", data);
		var stringData=JSON.stringify(data, undefined, 4);
		document.getElementById("people").innerHTML = stringData;
	});
}

//To get a single record for films resource by id
function getFilmById(id) {
	module.getResourceById('films',id,function(data) {
		//Logging the response data on console and assigning it to a DOM element. Below code in the function can be changed as per the requirement.
		console.log("getFilmById data", data);
		var stringData=JSON.stringify(data, undefined, 4);
		document.getElementById("films").innerHTML = stringData;
	});
}

//To get a single record for starships resource by id
function getStarshipById(id) {
	module.getResourceById('starships',id,function(data) {
		//Logging the response data on console and assigning it to a DOM element. Below code in the function can be changed as per the requirement.
		console.log("getStarshipById data", data);
		var stringData=JSON.stringify(data, undefined, 4);
		document.getElementById("starships").innerHTML = stringData;
	});
}

//To get a single record for vehicles resource by id
function getVehicleById(id) {
	module.getResourceById('vehicles',id,function(data) {
		//Logging the response data on console and assigning it to a DOM element. Below code in the function can be changed as per the requirement.
		console.log("getVehicleById data", data);
		var stringData=JSON.stringify(data, undefined, 4);
		document.getElementById("vehicles").innerHTML = stringData;
	});
}

//To get a single record for species resource by id
function getSpeciesById(id) {
	module.getResourceById('species',id,function(data) {
		//Logging the response data on console and assigning it to a DOM element. Below code in the function can be changed as per the requirement.
		console.log("getSpeciesById data", data);
		var stringData=JSON.stringify(data, undefined, 4);
		document.getElementById("species").innerHTML = stringData;
	});
}

//To get a single resource for planets by id
function getPlanetById(id) {
	module.getResourceById('planets',id,function(data) {
		//Logging the response data on console and assigning it to a DOM element. Below code in the function can be changed as per the requirement.
		console.log("getPlanetById data", data);
		var stringData=JSON.stringify(data, undefined, 4);
		document.getElementById("planets").innerHTML = stringData;
	});
}

//To get resources based on the value of search fields
function getReourceBySearchFields(resourcePath,searchValue) {
	module.getReourceBySearchFields(resourcePath,searchValue,function(data) {
		//Logging the response data on console and assigning it to a DOM element. Below code in the function can be changed as per the requirement.
		console.log("getReourceBySearchField data", data);
		var stringData=JSON.stringify(data, undefined, 4);
		document.getElementById("search").innerHTML = stringData;
	});
}