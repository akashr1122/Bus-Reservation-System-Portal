function confirmbook(bus) {
  // Create a new popup window
  // const popup = window.open("", "", "width=400,height=600");

  openPopup();
  const popup = document.querySelector("#popup");

  // Create the form HTML
  const formHtml = `
    <h3>Confirm your ticket</h3>
    <form id="pop-form">
      <div>
        <label for="busName">Bus Name: ${bus.busName}</label>
        
      </div>
      <div>
        <label for="busType">Bus Type: ${bus.busType}</label>
      </div>
      <div>
        <label for="routeFrom">Route From: ${bus.routeFrom}</label>
        
      </div>
      <div>
        <label for="routeTo">Route To: ${bus.routeTo}</label>
        
      </div>
      <div>
        <label for="arrivalTime">Arrival Time: ${bus.arrivalTime}</label>
        
      </div>
      <div>
        <label for="seats">Total Seats: ${bus.seats}</label>
        
      </div>
      <div>
        <label for="availableSeats">Available Seats: ${bus.availableSeats}</label>
        
      </div>
      <div>
        <button type="submit" id="submitBtn">Confirm Booking</button>
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
  form.addEventListener("submit", async (event) => {
    event.preventDefault();
    try {
      let Link = await fetch(
        `http://localhost:8080/reservation/add/${localStorage.getItem(
          "userId"
        )}/${bus.busId}`
      );
      let Data = await Link.json();
      console.log(Data);
      showSpanu1(
        `Enjoy the Ride !!! Reservation Successful! for the Bus ${bus.busName} `,
        0
      );
      closePopup();
      return Data;
    } catch (err) {
      console.log(err);
      showSpanu1(
        `Try again !!! Reservation unsuccessful! for ${bus.busName}`,
        1
      );
      closePopup();
    }
  });

  cancelBtn.addEventListener("click", () => {
    // popup.close(); // close the popup window
    closePopup();
  });
}

//popup

function openPopup() {
  document.getElementById("popup").style.display = "block";
}

function closePopup() {
  document.getElementById("popup").style.display = "none";
}

//popup end

//end of fetch

document.getElementById("my-span-u1").addEventListener("click", function () {
  this.style.display = "none";
});

//end of span tag

//span tag showing function

function showSpanu1(message, a) {
  document.getElementById("my-span-u1").style.display = "inline-block";
  document.getElementById("my-span-u1").innerText = message;

  if (a == 1) {
    document.getElementById("my-span-u1").style.backgroundColor = "red";
  } else {
    document.getElementById("my-span-u1").style.backgroundColor = "limegreen";
  }
}
