import React, { useState, useContext } from 'react';
import api from '../../services/api';
import { AuthContext } from '../../context/AuthContext';

const CommentForm = ({ movieId, onCommentAdded }) => {
  const [content, setContent] = useState('');
  const { token } = useContext(AuthContext);

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await api.post('/comments', { movieId, content });
      setContent('');
      onCommentAdded();
    } catch (err) {
      console.error('Error adding comment:', err);
    }
  };

  if (!token) {
    return (
      <p className="mt-4 text-sm text-[#b3b3b3]">
        You need to <a href="/login" className="text-[#e50914] hover:underline">log in</a> to add a comment.
      </p>
    );
  }

  return (
    <form onSubmit={handleSubmit} className="mt-4">
      <textarea
        value={content}
        onChange={(e) => setContent(e.target.value)}
        required
        placeholder="Write a comment..."
        className="w-full p-3 rounded bg-[#2a2a2a] text-white focus:outline-none"
      />
      <button
        type="submit"
        className="bg-[#e50914] hover:bg-[#f40612] text-white px-4 py-2 rounded mt-2"
      >
        Add Comment
      </button>
    </form>
  );
};

export default CommentForm;