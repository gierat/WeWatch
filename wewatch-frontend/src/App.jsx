import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import { AuthProvider } from './context/AuthContext';
import LoginPage from './pages/LoginPage';
import RegisterPage from './pages/RegisterPage';
import UserProfilePage from './pages/UserProfilePage';
import MoviePage from './pages/MoviePage';


const App = () => {
    return (
        <AuthProvider>
            <Router>
                <Routes>
                    <Route path="/login" element={<LoginPage />} />
                    <Route path="/register" element={<RegisterPage />} />
                    <Route path="/users/:id" element={<UserProfilePage />} />
                    <Route path="/movies/:id" element={<MoviePage />} />
                    <Route path="/" element={<h1>WeWatch</h1>} />
                </Routes>
            </Router>
        </AuthProvider>
    );
};

export default App;
