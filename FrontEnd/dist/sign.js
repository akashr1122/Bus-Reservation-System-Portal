document.getElementById("sign-in-fun").addEventListener("click", function () {
  signinfetch();
});

//sign in fetch checking

function signinfetch() {
  // Define the login data object

  // Define the fetch options
  const options = {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
    },
  };

  // Send the fetch request to the server
  fetch(
    `http://localhost:8080/busticket/login/${
      document.getElementById("sign-user").value
    }/${document.getElementById("sign-password").value}`,
    options
  )
    .then((res) => res.json())
    .then((resu) => {
      if (resu.message) {
        let mes = resu.message;
        showSpani1(mes);
        console.log(resu.message);
      } else if (resu.admin == true) {
        console.log(resu.username);
        console.log(resu);
        window.location.href = "/admin/admin.html";
        localStorage.setItem("user", resu.username);
        localStorage.setItem("userId", resu.userId);
      } else {
        console.log(resu.username);
        console.log(resu);

        window.location.href = "/User/user.html";
        localStorage.setItem("user", resu.username);
        localStorage.setItem("userId", resu.userId);
      }
      console.log(resu);
    });
}
//end of fetch

document.getElementById("my-span-i1").addEventListener("click", function () {
  this.style.display = "none";
});

//end of span tag

//span tag showing function

function showSpani1(message) {
  document.getElementById("my-span-i1").style.display = "inline-block";
  document.getElementById("my-span-i1").innerText = message;
}
