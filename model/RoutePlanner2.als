// Your alloy model should go in here

// instances: one, lone, all, no, some

// sig : Signature
// fact: contains predicates
// assert: contains predicates
// pred: Predicate - function that returns a boolean

// Root.*contents : reflexive transitive closure
// d.^contents : (non-flective) transitive closure
//  .^bar equivalent to (bar + bar.bar + bar.bar + bar.bar.bar)
// run
// show
// but
// some



// good at reasoning models after operations
// not good at modelling things over time
//    e.g. does the system ever deadlock? tla better for this

// A numeric time value representing a point it time
let Time = {
  i : Int | i > 0
}

sig TravelStop {}

sig Route {
  stops: seq TravelStop,
  leaveTime: Time,
  arriveTime: Time
}

// The reverse trip is route containing all of the forwards
// route travel stops but in the reverse order
fun reverseTrip [fr: Route] : Route {
  fr // TODO: cannot iterate to reverse a sequnce..
}

fun reverseStops [stops: seq TravelStop] : seq TravelStop {
  stops
}

//Always positive travel time
fact AlwaysPositiveTravelTime {
  all r: Route | r.arriveTime - r.leaveTime >= 0
}

// Adjacent stops in a route are always different
fact {
  // All adjacent pairs for a set of at least 2 elements
  //no r:Route | some i: Int | r.stops.subseq[i, i+1].hasDups
  no r:Route | some i: Int | #r.stops.subseq[i, i+1].elems < 2
  //no r:Route | r.stops.hasDups
}

// Required asserts

// Calculating the reverse trip should have the same number of items
assert ReverseTripSameSize {
  all r: Route, s: r.stops | #reverseStops[s] = #s
  //all r: Route | #r.stops = #reverseTrip[r].stops
}

// Routes with same start stop and end stop should only have one stop
assert NoCycleTrips {
  no r: Route, s: r.stops | s.first = s.last and #s > 1
}

check ReverseTripSameSize for 7 seq
check NoCycleTrips for 7 seq
