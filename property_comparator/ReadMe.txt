==================================================================================================
Overview:
==================================================================================================

Here is my completed Back-End Developer technical test.
This has also been added to my GitHub: https://github.com/Ku-Ni/PropertyComparator
I created a web service using the CSV data file as a repository, with end points based on the assignment questions.

There are three end points:

---------------------------
GET /average-price/postcode
---------------------------
Takes a string parameter named postcode and returns the average price for properties matching the supplied value outward as a 
JSON result, will return exception if no results for the supplied postcode is found.

e.g. GET /average-price/postcode?postcode=W1F returns 
{
    "postcode": "W1F",
    "propertyType": null,
    "averagePrice": 1158750
}

--------------------------------------------
GET /average-price-difference/property-types
--------------------------------------------
Takes two string parameters named property-type1 and property-type2 and returns a JSON object containing an array with the 
average prices for each property type and the difference between the two types.
The supplied parameters must be valid property types (Mansion,Flat,Detached,Terraced)

e.g. GET /average-price-difference/property-types?property-type1=Detached&property-type2=Flat returns
{
    "propertyTypes": [
        {
            "postcode": null,
            "propertyType": "DETACHED",
            "averagePrice": 320579.125
        },
        {
            "postcode": null,
            "propertyType": "FLAT",
            "averagePrice": 363999.75
        }
    ],
    "priceDifference": 43420.625
}

------------------------------
GET /properties/top-percentage
------------------------------
Takes double parameter name percentage and retrieves the top percentage of properties ordered by descending price value.
Properties outside the matched percentage, but which are valued the same as properties inside, will also be included 
in the result.
The method will only use the absolute value of the supplied percentage.
e.g. GET /properties/top-percentage?percentage=10 returns
[
    {
        "propertyReference": 12,
        "price": 7500000,
        "bedrooms": 11,
        "bathrooms": 4,
        "houseNumber": "",
        "address": "Brighton Road",
        "region": "Surrey",
        "postcode": "GU13 4DD",
        "propertyType": "MANSION"
    },
    {
        "propertyReference": 13,
        "price": 2500000,
        "bedrooms": 7,
        "bathrooms": 2,
        "houseNumber": "1",
        "address": "Station Road",
        "region": "London",
        "postcode": "W1F 3UT",
        "propertyType": "MANSION"
    }
] 	 


==================================================================================================
Build and run:
==================================================================================================
The project uses Java8, Spring-Boot and Maven.
To build the code, run as Maven build with goals: clean package, which will build an executable
jar.

The jar can then be executed just like any other application (assuming Java has been correctly 
setup on the executing system). 
The application will then start an internal Tomcat service which will run a localhost listening
on port 8080, so all endpoints can be accessed from http://localhost:8080.

For ease of use, I've enabled the shutdown end point, this will allow any user to shutdown the
application by calling POST /shutdown.


