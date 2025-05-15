import React, { useEffect, useState, useContext } from 'react';
import { Link } from 'react-router-dom';
import api from '../../services/api';
import { AuthContext } from '../../context/AuthContext';

const Navbar = () => {
  const [categories, setCategories] = useState([]);
  const { token, logout } = useContext(AuthContext);

  const userId = localStorage.getItem('userId');
  const nickname = localStorage.getItem('nickname');

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
          <span className="cursor-pointer hover:text-[#e50914]">Categories</span>
          <div className="absolute hidden group-hover:block bg-[#2a2a2a] text-sm mt-2 rounded shadow-lg z-50">
            {categories.map((category, idx) => (
              <Link
                key={idx}
                to={`/category/${encodeURIComponent(category)}`}
                className="block px-4 py-2 hover:bg-[#e50914] hover:text-white whitespace-nowrap"
              >
                {category}
              </Link>
            ))}
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