"use client";
import ColorBox from "@/components/ColorBox";
import SelectColors from "@/components/SelectColors";

export default function Home() {
  return (
      {/*TODO 7. Provider로  redux가 적용될 부분 설정하기   */}
      <div>
        <SelectColors />
        <ColorBox />
      </div>
  );
}
