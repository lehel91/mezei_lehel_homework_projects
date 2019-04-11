function bigImg(x) {
    x.style.height = "300px";
    x.style.width = "400px";
}

function normalImg(x) {
    x.style.height = "200px";
    x.style.width = "300px";
}

function makeSecondImageDissapear() {
    document.getElementById("image2").style.visibility = "hidden";
}

function makeSecondImageVisibleAgain() {
    document.getElementById("image2").style.visibility = "visible";
}

function setBorderForFirstAndSecondImages() {
    document.getElementById("image1").style.border = "thick solid #808080";
    document.getElementById("image3").style.border = "thick solid #808080";
}