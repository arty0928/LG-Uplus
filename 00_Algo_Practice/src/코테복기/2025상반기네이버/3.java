=== 3번 과일 맛을 섞어서 맛 조합의 개수 구하기 (중복 안됨)

n개 중에 과일 k개 섞고 (List<List<>> result 조합)
    
과일 A,B,C,D
맛 배열길이가 과일 길이랑 항상 같지는 않음
  0 1 2 3
-----------
A 0 1 0 0 
B 0 1 1 0
C 0 0 1 1
D 1 1 0 0
A B 섞어도 1 2 맛으로 인정 (중복x) -> set으로로

int tasteSize = fruie[0].length;

N = 4(과일 개수), K =2

Set<Set<Integer>> result = new HashSet<>();

for(List<Integer> cur : result){ //[ 0, 1] 선택한 과일 인덱스
   Set<Integer> set = new HashSet<>();
   for(int i : cur){ // 0번째 과일의 맛맛
      for(int j = 0; j < tasteSize; j++){ // 0 1 0 0
        int tast = fruite[i].charAt(j);
        if(taste == 1) {
            set.add(taste);
        }
      }
   }

   result.add(set);
}

return result.size();
