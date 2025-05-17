import React, { useEffect, useRef, useState } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';
import Navbar from '../components/layout/Navbar';
import Footer from '../components/layout/Footer';
import Slider from '../components/home/Slider';
import MovieCarousel from '../components/home/MovieCarousel';

const HomePage = () => {
  return (
    <div className="wrapper">
      <Navbar />
      <Slider />
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
          <MovieCarousel />
        </section>

        <section className="categories text-center my-8">
          <h2 className="text-xl text-[#e50914] mb-4">Popular Categories</h2>
          <div className="category-list flex flex-wrap justify-center gap-4">
          </div>
        </section>
      </div>
      <Footer />
    </div>
  );
};

export default HomePage;
