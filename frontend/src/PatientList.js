import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

class PatientList extends Component {

    constructor(props) {
        super(props);
        this.state = {patients: []};
	this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        fetch('/patients')
            .then(response => response.json())
            .then(data => this.setState({patients: data}));
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
                    <Button size="sm" color="primary" tag={Link} to={"/patients/" + patient.id}>Edit</Button>
                </ButtonGroup>
            </td>
        </tr>
    });

    return (
        <div>
            <AppNavbar/>
            <Container fluid>
                <div className="float-right">
                    <Button color="success" tag={Link} to="/Patients/new">Add Patient</Button>
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