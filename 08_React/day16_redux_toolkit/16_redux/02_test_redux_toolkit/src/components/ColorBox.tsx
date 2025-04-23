"use client";

import { useAppSelector } from "@/store/hooks";

const ColorBox = () => {
  /////////TODO8. useAppSelector를 통해 color 전달 받기

  /////////TODO9. useAppSelector를 통해 subcolor 전달 받기

  return (
      <div
        style={{
          width: "64px",
          height: "64px",
        }}
      />
      <div
        style={{
          width: "32px",
          height: "32px",
        }}
      />
    </>
  );
};

export default ColorBox;
