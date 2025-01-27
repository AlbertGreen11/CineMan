import axios from "axios";

class UserService {
    saveUser(user, powtorzoneHaslo) {
        return axios.post("http://localhost:9998/api/users/saveUser", user, powtorzoneHaslo);
    }
}

export default new UserService