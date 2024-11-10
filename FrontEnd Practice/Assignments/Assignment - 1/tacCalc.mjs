function processPayroll(
  basicPay,
  basicTaxPercentage,
  specialAllowance,
  specialAllowanceTax
) {
  try {
    if (basicTaxPercentage === 0) {
      throw new Error("Basic Tax percentage could not be zero");
    }
    if (specialAllowanceTax === 0) {
      throw new Error("Special allowance tax could not be zero");
    }

    if (basicPay < 10000) {
      throw new Error("Basic pay could not be < 10000");
    }

    return (
      (basicPay * basicTaxPercentage + specialAllowance * specialAllowanceTax) /
      100
    );
  } catch (e) {
    console.log("Error: " + e.message);
  }
}

// testcase 1:
console.log(processPayroll(15000, 14, 10000, 7));

// testcase 2:
processPayroll(0, 14, 10000, 7);

// testcase 3:
processPayroll(15000, 0, 10000, 7);

// Testcase 4:
processPayroll(15000, 14, 10000, 0);
