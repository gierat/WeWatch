import React from "react";
import {Link} from 'react-router-dom';


const Footer = () =>{
    return(
    <footer className="bg-[#1e1e1e] text-center text-[#b3b3b3] text-sm py-6 px-4 mt-auto">
      <p className="mb-2">&copy; 2025 WeWatch. All rights reserved.</p>
      <div className="footer-links space-x-2">
        <Link to="#" className="text-[#e50914] hover:underline">Privacy Policy</Link>
        <span>|</span>
        <Link to="#" className="text-[#e50914] hover:underline">Terms of Service</Link>
        <span>|</span>
        <Link to="#" className="text-[#e50914] hover:underline">Contact Us</Link>
      </div>
    </footer>
    );
};

export default Footer;
