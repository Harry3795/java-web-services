import logo from './logo.svg';
import './App.css';
import { Button } from 'reactstrap'
import React from 'react';
import Head1 from './components/header1';

function App() {
  return (
    <div className="App">
      
    <Head1 name="first"  pradeep="hello harry"/>
   <h1>hello pradeep</h1>
   <Button type="submit" color='primary' >Submit</Button>
   <Head1 name="second" pradeep="hello harry"/>
   <Head1 name="third" pradeep="hello harry"/>
    </div>
  );
}

export default App;
