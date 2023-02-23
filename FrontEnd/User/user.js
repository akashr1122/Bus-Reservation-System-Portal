// for search bus

weekdata('http://localhost:8080/buses');



async function weekdata(url) {
    try {
        let Link = await fetch(url);

        let Data = await Link.json();
        console.log(Data);

    } catch (err) {
        console.log(err);
    }
}


