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
  form.addEventListener("submit", (event) => {
    event.preventDefault();

    // Send the updated bus object to the server using a fetch() request
    fetch(
      `http://localhost:8080/reservation/add/${localStorage.getItem(
        "userId"
      )}/${bus.busId}`,
      {
        method: "GET",
        headers: {
          "Content-Type": "application/json",
        },
      }
    )
      .then((res) => {
        res.json();
        console.log(res);
      })
      .then((resu) => {
        console.log(resu);

        // if (!response.ok) {
        //   throw new Error(`HTTP error! status: ${response.status}`);
        // }
        // mess = `Bus ticket with ID ${bus.busId} updated successfully.`;
        // console.log(`Bus ticket with ID ${bus.busId} updated successfully.`);
        // showSpan(mess);
        // // popup.close(); // close the popup window
        // closePopup();
        // getAll();
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

//popup

function openPopup() {
  document.getElementById("popup").style.display = "block";
}

function closePopup() {
  document.getElementById("popup").style.display = "none";
}

//popup end
