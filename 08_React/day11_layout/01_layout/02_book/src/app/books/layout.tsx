import { Metadata } from "next";
import styles from "./book.module.scss";
import Link from "next/link";

export const metadata: Metadata = {
  title: 'Book 정보',
  description: '도서 정보를 관리하는 페이지',
};

export default function BookLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  console.log("book~~~~~");
  console.log(children);
  return <div className={styles.container}>
    <h1 className={styles.title}>도서 정보</h1>
    <nav>
      <ul  className={styles.nav}>
        <li>
          <Link className={styles.registerButton} href="/books">
            도서 목록</Link>
        </li>

        <li>
          <Link className={styles.registerButton} href="/books/regist">
            도서등록</Link>
        </li>

        
      </ul>
    </nav>
    {children}
  </div>;
}
