import React, { createContext, useState } from 'react';

export const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
    const [token, setToken] = useState(localStorage.getItem('authToken') || null);
    const [userId, setUserId] = useState(localStorage.getItem('userId') || null);
    const [nickname, setNickname] = useState(localStorage.getItem('nickname') || null);


    const login = (jwtToken, id, nick) => {
        setToken(jwtToken);
        setUserId(id);
        setNickname(nick);
        localStorage.setItem('authToken', jwtToken);
        localStorage.setItem('userId', id);
        localStorage.setItem('nickname', nick);

    };

    const logout = () => {
        setToken(null);
        setUserId(null);
        setNickname(null);
        localStorage.clear();
    };

    return (
        <AuthContext.Provider value={{ token, userId, nickname, login, logout }}>
            {children}
        </AuthContext.Provider>
    );
};
