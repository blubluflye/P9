import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link} from 'react-router-dom';
import { useParams , withRouter} from 'react-router';

class TestDiabete extends Component {


    emptyItem = {
        result: '',
    };

    constructor(props) {
        super(props);
        this.state = {
	    item: this.emptyItem
	};
    }

    async componentDidMount() {
	console.log(this.props.match.params);
	const result =await (await fetch(`/TestDb/${this.props.match.params.id}`)).json();
        this.setState({item: result});
    }

    render() {
        const {item} = this.state;
        return (
        <div>
            <AppNavbar/>
            <Container fluid>
	       <h3>result : {item.result}</h3>
            </Container>
        </div>
    );

  }
}
export default withRouter(TestDiabete);

