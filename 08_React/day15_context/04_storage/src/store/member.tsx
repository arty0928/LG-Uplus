"use client";
import { Member } from "@/types/member";
import { createContext, ReactNode, useContext, useState, useCallback, useMemo, useEffect } from "react";

interface MemberContextType {
  member: Member | null;
  loaded: boolean;
  login: (member: Member) => void;
  logout: () => void;
}

const MemberContext = createContext<MemberContextType | undefined>(undefined);

export const MemberProvider = ({ children }: { children: ReactNode }) => {
  const [member, setMember] = useState<Member | null>(null);
  const [loaded, setLoaded] = useState<boolean>(false);

  /* 

    localStorage
      - removeItem() 으로 삭제하기 전까지 저장
    
    sessionStorage
      - session이 유지 되는 동안 저장    

  */
  useEffect(() => {
    const store = sessionStorage.getItem("user");

    if (store) {
      try {
        setMember(JSON.parse(store));
      }
      catch (e) {
        console.log(e);
      }
    }
    setLoaded(true);
  }, []);

  useEffect(() => {
    if (loaded) {
      localStorage.setItem("user", JSON.stringify(member));
    }
  }, [member, loaded]);

  const login = useCallback((member: Member) => {
    setMember(member);
    sessionStorage.setItem("user", JSON.stringify(member));
  }, []);

  const logout = useCallback(() => {
    setMember(null);
    sessionStorage.removeItem("user");
  }, []);

  const returnValue = useMemo(
    () => ({
      member,
      loaded,
      login,
      logout,
    }),
    [member,loaded]
  );

  return <MemberContext.Provider value={returnValue}>{children}</MemberContext.Provider>;
};

export const useMemberContext = () => {
  const context = useContext(MemberContext);
  if (!context) {
    throw new Error("useMemberContext must be used within a MemberProvider");
  }
  return context;
};
