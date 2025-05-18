import React, { useEffect, useState, useContext } from 'react';
import { Link } from 'react-router-dom';
import api from '../../services/api';
import { AuthContext } from '../../context/AuthContext';

const Navbar = () => {
  const [categories, setCategories] = useState([]);
  const { token, userId, nickname, logout } = useContext(AuthContext);

  useEffect(() => {
    const fetchCategories = async () => {
      try {
        const res = await api.get('/categories');
        setCategories(res.data);
      } catch (err) {
        console.error('Failed to fetch categories', err);
      }
    };
    fetchCategories();
  }, []);

  return (
    <nav className="bg-[#1e1e1e] text-white px-6 py-4 shadow flex justify-between items-center">
      <Link to="/" className="text-2xl font-bold text-[#e50914]">WeWatch</Link>
      <ul className="flex gap-6 items-center">
        <li className="relative group">
          <div className="cursor-pointer hover:text-[#e50914]">
            Categories
          </div>
          <div className="absolute left-0 top-full 
            opacity-0 group-hover:opacity-100 
            scale-y-95 group-hover:scale-y-100
            pointer-events-none group-hover:pointer-events-auto 
            origin-top transform transition-all duration-700 ease-out 
            text-sm rounded shadow-lg bg-[#2a2a2a] z-50">
            <div className="flex flex-col">
              {categories.map((category, idx) => (
                <Link
                  key={idx}
                  to={`/categories/${encodeURIComponent(category)}`}
                  className="block px-4 py-2 hover:bg-[#e50914] hover:text-white whitespace-nowrap"
                >
                  {category}
                </Link>
              ))}
            </div>
          </div>
        </li>
        {token && (
          <>
            <li>
              <Link to={`/users/${userId}`} className="hover:text-[#e50914]">
                <i className="ri-user-line mr-1"></i>{nickname}
              </Link>
            </li>
            <li>
              <button onClick={logout} className="hover:text-[#e50914]">Logout</button>
            </li>
          </>
        )}
        {!token && (
          <>
            <li><Link to="/login" className="hover:text-[#e50914]">Login</Link></li>
            <li><Link to="/register" className="hover:text-[#e50914]">Register</Link></li>
          </>
        )}
      </ul>
    </nav>
  );
};

export default Navbar;