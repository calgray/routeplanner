// Your alloy model should go in here

// sig : Signature
// pred: Predicate - function that returns a boolean
// run
// show
// but
// some

// good at reasoning models after operations
// not good at modelling things over time
//    e.g. does the system ever deadlock? tla better for this

// daphne from microsoft

sig Name, Addr {}

sig Book {
  addr: Name -> lone Addr
}

pred show(b: Book) {
  #b.addr > 1
  some n: Name | #n.(b.addr) > 1
}

// pred show() {}

run show for 3 but 1 Book
