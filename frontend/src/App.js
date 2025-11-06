import { BrowserRouter, Routes, Route } from 'react-router-dom';

import HomePage from './pages/HomePage';
import LoginPage from './pages/LoginPage';
import RegisterPage from './pages/RegisterPage';
import DespesasPage from './pages/DespesasPage';
import ReceitasPage from './pages/ReceitasPage';
import ErroPage from './pages/ErroPage';
import PrivateRoute from './components/PrivateRoute';

function App() {
  return (
    <BrowserRouter>
      <Routes>

        <Route path="/login" element={<LoginPage />} />
        <Route path="/register" element={<RegisterPage />} />

        <Route element={<PrivateRoute />}>
          <Route path="/" element={<HomePage />} />
          <Route path="/despesas" element={<DespesasPage />} />
          <Route path="/receitas" element={<ReceitasPage />} />
        </Route>

        <Route path="*" element={<ErroPage />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;