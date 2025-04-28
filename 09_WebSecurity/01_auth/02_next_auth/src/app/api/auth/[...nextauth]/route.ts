import NextAuth from "next-auth";
import CredentialsProvider from "next-auth/providers/credentials";
import axios from "axios";

//////////// TODO 3. .env.local 파일에 설정한  BASE_URL 추출하기

// TODO 5. access Token이 만료된 경우 accessToken을 다시 받을 수 있는 함수 선언

//////////// TODO 4. NextAuth함수에 설정 하기

const authHandler = handler;
export { authHandler as GET, authHandler as POST };
