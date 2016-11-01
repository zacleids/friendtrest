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


// this function doesn't happen on every page load... just after the facebook login.
// thats why its not changing anything on the edit-account page.
function testAPI() {
  console.log('Welcome!  Fetching your information.... ');
  FB.api('/me', {fields : "name, email, picture, birthday"}, function(response) {
    console.log(response);
    console.log('Successful login for: ' + response.name);

    document.getElementById('profilepic').src = 
    response.picture.data.url;

    document.getElementById('profilepic-l').src = 
    response.picture.data.url;

    // getting first name and last name separate into an array'
    var nameArray = response.name.split(" ");
    var firstName = nameArray[0];
    var lastName = nameArray[1];

    // filling instances of the user's name
    var nameOccurances = document.getElementByClassName('fNamelName')

    for (var i = 0; i < nameOccurances.size; i++) {
      nameOccurances[i].innerHTML =
      firstName + ' ' + lastName;
    }

    document.getElementById('first-name-text-input').value =
    firstName;

    document.getElementById('last-name-text-input').value =
    lastName;

    document.getElementById('input-email').value =
    response.email;

    document.getElementById('dob-month-select').selectedIndex =
    parseInt(response.birthday.substring(0, 3));

    document.getElementById('dob-day-select').selectedIndex =
    parseInt(response.birthday.substring(3, 6));

    document.getElementById('dob-year-select').selectedIndex =
    parseInt(response.birthday.substring(6, 10));
  });
}
