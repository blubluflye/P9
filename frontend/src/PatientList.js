import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';
import axios from 'axios';

const INSTRUCTOR = 'user'
const PASSWORD = 'pass'

class PatientList extends Component {

    constructor(props) {
        super(props);
        this.state = {patients: []};
	this.remove = this.remove.bind(this);
    }

    componentDidMount() {
 	const response = axios.get('/patients',
            { headers: { authorization: 'Basic ' + window.btoa(INSTRUCTOR + ":" + PASSWORD) } }
        ).then(response => {
	        this.setState({patients: response.data})
	    }
	);
        console.log(response);
    }

    async remove(id) {
        await fetch(`/patients/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedPatients = [...this.state.patients].filter(i => i.id !== id);
            this.setState({patients: updatedPatients});
        });
    }

    render() {
        const {patients} = this.state;

        const patientList = patients.map(patient => {
            return <tr key={patient.id}>
                <td style={{whiteSpace: 'nowrap'}}>{patient.name}</td>
                <td>{patient.surname}</td>
		<td>{patient.id}</td>
            <td>
                <ButtonGroup>
                    <Button size="sm" color="primary" tag={Link} to={"/patients/edit/" + patient.id}>Edit</Button>
		    <Button size="sm" color="secondary" tag={Link} to={"/patient/info/" + patient.id}>Historique</Button>
		</ButtonGroup>
            </td>
        </tr>
    });

    return (
        <div>
            <AppNavbar/>
            <Container fluid>
                <div className="float-right">
                    <Button color="success" tag={Link} to="/patients/add">Add Patient</Button>
                </div>
                <h3>Patients</h3>
                <Table className="mt-4">
                    <thead>
                    <tr>
                        <th width="30%">Name</th>
                        <th width="30%">Surname</th>
	                <th width="30%">Id</th>
                        <th width="40%">Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    {patientList}
                    </tbody>
                </Table>
            </Container>
        </div>
    );
  }
}
export default PatientList;
