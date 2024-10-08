import {useNavigate} from "react-router-dom";

const Login = () => {
    const navigate = useNavigate();

    const handleJoin = () => {
        navigate("/join")
    };

    const handleLogin = () => {
        navigate("/login")
    };

    const handleNaver = () => {
        window.location.href = "http://localhost:8080/oauth2/authorization/naver"
    }

    return (
        <div>
            <button onClick={handleJoin}>회원가입</button>
            <button onClick={handleLogin}>로그인</button>
            <button onClick={handleNaver}>네이버로그인</button>
            <button>로그아웃</button>
        </div>
    )
}

export default Login;
