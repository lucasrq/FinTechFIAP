import React, { useState } from 'react';
import { useNavigate, Link } from 'react-router-dom';
import api from '../services/api';
import './LoginPage.css';

function RegisterPage() {
  const [nome, setNome] = useState('');
  const [email, setEmail] = useState('');
  const [senha, setSenha] = useState('');
  const navigate = useNavigate();

  const handleRegister = async (e) => {
    e.preventDefault();
    
    const novoUsuario = {
      nome,
      email,
      senha,
    };

    try {
      await api.post('/usuario', novoUsuario);
      
      alert('Cadastro realizado com sucesso! Faça o login.');
      navigate('/login');
    } catch (error) {
      alert('Erro ao cadastrar. Verifique se o e-mail já existe.');
      console.error("Erro no cadastro:", error);
    }
  };

  return (
    <div className="login-container">
      <form onSubmit={handleRegister} className="login-form">
        <h2>Cadastre-se</h2>
        
        <input 
          type="text" 
          value={nome} 
          onChange={(e) => setNome(e.target.value)} 
          placeholder="Nome Completo" 
          required 
        />
        
        <input 
          type="email" 
          value={email} 
          onChange={(e) => setEmail(e.target.value)} 
          placeholder="Email" 
          required 
        />
        
        <input 
          type="password" 
          value={senha} 
          onChange={(e) => setSenha(e.target.value)} 
          placeholder="Senha" 
          required 
        />
        
        <button type="submit">Cadastrar</button>
        
        <p style={{ textAlign: 'center', marginTop: '20px' }}>
          Já tem uma conta? <Link to="/login">Faça o login</Link>
        </p>
      </form>
    </div>
  );
}

export default RegisterPage;