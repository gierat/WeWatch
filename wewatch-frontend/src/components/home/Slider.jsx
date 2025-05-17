import React, { useEffect, useState } from 'react';

const Slider = () => {
  const [slides] = useState([
    "slider_1.jpg",
    "slider_2.jpg",
    "slider_3.jpg"
  ]);
  const [currentIndex, setCurrentIndex] = useState(0);

  useEffect(() => {
    const interval = setInterval(() => {
      setCurrentIndex((prev) => (prev === slides.length - 1 ? 0 : prev + 1));
    }, 5000);
    return () => clearInterval(interval);
  }, [slides]);

  return (
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
  );
};

export default Slider;