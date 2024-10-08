import axios from "axios";

const Main = () => {
    const token = localStorage.getItem('jwt');

    const handleAPI = () => {
        const auth = (token != null) ? `Bearer ${token}` : null;

        axios.get('/api/admin', {
            headers: {
                Authorization: auth
            }
        })
            .then((res) => {
                console.log(res);
            })
    };

    return (
        <div>
            <div>1번</div>
            <div>2번</div>
            <div>3번</div>
            <div>4번</div>
            <button onClick={handleAPI}>호출</button>
        </div>
    )
}

export default Main;