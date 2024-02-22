import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

class TestDiabete extends Component {

    constructor(props) {
        super(props);
        this.state = {
	    item: ""
	};
    }

    componentDidMount() {
        const result = fetch(`/TestDb/${this.props.match.params.id}`);
	this.setState({item: result});
    }

    render() {
        const {result} = this.state;
        return (
        <div>
            <AppNavbar/>
            <Container fluid>
	       <h3>result : {result}</h3>
            </Container>
        </div>
    );

  }
}
export default TestDiabete;

