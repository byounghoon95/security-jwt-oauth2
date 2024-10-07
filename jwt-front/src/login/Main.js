
import { useNavigate } from 'react-router-dom';

const Main = () => {
    const navigate = useNavigate(); 

    const handleJoin = () => {
      navigate('/join');
    };

    return (
        <>
          <button onClick={handleJoin}>회원가입</button>
          <button>로그인</button>
          <button>네이버로그인</button>
          <button>로그아웃</button>
        </>
    )
  }
  
  export default Main;