import React from 'react'
import ReactDOM from 'react-dom'
import {Route,Link, BrowserRouter as Router} from 'react-router-dom'
import App from "../src/components/app";
import Footer from "../src/components/footerComponent/Footer";
import NavBar from "../src/components/headerComponent/NavBar";
import HomePage from "../src/components/pages/HomePage";

const routing = (<Router>
    <div>
        <Route path="/App" component ={App} />
        <Route path="/Footer" component ={Footer} />
        <Route path="/NavBar" component ={NavBar} />
        <Route path="/HomePage" component ={HomePage} />
    </div>
</Router>);

ReactDOM.render(<App />, document.getElementById('root'));