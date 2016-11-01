function generateNavBar(currentPage) {
  var pageList = "<li>ERROR</li>";

  switch (currentPage) {
  	case "index":
      pageList = 
        '      <li><a href="reviews.html">Reviews</a></li>' + '\n' +
        '      <li><a href="browse.html">Browse</a></li>' + '\n' +
        '      <li><a href="edit-account.html">Manage Account</a></li>' + '\n';
      break;
    case "reviews":
      pageList = 
        '      <li class="active"><a href="reviews.html">Reviews<span class="sr-only">(current)</span></a></li>' + '\n' +
        '      <li><a href="browse.html">Browse</a></li>' + '\n' +
        '      <li><a href="edit-account.html">Manage Account</a></li>' + '\n';
      break;
    case "browse":
      pageList = 
        '      <li><a href="reviews.html">Reviews</a></li>' + '\n' +
        '      <li class="active"><a href="browse.html">Browse<span class="sr-only">(current)</span></a></li>' + '\n' +
        '      <li><a href="edit-account.html">Manage Account</a></li>' + '\n';
      break;
    case "edit-account":
      pageList = 
        '      <li><a href="reviews.html">Reviews</a></li>' + '\n' +
        '      <li><a href="browse.html">Browse</a></li>' + '\n' +
        '      <li class="active"><a href="edit-account.html">Manage Account<span class="sr-only">(current)</span></a></li>' + '\n';
      break;  
  }


  document.write(
  '<nav class="navbar navbar-default navbar-fixed-top">' + '\n' +
  '<div class="container-fluid">' + '\n' +
  '  <!-- Brand and toggle get grouped for better mobile display -->' + '\n' +
  '  <div class="navbar-header">' + '\n' +
  '    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">' + '\n' +
  '      <span class="sr-only">Toggle navigation</span>' + '\n' +
  '      <span class="icon-bar"></span>' + '\n' +
  '      <span class="icon-bar"></span>' + '\n' +
  '      <span class="icon-bar"></span>' + '\n' +
  '    </button>' + '\n' +
  '    <a class="navbar-brand" href="index.html">Friendtrest</a>' + '\n' +
  '  </div>' + '\n' +
  '' + '\n' +
  '  <!-- Collect the nav links, forms, and other content for toggling -->' + '\n' +
  '  <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">' + '\n' +
  '    <ul class="nav navbar-nav">' + '\n' + pageList +
  '' + '\n' +
  '      <li class="dropdown">' + '\n' +
  '        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>' + '\n' +
  '        <ul class="dropdown-menu">' + '\n' +
  '          <li><a href="#">Action</a></li>' + '\n' +
  '          <li><a href="#">Another action</a></li>' + '\n' +
  '          <li><a href="#">Something else here</a></li>' + '\n' +
  '          <li role="separator" class="divider"></li>' + '\n' +
  '          <li><a href="#">Separated link</a></li>' + '\n' +
  '          <li role="separator" class="divider"></li>' + '\n' +
  '          <li><a href="#">One more separated link</a></li>' + '\n' +
  '        </ul>' + '\n' +
  '      </li>' + '\n' +
  '    </ul>' + '\n' +
  '    <form class="navbar-form navbar-left">' + '\n' +
  '      <div class="form-group">' + '\n' +
  '        <input type="text" class="form-control" id="search_text" placeholder="Search">' + '\n' +
  '      </div>' + '\n' +
  '      <button type="button" class="btn btn-default" id="search_submit">Submit</button>' + '\n' +
  '    </form>' + '\n' +
  '    <ul class="nav navbar-nav navbar-right">' + '\n' +
  '    	<li><img class="navprofilepic" id="profilepic" src="img/generic-user.png"></li>' + '\n' +
  '    	<li class="nav-name"><span class="fNamelName" id="status">Generic User</span></li>' + '\n' +
  '      <li><a href="login.html">Logout</a></li>' + '\n' +
  '      <li class="dropdown">' + '\n' +
  '        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>' + '\n' +
  '        <ul class="dropdown-menu">' + '\n' +
  '          <li><a href="#">Action</a></li>' + '\n' +
  '          <li><a href="#">Another action</a></li>' + '\n' +
  '          <li><a href="#">Something else here</a></li>' + '\n' +
  '          <li role="separator" class="divider"></li>' + '\n' +
  '          <li><a href="#">Separated link</a></li>' + '\n' +
  '        </ul>' + '\n' +
  '      </li>' + '\n' +
  '    </ul>' + '\n' +
  '  </div><!-- /.navbar-collapse -->' + '\n' +
  '</div><!-- /.container-fluid -->' + '\n' +
  '</nav>' + '\n'
  );
}