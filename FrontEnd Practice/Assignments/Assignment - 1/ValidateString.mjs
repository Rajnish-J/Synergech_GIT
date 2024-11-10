import { Message } from "@mui/icons-material";

function validateString(str) {
  return new Promise((resolve, reject) => {
    for (let i = 0; i < str.length; i++) {
      const char = str.charAt(i);
      if (!((char >= "A" && char <= "Z") || (char >= "a" && char <= "z"))) {
        reject("Given string is not valid");
        return;
      }
    }
    resolve("Given string is valid");
  });
}

// Testcase 1:
validateString("Rajnish")
  .then((Message) => {
    console.log(Message);
  })
  .catch((Message) => {
    console.log(Message);
  });

// Testcase 2:
validateString("Rajnish123")
  .then((Message) => {
    console.log(Message);
  })
  .catch((Message) => {
    console.log(Message);
  });
