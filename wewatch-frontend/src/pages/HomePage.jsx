import React, { useEffect, useRef, useState } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';
import Navbar from '../components/layout/Navbar';
import Footer from '../components/layout/Footer';

const HomePage = () => {

  const [slides, setSlides] = useState([
    "slider_1.jpg",
    "slider_2.jpg",
    "slider_3.jpg"
  ]);
  const [currentIndex, setCurrentIndex] = useState(0);

  const slideRef = useRef(null);
  const carouselRef = useRef(null);

  useEffect(() => {
    const interval = setInterval(() => {
      setCurrentIndex((prevIndex) =>
        prevIndex === slides.length - 1 ? 0 : prevIndex + 1
      );
    }, 5000);
    return () => clearInterval(interval);
  }, [slides]);


  return (
    <div className="wrapper">
      <div>
        <Navbar />
      </div>
      <div className="slider relative w-full h-[50vh] overflow-hidden">
        {slides.map((filename, index) => (
          <div
            key={filename}
            className={`absolute top-0 left-0 w-full h-full transition-opacity duration-1000 ease-in-out ${
              index === currentIndex ? "opacity-100 z-10" : "opacity-0 z-0"
            }`}
          >
            <img
              src={`http://localhost:8080/api/images/slider/${filename}`}
              alt={`Slide ${index + 1}`}
              className="w-full h-full object-cover"
            />
          </div>
        ))}
      </div>

      <div className="main_content max-w-[1200px] mx-auto px-4">
        <section className="about-forum bg-[#1e1e1e] text-center my-8 p-8 rounded-lg shadow-lg">
          <h2 className="text-2xl text-[#e50914] mb-4">Welcome to WeWatch</h2>
          <p className="text-[#b3b3b3] text-base leading-relaxed">
            Join our vibrant community of movie and TV show enthusiasts. Discuss your favorite films/shows,
            share reviews, and discover new cinematic experiences. Whether you're a casual viewer or a
            passionate cinephile, WeWatch is the perfect place to engage with others who share your interests.
          </p>
        </section>

        <section className="recommended text-center my-8">
          <h2 className="text-xl text-[#e50914] mb-4">Recommended Movies</h2>
          <div className="relative overflow-hidden">
            <div className="carousel-container overflow-hidden">
            </div>
          </div>
        </section>

        <section className="categories text-center my-8">
          <h2 className="text-xl text-[#e50914] mb-4">Popular Categories</h2>
          <div className="category-list flex flex-wrap justify-center gap-4">
          </div>
        </section>
      </div>
      <div>
        <Footer />
      </div>
    </div>
  );
};

export default HomePage;
