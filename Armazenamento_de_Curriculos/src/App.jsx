import './App.css'

import Header from './components/Header'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import Tela_Inicial from './pages/Tela_Inicial.jsx'
import Tela_de_Login from './pages/Tela_de_Login.jsx'
import Tela_de_Cadastro from './pages/Tela_de_Cadastro.jsx'
import Tela_de_Busca from './pages/Tela_Resultado_de_Busca.jsx'
import Tela_de_Curriculo from './pages/Tela_de_Curriculo.jsx'
import Tela_de_Novo_Curriculo from './pages/Tela_Criacao_de_Curriculo.jsx'
import Tela_Alterar_Curriculo from './pages/Tela_de_Alteracao_de_Curriculo.jsx'

import ProtectedRoutes from './utils/ProtectedRoutes.jsx'

function App() {
  return (
    <>
      <div className="app">
        <Header />
        <BrowserRouter>
          <Routes>
            <Route element={<Tela_de_Login />} path="/login" />
            <Route element={<Tela_de_Cadastro />} path="/cadastro" />
            <Route element={<ProtectedRoutes />}>
              <Route element={<Tela_Inicial />} path="/" />
              <Route element={<Tela_de_Busca />} path="/buscar" />
              <Route element={<Tela_de_Novo_Curriculo />} path="/novo-curriculo" />
              <Route element={<Tela_de_Curriculo />} path="/curriculo" />
              <Route element={<Tela_Alterar_Curriculo />} path="/alterar" />
            </Route>

          </Routes>
        </BrowserRouter>

      </div>
    </>
  )
}

export default App
