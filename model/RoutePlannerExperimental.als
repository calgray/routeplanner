// good at reasoning models after operations
// not good at modelling things over time
//    e.g. does the system ever deadlock? tla better for this

// A numeric time value representing a point it time
let Time = {
  i : Int | i > 0
}

sig TravelStop {
  adj: set TravelStop
}

fact NoTravelStopSelfLoops {
  no s: TravelStop | s in s.adj
}


fact StopsAreConnected {
  // Connecting stops are bidirectional
  // To satisfy the reverse trip same length condition, stops must be bidirectional otherwise there may
  // be a shorter 1-way path that  does not exist on the reverse path
  all s: TravelStop | all s2: TravelStop | (s2 in s.adj and s in s2.adj) or (s2 not in s.adj and s not in s2.adj)
  // A stop is always connected to another stop
  all s: TravelStop | s in s.^adj
  // A stop must always have at least path to another stop
  // all s: TravelStop | #s.adj != 0
}

sig Route {
  stops: seq TravelStop,
  leaveTime: Time,
  arriveTime: Time
}

// No empty routes
fact NoEmptyRoute {
  no r:Route | #r.stops = 0
}

//Always positive travel time
fact AlwaysPositiveTravelTime {
  all r: Route | r.arriveTime - r.leaveTime >= 0
}

pred RouteExists[r: Route] {
  no r: Route | some i: Int | i in r.stops.inds and i not in r.stops.inds
}

fact AllRoutesExist {
  all r: Route | RouteExists[r]
}

// A trip is a reverse trip if the start and end are reversed
pred reverseTrip[fr: Route, rr: Route] {
  fr.stops.first = rr.stops.last and fr.stops.last = rr.stops.first
 // for simplicity, we could infer a reverse route has the same number of stops..
  //fr.stops.first = rr.stops.last and fr.stops.last = rr.stops.first and #fr.stops = #rr.stops
}

// Adjacent stops in a route are always different
fact AdjacentStopAlwaysDifferent {
  // All adjacent pairs for a set of at least 2 elements
  //no r:Route, i: Int | i in r.stops.inds and #r.stops.subseq[i, i+1] < 2
  // for simplicity, enforce a restriction of no cycles in a route (may be too restrictive for handling a u-turn)
  no r:Route | r.stops.hasDups
}

// Routes should be the shortest connection of travel stops
pred ShortestRoute[r: Route] {
  //no r:Route | r.stops.first.^adj
}

// Derived Assert

//assert ARouteExists {
//  some r: Route | all s, s2: TravelStop | r.stops.first = s and r.stops.last = s2
//}
//check ARouteExists for 7 seq


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
