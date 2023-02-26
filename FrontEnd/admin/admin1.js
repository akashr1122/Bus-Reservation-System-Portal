//span message
let mess;

//get all fetching

// let x = document.getElementById("GetAll");
// x.addEventListener(onclick, getAll());

function getAll() {
  fetch("http://localhost:8080/busticket/buseses")
    .then((res) => res.json())
    .then((resu) => {
      console.log(resu);
      getAllinHtml(resu);
    });
}

//get all appending in html page bus data;

function getAllinHtml(databus) {
  if (databus.length == 0) {
    return
  }
  let cards = document.querySelector(".card");


  cards.innerHTML = "";

  cards.style.display = "grid";
  cards.style.gridTemplateColumns = "repeat(auto-fill,350px)";
  cards.style.gridColumnGap = "3%";
  cards.style.gridRowGap = "20%";
  cards.style.justifyContent = "center";
  cards.style.padding = "2%";

  databus.forEach((ele) => {
    let busid = document.createElement("span");
    busid.innerText = "Bus ID : " + ele.busId;

    let busname = document.createElement("span");
    busname.innerText = "Bus Name : " + ele.busName;

    let busseats = document.createElement("span");
    busseats.innerText = "Capacity : " + ele.seats;

    let busfrom = document.createElement("span");
    busfrom.innerText = "From : " + ele.routeFrom;

    let busto = document.createElement("span");
    busto.innerText = "To : " + ele.routeTo;

    let busaseats = document.createElement("span");
    busaseats.innerText = "Seats Avl : " + ele.availableSeats;

    let busupdate = document.createElement("button");
    busupdate.innerText = "Update";
    busupdate.setAttribute("id", "update-btn");
    // busupdate.style.backgroundColor = "limegreen";

    busupdate.style.borderRadius = "10px";

    busupdate.style.border = "0px";
    busupdate.onclick = function () {
      updateBusTicket(ele);
    };

    let busdelete = document.createElement("button");
    busdelete.innerText = "Delete";
    busdelete.setAttribute("id", "delete-btn");
    busdelete.style.borderRadius = "10px";

    busdelete.style.border = "0px";
    busdelete.onclick = function () {
      deleteBusTicket("http://localhost:8080/busticket/bus/", ele.busId);
    };

    let busdiv = document.createElement("div");
    busdiv.style.border = "inset";
    busdiv.style.margin = "1%";
    busdiv.style.display = "grid";
    busdiv.style.gridTemplateColumns = "2fr 2fr";
    busdiv.append(
      busid,
      busname,
      busseats,
      busaseats,
      busfrom,
      busto,
      busupdate,
      busdelete
    );

    cards.append(busdiv);

    //id time type availableseats totalseats route from route to
    //update delete
  });
}

//deleting a bus

function deleteBusTicket(url1, bId) {
  fetch(`${url1}${bId}`, {
    method: "DELETE",
  })
    .then((response) => {
      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
      }
      mess = `Bus ticket with ID ${bId} deleted successfully.`;
      console.log(`Bus ticket with ID ${bId} deleted successfully.`);
      showSpan(mess);
      getAll();
    })
    .catch((error) => {
      mess = `Error while deleting bus ticket with ID ${bId}: ${error}`;
      console.error(`Error while deleting bus ticket with ID ${bId}: ${error}`);
      showSpan(mess);
      getAll();
    });
}

function deleteUserTicket(url1, bId) {
  fetch(`${url1}${bId}`, {
    method: "DELETE",
  })
    .then((response) => {
      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
      }
      mess = `User ticket with ID ${bId} deleted successfully.`;
      console.log(`User ticket with ID ${bId} deleted successfully.`);
      showSpan3(mess);
      getAll();
    })
    .catch((error) => {
      mess = `Error while deleting User ticket with ID ${bId}: ${error}`;
      console.error(`Error while deleting User ticket with ID ${bId}: ${error}`);
      showSpan3(mess);
    });
}

//update the bus

function updateBusTicket(bus) {
  // Create a new popup window
  // const popup = window.open("", "", "width=400,height=600");

  openPopup();
  const popup = document.querySelector("#popup");

  // Create the form HTML
  const formHtml = `
    <h2>Update Bus Ticket</h2>
    <form id="pop-form">
      <div>
        <label for="busName">Bus Name:</label>
        <input type="text" id="busName" name="busName" value="${bus.busName}">
      </div>
      <div>
        <label for="busType">Bus Type:</label>
        <select id="busType" name="busType">
          <option value="AC_SLEEPER" ${bus.busType === "AC_SLEEPER" ? "selected" : ""
    }>AC Sleeper</option>
          <option value="AC_SEATER" ${bus.busType === "AC_SEATER" ? "selected" : ""
    }>AC Seater</option>
          <option value="VOLVO_AC" ${bus.busType === "VOLVO_AC" ? "selected" : ""
    }>VOLVO AC</option>
          <option value="NONAC_SEATER" ${bus.busType === "NONAC_SEATER" ? "selected" : ""
    }>NONAC SEATER</option>
          <option value="NONAC_SLEEPER" ${bus.busType === "NONAC_SLEEPER" ? "selected" : ""
    }>NONAC SLEEPER</option>
        </select>
      </div>
      <div>
        <label for="routeFrom">Route From:</label>
        <input type="text" id="routeFrom" name="routeFrom" value="${bus.routeFrom
    }">
      </div>
      <div>
        <label for="routeTo">Route To:</label>
        <input type="text" id="routeTo" name="routeTo" value="${bus.routeTo}">
      </div>
      <div>
        <label for="arrivalTime">Arrival Time:</label>
        <input type="time" id="arrivalTime" name="arrivalTime" step="2" value="${bus.arrivalTime
    }">
      </div>
      <div>
        <label for="seats">Total Seats:</label>
        <input type="number" id="seats" name="seats" value="${bus.seats}">
      </div>
      <div>
        <label for="availableSeats">Available Seats:</label>
        <input type="number" id="availableSeats" name="availableSeats" value="${bus.availableSeats
    }">
      </div>
      <div>
        <button type="submit" id="submitBtn">Submit</button>
        <button type="button" id="cancelBtn">Cancel</button>
      </div>
    </form>
  `;

  // Add the form HTML to the popup window
  // popup.document.body.innerHTML = formHtml;
  popup.innerHTML = formHtml;

  // Get references to the form elements
  const form = popup.querySelector("form");
  const submitBtn = popup.querySelector("#submitBtn");
  const cancelBtn = popup.querySelector("#cancelBtn");

  // Add event listeners to the form elements
  form.addEventListener("submit", (event) => {
    event.preventDefault();

    const updatedBus = {
      busId: bus.busId,
      busName: popup.querySelector("#busName").value,
      busType: popup.querySelector("#busType").value,
      routeFrom: popup.querySelector("#routeFrom").value,
      routeTo: popup.querySelector("#routeTo").value,
      arrivalTime: popup.querySelector("#arrivalTime").value,
      seats: parseInt(popup.querySelector("#seats").value),
      availableSeats: parseInt(popup.querySelector("#availableSeats").value),
    };
    console.log(updatedBus);
    // Send the updated bus object to the server using a fetch() request
    fetch("http://localhost:8080/busticket/bus", {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(updatedBus),
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error(`HTTP error! status: ${response.status}`);
        }
        mess = `Bus ticket with ID ${bus.busId} updated successfully.`;
        console.log(`Bus ticket with ID ${bus.busId} updated successfully.`);
        showSpan(mess);
        // popup.close(); // close the popup window
        closePopup();
        getAll();
      })
      .catch((error) => {
        mess = `Error while updating bus ticket with ID ${bus.busId}: ${error}`;
        console.error(
          `Error while updating bus ticket with ID ${bus.busId}: ${error}`
        );
        showSpan(mess);
        closePopup();
        getAll();
      });
  });

  cancelBtn.addEventListener("click", () => {
    // popup.close(); // close the popup window
    closePopup();
  });
}
//end of form

// popup js

function openPopup() {
  document.getElementById("popup").style.display = "block";
}

function closePopup() {
  document.getElementById("popup").style.display = "none";
}

//endof popup js

//span tag msg hide and unhide on click

document.getElementById("my-span").addEventListener("click", function () {
  this.style.display = "none";
});

//end of span tag

//span tag showing function

function showSpan(message) {
  document.getElementById("my-span").style.display = "inline-block";
  document.getElementById("my-span").innerText = message;
}

function showSpan2(message) {
  document.getElementById("my-span2").style.display = "inline-block";
  document.getElementById("my-span2").innerText = message;
}

function showSpan3(message) {
  document.getElementById("my-span3").style.display = "inline-block";
  document.getElementById("my-span3").innerText = message;
}

function showSpan4(message) {
  document.getElementById("my-span4").style.display = "inline-block";
  document.getElementById("my-span4").innerText = message;
}
document.getElementById("my-span4").addEventListener("click", function () {
  this.style.display = "none";
});
document.getElementById("my-span3").addEventListener("click", function () {
  this.style.display = "none";
});
document.getElementById("my-span2").addEventListener("click", function () {
  this.style.display = "none";
});
//span tag closing function

//add new bus fetch api
let addbusobject;

const formnewbus = document.querySelector("#my-form-add"); // assuming the form has an ID of "myForm"
formnewbus.addEventListener("submit", (event) => {
  event.preventDefault(); // prevent the default form submit behavior

  addbusobject = {
    busName: document.getElementById("busName").value,
    busType: document.getElementById("busType").value,
    routeFrom: document.getElementById("routeFrom").value,
    routeTo: document.getElementById("routeTo").value,
    arrivalTime: document.getElementById("arrivalTime").value,
    seats: document.getElementById("seats").value,
    availableSeats: document.getElementById("availableSeats").value,
  };

  console.log(addbusobject);
  const url = "http://localhost:8080/busticket/bus";
  put(url, addbusobject)


});

function put(url, data) {
  fetch(url, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(data),
  })
    .then((response) => response.json())
    .then((data) => {
      //showSpan2("Bus Add Successfully");
      document.getElementById("my-form-add").reset();
      document.getElementById("add_route").reset();

    })
    .catch((error) => showSpan2("Bus Not Added " + error));
}
//end add new bus



//----------add rout---------------//
document.querySelector(".rout_form").addEventListener("submit", function () {
  let rout_from = document.getElementById("From").value;
  let rout_to = document.getElementById("To").value;
  let rout_Distence = document.getElementById("Distence").value;
  console.log(rout_from, rout_to, rout_Distence)
  let data = {
    routeFrom: rout_from,
    routeTo: rout_to,
    distance: rout_Distence
  }
  let routUrl = "http://localhost:8080/bus/route";
  put(routUrl, data)
})



//-----------------------For Get User data ------------------------//

function getAllUser() {
  fetch("http://localhost:8080/bus/user")
    .then((res) => res.json())
    .then((resu) => {
      console.log(resu);
      getAllUserInHtml(resu);
    });
}


function getAllUserInHtml(UserData) {
  console.log(UserData);
  if (UserData.message == "No any User  present") {
    return;
  }
  // if (UserData) {
  //   return;
  // }

  let cards = document.querySelector(".UserCard");

  cards.innerHTML = "";
  // cards.innerHTML = "";
  cards.style.display = "grid";
  cards.style.gridTemplateColumns = "repeat(auto-fill,350px)";
  cards.style.gridColumnGap = "3%";
  cards.style.gridRowGap = "20%";
  cards.style.justifyContent = "center";
  cards.style.padding = "2%";
  // console.log(UserData)
  UserData.forEach((ele) => {
    //console.log(ele)
    let userId = document.createElement("span");
    userId.innerText = "User ID : " + ele.userId;

    let userName = document.createElement("span");
    userName.innerText = "User Name : " + ele.username;

    let email = document.createElement("span");
    email.innerText = "User Email : " + ele.email;

    let contact = document.createElement("span");
    contact.innerText = "User Contact : " + ele.contact;

    let reservation = document.createElement("span");
    let Reserv=ele.reservation.length == 0 ? "Pending" : "Active"
    reservation.innerText = "Reservation : "+Reserv;


    let busdelete = document.createElement("button");
    busdelete.innerText = "Delete";
    busdelete.setAttribute("id", "delete-btn");
    busdelete.style.borderRadius = "10px";

    busdelete.style.border = "0px";
    busdelete.onclick = function () {
      deleteUserTicket("http://localhost:8080/bus/user/", ele.userId);
      setTimeout(() => {
        getAllUser();
      }, 200)
    };

    let busdiv = document.createElement("div");
    busdiv.style.border = "inset";
    busdiv.style.margin = "1%";
    busdiv.style.display = "grid";
    busdiv.style.gridTemplateColumns = "2fr 2fr";
    busdiv.append(
      userId,
      userName,
      email,
      contact,
      reservation,
      busdelete
    );

    cards.append(busdiv);

    //id time type availableseats totalseats route from route to
    //update delete
  });
}



//-------------------End User Data-----------------------------------------


//-----------------------ALL Rout------------------------------------------
function getAllRout() {
  fetch("http://localhost:8080/bus/route")
    .then((res) => res.json())
    .then((resu) => {
      console.log(resu);
      getAllRoutInHtml(resu);
    });
}

function getAllRoutInHtml(RoutData) {
  console.log(RoutData.message)
  if (RoutData.message == " Route is not present") {
    return;
  }

  let cards = document.querySelector(".rout_card");

  cards.innerHTML = "";
  // cards.innerHTML = "";
  cards.style.display = "grid";
  cards.style.gridTemplateColumns = "repeat(auto-fill,350px)";
  cards.style.gridColumnGap = "3%";
  cards.style.gridRowGap = "20%";
  cards.style.justifyContent = "center";
  cards.style.padding = "2%";
  // console.log(UserData)
  RoutData.forEach((ele) => {
    //console.log(ele)
    let routId = document.createElement("span");
    routId.innerText = "Route ID : " + ele.routeId;

    let from = document.createElement("span");
    from.innerText = "From: " + ele.routeFrom;

    let to = document.createElement("span");
    to.innerText = "To : " + ele.routeTo;

    let distance = document.createElement("span");
    distance.innerText = "Distance : " + ele.distance;


    let routdelete = document.createElement("button");
    routdelete.innerText = "Delete";
    routdelete.setAttribute("id", "delete-btn");
    routdelete.style.borderRadius = "10px";

    routdelete.style.border = "0px";
    routdelete.onclick = function () {
      deleteRoutTicket("http://localhost:8080/bus/route/", ele.routeId);
      setTimeout(() => {
        getAllRout();
      }, 200)
    };

    let routdiv = document.createElement("div");
    routdiv.style.border = "inset";
    routdiv.style.margin = "1%";
    routdiv.style.display = "grid";
    routdiv.style.gridTemplateColumns = "2fr 2fr";
    routdiv.append(
      routId,
      from,
      distance,
      to,
      routdelete
    );
    cards.append(routdiv);
  });
}
function deleteRoutTicket(url1, bId) {
  fetch(`${url1}${bId}`, {
    method: "DELETE",
  })
    .then((response) => {
      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
      }
      mess = `Route ticket with ID ${bId} deleted successfully.`;
      console.log(`Route ticket with ID ${bId} deleted successfully.`);
      showSpan4(mess);
    })
    .catch((error) => {
      mess = `Error while deleting Route ticket with ID ${bId}: ${error}`;
      console.error(`Error while deleting Route ticket with ID ${bId}: ${error}`);
      showSpan3(mess);
    });
}

function logout() {
  localStorage.removeItem("user");
  window.location.href = "/dist/index.html";

}