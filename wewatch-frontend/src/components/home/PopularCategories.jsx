import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import api from '../../services/api';

const PopularCategories = () => {
  const [categories, setCategories] = useState([]);

  useEffect(() => {
    const fetchCategories = async () => {
      try {
        const res = await api.get('/categories');
        setCategories(res.data);
      } catch (err) {
        console.error('Błąd ładowania kategorii:', err);
      }
    };
    fetchCategories();
  }, []);

  return (
    <section className="categories text-center my-8 px-4">
      <h2 className="text-[1.8rem] text-[#e50914] mb-4 font-semibold">Popular Categories</h2>
      <div className="category-list flex flex-wrap justify-center gap-4">
        {categories.map((category, index) => (
          <Link key={index} to={`/category/${encodeURIComponent(category)}`} className="text-white no-underline">
            <div className="category bg-[#1e1e1e] px-5 py-2 text-sm rounded hover:bg-[#e50914] transition-colors w-32">
              {category}
            </div>
          </Link>
        ))}
      </div>
    </section>
  );
};

export default PopularCategories;
