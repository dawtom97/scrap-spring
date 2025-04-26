function sendQuery(event) {

    event.preventDefault();

    const queryValue = Query.value;


    Loader.style.display = "block";
    SearchBtn.disabled = true;

    fetch("http://localhost:8080/api/scrap/get-by-title", {
        method:"POST",
        headers: {
            "Content-Type":"application/json"
        },
        body: JSON.stringify({query: Query.value})
    })
    .then(res => res.json())
    .then(data => {
        Results.innerText = JSON.stringify(data);
    })
    .catch(er => {
        console.log(er);
        Results.innerText = "Błąd pobierania danych";
    })
    .finally(() => {
        Loader.style.display = "none";
          SearchBtn.disabled = false;
    })
}