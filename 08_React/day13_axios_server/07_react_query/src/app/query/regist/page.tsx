"use client";
import { useMutation } from "@tanstack/react-query";
import styles from "./UseMutationEx.module.scss";
import { handleApi } from "@/utils/handleApi";
import { createUser } from "@/service/query";
import { useRef } from "react";
const UseMutaionEx = () => {
  const nameRef = useRef<HTMLInputElement>(null);
  const emailRef = useRef<HTMLInputElement>(null);

  const mutation = useMutation({
    mutationFn: createUser,
    onSuccess: (data) => {
      alert(`등록 선공 id: ${data.id}`);
    },
  })

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    const name = nameRef.current?.value || "";
    const email = emailRef.current?.value || "";

    mutation.mutate({ name, email });
  }
  return (
    <form onSubmit={handleSubmit} className={styles.form}>
      <input type="text" ref={nameRef} placeholder="Name" className={styles.input} required />
      <br />
      <input type="email" ref = {emailRef} placeholder="Email" className={styles.input} required />
      <br />
      <button type ="submit" className={styles.submitButton}></button>
     </form>
  );
};
export default UseMutaionEx;
