import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import { Link } from 'react-router-dom';
import { useState } from 'react';

import React from 'react'
import '../styles/esqueceuSenha.css'

const Tela_Esqueceu_Senha = () => {
    const [userName, setUserName] = useState("");

    const handleSubmit = (event) => {
        event.preventDefault();
        alert("Email de Recuperação: " + userName);
    };

    return (
        <div className="retrievalPage">
            <Form className='p-4 rounded border border-white' id='formEmail' onSubmit={handleSubmit}>
                <h1 className='titleRetrieval'>Digite o Email Cadastrado!</h1>
                <Form.Group className="mb-3" controlId="formBasicEmail">
                    <Form.Label>Email</Form.Label>
                    <Form.Control type="email" placeholder="Email" required onChange={(e) => setUserName(e.target.value)} />
                </Form.Group>
                <Button className='col-md-12' variant="primary" type="submit">
                    Recuperar Senha!
                </Button>
                <div className='voltarLogin'>
                    <Link className='voltarLoginLink' to="/login">Voltar ao Login</Link>
                </div>
            </Form>
        </div>
    )
}

export default Tela_Esqueceu_Senha
