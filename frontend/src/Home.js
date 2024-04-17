import React, { Component } from 'react';
import './App.css';
import AppNavbar from './AppNavbar';
import { Link, useHistory } from 'react-router-dom';
import { Button, Container } from 'reactstrap';
import Cookies from 'js-cookie';

class Home extends Component {

	constructor(props) {
        super(props);
    }

componentDidMount() {
	 const sessionId = Cookies.get('authenticated');
	console.log(sessionId);
	if (sessionId){
		 this.props.history.push("/patients");
	} else {
         this.props.history.push("/loginPage");
	}
    }

    render(){
    	return (
        <div>
        </div>
    )
    }

    /*render() {
        return (
            <div>
                <AppNavbar/>
                <Container fluid>
		    <Button color="link"><Link to="/loginPage">Login</Link></Button>
                    <Button color="link"><Link to="/patients">Patients</Link></Button>
                </Container>
            </div>
        );
    }*/
}
export default Home;
