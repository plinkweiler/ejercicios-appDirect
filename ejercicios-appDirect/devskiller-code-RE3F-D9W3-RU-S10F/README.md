# Introduction

You are working on an application that is responsible for managing flights data 

# Problem statement

To complete this task you should fulfill following requirements:

1. Implement `SeatsGenerator#createSeats(int rows, int seatsInRow, int firstRowNumber)` - which should generate a `Set` of Seats for passed arguments. Each seat should have a number assigned in following format: `<row_number><seat_in_a_row>` where `<row_number>` is a decimal number of row and `<seat_in_a_row>` is a capital letter. For example, if you pass `rows=2`, `seatsInRow=4`, `firstRowNumber=1`, following seats should be generated:
```
1A 1B 1C 1D
2A 2B 2C 2D
```
2. Implement `FlightManager#findFlightsBetween(String origin, String destination, boolean directionSensitive)` - which should return a `Set` of flights between passed airports. If `directionSensitive` is equal to `false`, then method should return all flight from `origin` to `desitination` **AND** from `destintation` to `origin`. For example, if following flights are available: 
```
WAW->MUC
JFK->PAR
PAR->JFK
```
Following flights should be returned for `origin=JFK,destination=PAR,directionSensitive=false`:
```
JFK->PAR,PAR->JFK
```
3. Make sure that `FlightManager` contains only unique flights - flights set should never contain two flights with the same `flightNo`. Please, complete this requirement by modyfing only a `Flight` class.