import React from 'react';

const BookDetail = ({ params: {isbn}} : {params : {isbn : string}}) => {
    return (
        <div>
            <h1>BookDetail {isbn}</h1>
        </div>
    );
};

export default BookDetail;