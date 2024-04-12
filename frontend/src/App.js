import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import PatientList from './PatientList';
import PatientAdd from "./PatientAdd.js";
import NoteList from './NoteList';
import NoteAdd from './NoteAdd';
import TestDiabete from './TestDiabete';
import PatientEdit from './PatientEdit';
import LoginPage from './LoginPage';

class App extends Component {
  render() {
    return (
        <Router>
          <Switch>
            <Route path='/' exact={true} component={Home}/>
            <Route path='/patients' exact={true} component={PatientList}/>
            <Route path='/patients/add' component={PatientAdd}/>
	    <Route path='/patients/edit/:id' component={PatientEdit}/>
	    <Route path='/notes/:id' component={NoteList}/>
            <Route path='/note/add/:id' component={NoteAdd}/>
	    <Route path='/testDiabete/:id' component={TestDiabete}/>
            <Route path='/LoginPage' element={<LoginPage/>} /> 
	  </Switch>
        </Router>
    )
  }
}

export default App;
