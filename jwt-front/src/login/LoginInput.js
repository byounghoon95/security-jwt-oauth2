import { useNavigate } from 'react-router-dom';
import axios from "axios";
import {useState} from "react";

const LoginInput = () => {
    const navigate = useNavigate();
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const onChangeUsername = (e) => setUsername(e.target.value);
    const onChangePassword = (e) => setPassword(e.target.value);

    const handleLogin = () => {
        axios.post('/api/user/login', null, {
            params: {
                username: username,
                password: password
            },
        })
            .then((res) => {
                let token = res.headers.authorization.split(" ")[1];
                localStorage.setItem('jwt', token);
            })
        navigate('/main');
    };

    return (
        <div>
            아이디 : <input type="text" value={username} onChange={onChangeUsername} placeholder="아이디를 입력하세요"></input>
            패스워드 : <input type="text" value={password} onChange={onChangePassword} placeholder="비밀번호를 입력하세요"></input>
            <button onClick={handleLogin}>로그인</button>
        </div>
    );
}

export default LoginInput;