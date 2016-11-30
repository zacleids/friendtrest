import React, { Component } from "react";



class Nav extends Component {
    render() {
        return (
            <nav className="navbar navbar-default navbar-fixed-top">
                <div className="container-fluid">
                    <div className="navbar-header">
                        <button type="button" className="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                            <span className="sr-only">Toggle navigation</span>
                            <span className="icon-bar"></span>
                            <span className="icon-bar"></span>
                            <span className="icon-bar"></span>
                        </button>
                        <a className="navbar-brand" href="index.html">Friendtrest</a>
                    </div>
                    <div className="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul className="nav navbar-nav">
                            <li>
                                <a href="reviews.html">Reviews</a>
                            </li>
                            <li>
                                <a href="browse.html">Browse</a>
                            </li>
                        </ul>
                        <form className="navbar-form navbar-left">
                            <div className="form-group">
                                <input type="text" className="form-control" id="search_text" placeholder="Search"/>
                            </div>
                            <button type="button" className="btn btn-default" id="search_submit">Submit</button>
                        </form>
                        <ul className="nav navbar-nav navbar-right">
                            <li>
                                <img className="navprofilepic" id="profilepic" src="img/generic-user.png"/>
                            </li>
                            <li className="nav-name">
                                <span className="fNamelName" id="' + strippedPage + 'NavName">Generic User</span>
                            </li>
                            <li className="dropdown">
                                <a href="#" className="dropdown-toggle" id="' + strippedPage + '-account-dropdown" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Account<span className="caret"></span></a>
                                <ul className="dropdown-menu">
                                    <li>
                                        <a id="' + strippedPage + '-edit-account" href="edit-account.html">Manage Account</a>
                                    </li>
                                    <li role="separator" className="divider"></li>
                                    <li>
                                        <a href="login.html">Logout</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        );
    }
}

export default Nav;
