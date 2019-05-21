// Your alloy model should go in here
sig Name, Addr {}
sig Book {
  addr: Name -> lone Addr
}

pred show() {}

run show for 3 but 1 Book
