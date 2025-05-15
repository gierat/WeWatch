import React, { useEffect, useRef, useState } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';
import Navbar from '../components/layout/Navbar';

const HomePage = () => {

  const slideRef = useRef(null);
  const carouselRef = useRef(null);

  useEffect(() => {
 
  }, []);


  return (
    <div className="wrapper">
      <div>
        <Navbar />
      </div>
      <div className="slider relative w-full h-[50vh] overflow-hidden">

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

      <footer className="bg-[#1e1e1e] text-center text-[#b3b3b3] text-sm py-4">
        <p>© 2024 WeWatch. All rights reserved.</p>
      </footer>
    </div>
  );
};

export default HomePage;
