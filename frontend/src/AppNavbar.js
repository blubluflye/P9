import React, {Component} from 'react';
import {Navbar, NavbarBrand} from 'reactstrap';
import {Link} from 'react-router-dom';
import Cookies from 'js-cookie';

export default class AppNavbar extends Component {
    constructor(props) {
        super(props);
        this.state = {isOpen: false};
        this.toggle = this.toggle.bind(this);
    }
    logout(){
        if(window.confirm("Are you sure want to Logout?")) {
            fetch('/logout');
	    Cookies.remove('authenticated');
                window.location.href = '/';
            }
    }



    toggle() {
        this.setState({
            isOpen: !this.state.isOpen
        });
    }

    render() {
        return <Navbar color="dark" dark expand="md">
            <NavbarBrand tag={Link} to="/">Home</NavbarBrand>
		    <p><button onClick={this.logout.bind(this)}>Logout</button></p>
        </Navbar>;
    }
}
