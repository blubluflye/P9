import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import AppNavbar from './AppNavbar';
import axios from 'axios';

class LoginPage extends Component {

    newUser = {
        username: '',
        password: ''
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

    async handleSubmit(event) {
	try{
        event.preventDefault();
        const {user} = this.state;
	await axios.post('/login?username=' + user.username + '&password='+ user.password, {headers:{'Accept': 'application/json',
                'Content-Type': 'application/json'}}
	);
	window.location.href='/patients';
	} catch(e){
		window.confirm("bad username/password");
	}
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
