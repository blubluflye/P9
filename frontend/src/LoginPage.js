import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import AppNavbar from './AppNavbar';
import axios from 'axios';

const INSTRUCTOR = 'user'
const PASSWORD = 'pass'

class LoginPage extends Component {

    newUser = {
        username: '',
        pass: ''
    };

    constructor(props) {
        super(props);
        this.state = {
            user: this.newUser
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        let user = {...this.state.user};
        user[name] = value;
        this.setState({user});
    }

    //method for login
    async handleSubmit(event) {
        event.preventDefault();
        const {user} = this.state;
	await axios.post('/login?username=user&password=pass', {headers:{'Accept': 'application/json',
                'Content-Type': 'application/json'}}
	);
	//need to add parameters and fix this call
        /*await fetch('/login?username=user&password=pass', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Authorization': 'Basic ' + window.btoa(INSTRUCTOR + ":" + PASSWORD)
            },
	    body: JSON.stringify(user),
        });*/
	window.location.href='/patients';
    }


    render() {
        const {user} = this.state;
        const title = <h2>Add Note</h2>;

        return <div>
            <AppNavbar/>
            <Container>
                {title}
                <Form onSubmit={this.handleSubmit}>
                    <FormGroup>
                        <Label for="username">Username</Label>
                        <Input type="text" name="username" id="username" value={user.username} required

                            onChange={this.handleChange} autoComplete="username"/>
                </FormGroup>
                <FormGroup>
                    <Label for="password">Password</Label>
                    <Input type="password" name="password" id="password" value={user.password} required
                           onChange={this.handleChange} autoComplete="password"/>
                </FormGroup>
                <FormGroup>
                    <Button color="primary" type="submit">Save</Button>{' '}
                    <Button color="secondary" tag={Link} to="/">Cancel</Button>
                </FormGroup>
                </Form>
            </Container>
        </div>
    }
}

export default withRouter (LoginPage)
