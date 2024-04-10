import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';
import axios from 'axios';

const INSTRUCTOR = 'user'
const PASSWORD = 'pass'


class NoteList extends Component {

    emptyPatient = {
        name: '',
        surname: '',
        birthdate: '',
        genre: '',
        address: '',
        telephone: ''
    };


    constructor(props) {
	     super(props);
        this.state = {notes: [], patient: this.emptyPatient};
    }

    componentDidMount() {
	fetch(`/patients/${this.props.match.params.id}`)
            .then(response => response.json())
            .then(data => this.setState({patient: data}));
        fetch(`/notes/${this.props.match.params.id}`)
            .then(response => response.json())
            .then(data => this.setState({notes: data}));

    }

    render() {
        const {notes} = this.state;
	const {patient} = this.state;
        const noteList = notes.map(note => {
            return <tr key={note.id}>
                <td style={{whiteSpace: 'nowrap'}}>{note.name}</td>
                <td>{note.note}</td>
        </tr>
    });
    return (
	<div>
            <AppNavbar/>
            <Container fluid>
	         <div className="float-right">
                    <Button color="success" tag={Link} to={"/note/add/" + this.props.match.params.id}>Add Note</Button>
	    	  </div>
	          <div className="float-right">
                    <Button color="success" tag={Link} to={"/testDiabete/" + this.props.match.params.id}>Test Diabete</Button>
                  </div>
	        <h3>Informations du patient</h3>
	    		<p>Name : {patient.name}</p>
                	<p>Surname : {patient.surname}</p>
                	<p>Birthdate : {patient.birthdate}</p>
                	<p>Genre : {patient.genre}</p>
                	<p>Address : {patient.address}</p>
                	<p>Telephone : {patient.telephone}</p>
                <h3>Notes du médecin</h3>
                <Table className="mt-4">
                    <thead>
                    <tr>
                        <th width="30%">Name</th>
                        <th width="40%">Note</th>
                    </tr>
                    </thead>
                    <tbody>
                    {noteList}
                    </tbody>
                </Table>
            </Container>
        </div>
    );

  }
}
export default NoteList;
