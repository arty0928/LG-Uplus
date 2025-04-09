import React, { useReducer, useState } from 'react';
import './Cart.css';

const sampleItem = {
  id: 1,
  name: "React 티셔츠",
  price: 25000,
  quantity: 1,
};

const command = {
    ADD: "ADD",
    PLUS : "PLUS",
    MINUS : "MINUS",
    REMOVE : "REMOVE",
}

const reducer = ((state, action) => {
    switch (action.type) {
        case command.ADD:
            return [...state, {...action.payload, total : action.payload.price * action.payload.quantity}];
        case command.PLUS:
            return state.map((item) => {
                if (item.id === action.id) {
                    const newQuantity = item.quantity + 1;
                    return {
                        ...item,
                        quantity: newQuantity,
                        total: newQuantity * item.price
                    };
                }
                return item;
            });
        
        case command.MINUS:
            return state.map((item) => {
                if (item.id === action.id) {
                    const newQuantity = Math.max(item.quantity - 1, 1);
                    return {
                        ...item,
                        quantity: newQuantity,
                        total: newQuantity * item.price
                    };
                }
                return item;
            });
        
        case command.REMOVE:
            return state.filter((item) => item.id !== action.id);
        default:
            return state;
        
    }
}
)

const Cart = () => {

    const [cart, dispatch] = useReducer(reducer, []);

    return (
        <div>
        <h2>🛒 장바구니</h2>
            <button onClick={() => dispatch({
                type: command.ADD, payload: { ...sampleItem, id: Date.now() },
            })
        }>
            React 티셔츠 추가
        </button>

            <ul className='cart-list'>
                {cart.map((item) => (
                    <li key={item.id} className="cart-item">
                        <div>
                        {item.name} - 수량: {item.quantity} - 가격: {item.total}
                        <div>
                            <button onClick={() => dispatch({ type: command.PLUS, id: item.id })}>+</button>
                            <button onClick={() => dispatch({ type: command.MINUS, id: item.id })}>-</button>
                            <button onClick={() => dispatch({ type: command.REMOVE, id: item.id })}>삭제</button>
                        </div>
                        </div>
                    </li>
                    ))}
        </ul>
        </div>
    );
};

export default Cart;