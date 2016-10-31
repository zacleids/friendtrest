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

  function testAPI() {
      console.log('Welcome!  Fetching your information.... ');
      FB.api('/me', {fields : "name, picture"}, function(response) {
          console.log(response);
          console.log('Successful login for: ' + response.name);
          document.getElementById('profilepic').src = 
              response.picture.data.url;
          
          document.getElementById('status').innerHTML =
              'You are logged in as ' + response.name + '.';
      });
  }
