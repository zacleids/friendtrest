/**
 * Created by austinzielinski on 10/28/16.
 */

function shuffle(arr) {    //Fisher-Yates
    var i=arr.length-1, j, temp;

    for (; i > 0; i--) {
        j = Math.floor(Math.random() * (i + 1))
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    return arr;
}