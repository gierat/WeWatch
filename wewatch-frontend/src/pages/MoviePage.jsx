import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import api from '../services/api';

const MoviePage = () => {
  const { id } = useParams();
  const [movie, setMovie] = useState(null);

  useEffect(() => {
    const fetchMovie = async () => {
      try {
        const response = await api.get(`/movies/${id}`);
        setMovie(response.data);
      } catch (err) {
        console.error('Error fetching movie:', err);
      }
    };
    fetchMovie();
  }, [id]);

  if (!movie) return <p className="text-white">Loading...</p>;

  return (
    <div className="wrapper bg-[#121212] text-white min-h-screen">
      <div className="movie-container max-w-6xl mx-auto bg-[#1e1e1e] p-6 rounded-lg shadow-lg mt-6">
        <div className="movie-columns flex flex-col md:flex-row gap-6">
          <div className="movie-poster w-full md:max-w-xs">
            <img
              src={`http://localhost:8080${movie.imagePath}`}
              alt={movie.title}
              className="rounded-lg shadow-md"
            />
          </div>
          <div className="movie-details flex flex-col justify-between">
            <h1 className="text-3xl font-bold text-[#e50914] mb-4">{movie.title}</h1>
            <p className="mb-4 leading-relaxed">{movie.description}</p>
            <div className="categories">
              <h3 className="text-xl mb-2 text-[#e50914]">Categories</h3>
              <div className="category-buttons flex flex-wrap gap-2">
                {movie.categories.map((cat, i) => (
                  <a
                    key={i}
                    href={`/category/${encodeURIComponent(cat)}`}
                    className="category-button border border-[#e50914] px-4 py-2 rounded-md hover:bg-[#e50914] hover:text-white text-sm"
                  >
                    {cat}
                  </a>
                ))}
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default MoviePage;