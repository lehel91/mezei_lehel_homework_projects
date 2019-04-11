var arrayOfAreas = [];

function createDesertTableFromJSON() {
    var deserts =
        [
            {
                "name": "Rub' al Háli",
                "size": 800000
            },
            {
                "name": "Kalahári",
                "size": 518000
            },
            {
                "name": "Nagy-homoksivatag",
                "size": 420000
            },
            {
                "name": "Takla-Makán",
                "size": 400000
            },
            {
                "name": "Szír-sivatag",
                "size": 350000
            },
            {
                "name": "Nagy-Viktória-sivatag",
                "size": 330000
            },
            {
                "name": "Kara-kum",
                "size": 300000
            },
            {
                "name": "Núbiai-sivatag",
                "size": 250000
            },
            {
                "name": "Kizil-kum",
                "size": 240000
            },
            {
                "name": "Gibson-sivatag",
                "size": 220000
            },
            {
                "name": "Simpson-sivatag",
                "size": 200000
            }
        ]


    var col = [];
    for (var i = 0; i < deserts.length; i++) {
        for (var key in deserts[i]) {
            if (col.indexOf(key) === -1) {
                col.push(key);
            }
        }
    }

    var table = document.createElement("table");

    // Ezzel csinalom meg a headert

    var tr = table.insertRow(-1);                   

    for (var i = 0; i < col.length; i++) {
        var th = document.createElement("th");      
        th.innerHTML = col[i];
        tr.appendChild(th);
    }

    // Itt jön a JSON a táblába soronként
    for (var i = 0; i < deserts.length; i++) {

        tr = table.insertRow(-1);

        for (var j = 0; j < col.length; j++) {
            var tabCell = tr.insertCell(-1);
            tabCell.innerHTML = deserts[i][col[j]];

            if (j===1) {
                arrayOfAreas = arrayOfAreas.concat(deserts[i][col[j]]);
            }
        }
    }

    // A Containerhez adom a táblát
    var divContainer = document.getElementById("desertsData");
    divContainer.innerHTML = "";
    divContainer.appendChild(table);

    //Itt jön egy új gomb, amivel majd lekérdezhetem a területösszeget
    var button = document.createElement("button");
    button.innerHTML = "Területek összege";

    //hozzáadom a containerhez
    var body = document.getElementsByTagName("divContainer")[0];
    divContainer.appendChild(button);

    //Eseménykezelés
    button.addEventListener("click", function () {
        calculateSumOfAreas();
    });
}

function calculateSumOfAreas() {
    var sumOfAreas = 0;
    for (var i = 0; i < arrayOfAreas.length; i++) {
        sumOfAreas += arrayOfAreas[i];
    }
    alert("A sivatagok területeinek összege: " + sumOfAreas + " km²");
}

