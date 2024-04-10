import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import AppNavbar from './AppNavbar';

const INSTRUCTOR = 'user'
const PASSWORD = 'pass'

class PatientEdit extends Component {

    emptyItem = {
        name: '',
        surname: '',
	birthdate: '',
	genre: '',
	address: '',
	telephone: ''
    };

    constructor(props) {
        super(props);
        this.state = {
            item: this.emptyItem
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    async componentDidMount() {
    	if (this.props.match.params.id !== 'new') {
        	//const patient = await (await fetch(`/patients/${this.props.match.params.patId}`)).json();
        	//this.setState({item: patient});
		 fetch(`/patients/${this.props.match.params.id}`)
            .then(response => response.json())
            .then(data => this.setState({item: data}));
    	}
    }

    handleChange(event) {
    	const target = event.target;
    	const value = target.value;
    	const name = target.name;
    	let item = {...this.state.item};
    	item[name] = value;
    	this.setState({item});
    }

    async handleSubmit(event) {
    	event.preventDefault();
    	const {item} = this.state;

    	await fetch('/patients/' + item.id, {
            method: 'PUT',
            headers: {
            	'Accept': 'application/json',
            	'Content-Type': 'application/json',
		'Authorization': 'Basic ' + window.btoa(INSTRUCTOR + ":" + PASSWORD)
            },
            body: JSON.stringify(item),
    	});
    	this.props.history.push('/patients');
    }

    render() {
    	const {item} = this.state;
    	const title = <h2>{'Edit Patient'}</h2>;

    	return <div>
            <AppNavbar/>
            <Container>
            	{title}
            	<Form onSubmit={this.handleSubmit}>
                    <FormGroup>
                    	<Label for="name">Name *</Label>
                    	<Input type="text" name="name" id="name" value={item.name} required
                            onChange={this.handleChange} autoComplete="name"/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="surname">Surname *</Label>
                        <Input type="text" name="surname" id="surname" value={item.surname} required
                            onChange={this.handleChange} autoComplete="surname"/>
                    </FormGroup>
		    <FormGroup>
                        <Label for="birthdate">Birthdate</Label>
                        <Input type="date" name="birthdate" id="birthdate" value={item.birthdate}
                            onChange={this.handleChange} autoComplete="birthdate"/>
                    </FormGroup>
		    <FormGroup>
                        <Label for="genre">Genre</Label>
                        <Input type="text" name="genre" id="genre" value={item.genre}
                            onChange={this.handleChange} autoComplete="genre"/>
                    </FormGroup>
		    <FormGroup>
                        <Label for="address">Address</Label>
                        <Input type="text" name="address" id="address" value={item.address}
                            onChange={this.handleChange} autoComplete="address"/>
                    </FormGroup>
		    <FormGroup>
                        <Label for="telephone">Telephone</Label>
                        <Input type="text" name="telephone" id="telephone" value={item.telephone}
                            onChange={this.handleChange} autoComplete="telephone"/>
                    </FormGroup>
                    <FormGroup>
                        <Button color="primary" type="submit">Save</Button>{' '}
	    	        <Button color="secondary" tag={Link} to="/patients">Cancel</Button>
                    </FormGroup>
            	</Form>
            </Container>
    	</div>
    }
}
export default withRouter(PatientEdit);
