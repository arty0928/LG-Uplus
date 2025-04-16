export const handleApi = async <T>(fn: () => Promise<T>) => {
  try {
    const data = await fn();
    console.log("handle data : ", data);
    return { data, error: null };
  } catch (error) {
    let msg = "";

    if (error instanceof Error) {
      msg = error.message;
    } else {
      msg = "오류가 발생했습니다.";
    }

    return { data: null, error: msg };
    
  }
};
//인자를 func으로 넘겨주면 promise 객체를 던져준다.