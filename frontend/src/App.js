import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import PatientList from './PatientList';
import PatientEdit from "./PatientEdit";

class App extends Component {
  render() {
    return (
        <Router>
          <Switch>
            <Route path='/' exact={true} component={Home}/>
            <Route path='/patients' exact={true} component={PatientList}/>
            <Route path='/patients/:id' component={PatientEdit}/>
          </Switch>
        </Router>
    )
  }
}

export default App;
