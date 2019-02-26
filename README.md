# SBootConnectedCities

Steps in development:
-----------
1) Using spring initializer, download a simple springboot application and its pom.xml. 
Selecting web in the modules 
  Enable Swagger for ease of use

2) interface for: Mechanism to fetch the connected cities through a file
3) extend the above interface to fetch the source from a file. Have a CSV file in resource folder

4) Add a controller and URL mapping by name /isConnected?source=<<>>&destination=<<>>
   I have to make an assumption that HTTP.GET request is sufficient.

5) Choice of a data-structure:
  Map<StartCity-String,LinkedListSet<ConnectedCities> 
   >Map is the best fit to store Key value pairs
   >LinkedSet would take care of duplicates, variable length 
   of cities connected to parent. 
   And performance of retrieval would be anyways same with arraylist because sequential access.  

6) functions required
   a> addConnections (C1, C2)// this will add 2 map entries C1 nd C2 with cities its directly connected to. 
   b> isConnected(c1, c2)
      with C1 as origin it'll try to find connected cities indirectly until C2 is found. if found returns yes. This would be a recursive call. else once all paths are traversed we return no. we will keep track of all Visited Sources in visitedCitiesin order to finally arrive with No          

7> classes identified
  a> FileReader extends ConnectionReader
  b> ConnectionCatlogue
      addConnection(..)
      isConnected(..)
        

8> testCases for ConnectionCatlogue
-------------------

>>>Assumptions: I understand assumptions should be resolved by raising questions.
Please consider assumptions as questions in case of F2F test

1) Its not coded for multi threading

Please read the file DevelopersNote.txt
