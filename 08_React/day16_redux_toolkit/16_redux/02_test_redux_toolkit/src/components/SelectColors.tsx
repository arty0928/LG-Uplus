"use client";

import { useCallback } from "react";
import { useAppDispatch } from "@/store/hooks";
import { changeColor, changeSubColor } from "@/store/colorSlice";

const colors = ["red", "orange", "yellow", "green", "blue", "indigo", "violet"];

const SelectColors = () => {
  ////////////todo10.  useAppDispatch()를 통해 dispatch

  ////////////todo11. dispatch함수로 changeColor action 수행하기

  ////////////todo12. dispatch함수로 changeColor action 수행하기

  return (
    <div>
      <h2>색상을 선택하세요.</h2>
      <div style={{ display: "flex", gap: "8px" }}>
        {colors.map((color) => (
          <div
            key={color}
            style={{
              background: color,
              width: "24px",
              height: "24px",
              cursor: "pointer",
              borderRadius: "4px",
            }}
          />
        ))}
      </div>
      <hr />
    </div>
  );
};

export default SelectColors;
