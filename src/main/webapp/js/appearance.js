/**
 * Created by austinzielinski on 10/28/16.
 */

function getColor(rating) {
         if (rating >= 9.5) return "#008000";
    else if (rating >= 9.0) return "#80C000";
    else if (rating >= 8.5) return "#ffff00";
    else if (rating >= 8.0) return "#ffd200";
    else if (rating >= 7.5) return "#ffa500";
    else if (rating >= 7.0) return "#ff5200";
    else if (rating >= 6.0) return "#ff0000";
    else if (rating >= 5.0) return "#8b4513";
    else if (rating >= 4.0) return "#68340e";
    else if (rating >= 3.0) return "#46220a";
    else if (rating >= 2.0) return "#231105";
                      else return "#000000";
}

function makeClosePlaceholder() {
    var placeholder = "<span style='height: 14px'></span>";
    placeholder += "<span class='white'></span>";
    placeholder += "<span class='spacer'></span>";
    placeholder += "<span class='white'></span>";
    return placeholder;
}

function makeControls(id) {
    var controls = "<div class='close_place' id='close_place" + id + "'>";
    controls += makeClosePlaceholder();
    controls += "</div>";
    controls += "<div class='close' id='close" + id + "'>&#10006;</div>";
    controls += "<div class='toggle' id='toggle" + id + "'>";
    controls += makeToggle();
    controls += "</div>";
    return controls
}

function makePopup(id) {
    var popup = "<div class='popup' id='popup" + id + "'>";
    popup += makePopupParts(id);
    popup += "</div>";
    return popup;
}

function makePopupParts(id) {
    var parts = "<div class='rate_rev' id='rate_rev" + id + "'>";
    parts += makeRateReview(id);
    parts += "</div>";
    parts += "<div class='controls' id='controls" + id + "'>";
    parts += makeControls(id);
    parts += "</div>";
    return parts;
}

function makeRateReview(id) {
    var rate_review = "<input class='rating' id='rating" + id + "' type='range' min='0' max='10' value='0.5' step='0.01'>";
    rate_review += "<textarea class='review' id='review" + id + "' rows='7' cols='25'></textarea>";
    return rate_review;
}

function makeToggle() {
    var toggle = "<span class='spacer'></span>";

    for (var i = 0; i < 11; i++) {
        toggle += "<span class='white'></span>";
        toggle += "<span class='spacer'></span>";
    }

    return toggle;
}