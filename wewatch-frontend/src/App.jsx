import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import { AuthProvider } from './context/AuthContext';
import HomePage from './pages/HomePage';
import LoginPage from './pages/LoginPage';
import RegisterPage from './pages/RegisterPage';
import UserProfilePage from './pages/UserProfilePage';
import MoviePage from './pages/MoviePage';
import Navbar from './components/layout/Navbar';


const App = () => {
    return (
        <AuthProvider>
            <Router>
                <Routes>
                    <Route path="/" element={<HomePage />} />
                    <Route path="/login" element={<LoginPage />} />
                    <Route path="/register" element={<RegisterPage />} />
                    <Route path="/users/:id" element={<UserProfilePage />} />
                    <Route path="/movies/:id" element={<MoviePage />} />
                </Routes>
            </Router>
        </AuthProvider>
    );
};

export default App;
