// good at reasoning models after operations
// not good at modelling things over time
//    e.g. does the system ever deadlock? tla better for this

// A numeric time value representing a point it time
// Time must be a quantified property to compare time differences
let Time = {
  value: Int
}

// A reachable point in a travel graph
sig TravelStop {
  adj: set TravelStop
}

// Navigation should never need to take a self loop
fact NoTravelStopSelfLoops {
  no s: TravelStop | s in s.adj
}

// Connecting stops are bidirectional
fact TravelStopsAreBiDirectional {
  // To satisfy the reverse trip same length condition, stops must be bidirectional otherwise there may
  // be a shorter 1-way path that  does not exist for the reverse path
  all s: TravelStop | all s2: TravelStop | (s2 in s.adj and s in s2.adj) or (s2 not in s.adj and s not in s2.adj)
}

// A Route through a travel graph
sig Route {
  stops: seq TravelStop,
  leaveTime: Time,
  arriveTime: Time
}

//Always positive travel time
fact AlwaysPositiveTravelTime {
  all r: Route | r.arriveTime - r.leaveTime >= 0
}

// No empty routes
fact NoEmptyRoute {
  no r:Route | #r.stops = 0
}

// A stop sequence must be backed by a connected graph
pred RouteExists[r: Route] {
  //complicated without iteration
  //no r: Route | some i: Int | i in r.stops.inds and i not in r.stops.inds
}

// All travel stops in a route must be connected
fact AllRoutesConnected {
  all r: Route | RouteExists[r]
}

// Adjacent stops in a route are always different
fact NoSelfLoopsInARoute {
  // All adjacent pairs for a set of at least 2 elements
  // no r:Route, i: Int | i in r.stops.inds and #r.stops.subseq[i, i+1] < 2
}
// for simplicity, enforce a restriction of no cycles in a route (may be too restrictive for handling a u-turn)
fact NoLoopsInARoute {
  no r:Route | r.stops.hasDups
}

// A trip is a reverse trip if the start and end are reversed
pred reverseTrip[fr: Route, rr: Route] {
  fr.stops.first = rr.stops.last and fr.stops.last = rr.stops.first

  //alternatively to extend this further we will need:
  // a predicate capable of determining that a route is valid
  // a predicate determining a route is the shortest possible route.
  // This would require a decision about what determines the best route in terms of: time,
  // or number of stops and what to do in situations where there is a draw.
  //we could say a reverse trip is the reversal of another trip by definition. 
  fr.stops.first = rr.stops.last and fr.stops.last = rr.stops.first and  #fr.stops = #rr.stops
}

// Required Asserts

// A the reverse trip of a particular route should always have the same number of stops
assert ReverseTripSameSize {
  no fr: Route, rr: Route | reverseTrip[fr, rr] and #fr.stops != #rr.stops
}

// Routes with same start stop and end stop should only have one stop
assert NoCycleTrips {
  no r: Route | r.stops.first = r.stops.last and #r.stops != 1
}


check ReverseTripSameSize for 7 seq
check NoCycleTrips for 7 seq
