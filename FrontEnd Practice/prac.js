const rajnish = {
  firstname: "rajnish",
  lastname: "jaisankar",
  age: 22,
  college: "panimalar engineering college",
  deegree: "B.E",
  CGPA: 8.8,
  fullname: function () {
    return rajnish.firstname + " " + rajnish.lastname;
  },
};

const rajnishDOB = {
  date: 7,
  month: 10,
  year: 2002,
};

const merged = Object.assign(rajnish, rajnishDOB);

const splited = { ...rajnish, ...rajnishDOB };

let age = rajnish.age;

console.log(age);

// console.log(merged);
// console.log(splited);

const { firstname, lastname = "kolhi" } = rajnish;

console.log(firstname + " " + lastname);
    