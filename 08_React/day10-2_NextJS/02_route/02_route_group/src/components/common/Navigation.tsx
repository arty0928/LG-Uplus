import React from 'react';
import styles from './Navigation.module.scss';
import Link from 'next/link';

const navigation = () => {
    return (
        <nav className={styles.nav}>
            <ul className={styles.menu}> 
                <li>
                    <Link className={styles.menu_item} href={"/"}>Home</Link>
                </li>
                <li>
                    <Link className={styles.menu_item} href={"/about-us"}>About-us</Link>
                </li>
                <li>
                    <Link className={styles.menu_item} href={"/book"}>Book</Link>
                </li>

                <li>
                    <Link className={styles.menu_item} href={"/test"}>Test</Link>
                </li>

                <li>
                    <Link className={styles.menu_item} href={"/book/book-insert"}>Book Insert</Link>
                </li>
            </ul>
        </nav>
    );
};

export default navigation;