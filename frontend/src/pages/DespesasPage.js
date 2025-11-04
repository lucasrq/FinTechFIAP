import React, { useState, useEffect } from 'react';
import api from '../services/api';
import './DespesasPage.css';
import '../index.css';

function DespesasPage() {
  const [despesas, setDespesas] = useState([]);
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
      api.get(`/despesa/despesa-usuario/${usuarioId}`)
        .then(response => {
          setDespesas(response.data);
        })
        .catch(error => console.error("Erro ao buscar despesas:", error));
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

    const dadosDespesa = {
      descricao,
      valor: parseFloat(valor),
      categoria: "Padrão",
      pago: 'S',
      dataPagamento: new Date().toISOString().split('T')[0],
      usuario: { id: usuarioId }
    };

    if (editandoId) {
      try {
        const response = await api.put(`/despesa/${editandoId}`, dadosDespesa);
        setDespesas(despesas.map(d => (d.id === editandoId ? response.data : d)));
        resetForm();
      } catch (error) {
        console.error("Erro ao atualizar despesa:", error);
      }
    } else {
      try {
        const response = await api.post('/despesa', dadosDespesa);
        setDespesas([...despesas, response.data]);
        resetForm();
      } catch (error) {
        console.error("Erro ao criar despesa:", error);
      }
    }
  };

  const handleDelete = async (idDespesa) => {
    try {
      await api.delete(`/despesa/${idDespesa}`);
      setDespesas(despesas.filter(d => d.id !== idDespesa));
    } catch (error) {
      console.error("Erro ao deletar despesa:", error);
    }
  };

  const handleEdit = (despesa) => {
    setEditandoId(despesa.id);
    setDescricao(despesa.descricao);
    setValor(despesa.valor);
  };


  return (
    <div className="container"> 
      <h2>Minhas Despesas</h2>
      
      <form onSubmit={handleSubmit} className="crud-form">
        <input type="text" placeholder="Descrição" value={descricao} onChange={(e) => setDescricao(e.target.value)} required />
        <input type="number" placeholder="Valor" value={valor} onChange={(e) => setValor(e.target.value)} required />
        <button type="submit">{editandoId ? 'Atualizar' : 'Adicionar'}</button>
        {editandoId && <button type="button" onClick={resetForm}>Cancelar</button>}
      </form>
      
      <ul className="crud-list">
        {despesas.map(despesa => (
          <li key={despesa.id}>
            <span>{despesa.descricao} - R$ {despesa.valor.toFixed(2)}</span>
            <div className="list-item-buttons">
              <button onClick={() => handleEdit(despesa)}>Editar</button>
              <button onClick={() => handleDelete(despesa.id)}>Excluir</button>
            </div>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default DespesasPage;