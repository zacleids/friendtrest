import React, { Component } from "react";

class Nav extends Component {
    render() {
        return (
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.html">Friendtrest</a>
                </div>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><a href="reviews.html">Reviews</a></li>
                        <li><a href="browse.html">Browse</a></li>
                    </ul>
                    <form class="navbar-form navbar-left">
                        <div class="form-group">
                            <input type="text" class="form-control" id="search_text" placeholder="Search"></input>
                        </div>
                        <button type="button" class="btn btn-default" id="search_submit">Submit</button>
                    </form>
                    <ul class="nav navbar-nav navbar-right">
                        <li><img class="navprofilepic" id="profilepic" src="img/generic-user.png"></img></li>
                        <li class="nav-name"><span class="fNamelName" id="' + strippedPage + 'NavName">Generic User</span></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" id="' + strippedPage + '-account-dropdown" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Account<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a id="browse-edit-account" href="edit-account.html">Manage Account</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="login.html">Logout</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        );
    }
}

export default Nav;