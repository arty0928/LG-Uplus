//https://jsonplaceholder.typicode.com/users


/*    <div className="container">
      <h1 className="title">User List</h1>
      <ul className="user-list">
       
          <li key="" className="user-item">
            <span className="user-name"></span>
            <br />
            <span className="user-email"></span>
          </li>
        
      </ul>
    </div>
*/


import React, { useEffect, useState } from 'react';
import './Info.css';

const Info = () => {
  const [users, setUsers] = useState([]);
  const [loading, setLoadong] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetch("https://jsonplaceholder.typicode.com/users")
      .then((response) => {
        if (!response.ok) {
          throw new Error("사용자 정보를 조회 중에 오류가 발생했습니다.");
        }
        return response.json();
      })
      .then((data) => {
        setUsers(data);
      })
      .catch((err) => {
        setError(err.message);
      })
      .finally(() => {
        setLoadong(false);
      });
  }, []);

  if (loading) return <p className='loading'>Loading....</p>;
  if (error) return <p className='error'>오류 발생 : {error}</p>;
  return (
    <div className="container">
      <h1 className="title">User List</h1>
      <ul className="user-list">
        {users.map((user) => (
          <li key="" className="user-item">
            <span className="user-name"></span>
            <br />
            <span className="user-email"></span>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Info;