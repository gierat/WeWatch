import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import api from '../services/api';
import Navbar from '../components/layout/Navbar';

const UserProfilePage = () => {
  const { id } = useParams();
  const [user, setUser] = useState(null);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchUser = async () => {
      try {
        const response = await api.get(`/users/${id}`);
        console.log("Requested user ID:", id);
        setUser(response.data);
      } catch (err) {
        setError('User not found');
      }
    };

    fetchUser();
  }, [id]);

  if (error) {
    return <div className="text-red-500 text-center mt-10">{error}</div>;
  }

  if (!user) {
    return <div className="text-center mt-10 text-white">Loading...</div>;
  }

  return (
    <div className="wrapper">
      <div>
        <Navbar/>
      </div>
      <div className="min-h-screen bg-[#121212] text-white px-4 py-10">
        <div className="max-w-2xl mx-auto bg-[#1e1e1e] p-6 rounded-lg shadow-md">
          <h1 className="text-3xl font-bold text-[#e50914] mb-6">{user.nickname}'s Profile</h1>
          <div className="space-y-4">
            <p><span className="font-semibold">First Name:</span> {user.firstName}</p>
            <p><span className="font-semibold">Last Name:</span> {user.lastName}</p>
            <p><span className="font-semibold">Email:</span> {user.email}</p>
            <p><span className="font-semibold">Role:</span> {user.role}</p>
          </div>
        </div>
      </div>
    </div>
  );
};

export default UserProfilePage;