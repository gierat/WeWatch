import React, { useEffect, useState } from 'react';
import api from '../../services/api';

const CommentList = ({ movieId }) => {
  const [comments, setComments] = useState([]);

  useEffect(() => {
    const fetchComments = async () => {
      try {
        const response = await api.get(`/comments/movie/${movieId}`);
        setComments(response.data);
      } catch (err) {
        console.error('Error fetching comments:', err);
      }
    };
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
            </div>
            <p>{comment.content}</p>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default CommentList;