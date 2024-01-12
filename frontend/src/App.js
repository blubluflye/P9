import logo from './logo.svg';
import './App.css';
import React, { Component } from 'react';

class App extends Component {
	state = {
		patients: []
	};

	async componentDidMount() {
		const response = await fetch('/patients');
		const body = await response.json();
		this.setState({patients: body});
	}

	render() {
		const {patients} = this.state;
	return (
		<div className="App">
			<header className="App-header">
				<img src={logo} className="App-logo" alt="logo" />
		         	<div className="App-intro">
					<h2>Patients</h2>
					{patients.map(patient =>
                  				<div key={patient.id}>
                    					{patient.name} {patient.surname}
                  				</div>
              				)}
            			</div>
          		</header>
        	</div>
		);
	}
}

export default App;
