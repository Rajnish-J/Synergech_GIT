function classifyFruit(...fruits) {
  let ret = "";

  for (let i = 0; i < fruits.length; i++) {
    if (i === fruits.length - 1) {
      ret += fruits[i];
    } else {
      ret += fruits[i] + ", ";
    }
  }
  return ret;
}

// testcase 1:
console.log(classifyFruit("mango", "banana", "apple"));

// testcase 2:
console.log(classifyFruit("apple"));
