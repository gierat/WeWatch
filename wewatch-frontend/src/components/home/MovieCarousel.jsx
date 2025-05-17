import React, { useEffect, useState, useRef } from 'react';
import api from '../../services/api';
import { useNavigate } from 'react-router-dom';

const MovieCarousel = () => {
  const [movies, setMovies] = useState([]);
  const containerRef = useRef(null);
  const navigate = useNavigate();

  useEffect(() => {
    const fetchMovies = async () => {
      try {
        const res = await api.get('/movies');
        setMovies(res.data.slice(0, 8));
      } catch (err) {
        console.error('Błąd pobierania filmów:', err);
      }
    };
    fetchMovies();
  }, []);

  const scrollLeft = () => {
    containerRef.current.scrollBy({ left: -300, behavior: 'smooth' });
  };

  const scrollRight = () => {
    containerRef.current.scrollBy({ left: 300, behavior: 'smooth' });
  };

  return (
    <div className="relative">
      <button
        onClick={scrollLeft}
        className="absolute left-0 top-1/2 transform -translate-y-1/2 bg-black/50 text-white px-2 py-1 z-10 rounded hover:bg-black/70"
      >
        &#10094;
      </button>
      <div
        ref={containerRef}
        className="flex overflow-x-auto no-scrollbar space-x-4 px-6"
        style={{ scrollSnapType: 'x mandatory' }}
      >
        {movies.map((movie) => (
          <div
            key={movie.id}
            className="min-w-[180px] max-w-[180px] flex-shrink-0 cursor-pointer"
            onClick={() => navigate(`/movies/${movie.id}`)}
          >
            <img
              src={`http://localhost:8080${movie.imagePath}`}
              alt={movie.title}
              className="rounded shadow-md hover:scale-105 transition-transform duration-300"
            />
          </div>
        ))}
      </div>
      <button
        onClick={scrollRight}
        className="absolute right-0 top-1/2 transform -translate-y-1/2 bg-black/50 text-white px-2 py-1 z-10 rounded hover:bg-black/70"
      >
        &#10095;
      </button>
    </div>
  );
};

export default MovieCarousel;