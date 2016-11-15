import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import Nav from './Nav';
import '../../webapp/css/bootstrap-social.css';
import '../../webapp/css/browse-styles.css';
import '../../webapp/css/edit-info-styles.css';
import '../../webapp/css/global-styles.css';
import '../../webapp/css/index.css';
import '../../webapp/css/login-styles.css';
import '../../webapp/css/rating.css';
import '../../webapp/css/reviews-styles.css';
import '../../webapp/css/styles.css';


ReactDOM.render(
    <Nav />,
    document.getElementById('nav')
);

ReactDOM.render(
  <App />,
  document.getElementById('root')
);

