import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import AppNavbar from './AppNavbar';

class NoteAdd extends Component {

    emptyItem = {
        name: '',
        note: ''
    };

    constructor(props) {
        super(props);
        this.state = {
            item: this.emptyItem
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
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

        await fetch('/notes' + (this.props.match.params.id), {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(item),
        });
        this.props.history.push(`/notes/${this.props.match.params.id}`);
    }

    render() {
        const {item} = this.state;
        const title = <h2>Add Note</h2>;

        return <div>
            <AppNavbar/>
            <Container>
                {title}
                <Form onSubmit={this.handleSubmit}>
                    <FormGroup>
                        <Label for="name">Name</Label>
                        <Input type="text" name="name" id="name" value={item.name || ''}
                            onChange={this.handleChange} autoComplete="name"/>
                </FormGroup>
                <FormGroup>
                    <Label for="note">Note</Label>
                    <Input type="text" name="note" id="note" value={item.note || ''}
                           onChange={this.handleChange} autoComplete="note"/>
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

export default withRouter(NoteAdd);
