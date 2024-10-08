import axios from "axios";

const Main = () => {
    const token = localStorage.getItem('jwt');

    const handleAPI = () => {
        axios.get('/api/admin', {
            headers: {
                Authorization: `Bearer ${token}`
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