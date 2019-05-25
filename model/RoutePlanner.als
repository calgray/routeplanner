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
sig Time {}

sig TravelStop {
  leaveTime: Time,
  arriveTime: Time
}

sig Route {
  stops: seq TravelStop
}

// The reverse trip is route containing all of the forwards
// route travel stops but in the reverse order
fun reverseTrip [fr: Route] : Route {
  fr // TODO: cannot iterate to reverse a sequnce..
}

// All stops in a route are unique
fact {
  all r:Route | #r.stops = #r.stops.elems
}

// Adjacent stops in a route are always different
fact {

}

//OP facts

// Routes with same start stop and end stop should only have one stop
fact NoCycleTrips {
  no r: Route | r.stops.first = r.stops.last and #r.stops > 1
}

// Required asserts

// Calculating the reverse trip should have the same number of items
assert ReverseTripSameSize {
  all r: Route | #r.stops.elems = #reverseTrip[r].stops.elems
}

// Routes with same start stop and end stop should only have one stop
assert NoCycleTrips {
  no r: Route | r.stops.first = r.stops.last and #r.stops > 1
}

check ReverseTripSameSize for 7 seq
check NoCycleTrips for 7 seq
