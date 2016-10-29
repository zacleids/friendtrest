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