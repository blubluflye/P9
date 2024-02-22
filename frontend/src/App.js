import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import PatientList from './PatientList';
import PatientEdit from "./PatientEdit";
import NoteList from './NoteList';
import NoteAdd from './NoteAdd';
import TestDiabete from './TestDiabete';

class App extends Component {
  render() {
    return (
        <Router>
          <Switch>
            <Route path='/' exact={true} component={Home}/>
            <Route path='/patients' exact={true} component={PatientList}/>
            <Route path='/patients/:id' component={PatientEdit}/>
	    <Route path='/notes/:id' component={NoteList}/>
            <Route path='/note/add/:id' component={NoteAdd}/>
	    <Route pathe='/testDiabete/:id' component={TestDiabete}/>
	  </Switch>
        </Router>
    )
  }
}

export default App;
