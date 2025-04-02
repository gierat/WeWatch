import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { register } from '../../services/authService';

const RegisterForm = () => {
    const [formData, setFormData] = useState({
        firstName: '',
        lastName: '',
        email: '',
        password: '',
    });
    const navigate = useNavigate();

    const handleChange = (e) => {
        setFormData({ ...formData, [e.target.name]: e.target.value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            await register(formData);
            navigate('/login');
        } catch (error) {
            console.error('Błąd rejestracji:', error);
        }
    };

    return (
        <div className="flex items-center justify-center min-h-screen bg-[#121212] text-white px-4">
            <div className="bg-[#1e1e1e] p-8 rounded-lg shadow-lg w-full max-w-md text-center">
                <h1 className="text-3xl font-bold mb-6 text-[#e50914]">Register</h1>
                <form onSubmit={handleSubmit} className="flex flex-col text-left">
                    <label className="mb-1 text-sm">First Name:</label>
                    <input
                        type="text"
                        name="firstName"
                        value={formData.firstName}
                        onChange={handleChange}
                        className="mb-4 p-3 rounded bg-[#2a2a2a] text-white focus:outline-none focus:ring-2 focus:ring-[#e50914]"
                        required
                    />

                    <label className="mb-1 text-sm">Last Name:</label>
                    <input
                        type="text"
                        name="lastName"
                        value={formData.lastName}
                        onChange={handleChange}
                        className="mb-4 p-3 rounded bg-[#2a2a2a] text-white focus:outline-none focus:ring-2 focus:ring-[#e50914]"
                        required
                    />

                    <label className="mb-1 text-sm">Email:</label>
                    <input
                        type="email"
                        name="email"
                        value={formData.email}
                        onChange={handleChange}
                        className="mb-4 p-3 rounded bg-[#2a2a2a] text-white focus:outline-none focus:ring-2 focus:ring-[#e50914]"
                        required
                    />

                    <label className="mb-1 text-sm">Password:</label>
                    <input
                        type="password"
                        name="password"
                        value={formData.password}
                        onChange={handleChange}
                        className="mb-4 p-3 rounded bg-[#2a2a2a] text-white focus:outline-none focus:ring-2 focus:ring-[#e50914]"
                        required
                    />

                    <button
                        type="submit"
                        className="bg-[#e50914] hover:bg-[#f40612] text-white py-3 rounded transition-colors duration-300 ease-in-out"
                    >
                        Register
                    </button>
                </form>

                <p className="mt-4 text-sm text-[#b3b3b3]">
                    Already have an account?{' '}
                    <a href="/login" className="text-[#e50914] hover:underline">
                        Login here
                    </a>.
                </p>
            </div>
        </div>
    );
};

export default RegisterForm;
