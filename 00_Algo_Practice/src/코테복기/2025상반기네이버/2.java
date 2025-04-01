// ==== 2번 문제 < 각  요청이 있고 난 후에 대화방에 들어있는 사용자 갯수를 배열로로
// 사용자 int id, int time(대화방에 들어간 시간), status (boolean 1: accept,0 : 자리비움)
// N개의 사이즈에 사용자를 넣을 수 있음

// <입력 >
// request [[11,1],[12,1],[13,1],[16,3],[200,1],[214,1],[216,1]] -> 정답은 [ 1, 2, 1,, ] -> 사이즈가 request의 길이와 같음
// time,id 순서 ( time이 오름차순으로 request보냄)
// n : 대화방 크기
// a : 대화방에 들어온 후 a시간이 지나면 자리비움으로 변경
// b : 대화방에 들어간 후 b시간이 지나면 대화방에서 삭제


// 대화방 접근 방식 
// Map<id，User> users -> 수정, 삭제에 용이하려고 탐색 시간 단축축
// Class User 생성함: int id, int time(대화방에 들어간 시간), status (boolean 1: accept,0 : 자리비움)


// for ( int i = 0 i < request)
//      time = request[i][0] , id = request[i][1]
//      User newUser = new User(id, time, false);

//     //1. 대화방에 있는 사용자 time status 갱신
//     for(Map.Entry<Integer,User> entry : users.entrySet()){
//         User checkUser = entry.getValue();
//         int checkId = entry.getKey();

//         // accept인 것 중 대화방에 참여가 시간부터 a초기 지나면 상태 업데이트
//         if(checkUser.status == true){
//             if(time - checkUser.time > a) {
//                 users.get(checkId).status = false;
//             }
//         }

//         // 대화방에 있는 것 중 참여 시간 부터 b초가 지났으면 대화방에서 삭제
//         if(time - checkUser.time > b) {
//             users.remove(checkId);
//         }
//     }

//     //  1. 대화방에 유저가 없으면
//         if(!map.containsKey(id)){
//             newUser.status = true;
//             users.put(id, newUser);
//         }

//     //   2. 대화방에 있으면 
//         else{
//             //대화방 크기  < n :
//             if(map.size() < n){
//                 map.put(id, newUser);
//             }
//             else if (map.size() == n){
//                 // 자리 비움 중 제일 오래된 사용자 지우고, 새로운 유저 넣기 
//                 /*
//                  * 
//                    User maxUser = null;

//                    for(Entry.map<Integer, User> entry : users.entrySet<>()){  -> 근데 여기서 고민, 계속 정렬? pq여야 했나 ? 그런데 그러면 어차피 탐색할 때 시간 오래 걸림.
//                         User tempUser = entry.getValue();
//                         int tempID = entry.getKey();

//                         if() -> 여기까지 함. maxUser 갱신을 누구랑 비교해야 하지? map은 인덱스가 없는데, 처음 가지고 잇는애? 비어있는 경우는?
//                    }
//                  */
//             }
//         }

