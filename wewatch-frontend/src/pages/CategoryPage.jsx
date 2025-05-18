import React, { useEffect, useState } from 'react';
import { useParams, useNavigate, Link } from 'react-router-dom';
import api from '../services/api';

const CategoryPage = () => {
  const { categoryName } = useParams();
  const [movies, setMovies] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    const fetchMoviesByCategory = async () => {
      try {
        const res = await api.get(`/categories/${encodeURIComponent(categoryName)}`);
        setMovies(res.data);
      } catch (err) {
        console.error('Błąd ładowania filmów z kategorii:', err);
      }
    };
    fetchMoviesByCategory();
  }, [categoryName]);

  return (
    <div className="min-h-screen bg-[#121212] text-white">
      <div className="category-container max-w-[1200px] mx-auto py-10 px-4 text-center">
        <h1 className="text-3xl font-bold text-[#e50914] mb-6">Movies in "{categoryName}"</h1>
        <div className="movie-list flex flex-wrap justify-center gap-6">
          {movies.map((movie) => (
            <div
              key={movie.id}
              className="movie-item w-[150px] text-center"
            >
              <Link to={`/movies/${movie.id}`} className="text-white no-underline">
                <img
                  src={`http://localhost:8080${movie.imagePath}`}
                  alt={movie.title}
                  className="w-full rounded-lg shadow-md"
                />
                <p className="mt-2 hover:text-[#e50914] transition-colors">{movie.title}</p>
              </Link>
            </div>
          ))}
        </div>
        {movies.length === 0 && (
          <p className="text-[#b3b3b3] mt-10">No movies found in this category.</p>
        )}
        <Link to="/" className="back-link inline-block mt-8 text-[#e50914] hover:underline">
          Back to Main Page
        </Link>
      </div>
    </div>
  );
};

export default CategoryPage;
