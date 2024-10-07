import { useNavigate } from 'react-router-dom';

const Join = () => {
  const navigate = useNavigate(); 

  const backToMain = () => {
    navigate('/');
  };

  return (
    <div>
      아이디 : <input placeholder="아이디를 입력하세요"></input>
      패스워드 : <input placeholder="비밀번호를 입력하세요"></input>
      <button onClick={backToMain}>회원가입</button>
      <button onClick={backToMain}>회원가입</button>
      <button onClick={backToMain}>회원가입</button>
      <button onClick={backToMain}>회원가입</button>
      <button onClick={backToMain}>회원가입</button>
    </div>
  )
}

export default Join;  