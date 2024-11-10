let res = function (numberOne, numberTwo) {
  let addOne = adder(numberOne);
  let addTwo = adder(numberTwo);
  if (addOne > addTwo) {
    return numberOne;
  } else {
    return numberTwo;
  }
};

function adder(number) {
  let res = 0;
  while (number > 0) {
    let rem = number % 10;
    res += rem;
    number /= 10;
  }

  return res;
}

console.log(res(126, 124));
