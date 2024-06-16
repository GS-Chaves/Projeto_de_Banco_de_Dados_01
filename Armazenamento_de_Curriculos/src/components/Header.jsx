import React from 'react'

import logo from '../assets/CVPedia_Logo.jpg'
import loginImage from '../assets/login.png'

import Image from 'react-bootstrap/Image';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';

import '../styles/header.css'

const Header = () => {

    const logado = 'Faça Login'

    return (
        <div>
            <Navbar expand="lg" className="navbar bg-body-tertiary">
                <Container>
                    <Navbar.Brand href="/"><Image className='logo' src={logo} rounded /></Navbar.Brand>
                    <Navbar.Toggle aria-controls="basic-navbar-nav" />
                    <Navbar.Collapse id="basic-navbar-nav">
                        <Nav className="mx-auto">
                            <Nav.Link className='mx-lg-2 link-header' href="/buscar/">Buscar</Nav.Link>
                            <Nav.Link className='mx-lg-2 link-header' href="/login/">Login</Nav.Link>
                        </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
        </div>
    )
}

export default Header
