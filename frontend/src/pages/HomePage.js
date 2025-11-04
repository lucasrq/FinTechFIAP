import React from 'react';
import { useNavigate } from 'react-router-dom';
import './HomePage.css';
import '../index.css';

function HomePage() {
  const navigate = useNavigate();
  const usuario = JSON.parse(localStorage.getItem('usuarioLogado'));

  const handleLogout = () => {
    localStorage.removeItem('usuarioLogado');
    navigate('/login');
  };

  return (

    <div className="container">
      <div className="home-header">
        <h2>Bem-vindo, {usuario ? usuario.nome : 'Usuário'}!</h2>
        <button onClick={handleLogout} className="logout-button">
          Sair
        </button>
      </div>
      
      <p>Selecione uma opção para gerenciar suas finanças:</p>
      
      <nav className="home-nav">
        <button onClick={() => navigate('/despesas')} className="nav-button">
          Ver Despesas
        </button>
        <button onClick={() => navigate('/receitas')} className="nav-button receitas">
          Ver Receitas
        </button>
      </nav>
    </div>
  );
}

export default HomePage;