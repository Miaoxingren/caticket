var CATICKET = {};

CATICKET.eventHandler = (function() {
    var addEvent = function (target, type, handler) {
        if (target.addEventListener) {
            target.addEventListener(type, handler, false);
        } else if (target.attachEvent) {
            target.attachEvent('on' + type,  handler);
        } else {
            target['on' + type] = handler;
        }
    },
    removeEvent = function (target, type, handler) {
        if (target.removeEventListener) {
            target.removeEventListener(type, handler, false);
        } else if (target.detachEvent) {
            target.detachEvent("on" + type, handler);
        } else {
            target["on" + type] = null;
        }
    };
    return {
        addEvent : addEvent,
        removeEvent: removeEvent
    };
}());

CATICKET.classHandler = (function () {
    var hasClass = function (target, classname) {
        return target.className.indexOf(classname) !== -1;
    },

    addClass = function(target, classnames) {
        var classes = classnames.split(' ');
            i = 0,
            max = classes.length;
        for (; i < max; i += 1) {
            if (!hasClass(target, classes[i])) {
                target.className += " " + classes[i];
            }
        }
    },

    removeClass = function(target, classnames) {
        var classes = classnames.split(' ');
            i = 0,
            max = classes.length;
        for (; i < max; i += 1) {
            if (hasClass(target, ' ' + classes[i])) {
                target.className = target.className.replace(' ' + classes[i], "");
            } else if (hasClass(target, classes[i])) {
                target.className = target.className.replace(classes[i], "");
            }   
        }
    },
    toggleClass = function(target, classname) {
        if (hasClass(target, classname)) {
            removeClass(target, classname);
            return true;
        } else {
            addClass(target, classname);
            return false;
        }
    };

    return {
        hasClass: hasClass,
        addClass: addClass,
        removeClass: removeClass,
        toggleClass: toggleClass
    };
}());

CATICKET.seatHandler = (function () {
    var seats = [],
    addSeat = function(seat) {
        seats.push(seat);
    },

    removeSeat = function(seat) {
        var i = 0,
            max = seats.length;
        for (; i < max; i += 1) {
            if (seats[i].line === seat.line && seats[i].chair === seat.chair) {
                seats.splice(i, 1);
                return i;
            }
        }
        return -1;
    },

    getAllSeats = function () {
        return seats;
    },

    getSeatCnt = function () {
        return seats.length;
    },

    getSeatStr = function () {
        var i = 0,
            str = "",
            length = seats.length;
        for (; i < length; ++i) {
            str += seats[i].line + '-'  + seats[i].chair + ',';
        }
        return str;
    };

    return {
        addSeat: addSeat,
        removeSeat: removeSeat,
        getAllSeats: getAllSeats,
        getSeatCnt: getSeatCnt,
        getSeatStr: getSeatStr
    };
}());


(function(){
    var eventHandler = CATICKET.eventHandler,
        seatHandler = CATICKET.seatHandler,
        classHandler = CATICKET.classHandler,
        seatTable = document.querySelector(".seat-table"),
        seatSelected = document.querySelector(".check-seats"),
        seatError = document.querySelector(".seat-error"),
        seatPrice = document.querySelector(".info-session-price"),
        ticketCount = document.querySelector(".tickets-count"),
        seatCost = document.querySelector(".tickets-cost"),
        seatCnt = document.querySelector(".input-seatcnt"),
        totalPrice = document.querySelector(".input-price"),
        seats = document.querySelector(".input-seats");
    if (!seatTable) {
        return;
    }
    eventHandler.addEvent(seatTable, "click", function (event) {
        var event = event || window.event,
            target = event.target || event.srcElement,
            seat = {
                line: target.parentNode.getAttribute("line"),
                chair: target.parentNode.getAttribute("chair")
            },
            seatNode,
            seatIndex,
            singlePrice = seatPrice.innerHTML - "";
        if (target.nodeName.toLowerCase() === "span") {
            if (classHandler.hasClass(target, "seat-taken")) {
                return;
            }
            if (seatHandler.getSeatCnt() >= 4 && classHandler.hasClass(target, "icon-ipad")) {
                classHandler.removeClass(seatError, "invisible");
                return;
            }
            if (classHandler.toggleClass(target, "icon-ipad")) {
                seatHandler.addSeat(seat);
                seatNode = document.createElement("span");
                seatNode.setAttribute("class", "label label-info");
                seatNode.innerHTML = seat.line + "排" + seat.chair + "座";
                seatSelected.appendChild(seatNode);
                ticketCount.innerHTML = ticketCount.innerHTML - "" + 1;
                seatCost.innerHTML = seatCost.innerHTML - "" + singlePrice;
                seatCnt.value = ticketCount.innerHTML;
                totalPrice.value = seatCost.innerHTML;
                seats.value = seatHandler.getSeatStr();
            }
            if (classHandler.toggleClass(target, "icon-task")) {
                seatIndex = seatHandler.removeSeat(seat);
                if (seatIndex !== -1) {
                    seatSelected.removeChild(seatSelected.childNodes[seatIndex + 1]);
                    ticketCount.innerHTML = ticketCount.innerHTML - "" - 1;
                    seatCost.innerHTML = seatCost.innerHTML - "" - singlePrice;
                    seatCnt.value = ticketCount.innerHTML;
                    totalPrice.value = seatCost.innerHTML;
                    seats.value = seatHandler.getSeatStr();
                }
                if (seatHandler.getSeatCnt() < 4) {
                    classHandler.addClass(seatError, "invisible");
                    return;
                }
            }
        }
    });
}());


(function(){
    var classHandler = CATICKET.classHandler,
        signin = document.querySelector(".signin"),
        joinus = document.querySelector(".joinus"),
        username = document.querySelector(".input-username"),
        password = document.querySelector(".input-password"),
        pwdRepeat = document.querySelector(".input-pwd-repeat")
        pwderror = document.querySelector(".pwderror"),
        lengtherror = document.querySelector(".lengtherror"),
        validate = function () {
            var val1 = password.value,
                val2 = pwdRepeat.value,
                val3 = username.value;
            if (val1.replace(" ", "") !== val1 || val2.replace(" ", "") !== val2 || val3.replace(" ", "") !== val3 ||
                val1.length < 4 || val2.length < 4 || val3.length < 4) {
                classHandler.removeClass(lengtherror, "invisible");
                joinus.disabled = true;
            }
            if (val1 !== val2) {
                classHandler.removeClass(pwderror, "invisible");
                joinus.disabled = true;
            } else {
                classHandler.addClass(lengtherror, "invisible");
                classHandler.addClass(pwderror, "invisible");
                joinus.disabled = false;
            }
        };
    if (password) {
        pwdRepeat.onblur = validate;
        password.onblur = validate;
    }
}());
