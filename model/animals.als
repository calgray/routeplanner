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

sig Edible {}

sig Plant extends Edible {}

sig Meat extends Edible {}

sig Animal extends Meat {
    eats: one Edible
    eatenBy: set Animal
}

sig Carnivore extends Animal { }

// 2.0 Transitive closure

// 2.1. The set of carnivors, which consists of all
// animals who eat meat 
fact CarnivoresEatMeat {
    all c: Carnivore -> eats Meat
}

// 2.2 The set of animals above a rabbit in the food chain
sig Rabbit {

}

sig Node, NodeList {}