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

  useEffect(() => {
    const store = localStorage.getItem("user");

    if (store) {
      try {
        setMember(JSON.parse(store));
      }
      catch {
        setMember(null);
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
  }, []);

  const logout = useCallback(() => {
    setMember(null);
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
