import React, { createContext, useState } from 'react';

export const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
    const [token, setToken] = useState(localStorage.getItem('authToken') || null);
    const [userId, setUserId] = useState(localStorage.getItem('userId') || null);
    const [nickname, setNickname] = useState(localStorage.getItem('nickname') || null);
    const [role, setRole] = useState(localStorage.getItem('authRole') || null);


    const login = (jwtToken, id, nick, role) => {
        setToken(jwtToken);
        setUserId(id);
        setNickname(nick);
        setRole(role);
        localStorage.setItem('authToken', jwtToken);
        localStorage.setItem('userId', id);
        localStorage.setItem('nickname', nick);
        localStorage.setItem('role', role);
    };

    const logout = () => {
        setToken(null);
        setUserId(null);
        setNickname(null);
        setRole(null);
        localStorage.clear();
    };

    return (
        <AuthContext.Provider value={{ token, userId, nickname, role, login, logout }}>
            {children}
        </AuthContext.Provider>
    );
};
