import React, { useEffect, useState, useContext } from 'react';
import api from '../../services/api';
import { AuthContext } from '../../context/AuthContext';

const CommentList = ({ movieId }) => {
  const [comments, setComments] = useState([]);
  const { token, role } = useContext(AuthContext);

  const fetchComments = async () => {
    try {
      const response = await api.get(`/comments/movie/${movieId}`);
      setComments(response.data);
    } catch (err) {
      console.error('Error fetching comments:', err);
    }
  };

  const handleDelete = async (id) => {
    if (!window.confirm('Are you sure you want to delete this comment?')) return;
    try {
      await api.delete(`/comments/${id}`);
      fetchComments();
    } catch (err) {
      console.error('Error deleting comment:', err);
    }
  };

  useEffect(() => {
    fetchComments();
  }, [movieId]);

  return (
    <div className="comments mt-8">
      <h3 className="text-[#e50914] mb-4 text-xl font-semibold">Comments</h3>
      <ul className="space-y-4">
        {comments.map(comment => (
          <li key={comment.id} className="bg-[#1e1e1e] p-4 rounded shadow">
            <div className="flex justify-between text-sm mb-2">
              <strong>{comment.nickname}</strong>
              <span>{new Date(comment.createdAt).toLocaleString()}</span>
              {(token && role && role.toUpperCase() === 'ADMIN') && (
                <button
                  onClick={() => handleDelete(comment.id)}
                  className="text-[#e50914] text-xs ml-4 hover:underline"
                >
                  Delete
                </button>
              )}
            </div>
            <p>{comment.content}</p>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default CommentList;
