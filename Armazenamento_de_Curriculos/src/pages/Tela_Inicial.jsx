import '../styles/tela_inicial.css'

import React from 'react'

import Button from 'react-bootstrap/Button';
import { Row, Col, Container } from 'react-bootstrap';
import Form from 'react-bootstrap/Form';
import { FaSearch } from 'react-icons/fa';

import { Link } from 'react-router-dom';

const Tela_Inicial = () => {
    return (
        <div className='tela_Inicial'>
            <Form className='form rounded border border-white'>
                <h1>Bem Vindo!</h1>
                <Container className='titleInicial'>
                    Qual Curriculo deseja ver?
                    <Form className="d-flex">
                        <Form.Control
                            type="search"
                            placeholder="Search"
                            className="me-2"
                            aria-label="Search"
                        />
                        <Button href='buscar' variant="primary"><FaSearch /></Button>
                    </Form>

                    <Row xs='auto'>
                        <Col sm={2}></Col>
                        <Col sm={7}>
                            <Button className='botao-login-inicial' variant='primary' href='/meu-curriculo' type='button'>Meu Curriculo</Button>
                        </Col>
                    </Row>
                </Container>
            </Form>
        </div>
    )
}

export default Tela_Inicial
