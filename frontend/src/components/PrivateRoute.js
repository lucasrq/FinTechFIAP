import React from 'react';
import { Navigate, Outlet } from 'react-router-dom';

const useAuth = () => {
  const usuario = localStorage.getItem('usuarioLogado');
  return usuario ? true : false;
};

const PrivateRoute = () => {
  const isAuth = useAuth();
  return isAuth ? <Outlet /> : <Navigate to="/login" />;
};

export default PrivateRoute;