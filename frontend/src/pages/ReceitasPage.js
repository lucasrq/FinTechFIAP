import React, { useState, useEffect } from 'react';
import api from '../services/api';
import './DespesasPage.css'
import '../index.css'; 

function ReceitasPage() {
  const [receitas, setReceitas] = useState([]);
  const [descricao, setDescricao] = useState('');
  const [valor, setValor] = useState('');
  const [usuarioId, setUsuarioId] = useState(null);
  const [editandoId, setEditandoId] = useState(null);

  useEffect(() => {
    const usuarioString = localStorage.getItem('usuarioLogado');
    if (usuarioString) {
      const usuario = JSON.parse(usuarioString);
      setUsuarioId(usuario.id);
    }
  }, []);

  useEffect(() => {
    if (usuarioId) {
      api.get(`/receita/receita-usuario/${usuarioId}`)
        .then(response => {
          setReceitas(response.data);
        })
        .catch(error => console.error("Erro ao buscar receitas:", error));
    }
  }, [usuarioId]);

  const resetForm = () => {
    setDescricao('');
    setValor('');
    setEditandoId(null);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (!usuarioId) return;

    const dadosReceita = {
      descricao,
      valor: parseFloat(valor),
      dataRecebimento: new Date().toISOString().split('T')[0],
      usuario: { id: usuarioId }
    };

    if (editandoId) {
      try {
        const response = await api.put(`/receita/${editandoId}`, dadosReceita);
        setReceitas(receitas.map(r => (r.id === editandoId ? response.data : r)));
        resetForm();
      } catch (error) {
        console.error("Erro ao atualizar receita:", error);
      }
    } else {
      try {
        const response = await api.post('/receita', dadosReceita);
        setReceitas([...receitas, response.data]);
        resetForm();
      } catch (error) {
        console.error("Erro ao criar receita:", error);
      }
    }
  };

  const handleDelete = async (idReceita) => {
    try {
      await api.delete(`/receita/${idReceita}`);
      setReceitas(receitas.filter(r => r.id !== idReceita));
    } catch (error) {
      console.error("Erro ao deletar receita:", error);
    }
  };

  const handleEdit = (receita) => {
    setEditandoId(receita.id);
    setDescricao(receita.descricao);
    setValor(receita.valor);
  };

  return (
    <div className="container">
      <h2>Minhas Receitas</h2>
      
      <form onSubmit={handleSubmit} className="crud-form">
        <input type="text" placeholder="Descrição" value={descricao} onChange={(e) => setDescricao(e.target.value)} required />
        <input type="number" placeholder="Valor" value={valor} onChange={(e) => setValor(e.target.value)} required />
        <button type="submit">{editandoId ? 'Atualizar' : 'Adicionar'}</button>
        {editandoId && <button type="button" onClick={resetForm}>Cancelar</button>}
      </form>
      
      <ul className="crud-list">
        {receitas.map(receita => (
          <li key={receita.id}>
            <span>{receita.descricao} - R$ {receita.valor.toFixed(2)}</span>
            <div className="list-item-buttons">
              <button onClick={() => handleEdit(receita)}>Editar</button>
              <button onClick={() => handleDelete(receita.id)}>Excluir</button>
            </div>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default ReceitasPage;