import React, { useState, useContext } from 'react';
import { useNavigate } from 'react-router-dom';
import { AuthContext } from '../../context/AuthContext';
import { login } from '../../services/authService';

const LoginForm = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const { login: loginContext } = useContext(AuthContext);
    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const data = await login({ email, password });
            if(data.token){
                loginContext(data.token, data.userId, data.nickname);
            }
            navigate('/');
        } catch (error) {
            console.error('Błąd logowania:', error);
        }
    };

    return (
        <div className="flex items-center justify-center min-h-screen bg-[#121212] text-white px-4">
            <div className="bg-[#1e1e1e] p-8 rounded-lg shadow-lg w-full max-w-md text-center">
                <h1 className="text-3xl font-bold mb-6 text-[#e50914]">Login</h1>
                <form onSubmit={handleSubmit} className="flex flex-col text-left">
                    <label className="mb-1 text-sm">Email:</label>
                    <input
                        type="email"
                        className="mb-4 p-3 rounded bg-[#2a2a2a] text-white focus:outline-none focus:ring-2 focus:ring-[#e50914]"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                        required
                    />
                    <label className="mb-1 text-sm">Password:</label>
                    <input
                        type="password"
                        className="mb-4 p-3 rounded bg-[#2a2a2a] text-white focus:outline-none focus:ring-2 focus:ring-[#e50914]"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        required
                    />
                    <button
                        type="submit"
                        className="bg-[#e50914] hover:bg-[#f4061205] text-white py-3 rounded transition duration-300 ease-in-out"
                    >
                        Login
                    </button>
                </form>
                <p className="mt-4 text-sm text-[#b3b3b3]">
                    Don't have an account? <a href="/register" className="text-[#e50914] hover:underline">Register here</a>.
                </p>
            </div>
        </div>
    );
};

export default LoginForm;
