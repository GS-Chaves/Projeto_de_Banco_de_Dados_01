import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import { Link } from 'react-router-dom';
import { useState } from 'react';

import '../styles/login.css'

const Tela_de_Login = () => {
    const [userName, setUserName] = useState("");
    const [userPassword, setPassWord] = useState("");

    const handleSubmit = (event) => {
        event.preventDefault();
        alert("Enviando os dados: " + userName + " - " + userPassword);
    };

    return (

        <div className='telaLogin'>
            <div className="loginForm">
                <Form className='p-4 rounded border border-white' id='formLogin' onSubmit={handleSubmit}>
                    <h1 className='title'>Bem Vindo!</h1>
                    <Form.Group className="mb-3" controlId="formBasicEmail">
                        <Form.Label>Email</Form.Label>
                        <Form.Control type="email" placeholder="Email" required onChange={(e) => setUserName(e.target.value)} />
                    </Form.Group>
                    <Form.Group className="mb-3" controlId="formBasicPassword">
                        <Form.Label>Senha</Form.Label>
                        <Form.Control type="password" placeholder="Senha" required onChange={(e) => setPassWord(e.target.value)} />
                    </Form.Group>
                    <Button className='col-md-12' variant="primary" type="submit">
                        Login
                    </Button>
                    <p className='registrar'>Não tem uma conta? <a className='linkRegistrar' href="/cadastro/">Cadastre-se</a></p>
                </Form>
            </div>
        </div>
    )
}

export default Tela_de_Login
