import Car from "./Car.mjs";

const c1 = new Car("4-Wheeler", "Petrol", "SUV", "Honda");

const c2 = Object.assign(Object.create(Object.getPrototypeOf(c1)), c1);

c2.carType = "sedan";

console.log("Details of C1: ");
c1.displayCarDetails();

console.log("Details of C2: ");
c2.displayCarDetails();
