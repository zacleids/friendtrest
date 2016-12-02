

function getAddressPart( name, url ) {
    if (!url) url = location.href;
    name = name.replace(/[\[]/,"\\\[").replace(/[\]]/,"\\\]");
    var regexS = "[\\?&]"+name+"=([^&#]*)";
    var regex = new RegExp( regexS );
    var results = regex.exec( url );
    return results == null ? null : results[1].replace(/\+/g,' ');
}

function search(){
    var name = $("#search_text").val();
    var url = location.href;
    var site = url;
    if(url.indexOf(".com") === -1){
        site = url.split("/")[0] + "/search.html?name=" + name.replace(/ /g, '+');
    } else{
        site = url.split(".com")[0] + ".com/search.html?name=" + name.replace(/ /g, '+');
    }

    window.location.replace(site);
}
