
n loadPage(pageTitle) {
    // window.fbAsyncInit = function() {
    //     FB.init({
    //         appId      : '1665496440428179',
    //         xfbml      : true,
    //         version    : 'v2.8'
    //     });
    //     FB.AppEvents.logPageView();
    // };
    
    // (function(d, s, id){
    //     var js, fjs = d.getElementsByTagName(s)[0];
    //     if (d.getElementById(id)) {return;}
    //     js = d.createElement(s); js.id = id;
    //     js.src = "//connect.facebook.net/en_US/sdk.js";
    //     fjs.parentNode.insertBefore(js, fjs);
    // }(document, 'script', 'facebook-jssdk'));
    
    FB.getLoginStatus(function(response) {
        statusChngeCallback(response);
    });
    
    function statusChngeCallback(response) {
        console.log('statusChngeCallback');
        console.log(response);
        if (response.status === 'connected') {
            // print the access token
            console.log(response.authResponse.accessToken);
            
            // Logged into your app and Facebook.
            getStuffFromAPI();
        }
        else if (response.status === 'not_authorized') {
            // The person is logged into Facebook, but not your app.
            //window.location="login.html";
        }
        else {
            // The person is not logged into Facebook, so we're not sure if
            // they are logged into this app or not.
            //window.location="login.html";
        }
    }
    
    function getStuffFromAPI() {
        FB.api('/me', {fields : 'first_name, last_name, name, email, picture'}, function(response) {
            var fullName = response.name;
            //var picURL = response.picture.data.url;
            document.getElementById(pageTitle + 'NavName').innerHTML =
                fullName;
            // document.getElementById('profilepic').src = 
            //     picURL;
                
            switch (pageTitle) {
                case 'index':
                    break;
                
                case 'reviews':
                    break;
                
                case 'browse':
                    break;
                
                case 'edit-account':
                    document.getElementById('profilepic-l').src = 
                        'http://graph.facebook.com/' + response.id + '/picture?type=large';
                    document.getElementById('first-name-text-input').value =
                        response.first_name;
                    document.getElementById('last-name-text-input').value =
                        response.last_name;
                    document.getElementById('input-email').value =
                        response.email;
                    break;  
            }
        });
    }
}
