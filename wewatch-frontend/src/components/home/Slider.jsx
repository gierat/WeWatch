import React, { useEffect, useState } from 'react';

const Slider = () => {
  const [slides] = useState([
    "slider_1.jpg",
    "slider_2.jpg",
    "slider_3.jpg"
  ]);
  const [currentIndex, setCurrentIndex] = useState(0);

    const goToNext = () => {
        setCurrentIndex((prev) => (prev === slides.length - 1 ? 0 : prev + 1));
    };

    const goToPrev = () => {
        setCurrentIndex((prev) => (prev === 0 ? slides.length - 1 : prev - 1));
    };

    const goToSlide = (index) => {
        setCurrentIndex(index);
    };

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
        <button
            onClick={goToPrev}
            className="absolute left-4 top-1/2 transform -translate-y-1/2 bg-black/50 text-white px-3 py-2 rounded-full z-20 hover:bg-opacity-70"
        >
        &#10094;
        </button>
        <button
            onClick={goToNext}
            className="absolute right-4 top-1/2 transform -translate-y-1/2 bg-black/50 text-white px-3 py-2 rounded-full z-20 hover:bg-opacity-70"
        >
        &#10095;
        </button>
        <div className="absolute bottom-4 left-1/2 transform -translate-x-1/2 flex gap-2 z-20">
            {slides.map((_, index) => (
                <button
                    key={index}
                    onClick={() => goToSlide(index)}
                    className={`w-3 h-3 rounded-full ${
                    index === currentIndex ? "bg-[#e50914]" : "bg-gray-400"
                    } transition-colors duration-300`}
                ></button>
            ))}
        </div>
    </div>
  );
};

export default Slider;