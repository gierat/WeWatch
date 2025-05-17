import React, { useEffect, useRef, useState } from 'react';
import api from '../../services/api';
import { useNavigate } from 'react-router-dom';

const RecommendCarousel = () => {
  const [images, setImages] = useState([]);
  const [currentIndex, setCurrentIndex] = useState(0);
  const navigate = useNavigate();

  useEffect(() => {
    const fetchImages = async () => {
      try {
        const res = await api.get('/images/recommend_carousel');
        setImages(res.data);
      } catch (err) {
        console.error('Błąd ładowania obrazów karuzeli:', err);
      }
    };
    fetchImages();
  }, []);

  useEffect(() => {

  }, []);

  const scrollRight = () => {
    if (currentIndex < images.length - 4) {
      setCurrentIndex(prev => prev + 1);
    }
  };

  const scrollLeft = () => {
    if (currentIndex > 0) {
      setCurrentIndex(prev => prev - 1);
    }
  };

  const getTransformStyle = () => {
    return {
      transform: `translateX(-${currentIndex * (100 / 4)}%)`
    };
  };

  return (
    <section className="recommended text-center my-8 px-4">
      <h2 className="text-[1.8rem] text-[#e50914] mb-4 font-semibold">Recommended Movies</h2>
      <div className="custom-carousel relative w-full overflow-hidden">
        <div className="carousel-container w-full overflow-hidden">
          <div
            className="carousel-track flex transition-transform duration-700 ease-in-out"
            style={getTransformStyle()}
          >
            {images.map(({ filename, movieId }, index) => (
              <div
                key={index}
                className="carousel-item w-1/4 flex-shrink-0 cursor-pointer p-2"
                onClick={() => navigate(`/movies/${movieId}`)}
              >
                <img
                  src={`http://localhost:8080/api/images/recommend_carousel/${filename}`}
                  alt={`Movie ${index + 1}`}
                  className="w-full h-[270px] object-cover rounded-lg shadow-md hover:scale-105 transition-transform duration-300"
                />
              </div>
            ))}
          </div>
        </div>

        <button
          onClick={scrollLeft}
          className="carousel-prev absolute left-2 top-1/2 transform -translate-y-1/2 bg-black/50 text-white p-2 text-lg z-[100] hover:bg-black/70 rounded"
        >
          &#10094;
        </button>
        <button
          onClick={scrollRight}
          className="carousel-next absolute right-2 top-1/2 transform -translate-y-1/2 bg-black/50 text-white p-2 text-lg z-[100] hover:bg-black/70 rounded"
        >
          &#10095;
        </button>
      </div>
    </section>
  );
};

export default RecommendCarousel;