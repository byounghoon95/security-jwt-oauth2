import { useNavigate } from 'react-router-dom';
import axios from "axios";
import {useState} from "react";

const Join = () => {
    const navigate = useNavigate();
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const onChangeUsername = (e) => setUsername(e.target.value);
    const onChangePassword = (e) => setPassword(e.target.value);

    const handleJoin = () => {
        axios.post('/api/user/join', {
            username: username,
            password: password
        })
            .then((res) => {
                console.log(res);
            })
        navigate('/');
    };

    return (
        <div>
            아이디 : <input type="text" value={username} onChange={onChangeUsername} placeholder="아이디를 입력하세요"></input>
            패스워드 : <input type="text" value={password} onChange={onChangePassword} placeholder="비밀번호를 입력하세요"></input>
            <button onClick={handleJoin}>회원가입</button>
        </div>
    );
}

export default Join;  