// This is called with the results from from FB.getLoginStatus().
function statusChangeCallback(response) {
  console.log('statusChangeCallback');
  console.log(response);
  if (response.status === 'connected') {
    // print the access token
    console.log(response.authResponse.accessToken);

    // Logged into your app and Facebook.
    testAPI();
  }
  else if (response.status === 'not_authorized') {
    // The person is logged into Facebook, but not your app.
    document.getElementById('status').innerHTML = 'Please log ' +
    'into this app.';
  }
  else {
    // The person is not logged into Facebook, so we're not sure if
    // they are logged into this app or not.
    document.getElementById('status').innerHTML = 'Please log ' +
    'into Facebook.';
  }
}

// This function is called when someone finishes with the Login
// Button.
function checkLoginState() {
  window.location="index.html";
  FB.getLoginStatus(function(response) {
    statusChangeCallback(response);
  });
}

window.fbAsyncInit = function() {
  FB.init({
    appId: '1665496440428179',
    cookie: true, // enable cookies to allow the server to access 
    // the session
    xfbml: true, // parse social plugins on this page
    version: 'v2.6' // use graph api version 2.5
  });

  FB.getLoginStatus(function(response) {
    statusChangeCallback(response);
  });

};

// Load the SDK asynchronously
(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s);
  js.id = id;
  js.src = "//connect.facebook.net/en_US/sdk.js";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));


// this code is going to be refactored into individual javascript files
// so that it's not checking over and over for element's that don't exist
function testAPI() {
  console.log('Welcome!  Fetching your information.... ');
  FB.api('/me', {fields : "name, email, picture"}, function(response) {
    console.log(response);
    console.log('Successful login for: ' + response.name);


    if (document.getElementById('profilepic') != null) {
      document.getElementById('profilepic').src = 
        response.picture.data.url;
    }

    if (document.getElementById('profilepic-l') != null) {
      document.getElementById('profilepic-l').src = 
        'http://graph.facebook.com/' + response.id + '/picture?type=large';
    }

    // getting first name and last name separate into an array'
    var fullName = response.name;
    var nameArray = fullName.split(" ");
    var firstName = nameArray[0];
    var lastName = nameArray[1];

    //account management page
    if (document.getElementById('first-name-text-input') != null) {
      document.getElementById('first-name-text-input').value =
        firstName;
    }

    if (document.getElementById('last-name-text-input') != null) {
      document.getElementById('last-name-text-input').value =
        lastName;
    }

    if (document.getElementById('input-email') != null) {
      document.getElementById('input-email').value =
        response.email;
    }

    // filling names for nav bars
    if (document.getElementById('indexNavName') != null) {
      document.getElementById('indexNavName').innerHTML =
        fullName;
    }

    if (document.getElementById('reviewsNavName') != null) {
      document.getElementById('reviewsNavName').innerHTML =
        fullName;
    }

    if (document.getElementById('browseNavName') != null) {
      document.getElementById('browseNavName').innerHTML =
        fullName;
    }

    if (document.getElementById('edit-accountNavName') != null) {
      document.getElementById('edit-accountNavName').innerHTML =
        fullName;
    }
  });
}
