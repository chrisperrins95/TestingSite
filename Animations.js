function fadeIn(image) {
    var itemVisible = true;
    var fading = setInterval(fader, 10);
    function fader() {
        image.style.opacity = parseFloat(image.style.opacity) + 0.005;
        if (image.style.opacity >= 1) {
            clearInterval(fading);
        }
    }
}

function fadeInOut(image, WaitTime) {
    var itemVisible = true;
    var fading = setInterval(fader, 10);
    function fader() {
        image.style.opacity = parseFloat(image.style.opacity) + 0.005;
        if (image.style.opacity >= 1) {
            clearInterval(fading);
            wait(WaitTime, fadeOut, image);
        }
    }
}

function fadeOut(image) {
    var itemVisible = true;
    var fading = setInterval(fader, 10);
    function fader() {
        image.style.opacity = parseFloat(image.style.opacity) - 0.005;
        if (image.style.opacity <= 0) {
            clearInterval(fading);
        }
    } 
}