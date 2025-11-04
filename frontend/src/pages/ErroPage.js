import React from 'react';
import { Link } from 'react-router-dom';
import './ErroPage.css';

function ErroPage() {
  return (
    <div className="error-container">
      <h2>404</h2>
      <p>Ops! A página que você está procurando não foi encontrada.</p>
      <Link to="/">Voltar para a página inicial</Link>
    </div>
  );
}

export default ErroPage;