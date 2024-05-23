import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import './index.css'

import { createBrowserRouter, RouterProvider } from 'react-router-dom'

import Tela_Inicial from './pages/Tela_Inicial.jsx'
import Tela_de_Login from './pages/Tela_de_Login.jsx'
import Tela_de_Cadastro from './pages/Tela_de_Cadastro.jsx'
import Tela_de_Busca from './pages/Tela_Resultado_de_Busca.jsx'
import Tela_de_Curriculo from './pages/Tela_de_Curriculo.jsx'
import Tela_de_Novo_Curriculo from './pages/Tela_Criacao_de_Curriculo.jsx'
import Tela_Alterar_Curriculo from './pages/Tela_de_Alteracao_de_Curriculo.jsx'
import Tela_Esqueceu_Senha from './pages/Tela_Esqueceu_Senha.jsx'

import Pagina_de_Erro from './pages/Pagina_de_Erro.jsx'


const router = createBrowserRouter([
  {
    path: "/",
    element: <App />,
    errorElement: <Pagina_de_Erro />,
    children: [
      {
        path: "/",
        element: <Tela_Inicial />,
      },
      {
        path: "login",
        element: <Tela_de_Login />,
      },
      {
        path: "cadastro",
        element: <Tela_de_Cadastro />,
      },
      {
        path: "buscar",
        element: <Tela_de_Busca />,
      },
      {
        path: "novo-curriculo",
        element: <Tela_de_Novo_Curriculo />,
      },
      {
        path: "curriculo",
        element: <Tela_de_Curriculo />,
      },
      {
        path: "alterar",
        element: <Tela_Alterar_Curriculo />,
      },
      {
        path: "esqueceu-senha",
        element: <Tela_Esqueceu_Senha />,
      },
    ]
  }
]);

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>,
)
