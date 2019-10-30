import React from 'react';
import logo from './oops404.png';
import './App.css';

function App() {
  return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="oops404" />
          <h1>
            Welcome To Plan Easily!
          </h1>
          <p>
            This is a webapp designed to help you and your friends keep better track of your events. No more confusion.
            No more hassle
          </p>
          <a
              className="App-link"
              href="https://github.com/Oops-404/Cs4800-Oops-404"
              target="_blank"
              rel="noopener noreferrer"
          >
            Plan Easily by Oops404
          </a>
        </header>
      </div>
  );
}

export default App;
