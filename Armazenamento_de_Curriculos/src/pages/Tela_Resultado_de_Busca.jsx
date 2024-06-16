import React, { useEffect, useState } from 'react';
import API from '../axios/config';
import ListGroup from 'react-bootstrap/ListGroup';
import { Button, Col, Container, Form, Row } from 'react-bootstrap';

import '../styles/tela_resultado_de_busca.css'
import { FaSearch } from 'react-icons/fa';
import { Link } from 'react-router-dom';

const Tela_Resultado_de_Busca = () => {
    const [curriculos, setCurriculos] = useState([]);

    const getCurriculos = async () => {
        try {
            const response = await API.get('/usuario'); // Usa a instância personalizada do Axios
            const data = response.data;
            setCurriculos(data); // Armazena os dados recebidos no estado
            console.log(data);
        } catch (error) {
            console.log(error);
        }
    };

    useEffect(() => {
        getCurriculos();
    }, []);

    return (
        <div className='resultadoBusca'>
            <Container className='form rounded border border-white'>
                <Row>
                    <Col xs lg="2">
                        <Form>
                            <Form.Control
                                type='search'
                                placeholder='Buscar'
                                aria-label='Search'
                            />
                        </Form>
                    </Col>
                    <Col xs lg="2">
                        <Button href='' variant='primary'><FaSearch /></Button>
                    </Col>
                </Row>
                <Row className='justify-content-md-center'>
                    <Col md="auto">
                        <h1 className='titleResult'>Resultado de Busca</h1>
                    </Col>
                </Row>
                <ListGroup>
                    {curriculos.length === 0 ? <p>Carregando...</p> : (curriculos.map(curriculo => (
                        <ListGroup.Item action href={'/curriculo/' + curriculo.id_usuario} key={curriculo.id_usuario}>{curriculo.nome_usuario}, {curriculo.email_usuario}, {curriculo.senha_usuario}</ListGroup.Item>
                    ))
                    )}
                </ListGroup>
            </Container>
        </div>
    );
};

export default Tela_Resultado_de_Busca;
