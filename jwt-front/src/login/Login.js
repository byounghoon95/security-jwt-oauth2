import {useNavigate} from "react-router-dom";

const Login = () => {
    const navigate = useNavigate();

    const handleJoin = () => {
        navigate("/join")
    };

    return (
        <div>
            <button onClick={handleJoin}>회원가입</button>
            <button>로그인</button>
            <button>네이버로그인</button>
            <button>로그아웃</button>
        </div>
    )
}

export default Login;
