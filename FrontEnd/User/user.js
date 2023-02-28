// For Api fetch
async function weekdata(url) {
  try {
    let Link = await fetch(url);

    let Data = await Link.json();
    // console.log(Data);
    return Data;
  } catch (err) {
    console.log(err);
  }
}

//  POST method implementation:
async function postData(url = "", data = {}) {
  // Default options are marked with *
  const response = await fetch(url, {
    method: "POST", // *GET, POST, PUT, DELETE, etc.
    mode: "cors", // no-cors, *cors, same-origin
    cache: "no-cache", // *default, no-cache, reload, force-cache, only-if-cached
    credentials: "same-origin", // include, *same-origin, omit
    headers: {
      "Content-Type": "application/json",
      // 'Content-Type': 'application/x-www-form-urlencoded',
    },
    body: JSON.stringify(data), // body data type must match "Content-Type" header
  });
  return response.json(); // parses JSON response into native JavaScript objects
}

// for Create From and to option
(async () => {
  let from = await weekdata("http://localhost:8080/bus/routeFrom");
  let to = await weekdata("http://localhost:8080/bus/routeTo");
  let From = document.getElementById("From");
  let To = document.getElementById("To");
  from.forEach((element) => {
    From.append(creatOption(element));
  });

  to.forEach((element) => {
    To.append(creatOption(element));
  });

  function creatOption(destination) {
    let ele = document.createElement("option");
    ele.innerText = destination.charAt(0).toUpperCase() + destination.slice(1);
    ele.value = destination;
    return ele;
  }
})();

// To Get all Available Buses-------------

async function AvailableBusInRoot() {
  let from = document.getElementById("From").value;
  let to = document.getElementById("To").value;
  if (from == "hide" || to == "hide") {
    return;
  }
  let bus = await weekdata(`http://localhost:8080/bus/route/${from}/${to}`);
  function createElement(ele) {
    let ele2 = document.createElement(ele);
    return ele2;
  }

  let card = document.getElementById("container");
  card.innerHTML = "";
  if (bus.length == 0) {
    card.innerHTML = `<div class="t-center "><div class="error-view oops-page"><img src="https://www.redbus.in/images/no_bus.png"><div class="oops-wrapper"><h3>Oops! No buses found.</h3><div class="message-container"><div class="msg-c-msg">No routes available</div></div></div></div></div>`;
  }
  bus.forEach((ele) => {
    //console.log(ele)

    let cardDiv = createElement("div");
    cardDiv.setAttribute("class", "card");

    let heroImg = createElement("img");
    heroImg.src =
      "https://assets.volvo.com/is/image/VolvoInformationTechnologyAB/1860x1050-volvo-9700-CGI1?qlt=82&wid=1024&ts=1656931444230&dpr=off&fit=constrain";

    let card_content = createElement("div");
    card_content.setAttribute("class", "card-content");

    let rout = createElement("div");
    rout.setAttribute("class", "rout_");
    let from = createElement("H3");
    from.innerText =
      ele.routeFrom.charAt(0).toUpperCase() + ele.routeFrom.slice(1);
    let I = createElement("i");
    I.setAttribute("class", "fa-solid fa-arrow-right-arrow-left red");
    let to = createElement("h3");
    to.innerText = ele.routeTo.charAt(0).toUpperCase() + ele.routeTo.slice(1);
    rout.append(from, I, to);

    let busName = createElement("h2");
    busName.setAttribute("class", "card-title");

    let avaialableSeats = createElement("h3");
    avaialableSeats.innerText = "Available seats :- " + ele.availableSeats;
    busName.innerText =
      "Name :- " + ele.busName.charAt(0).toUpperCase() + ele.busName.slice(1);

    let arrivalTime = createElement("h3");
    arrivalTime.innerText = "Arrival Time :- " + ele.arrivalTime;
    let btn = createElement("button");
    btn.setAttribute("class", "book-button");
    btn.innerText = "Book Now";
    btn.onclick = function () {
      console.log(ele);
      confirmbook(ele);

      console.log(ele);
      // let data = {
      //   reservationType: "active",
      //   bus: {
      //     busId: ele.busId,
      //   },
      // };
      // //console.log(data)
      // postData("http://localhost:8080/reservation/add", data).then((data) => {
      //   console.log(data); // JSON data parsed by `data.json()` call
      // });
    };

    card_content.append(rout, busName, avaialableSeats, arrivalTime, btn);

    cardDiv.append(heroImg, card_content);
    card.append(cardDiv);
  });
}

//name of sign in
if (localStorage.getItem("user")) {
  document.getElementById("search").innerText = localStorage.getItem("user");
}
