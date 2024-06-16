import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import Button from 'react-bootstrap/Button';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import { Container } from 'react-bootstrap';
import API from '../axios/config';

import '../styles/telaCadastro.css';

const Tela_de_Cadastro = () => {
    const navigate = useNavigate();
    const [validated, setValidated] = useState(false);
    const [passwordMatch, setPasswordMatch] = useState(true);
    const [userName, setUserName] = useState("");
    const [userLastName, setUserLastName] = useState("");
    const [userEmail, setUserEmail] = useState("");
    const [userPassword, setUserPassword] = useState("");

    const handleSubmit = async (event) => {
        const form = event.currentTarget;
        const password = form.elements.validationCustom04.value;
        const confirmPassword = form.elements.validationCustom05.value;
        if (form.checkValidity() === false || password !== confirmPassword) {
            event.stopPropagation();

            if (password !== confirmPassword) {
                setPasswordMatch(false);
            }
        } else {
            setPasswordMatch(true);
            const name = userName + " " + userLastName;

            const post = {
                nome_usuario: name,
                email_usuario: userEmail,
                senha_usuario: userPassword
            };

            console.log(post);

            await API.post("/usuario", post);
            navigate("/buscar/");
        }
        event.preventDefault();
        setValidated(true);
    };

    return (
        <Container className='telaCadastro p-4 rounded border border-white'>
            <h1>Cadastro de Login!</h1>
            <Form noValidate validated={validated} onSubmit={handleSubmit}>
                <Row className="mb-3">
                    <Form.Group as={Col} md="6" controlId="validationCustom01">
                        <Form.Label>Nome</Form.Label>
                        <Form.Control
                            required
                            type="text"
                            placeholder="Digite seu nome..."
                            onChange={(e) => setUserName(e.target.value)}
                        />
                        <Form.Control.Feedback>Ok!</Form.Control.Feedback>
                        <Form.Control.Feedback type='invalid'>Por favor coloque seu Nome!</Form.Control.Feedback>
                    </Form.Group>
                    <Form.Group as={Col} md="6" controlId="validationCustom02">
                        <Form.Label>Sobrenome</Form.Label>
                        <Form.Control
                            required
                            type="text"
                            placeholder="Digite seu sobrenome..."
                            onChange={(e) => setUserLastName(e.target.value)}
                        />
                        <Form.Control.Feedback>Ok!</Form.Control.Feedback>
                        <Form.Control.Feedback type='invalid'>Por favor coloque seu Sobrenome!</Form.Control.Feedback>
                    </Form.Group>
                </Row>
                <Row className="mb-3">
                    <Form.Group as={Col} md="6" controlId="validationCustom03">
                        <Form.Label>Email</Form.Label>
                        <Form.Control
                            required
                            type="email"
                            placeholder="Digite seu email..."
                            onChange={(e) => setUserEmail(e.target.value)}
                        />
                        <Form.Control.Feedback>Ok!</Form.Control.Feedback>
                        <Form.Control.Feedback type='invalid'>Por favor coloque seu Email!</Form.Control.Feedback>
                    </Form.Group>
                    <Form.Group as={Col} md="3" controlId="validationCustom04">
                        <Form.Label>Senha</Form.Label>
                        <Form.Control type="password" placeholder="Digite sua senha..." required onChange={(e) => setUserPassword(e.target.value)} />
                        <Form.Control.Feedback>Ok!</Form.Control.Feedback>
                        <Form.Control.Feedback type="invalid">
                            Por favor escolha uma senha!
                        </Form.Control.Feedback>
                    </Form.Group>
                    <Form.Group as={Col} md="3" controlId="validationCustom05">
                        <Form.Label>Repita a Senha</Form.Label>
                        <Form.Control type="password" placeholder="Repita a senha..." required isInvalid={!passwordMatch} />
                        <Form.Control.Feedback type="invalid">
                            {passwordMatch ? 'Por favor reescreva sua senha!' : 'As senhas não coincidem!'}
                        </Form.Control.Feedback>
                    </Form.Group>
                </Row>

                <h2>Endereço</h2>

                <Row className='mb-3'>
                    <Form.Group as={Col} className="mb-3" controlId="validationCustom06">
                        <Form.Label>Rua</Form.Label>
                        <Form.Control placeholder="Digite sua Rua..." required />
                        <Form.Control.Feedback>Ok!</Form.Control.Feedback>
                        <Form.Control.Feedback type='invalid'>
                            Por favor coloque sua rua!
                        </Form.Control.Feedback>
                    </Form.Group>

                    <Form.Group as={Col} controlId="formGridState">
                        <Form.Label>Bairro</Form.Label>
                        <Form.Select required>
                            <option value="">Escolha uma opção!</option>
                            <option value="1">Option 1</option>
                            <option value="2">Option 2</option>
                        </Form.Select>
                        <Form.Control.Feedback type="invalid">
                            Opção Inválida!
                        </Form.Control.Feedback>
                    </Form.Group>

                    <Form.Group as={Col} controlId="formGridState">
                        <Form.Label>Cidade</Form.Label>
                        <Form.Select required>
                            <option value="">Escolha uma opção!</option>
                            <option value="1">Option 1</option>
                            <option value="2">Option 2</option>
                        </Form.Select>
                        <Form.Control.Feedback type="invalid">
                            Opção Inválida!
                        </Form.Control.Feedback>
                    </Form.Group>
                </Row>

                <Row className="mb-3">
                    <Form.Group as={Col} controlId="formGridState">
                        <Form.Label>Estado</Form.Label>
                        <Form.Select required>
                            <option value="">Escolha uma opção!</option>
                            <option value="1">Option 1</option>
                            <option value="2">Option 2</option>
                        </Form.Select>
                        <Form.Control.Feedback type="invalid">
                            Opção Inválida!
                        </Form.Control.Feedback>
                    </Form.Group>

                    <Form.Group as={Col} controlId="formGridState">
                        <Form.Label>Pais</Form.Label>
                        <Form.Select required>
                            <option value="">Escolha uma opção!</option>
                            <option value="1">Option 1</option>
                            <option value="2">Option 2</option>
                        </Form.Select>
                        <Form.Control.Feedback type="invalid">
                            Opção Inválida!
                        </Form.Control.Feedback>
                    </Form.Group>

                    <Form.Group as={Col} controlId="validationCustom06">
                        <Form.Label>CEP</Form.Label>
                        <Form.Control placeholder="Digite seu CEP..." required />
                        <Form.Control.Feedback>Ok!</Form.Control.Feedback>
                        <Form.Control.Feedback type='invalid'>
                            Por favor coloque seu CEP!
                        </Form.Control.Feedback>
                    </Form.Group>
                </Row>

                <h2>Formação</h2>

                <Row className='mb-3'>
                    <Form.Group as={Col} controlId="validationCustom06">
                        <Form.Label>Cursos Completos</Form.Label>
                        <Form.Control placeholder="Digite seus Cursos Completos..." required />
                        <Form.Control.Feedback>Ok!</Form.Control.Feedback>
                        <Form.Control.Feedback type='invalid'>
                            Por favor preencha esse campo!
                        </Form.Control.Feedback>
                    </Form.Group>

                    <Form.Group as={Col} controlId="validationCustom06">
                        <Form.Label>Cursos em Andamento</Form.Label>
                        <Form.Control placeholder="Digite seus Cursos em Andamento..." required />
                        <Form.Control.Feedback>Ok!</Form.Control.Feedback>
                        <Form.Control.Feedback type='invalid'>
                            Por favor preencha esse campo!
                        </Form.Control.Feedback>
                    </Form.Group>
                </Row>

                <h2>Experiencia Profissional</h2>

                <Row>
                    <Form.Group as={Col} controlId="validationCustom06">
                        <Form.Label>Cursos em Andamento</Form.Label>
                        <Form.Control placeholder="Digite seus Cursos em Andamento..." required />
                        <Form.Control.Feedback>Ok!</Form.Control.Feedback>
                        <Form.Control.Feedback type='invalid'>
                            Por favor preencha esse campo!
                        </Form.Control.Feedback>
                    </Form.Group>
                </Row>

                <Form.Group className="mb-3">
                    <Form.Check
                        required
                        label="Aceito os Termos e Condições"
                        feedback="Você precisa aceitar para continuar!"
                        feedbackType="invalid"
                    />
                </Form.Group>
                <Button type="submit">Concluir</Button>
            </Form>
        </Container>
    )
}

export default Tela_de_Cadastro;
