let currentuser = 0;

document.getElementById("sign-in-fun").addEventListener("click", function () {
  signinfetch();
});

//sign in fetch checking

function signinfetch() {
  // Define the login data object
  currentuser = document.getElementById("sign-user").value;
  console.log(currentuser);
  const logindata = {
    username: document.getElementById("sign-user").value,
    password: document.getElementById("sign-password").value,
  };

  // Define the fetch options
  const options = {
    method: "POST",
    body: JSON.stringify(logindata),
    headers: {
      "Content-Type": "application/json",
    },
  };

  // Send the fetch request to the server
  fetch("http://localhost:8080/busticket/login", options)
    .then((response) => {
      if (response.ok) {
        // If the login is successful, redirect to user.html
        window.location.href = "/User/user.html";
        return "Login successful";
      } else {
        throw new Error("Login failed");
      }
    })
    .then((message) => console.log(message))
    .catch((error) => console.error(error));
}
//end of fetch
