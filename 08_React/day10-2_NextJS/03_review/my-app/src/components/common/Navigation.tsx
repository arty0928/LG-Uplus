import Link from 'next/link';
import React from 'react';
import Styles from './Navigation.module.scss';

const Navigation = () => {
    return (
        <>
            <div className={Styles.wrapper}>
                <nav className={Styles.nav}>
                    <ul className={Styles.menu}>
                        <li>
                            <Link className={Styles.menu_item} href={"/"}>Home</Link>
                        </li>

                        <li>
                            <Link className={Styles.menu_item} href={"/community"}>Community</Link>
                        </li>

                        <li>
                            <Link className={Styles.menu_item} href={"/book"}>Book</Link>
                        </li>

                        <li>
                            <Link className={Styles.menu_item} href={"/notice"}>Notice</Link>
                        </li>

                        <li>
                            <Link className={Styles.menu_item} href={"/qna"}>QnA</Link>
                        </li>
                    </ul>
                    <ul className={Styles.login}>
                        <li>
                            <Link className={Styles.menu_item} href={"/login"}>Login</Link>
                        </li>
                    </ul>
                </nav>
            </div>
        </>
    );
};

export default Navigation;
