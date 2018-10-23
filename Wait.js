function wait(time, postEvent, parameter1, parameter2, parameter3) {
    var counter = 0;
    var waiter = setInterval(function() {
            console.log(counter);
            clearInterval(waiter);
            postEvent(parameter1, parameter2, parameter3);
    }, time);
}