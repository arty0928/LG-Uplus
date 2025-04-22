"use client";
import { useCallback, useRef } from "react";
import styles from "./regist.module.scss";
import { Member } from "@/types/member";
import { useMutation } from "@tanstack/react-query";
import { useRouter } from "next/navigation";
import { insertBook } from "@/service/books";
import { insetMember } from "@/service/member";


const BookRegist = () => {

  const idRef = useRef<HTMLInputElement>(null); 
  const passwordRef = useRef<HTMLInputElement>(null); 
  const nameRef = useRef<HTMLInputElement>(null); 
  const emailRef = useRef<HTMLInputElement>(null); 
  const addressRef = useRef<HTMLInputElement>(null); 
  const phoneRef = useRef<HTMLInputElement>(null); 
  const withdrawRef = useRef<HTMLInputElement>(null); 
  const router = useRouter();

  const { mutate } = useMutation({
    mutationFn: insetMember,
    onSuccess: (member) => {
      alert(member)
      router.push("/");
    },
    onError: (error) => {
      alert("등록 실패");
      console.log(error);
    }
  });
  const handleSubmit = useCallback(async () => {
    const id = idRef.current?.value.trim() || "";
    const password = passwordRef.current?.value.trim() || "";
    const name = nameRef.current?.value.trim() || "";

    if (!id) {
      alert("사용자 아이디를 입력하세요");
      idRef.current?.focus();
      return;
    }
    if (!password) {
      alert("사용자 비밀번호를 입력하세요");
      passwordRef.current?.focus();
      return;
    }
    if (!name) {
      alert("사용자 이름을 입력하세요");
      nameRef.current?.focus();
      return;
    }

    const member: Member = {
      id,
      password,
      name,
      email: emailRef.current?.value || "",
      address: addressRef.current?.value || "",
      phone: phoneRef.current?.value || "",
      withdraw: withdrawRef.current?.value || ""
    };
    mutate(member);
  },[mutate]);

  return (
    <div className={styles.container}>
      <table className={styles.table}>
        <caption>회원 가입</caption>
        <tbody>
          <tr>
            <td>아 이 디</td>
            <td>
              <input type="text" ref={idRef} autoComplete="off"/>
            </td>
          </tr>
          <tr>
            <td>비밀번호</td>
            <td>
              <input type="password" ref={passwordRef} autoComplete="new-password"/>
            </td>
          </tr>
          <tr>
            <td>이름</td>
            <td>
              <input type="text" ref={nameRef} />
            </td>
          </tr>
          <tr>
            <td>이메일</td>
            <td>
              <input type="email" ref={emailRef} />
            </td>
          </tr>
          <tr>
            <td>주소</td>
            <td>
              <input type="text" ref={addressRef} />
            </td>
          </tr>
          <tr>
            <td>전화번호</td>
            <td>
              <input type="text" ref={phoneRef} />
            </td>
          </tr>
        </tbody>
      </table>
      <div className={styles.buttonGroup}>
        <button className={styles.registerButton} onClick={handleSubmit}>회원 가입</button>
      </div>
    </div>
  );
};

export default BookRegist;
