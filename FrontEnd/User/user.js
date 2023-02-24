

// For Api fetch
async function weekdata(url) {
    try {
        let Link = await fetch(url);

        let Data = await Link.json();
        // console.log(Data);
        return Data

    } catch (err) {
        console.log(err);
    }
}

// for Create From and to option
(async () => {
    let from = await weekdata('http://localhost:8080/bus/routeFrom')
    let to = await weekdata('http://localhost:8080/bus/routeTo');
    let From = document.getElementById("From");
    let To = document.getElementById("To")
    from.forEach(element => {
        From.append(creatOption(element));
    });


    from.forEach(element => {
        To.append(creatOption(element));
    });



    function creatOption(destination) {
        let ele = document.createElement("option")
        ele.innerText = destination.charAt(0).toUpperCase() + destination.slice(1);
        ele.value = destination;
        return ele;
    }
})();











// To Get all Available Buses-------------

async function AvailableBusInRoot() {
    let from = document.getElementById("From").value;
    let to = document.getElementById("To").value;
    let bus= await weekdata(`http://localhost:8080/bus/route/${from}/${to}`)
    console.log(bus);
}
