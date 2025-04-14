import Link from 'next/link';
import React from 'react';

const Book = () => {
    return (
        <div>
            <h1>BOOK</h1>
            <div>
                <div>
                    <Link href="/book/1">1111</Link>
                </div>

                <div>
                    <Link href="/book/2">2222</Link>
                </div>

                <div>
                    <Link href="/book/3">3333</Link>
                </div>

            </div>
        </div>
    );
};

export default Book;